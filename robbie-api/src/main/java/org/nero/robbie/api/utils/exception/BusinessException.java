package org.nero.robbie.api.utils.exception;

import org.nero.robbie.api.utils.message.Message;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/10/28 22:11
 */
public class BusinessException extends Exception {

    /**
     * errorCode
     */
    private String errorCode;

    public BusinessException() {
        super();
    }

    /**
     * 传Message类型
     *
     * @param message
     */
    public BusinessException(Message message) {
        super(message.toString());
        this.errorCode = message.getCode();
    }

    /**
     * 直接传错误消息
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * 获取errorCode
     *
     * @return
     */
    public String getErrorCode() {
        return this.errorCode;
    }
}