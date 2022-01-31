package com.tencent.mobileqq.utils.httputils;

import android.os.Bundle;

public abstract interface HttpCommunicator$TransferProgressListener
{
  public static final int a = 0;
  public static final int b = 1;
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString, Bundle paramBundle);
  
  public abstract void a(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator.TransferProgressListener
 * JD-Core Version:    0.7.0.1
 */