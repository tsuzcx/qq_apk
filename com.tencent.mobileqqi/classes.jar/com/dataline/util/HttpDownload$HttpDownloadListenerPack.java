package com.dataline.util;

import android.os.Handler;
import android.os.Looper;
import es;
import et;
import eu;

public class HttpDownload$HttpDownloadListenerPack
  implements HttpDownload.HttpDownloadListener
{
  private HttpDownload.HttpDownloadListener jdField_a_of_type_ComDatalineUtilHttpDownload$HttpDownloadListener;
  
  public HttpDownload$HttpDownloadListenerPack(HttpDownload paramHttpDownload, HttpDownload.HttpDownloadListener paramHttpDownloadListener)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpDownloadListener = paramHttpDownloadListener;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpDownloadListener.b(paramLong1, paramLong2, paramLong3);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    new Handler(Looper.getMainLooper()).post(new es(this, paramLong1, paramString, paramLong2));
  }
  
  public void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new et(this, paramLong1, paramBoolean, paramLong2, paramInt1, paramInt2, paramInt3, paramString1, paramString2));
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3)
  {
    new Handler(Looper.getMainLooper()).post(new eu(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpDownloadListener.a(paramLong1, paramString, paramLong2);
  }
  
  public void b(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComDatalineUtilHttpDownload$HttpDownloadListener.a(paramLong1, paramBoolean, paramLong2, paramInt1, paramInt2, paramInt3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.HttpDownload.HttpDownloadListenerPack
 * JD-Core Version:    0.7.0.1
 */