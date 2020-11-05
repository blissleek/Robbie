package org.nero.robbie.attachment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author blissleek
 * @version 1.0.0
 * @date 2020/10/28 22:06
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.nero.robbie.attachment.serviceImpl")
public class AttachmentServiceImplConfiguration {
}