package com.tencent.biz.pubaccount.util;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import obs;
import org.apache.http.protocol.HttpContext;

public class PubAccountHttpDownloader$1
  implements Runnable
{
  public PubAccountHttpDownloader$1(obs paramobs, OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, HttpContext paramHttpContext, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong) {}
  
  public void run()
  {
    try
    {
      obs.a(this.this$0, this.val$out, this.a, this.val$handler, this.bdW, this.b, this.awf, this.bdX, this.h, this.yw);
      if (this.val$out != null) {
        this.val$out.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("PubAccountHttpDownloader", 1, localIOException.getMessage());
      obs.a(this.this$0, this.a, this.bdW, this.b, this.awf, this.bdX, localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PubAccountHttpDownloader.1
 * JD-Core Version:    0.7.0.1
 */