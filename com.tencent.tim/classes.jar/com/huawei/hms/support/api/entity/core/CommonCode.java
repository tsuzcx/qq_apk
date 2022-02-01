package com.huawei.hms.support.api.entity.core;

public abstract interface CommonCode
{
  public static final int ERROR = 1;
  public static final int OK = 0;
  
  public static abstract interface ErrorCode
  {
    public static final int ARGUMENTS_INVALID = 907135000;
    public static final int CLIENT_API_INVALID = 907135003;
    public static final int EXECUTE_TIMEOUT = 907135004;
    public static final int HMS_VERSION_CONFIGER_INVALID = 907135007;
    public static final int INTERNAL_ERROR = 907135001;
    public static final int NAMING_INVALID = 907135002;
    public static final int NOT_IN_SERVICE = 907135005;
    public static final int SESSION_INVALID = 907135006;
  }
  
  public static abstract interface StatusCode
  {
    public static final int API_CLIENT_EXPIRED = 1001;
    public static final int API_UNAVAILABLE = 1000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.entity.core.CommonCode
 * JD-Core Version:    0.7.0.1
 */