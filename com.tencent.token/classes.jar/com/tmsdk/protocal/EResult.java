package com.tmsdk.protocal;

public abstract interface EResult
{
  public static final int ER_CANCEL = 10;
  public static final int ER_Expired = 4;
  public static final int ER_Fail = 2;
  public static final int ER_Invalid = 3;
  public static final int ER_None = 0;
  public static final int ER_Publish_Delayed = 6;
  public static final int ER_Publish_Delayed_Expired = 8;
  public static final int ER_Publish_Delayed_Failed = 7;
  public static final int ER_Publish_Delayed_Success = 9;
  public static final int ER_Publish_Failed = 5;
  public static final int ER_Revoke = 11;
  public static final int ER_Success = 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.protocal.EResult
 * JD-Core Version:    0.7.0.1
 */