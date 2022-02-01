package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import aqgs;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import sha;

public final class MergeBitmapBlurUtil$1
  implements Runnable
{
  public MergeBitmapBlurUtil$1(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    try
    {
      Object localObject = aqgs.getBitmapFromCache(this.arC);
      if (localObject != null)
      {
        sha.b((Bitmap)localObject, this.ob);
        return;
      }
      localObject = new URL(this.arC).openConnection();
      int i = ((HttpURLConnection)localObject).getContentLength();
      ((URLConnection)localObject).connect();
      localObject = ((URLConnection)localObject).getInputStream();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject, i);
      Bitmap localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
      localBufferedInputStream.close();
      ((InputStream)localObject).close();
      sha.b(this.arC, localBitmap, this.ob);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.1
 * JD-Core Version:    0.7.0.1
 */