package com.tencent.qqmail.utilities.draw;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.FileOutputStream;

final class DrawIcon$1
  implements Runnable
{
  DrawIcon$1(String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(this.val$bitmapPath);
      this.val$bmp.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
      localFileOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.draw.DrawIcon.1
 * JD-Core Version:    0.7.0.1
 */