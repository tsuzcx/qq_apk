package com.tencent.qqmail.utilities.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BitmapUtil
{
  public static byte[] bmpToBytes(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    Log.i("BitmapUtils", "bmpToBytes begin");
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, paramInt, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    try
    {
      localByteArrayOutputStream.close();
      Log.i("BitmapUtils", "bmpToBytes end");
      return paramBitmap;
    }
    catch (IOException paramCompressFormat)
    {
      for (;;)
      {
        paramCompressFormat.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.bitmap.BitmapUtil
 * JD-Core Version:    0.7.0.1
 */