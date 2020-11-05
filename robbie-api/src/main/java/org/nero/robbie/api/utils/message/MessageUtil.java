package org.nero.robbie.api.utils.message;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/10/28 21:16
 */
public class MessageUtil {
    private static MessageSource messageSource;

    /**
     * 注入 message_source.xml
     */
    private static void init() {
        if (messageSource == null) {
            synchronized (MessageUtil.class) {
                ApplicationContext applicationContextFactory = new ClassPathXmlApplicationContext("classpath:message_source.xml");
                messageSource = (MessageSource) applicationContextFactory.getBean("messageSource");
            }
        }
    }

    /**
     * 获取消息
     *
     * @param errorCode messageId
     * @param param     参数
     * @return message
     */
    public static String getMessage(String errorCode, String... param) {
        init();
        try {
            return messageSource.getMessage(errorCode, param, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return errorCode;
        }
    }

    /**
     * 获取消息
     *
     * @param errorCode messageId
     * @return message
     */
    public static String getMessage(String errorCode) {
        init();
        try {
            return messageSource.getMessage(errorCode, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            return errorCode;
        }
    }
}
