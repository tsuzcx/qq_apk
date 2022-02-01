package com.google.android.filament.gltfio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ImageLoader
{
  public static int desiredSize = 2147483647;
  
  private static int calculateInSampleSizeNew(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    float f1 = Math.max(j, i);
    float f2 = Math.min(j, i);
    float f3 = Math.max(paramInt1, paramInt2);
    if ((Math.min(paramInt1, paramInt2) <= 0.0F) || (f1 <= f3)) {
      paramInt1 = 1;
    }
    do
    {
      do
      {
        return paramInt1;
        if (f1 / f2 <= 2.0F) {
          break;
        }
        f1 = i * j;
        f2 = paramInt1 * paramInt2;
        if (Build.VERSION.SDK_INT < 24) {
          break label256;
        }
        paramInt2 = 1;
        while (f1 / (paramInt2 * paramInt2) >= f2) {
          paramInt2 += 1;
        }
        paramInt1 = paramInt2;
      } while (!paramBoolean);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 1);
    return paramInt2 - 1;
    for (;;)
    {
      if (f1 / (paramInt2 * paramInt2) >= f2)
      {
        paramInt2 *= 2;
      }
      else
      {
        paramInt1 = paramInt2;
        if (!paramBoolean) {
          break;
        }
        paramInt1 = paramInt2;
        if (paramInt2 <= 1) {
          break;
        }
        return paramInt2 / 2;
        if (Build.VERSION.SDK_INT >= 24)
        {
          paramInt2 = 1;
          while (f1 / paramInt2 >= f3) {
            paramInt2 += 1;
          }
          paramInt1 = paramInt2;
          if (!paramBoolean) {
            break;
          }
          paramInt1 = paramInt2;
          if (paramInt2 <= 1) {
            break;
          }
          return paramInt2 - 1;
        }
        for (;;)
        {
          if (f1 / paramInt2 >= f3)
          {
            paramInt2 *= 2;
          }
          else
          {
            paramInt1 = paramInt2;
            if (!paramBoolean) {
              break;
            }
            paramInt1 = paramInt2;
            if (paramInt2 <= 1) {
              break;
            }
            return paramInt2 / 2;
            paramInt2 = 1;
          }
        }
        label256:
        paramInt2 = 1;
      }
    }
  }
  
  private static int[] getImageInfoFromFile(char[] paramArrayOfChar)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      Log.d("filament", "loadImageFromFile Info: " + String.valueOf(paramArrayOfChar));
      BitmapFactory.decodeFile(String.valueOf(paramArrayOfChar), localOptions);
      int i = calculateInSampleSizeNew(localOptions, desiredSize, desiredSize, false);
      int j = localOptions.outWidth / i;
      int k = localOptions.outHeight / i;
      return new int[] { j, k, i };
    }
    catch (Exception paramArrayOfChar) {}
    return null;
  }
  
  private static int[] getImageInfoFromMemory(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt, localOptions);
      paramInt = calculateInSampleSizeNew(localOptions, desiredSize, desiredSize, false);
      int i = localOptions.outWidth / paramInt;
      int j = localOptions.outHeight / paramInt;
      return new int[] { i, j, paramInt };
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private static byte[] loadImageFromFile(char[] paramArrayOfChar, int paramInt)
  {
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt;
      Log.d("filament", "loadImageFromFile: " + String.valueOf(paramArrayOfChar));
      paramArrayOfChar = BitmapFactory.decodeFile(String.valueOf(paramArrayOfChar), (BitmapFactory.Options)localObject);
      localObject = ByteBuffer.allocateDirect(paramArrayOfChar.getByteCount());
      paramArrayOfChar.copyPixelsToBuffer((Buffer)localObject);
      Log.d("filament", "test for image load width: " + paramArrayOfChar.getWidth() + ", height:" + paramArrayOfChar.getHeight());
      paramArrayOfChar.recycle();
      paramArrayOfChar = ((ByteBuffer)localObject).array();
      return paramArrayOfChar;
    }
    catch (Exception paramArrayOfChar) {}
    return null;
  }
  
  private static byte[] loadImageFromMemory(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt2;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt1, (BitmapFactory.Options)localObject);
      localObject = ByteBuffer.allocateDirect(paramArrayOfByte.getByteCount());
      paramArrayOfByte.copyPixelsToBuffer((Buffer)localObject);
      Log.d("filament", "test for image load width: " + paramArrayOfByte.getWidth() + ", height:" + paramArrayOfByte.getHeight());
      paramArrayOfByte.recycle();
      paramArrayOfByte = ((ByteBuffer)localObject).array();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.filament.gltfio.ImageLoader
 * JD-Core Version:    0.7.0.1
 */