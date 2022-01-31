package com.dataline.util;

import android.os.Handler;
import android.os.Looper;
import eo;
import ep;
import eq;

public class HttpUpload$HttpUploadListenerPack
  implements HttpUpload.HttpUploadListener
{
  HttpUpload.HttpUploadListener jdField_a_of_type_ComDatalineUtilHttpUpload$HttpUploadListener = null;
  
  public HttpUpload$HttpUploadListenerPack(HttpUpload paramHttpUpload, HttpUpload.HttpUploadListener paramHttpUploadListener)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpUploadListener = paramHttpUploadListener;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    new Handler(Looper.getMainLooper()).post(new eq(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    new Handler(Looper.getMainLooper()).post(new eo(this, paramLong1, paramString, paramLong2));
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new ep(this, paramLong1, paramBoolean, paramLong2, paramInt1, paramInt2, paramInt3, paramString1, paramString2));
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpUploadListener.a(paramLong1, paramLong2, paramLong3);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpUploadListener.a(paramLong1, paramString, paramLong2);
  }
  
  public void b(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload$HttpUploadListener.a(paramLong1, paramBoolean, paramLong2, paramInt1, paramInt2, paramInt3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.HttpUpload.HttpUploadListenerPack
 * JD-Core Version:    0.7.0.1
 */