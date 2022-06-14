package com.ndex.clonemate.global.utils;

import com.ndex.clonemate.global.dto.ApiResult;

public class ApiUtils {
    private ApiUtils() {
    }

    public static ApiResult<Void> createSuccessEmptyApi() {
        return ApiResult.<Void>builder()
                .success(true)
                .build();
    }

    public static <T> ApiResult<T> createSuccessApi(T t) {
        return ApiResult.<T>builder()
                .success(true)
                .data(t)
                .build();
    }
}
