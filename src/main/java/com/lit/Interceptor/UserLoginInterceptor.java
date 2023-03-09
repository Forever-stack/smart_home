package com.lit.Interceptor;

import com.lit.utils.JwtUitls;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginInterceptor implements HandlerInterceptor {
    JwtUitls jwtUitls = new JwtUitls();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器prehadle方法");
        String token = request.getHeader("token");
        System.out.println(token+"token==============");
        try {
            if(token==null){
                response.getWriter().write("error1");
                return false;
            }
            int verify  = jwtUitls.verify(token);
            if (verify!=1){
                if(verify == 2){
                    response.getWriter().write("error1");
                    return false;
//
                }else if(verify == 0){
                    response.getWriter().write( "error2");
                    return false;
//
                }
            }else if(verify  == 1){
                //验证成功，放行
                return true;
            }
            System.out.println(request.getRequestURL());
            response.getWriter().write("err:notLogin");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行了拦截器的postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(request.getContextPath());
    }
}
