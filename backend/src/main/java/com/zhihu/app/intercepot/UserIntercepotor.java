//package intercepot;
//
//import com.alibaba.fastjson.JSON;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import model.Result;
//import model.User;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
//
//public class UserIntercepotor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        User user = (User) request.getSession().getAttribute("user");
//        if (user == null) {
//            response.getWriter().write(JSON.toJSONString(Result.fail()));
//            return false;
//        }
//        return true;
//    }
//
//    //Controller方法执行之后
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//    }
//
//    // 整个请求完成后（包括Thymeleaf渲染完毕）
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler
//            , Exception ex) throws Exception {
//
//    }
//}
