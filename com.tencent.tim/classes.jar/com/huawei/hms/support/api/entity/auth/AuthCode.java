package com.huawei.hms.support.api.entity.auth;

public abstract interface AuthCode
{
  public static abstract interface ErrorCode
  {
    public static final int CERT_FINGERPRINT_EMPTY = 907135702;
    public static final int GET_SCOPE_ERROR = 907135700;
    public static final int PERMISSION_LIST_EMPTY = 907135703;
    public static final int SCOPE_LIST_EMPTY = 907135701;
  }
  
  public static abstract interface StatusCode
  {
    public static final int AUTH_INFO_NOT_EXIST = 6002;
    public static final int CERT_FINGERPRINT_ERROR = 6003;
    public static final int OK = 0;
    public static final int PERMISSION_EXPIRED = 6006;
    public static final int PERMISSION_NOT_AUTHORIZED = 6005;
    public static final int PERMISSION_NOT_EXIST = 6004;
    public static final int WAITING_CONNECT = 6001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.auth.AuthCode
 * JD-Core Version:    0.7.0.1
 */