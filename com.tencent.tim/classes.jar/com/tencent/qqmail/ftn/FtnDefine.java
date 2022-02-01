package com.tencent.qqmail.ftn;

public final class FtnDefine
{
  public static final int DOWNLOAD_ERROR_TYPE_ABORT = 3;
  public static final int DOWNLOAD_ERROR_TYPE_FILE = 1;
  public static final int DOWNLOAD_ERROR_TYPE_NETWORK = 0;
  public static final int DOWNLOAD_ERROR_TYPE_RESPONSE = 2;
  public static final int ERROR_TYPE_CGI = 2;
  public static final int ERROR_TYPE_DOMAIN = 5;
  public static final int ERROR_TYPE_DOWNLOAD = 7;
  public static final int ERROR_TYPE_FTN = 3;
  public static final int ERROR_TYPE_LOGIN = 4;
  public static final int ERROR_TYPE_NETWORK = 1;
  public static final int ERROR_TYPE_UNKNOWN = 0;
  public static final int ERROR_TYPE_UPLOAD = 6;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_DOMAIN_ERROR = 10;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_NOT_EXIST = 8;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_REOPEN = 11;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_SPAM = 1;
  public static final int LOGIN_ERROR_TYPE_ACCOUNT_SUSPEND = 9;
  public static final int LOGIN_ERROR_TYPE_NEED_PASSWORD = 5;
  public static final int LOGIN_ERROR_TYPE_NEED_SECOND_PASSWORD = 6;
  public static final int LOGIN_ERROR_TYPE_NEED_VERIFY_CODE = 7;
  public static final int LOGIN_ERROR_TYPE_PASSWORD_ERROR = 2;
  public static final int LOGIN_ERROR_TYPE_SECOND_PASSWORD_ERROR = 3;
  public static final int LOGIN_ERROR_TYPE_UNKOWN = 0;
  public static final int LOGIN_ERROR_TYPE_VERIFY_CODE_ERROR = 4;
  public static final int NETWORK_ERROR_TYPE_ABORT = 4;
  public static final int NETWORK_ERROR_TYPE_BUSY = 9;
  public static final int NETWORK_ERROR_TYPE_CONNECT = 7;
  public static final int NETWORK_ERROR_TYPE_HOST = 6;
  public static final int NETWORK_ERROR_TYPE_HTTP = 0;
  public static final int NETWORK_ERROR_TYPE_OPERATION = 2;
  public static final int NETWORK_ERROR_TYPE_PROXY = 5;
  public static final int NETWORK_ERROR_TYPE_SOCKET = 1;
  public static final int NETWORK_ERROR_TYPE_TIMEOUT = 3;
  public static final int NETWORK_ERROR_TYPE_UNKNOWN = 10;
  public static final int NETWORK_ERROR_TYPE_UNLOGIN = 8;
  public static final int UPLOAD_ERROR_TYPE_ABORT = 5;
  public static final int UPLOAD_ERROR_TYPE_EXCEED_CAPACITY = -110;
  public static final int UPLOAD_ERROR_TYPE_FILE = 1;
  public static final int UPLOAD_ERROR_TYPE_NETWORK = 0;
  public static final int UPLOAD_ERROR_TYPE_RESPONSE = 4;
  public static final int UPLOAD_ERROR_TYPE_SEND = 2;
  public static final int UPLOAD_ERROR_TYPE_SHA = 3;
  
  public static abstract class FtnCallback
  {
    public void onBeforeSend() {}
    
    public void onComplete() {}
    
    public abstract void onError(int paramInt1, int paramInt2, int paramInt3, String paramString);
    
    public void onProcessData(long paramLong1, long paramLong2) {}
    
    public abstract void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnDefine
 * JD-Core Version:    0.7.0.1
 */