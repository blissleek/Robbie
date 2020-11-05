package org.nero.robbie.attachment.service;


import org.nero.robbie.attachment.entity.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @author blissleek
 * @version 1.0.0
 * @since 2020-10-28 21:10:31
 */
public interface AttachmentUploaderService {

    /**
     * 上传文件
     * @param file file
     * @return Attachment
     * @throws Exception
     */
    Attachment uploadMultipartFile(MultipartFile file) throws Exception;

    /**
     * 流式上传文件
     * @param key
     * @param stream
     * @param contentType
     * @return Attachment
     * @throws Exception
     */
    Attachment uploadStream(String key, InputStream stream, String contentType) throws  Exception;
}
