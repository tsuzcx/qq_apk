package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ShortVideoThumbDownloader
  extends AbsDownloader
{
  public static final String a = "shortVideoThumb";
  private static final String b = "ShortVideoThumbDownloader";
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = paramFile.getAbsolutePath();
    if (!FileUtils.b(paramFile))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoThumbDownloader", 2, "decodeFile file not exits. just return");
      }
      paramFile = null;
    }
    do
    {
      do
      {
        return paramFile;
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile, paramDownloadParams);
        int i = paramURLDrawableHandler.getWidth();
        int j = paramURLDrawableHandler.getHeight();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoThumbDownloader", 2, "decodeFile : thumbPath = " + paramFile + ", w=" + i + ", h=" + j);
        }
        paramFile = ShortVideoUtils.a(paramURLDrawableHandler);
        if (paramFile == null) {
          return null;
        }
        int k = paramFile[0];
        int m = paramFile[1];
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoThumbDownloader", 2, "decodeFile ==> dstW:" + k + ", dstH:" + m);
        }
        float f1 = k / i;
        float f2 = m / j;
        paramDownloadParams = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
        paramDownloadParams.setDensity(160);
        paramFile = new Canvas(paramDownloadParams);
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        paramFile.drawRoundRect(new RectF(0.0F, 0.0F, k, m), 12.0F, 12.0F, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paramFile.scale(f1, f2);
        paramFile.drawBitmap(paramURLDrawableHandler, 0.0F, 0.0F, localPaint);
        paramFile = paramDownloadParams;
      } while (paramURLDrawableHandler == null);
      paramFile = paramDownloadParams;
    } while (paramURLDrawableHandler.isRecycled());
    paramURLDrawableHandler.recycle();
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */