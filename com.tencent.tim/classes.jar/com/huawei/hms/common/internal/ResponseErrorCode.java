package com.huawei.hms.common.internal;

import android.os.Parcelable;

public abstract interface ResponseErrorCode
{
  public abstract int getErrorCode();
  
  public abstract String getErrorReason();
  
  public abstract Parcelable getParcelable();
  
  public abstract String getResolution();
  
  public abstract int getStatusCode();
  
  public abstract String getTransactionId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.ResponseErrorCode
 * JD-Core Version:    0.7.0.1
 */