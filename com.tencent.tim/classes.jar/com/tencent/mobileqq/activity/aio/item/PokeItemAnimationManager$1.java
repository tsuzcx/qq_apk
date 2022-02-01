package com.tencent.mobileqq.activity.aio.item;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import xkr;

public class PokeItemAnimationManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LzmaUtils", 2, "inFileDir:" + this.val$zipFileName + " | outFileDir:" + this.aVh);
      }
      aqhq.W(this.val$zipFileName, this.aVh, false);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LzmaUtils", 2, localIOException, new Object[0]);
        }
      }
    }
    xkr.a(this.this$0, this.aVh, this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager.1
 * JD-Core Version:    0.7.0.1
 */