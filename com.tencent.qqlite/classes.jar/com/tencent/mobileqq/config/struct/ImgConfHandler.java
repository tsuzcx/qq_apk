package com.tencent.mobileqq.config.struct;

import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;

public abstract interface ImgConfHandler
  extends IHttpCommunicatorListener
{
  public static final byte a = 1;
  public static final int a = 12288;
  public static final byte b = 2;
  public static final byte c = 3;
  
  public abstract long a(int paramInt);
  
  public abstract Bitmap a(int paramInt);
  
  public abstract String a(int paramInt);
  
  public abstract String a(String paramString, byte paramByte);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte);
  
  public abstract void b_(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.ImgConfHandler
 * JD-Core Version:    0.7.0.1
 */