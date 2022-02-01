package com.tencent.mobileqq.nearby;

import ajpx;
import android.graphics.Bitmap;
import aqdu.a;
import java.util.Iterator;
import java.util.List;

public class NearbyIconDecoder$1
  implements Runnable
{
  public NearbyIconDecoder$1(ajpx paramajpx, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      String[] arrayOfString = this.val$key.split("_s_");
      if ((arrayOfString.length == 3) && (this.this$0.Dw != null))
      {
        int i = Integer.parseInt(arrayOfString[0]);
        int j = Integer.parseInt(arrayOfString[2]);
        Iterator localIterator = this.this$0.Dw.iterator();
        while (localIterator.hasNext()) {
          ((aqdu.a)localIterator.next()).a(i, arrayOfString[1], j, this.val$bmp);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyIconDecoder.1
 * JD-Core Version:    0.7.0.1
 */