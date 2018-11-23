package com.otc.platform.exception;

import com.otc.platform.response.ResponseCode;

public class NotCodeErrException extends RuntimeException{

  private int errCode;
  private String errMsg;

  public NotCodeErrException(String errMsg) {
    super(errMsg);
    this.errCode = ResponseCode.VERIFY_CODE.getCode();
  }

  public NotCodeErrException(ResponseCode errCode, String errMsg) {
    super(errMsg);
    this.errCode = errCode.getCode();
  }

}
