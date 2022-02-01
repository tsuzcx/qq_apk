package com.tencent.av.video.effect.lowlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.av.video.effect.utils.Log;
import com.tencent.av.video.effect.utils.StorageUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class LowLightTools
{
  private static final String LOW_LIGHT_IMAGE = "LowLight.png";
  public static final String TAG = "LowLightTools";
  
  public static <T extends Number> double clipping(T paramT)
  {
    if (paramT.doubleValue() < 0.0D) {
      return 0.0D;
    }
    if (paramT.doubleValue() > 255.0D) {
      return 255.0D;
    }
    return paramT.doubleValue();
  }
  
  public static Bitmap getLowLightImage(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    int i;
    int k;
    for (;;)
    {
      try
      {
        localBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        arrayOfByte = new byte[262144];
        j = 0;
        i = 0;
      }
      catch (Throwable localThrowable)
      {
        Bitmap localBitmap;
        byte[] arrayOfByte;
        int j;
        float f;
        int m;
        Log.d("LowLightTools", "getLowLightImage:" + localThrowable);
        return null;
      }
      if (k >= 256) {
        break label220;
      }
      f = (float)Math.pow(1.0F - (255.0F - k) * paramFloat2 / (255.0F - paramFloat1), paramFloat3);
      m = (byte)(int)clipping(Double.valueOf(Math.pow((int)clipping(Integer.valueOf((int)((i - paramFloat1) / f + paramFloat1))) / 255.0F, paramFloat4) * 255.0D));
      arrayOfByte[j] = ((byte)m);
      arrayOfByte[(j + 1)] = ((byte)m);
      arrayOfByte[(j + 2)] = ((byte)m);
      arrayOfByte[(j + 3)] = -1;
      j += 4;
      k += 1;
    }
    label220:
    label227:
    for (;;)
    {
      localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(arrayOfByte));
      if (paramBoolean) {
        saveBitmap(localBitmap);
      }
      return localBitmap;
      for (;;)
      {
        if (i >= 256) {
          break label227;
        }
        k = 0;
        break;
        i += 1;
      }
    }
  }
  
  public static Bitmap getLowLightImage(Context paramContext, String paramString)
  {
    try
    {
      paramContext = BitmapFactory.decodeStream(CommonUtils.getInputStreamFromPath(paramContext, paramString + "/" + "LowLight.png"));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.d("LowLightTools", "getLowLightImage:" + paramContext);
    }
    return null;
  }
  
  public static void saveBitmap(Bitmap paramBitmap)
  {
    Object localObject = new File(StorageUtils.VIDEO_EFFECT_PATH + "LowLight/lowLight_saved.png");
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      localObject = new FileOutputStream((File)localObject);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((FileOutputStream)localObject).flush();
      ((FileOutputStream)localObject).close();
      return;
    }
    catch (Exception paramBitmap)
    {
      Log.d("LowLightTools", "saveBitmap:" + paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.lowlight.LowLightTools
 * JD-Core Version:    0.7.0.1
 */