//package config;
//
//import intercepot.UserIntercepotor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        UserIntercepotor userIntercepotor = new UserIntercepotor();
//        registry.addInterceptor(userIntercepotor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login")
//                .excludePathPatterns("/contentCard")
//                .excludePathPatterns("/hot")
//                .excludePathPatterns("/search");
//    }
//}
