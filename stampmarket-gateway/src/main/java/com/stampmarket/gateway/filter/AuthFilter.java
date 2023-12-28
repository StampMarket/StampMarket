package com.stampmarket.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.stampmarket.common.utils.JwtTool;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 权限过滤器
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE; // 前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 获取请求
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        // 判断是否为登录请求或注册请求，如果是则放行
        if (request.getRequestURI().contains("/user/login") || request.getRequestURI().contains("/user/register")) {
            return null;
        }
        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        // 判断token是否为空，如果为空则拦截
        if (token == null || token.isEmpty()) {
            // 拦截请求，不再转发
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.setResponseBody("未登录，请先进行登录");
            return null;
        }
        // 解析token
        // 判断token是否有效，如果无效则拦截
        try{
            // 解析token，不出错则说明token有效
            JwtTool.parseToken("stamp_market", token);
        } catch (Exception e) {
            // 拦截请求，不再转发
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(403);
            currentContext.setResponseBody("登录已过期，请重新登录");
            return null;
        }
        // 继续转发请求
        return null;
    }
}
