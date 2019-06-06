package com.sheepyang1993.sheepcommon.http.interceptor;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author SheepYang
 * @email 332594623@qq.com
 * @date 2019/5/28 15:30
 * @describe token拦截器, 参考HttpLoggingInterceptor
 */
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        return response;
    }
}

