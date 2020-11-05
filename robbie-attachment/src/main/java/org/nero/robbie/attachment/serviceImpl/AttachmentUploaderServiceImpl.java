package org.nero.robbie.attachment.serviceImpl;


import io.minio.MinioClient;
import org.nero.robbie.attachment.entity.Attachment;
import org.nero.robbie.attachment.service.AttachmentUploaderService;
import org.nero.robbie.attachment.serviceImpl.properties.MinioProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author blissleek
 * @version 1.0.0
 * @since 2020-10-28 21:10:33
 */
@Component
public class AttachmentUploaderServiceImpl implements AttachmentUploaderService {
    private final MinioProperties minioProperties;

    public AttachmentUploaderServiceImpl(MinioProperties minioProperties) {
        this.minioProperties = minioProperties;
    }

    @Override
    public Attachment uploadMultipartFile(MultipartFile file) throws Exception {
        return uploadStream(file.getOriginalFilename(), file.getInputStream(), file.getContentType());
    }

    @Override
    public Attachment uploadStream(String key, InputStream stream, String contentType) throws Exception {
        MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(), minioProperties.getAccessKey(),
                minioProperties.getAccessSecret());
        boolean isExist = minioClient.bucketExists(minioProperties.getBucket());
        if (!isExist) {
            minioClient.makeBucket(minioProperties.getBucket());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String fileName = minioProperties.getPathPrefix() + "/" + sdf.format(date) + "_" + key;
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1);
        long fileLength = stream.available();

        minioClient.putObject(minioProperties.getBucket(), fileName, stream, fileLength, null, null, contentType);
        String url = minioProperties.getEndpoint() + minioProperties.getBucket() + "/" + fileName;
        return new Attachment(fileName, contentType, extension, url, fileLength);
    }
}
