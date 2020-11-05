package org.nero.robbie.api;

import org.nero.robbie.attachment.AttachmentServiceImplConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author blissleek
 * @version 1.0.0
 * @since 2020-10-28 19:10:55
 */
@Import({AttachmentServiceImplConfiguration.class})
@SpringBootApplication
public class RobbieApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobbieApiApplication.class, args);
    }

}
