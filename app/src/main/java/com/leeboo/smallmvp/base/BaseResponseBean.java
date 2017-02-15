package com.leeboo.smallmvp.base;


import com.leeboo.smallmvp.netsetting.ErrorCode;

public class BaseResponseBean<T> {
    public String code;
    public String msg;
    public T      data;

    public boolean isSuccess() {
        if (this.code.equals(ErrorCode.error0_code)) {
            return true;
        } else {
            return false;
        }
    }
}
