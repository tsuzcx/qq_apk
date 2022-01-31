package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public abstract class BaseResp
{
  public int errCode;
  public String errStr;
  public String transaction;
  
  abstract boolean checkArgs();
  
  public void fromBundle(Bundle paramBundle)
  {
    this.errCode = paramBundle.getInt("_wxapi_baseresp_errcode");
    this.errStr = paramBundle.getString("_wxapi_baseresp_errstr");
    this.transaction = paramBundle.getString("_wxapi_baseresp_transaction");
  }
  
  public abstract int getType();
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putInt("_wxapi_baseresp_errcode", this.errCode);
    paramBundle.putString("_wxapi_baseresp_errstr", this.errStr);
    paramBundle.putString("_wxapi_baseresp_transaction", this.transaction);
  }
  
  public static abstract interface ErrCode
  {
    public static final int ERR_AUTH_DENIED = -4;
    public static final int ERR_COMM = -1;
    public static final int ERR_OK = 0;
    public static final int ERR_SENT_FAILED = -3;
    public static final int ERR_UNSUPPORT = -5;
    public static final int ERR_USER_CANCEL = -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.BaseResp
 * JD-Core Version:    0.7.0.1
 */