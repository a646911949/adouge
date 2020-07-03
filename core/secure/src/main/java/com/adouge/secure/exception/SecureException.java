package com.adouge.secure.exception;

import com.adouge.core.tool.api.IResultCode;
import com.adouge.core.tool.api.ResultCode;
import lombok.Getter;

/**
 * @author : Vinson
 * @date : 2020/6/15 1:07 下午
 */
public class SecureException  extends RuntimeException {
    private static final long serialVersionUID = 2359767895161832954L;

    @Getter
    private final IResultCode resultCode;

    public SecureException(String message) {
        super(message);
        this.resultCode = ResultCode.UN_AUTHORIZED;
    }

    public SecureException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public SecureException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
