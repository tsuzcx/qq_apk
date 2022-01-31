package com.tencent.av.service;

import android.graphics.Bitmap;
import android.os.IInterface;

public abstract interface IQQServiceForAV
  extends IInterface
{
  public abstract int a(String paramString);
  
  public abstract Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract String a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, String paramString1, String paramString2);
  
  public abstract void a(IQQServiceCallback paramIQQServiceCallback);
  
  public abstract boolean a();
  
  public abstract boolean a(long paramLong);
  
  public abstract boolean a(String paramString);
  
  public abstract long[] a(String paramString);
  
  public abstract void b(IQQServiceCallback paramIQQServiceCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.service.IQQServiceForAV
 * JD-Core Version:    0.7.0.1
 */