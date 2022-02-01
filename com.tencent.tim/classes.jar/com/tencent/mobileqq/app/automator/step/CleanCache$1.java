package com.tencent.mobileqq.app.automator.step;

import acbn;
import android.os.Build.VERSION;
import aoop;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class CleanCache$1
  implements Runnable
{
  private int cyD;
  
  CleanCache$1(CleanCache paramCleanCache) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        CleanCache.a(this.this$0, this.cyD);
        CleanCache.a(this.this$0);
        File[] arrayOfFile = new File[3];
        arrayOfFile[0] = new File(acbn.SDCARD_PATH + "photo");
        arrayOfFile[1] = new File(acbn.SDCARD_PATH + "ptv_template");
        arrayOfFile[2] = new File(acbn.bmC + File.separator + "_dynamic");
        int k = arrayOfFile.length;
        j = 0;
        if (i < k)
        {
          File localFile = arrayOfFile[i];
          j += CleanCache.a(this.this$0, localFile, 2000, 500);
          i += 1;
          continue;
        }
        i = CleanCache.a(this.this$0, new File(SafeBitmapFactory.LARGE_MAP_CACHE_PATH), 150, 50) + j;
        if (Build.VERSION.SDK_INT >= 21) {
          continue;
        }
        i += CleanCache.a(this.this$0, aoop.aW, 2000, 500);
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache. delete " + i + " cache file(s)");
        }
        this.this$0.cNA();
        this.this$0.cNz();
        CleanCache.b(this.this$0);
        CleanCache.c(this.this$0);
      }
      catch (Exception localException)
      {
        int j;
        localException.printStackTrace();
        continue;
      }
      this.this$0.a.notifyUI(40001, true, null);
      return;
      j = CleanCache.a(this.this$0, aoop.aW, 5000, 2000);
      i += j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CleanCache.1
 * JD-Core Version:    0.7.0.1
 */