package com.cc.springcloud.plugins;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResultUtil {


    public enum ResultException {
        // ====================   common exception start
        SUCCESS(0, "success"),
        ILLEGAL_CALL(10000, "Illegal Call"),//非法请求
        INVALID_TOKEN_EXCEPTION(10001, "Token Error Or Expired"), //token
        INVALID_SINGATURE_EXCEPTION(10002, "Signature Error"),
        NOT_FOUND_EXCEPTION(10004, "URI Not Found"), //404
        SERVER_ERROR_EXCEPTION(10005, "Server Error"), //服务异常
        PARMA_ERROR_EXCEPTION(10006, "Parmameters Error"), //参数错误
        MEHTOD_NOTSUPPORT_EXCEPTION(10007, "Method Not Support"),
        UNKNOWN_EXCEPTION(10009, "Unknown Error"),
        BUSINESS_EXCEPTION(10010, ""),
        ;


        private int code;
        private String message;

        ResultException(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.message;
        }
    }

    public static class Result implements java.io.Serializable {
        private static final long serialVersionUID = -2957990471064549945L;
        private String traceId;
        private final int code;
        private final String msg;
        private Map<String, Object> data;

        private Result() {
            this.code = ResultException.SUCCESS.code;
            this.msg = ResultException.SUCCESS.message;
        }

        private Result(String msg) {
            this.code = ResultException.BUSINESS_EXCEPTION.code;
            this.msg = msg;
            this.data = Collections.emptyMap();
        }

        private Result(int code, String msg) {
            this.code = code;
            this.msg = msg;
            this.data = Collections.emptyMap();
        }

        private Result(ResultException exception) {
            this.code = exception.code;
            this.msg = exception.message;
            this.data = Collections.emptyMap();
        }

        public String getMsg() {
            return msg;
        }

        public int getCode() {
            return code;
        }

        public Map<String, Object> getData() {
            return data;
        }

        public void addData(String key, Object value) {
            if (this.code == 0)
                if (this.data == null)
                    data = new HashMap<String, Object>();
            data.put(key, value);

        }

        public String getTraceId() {
            return traceId;
        }

        public void setTraceId(String traceId) {
            this.traceId = traceId;
        }
    }

    public static Result getSuccResult() {
        return new Result();
    }

    public static Result getExceptionResult(ResultException exception) {
        return new Result(exception);
    }

    public static Result getBusinessExceptionResult(String msg) {
        return new Result(msg);
    }

    public static Result getCustomeredExceptionResult(int code, String msg) {
        return new Result(code, msg);
    }

}

