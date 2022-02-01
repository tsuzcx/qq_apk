package com.tencent.qqmail.advertise;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.gifimageview.GifAction;
import com.tencent.qqmail.view.gifimageview.GifDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AdvertiseImageDecoder
  implements GifAction
{
  public static final String TAG = "AdvertiseImageDecoder";
  private static volatile AdvertiseImageDecoder instance;
  private GifDecoder gifDecoder;
  
  public static AdvertiseImageDecoder getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AdvertiseImageDecoder();
      }
      return instance;
    }
    finally {}
  }
  
  public void clearFrameBitmap()
  {
    AdvertiseFileUtils.getInstance().clearCurrAdvertiseImagePath();
  }
  
  public void deocdeFinish()
  {
    QMLog.log(4, "AdvertiseImageDecoder", "deocdeFinish");
    SharedPreferenceUtil.setHasLastPushAdvertiseImage(false);
  }
  
  public String[] getAllFrames()
  {
    try
    {
      String[] arrayOfString = AdvertiseFileUtils.getInstance().listCurrAdvertiseImagePath();
      return arrayOfString;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String getFrameImageName(int paramInt)
  {
    String str = FileUtil.getAdvertiseImgDir() + "advertise_frame" + paramInt + ".png";
    if (paramInt < 10) {
      str = FileUtil.getAdvertiseImgDir() + "advertise_frame0" + paramInt + ".png";
    }
    return str;
  }
  
  public void parseOk(boolean paramBoolean, int paramInt)
  {
    QMLog.log(4, "AdvertiseImageDecoder", "frameIndex = " + paramInt + "parseStatus = " + paramBoolean);
    if (paramInt == 1) {
      clearFrameBitmap();
    }
    Bitmap localBitmap = this.gifDecoder.getFrameImage(paramInt - 1);
    QMLog.log(4, "AdvertiseImageDecoder", "bmp = " + localBitmap);
    if (localBitmap == null) {}
    do
    {
      return;
      saveFrameBitmap(paramInt, localBitmap);
    } while (this.gifDecoder.getStatus() != -1);
    QMLog.log(4, "AdvertiseImageDecoder", "GifDecoder.STATUS_FINISH");
    deocdeFinish();
  }
  
  public void saveFrameBitmap(int paramInt, Bitmap paramBitmap)
  {
    String str = getFrameImageName(paramInt);
    try
    {
      boolean bool = ImageUtil.writeBitmapToLocation(paramBitmap, Bitmap.CompressFormat.PNG, 100, str);
      QMLog.log(4, "AdvertiseImageDecoder", "isSuccess = " + Boolean.valueOf(bool));
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public void startDecode()
  {
    try
    {
      Object localObject = AdvertiseFileUtils.getInstance().listLastPushImage();
      if ((localObject == null) || (localObject.length <= 0))
      {
        QMLog.log(4, "AdvertiseImageDecoder", "startDecode lastpushDirFiles null or empty : " + localObject);
        return;
      }
      localObject = localObject[0];
      if (localObject == null) {
        return;
      }
      if (((File)localObject).getName().endsWith("png"))
      {
        QMLog.log(4, "AdvertiseImageDecoder", "decode a png");
        Threads.runInBackground(new AdvertiseImageDecoder.1(this, (File)localObject));
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    if (localIOException.getName().endsWith("gif"))
    {
      QMLog.log(4, "AdvertiseImageDecoder", "decode a gif");
      this.gifDecoder = new GifDecoder(new FileInputStream(localIOException), this);
      this.gifDecoder.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.advertise.AdvertiseImageDecoder
 * JD-Core Version:    0.7.0.1
 */