package org.nero.robbie.attachment.entity;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/10/28 21:33
 */
public class Attachment {
    private String name;
    private String contentType;
    private String extension;
    private String url;
    private long length;

    public Attachment() {
    }

    public Attachment(String name, String contentType, String extension, String url, long length) {
        this.name = name;
        this.contentType = contentType;
        this.extension = extension;
        this.url = url;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}
