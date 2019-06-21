package com.career.genius.config.sys;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.UUID;

/**
 * 请描述该类
 *
 * @author LZM
 * @since 2018-11-21 18:51
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//               .allowedHeaders("*")
//                .maxAge(3600)
//                .allowCredentials(true);
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
//
//    /**
//     * 文件上传配置
//     *
//     * @return
//     */
//    @Bean
//    public MultipartConfigElement multipartConfigElement() {
//        MultipartConfigFactory factory = new MultipartConfigFactory();
//        //文件最大
//        factory.setMaxFileSize(DataSize.ofMegabytes(40)); //KB,MB
//        /// 设置总上传数据总大小
//        factory.setMaxRequestSize(DataSize.ofMegabytes(40));
//        return factory.createMultipartConfig();
//    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
