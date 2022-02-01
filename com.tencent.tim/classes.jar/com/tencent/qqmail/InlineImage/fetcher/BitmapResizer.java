package com.tencent.qqmail.InlineImage.fetcher;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.io.ByteArrayOutputStream;

public class BitmapResizer
{
  public static final int MAX_IMAGE_HEIGHT = QMUIKit.getScreenHeight() * 2 / 3;
  public static final int MAX_IMAGE_WIDTH = QMUIKit.getScreenWidth() * 2 / 3;
  
  public static byte[] readResizedBitmap(String paramString)
  {
    try
    {
      paramString = ImageUtil.decodeSampledBitmapFromDisk(paramString, MAX_IMAGE_WIDTH, MAX_IMAGE_HEIGHT);
      if (paramString == null) {
        return null;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.BitmapResizer
 * JD-Core Version:    0.7.0.1
 */