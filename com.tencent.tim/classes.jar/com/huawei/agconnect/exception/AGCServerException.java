package com.huawei.agconnect.exception;

public class AGCServerException
  extends AGCException
{
  public static final int AUTHENTICATION_FAILED = 403;
  public static final int OK = 200;
  public static final int SERVER_NOT_AVAILABLE = 503;
  public static final int SERVER_RSP_INVALID = 2;
  public static final int UNKNOW_EXCEPTION = 500;
  
  public AGCServerException(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.exception.AGCServerException
 * JD-Core Version:    0.7.0.1
 */