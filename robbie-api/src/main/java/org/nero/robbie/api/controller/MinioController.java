package org.nero.robbie.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.nero.robbie.api.utils.JsonResult;
import org.nero.robbie.api.utils.exception.BusinessException;
import org.nero.robbie.api.utils.message.Message;
import org.nero.robbie.attachment.entity.Attachment;
import org.nero.robbie.attachment.service.AttachmentUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/10/28 22:09
 */
@Api(tags = "minio")
@RestController
@CrossOrigin
@RequestMapping("/minio")
public class MinioController {
    private final AttachmentUploaderService attachmentUploaderService;

    @Autowired
    public MinioController(AttachmentUploaderService attachmentUploaderService) {
        this.attachmentUploaderService = attachmentUploaderService;
    }

    @ApiOperation(value = "文件上传", notes = "上传文件到minio服务器", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Attachment> upload(@RequestParam("file") MultipartFile file) throws Exception {
        JsonResult<Attachment> jsonResult = new JsonResult<>();
        Attachment attachment;
        try {
            attachment = attachmentUploaderService.uploadMultipartFile(file);
        } catch (Exception e) {
            throw new BusinessException(new Message("CM.MINIO.UPDATE_FAILED", "文件"));
        }
        jsonResult.setMessage(new Message("CM.MINIO.UPDATE_SUCCESS", "文件"));
        jsonResult.setData(attachment);
        return jsonResult;
    }
}