package com.tencent.tim.timleba;

import aehu;
import android.graphics.Bitmap;
import auno;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class TimLebaHelper$3
  implements Runnable
{
  public TimLebaHelper$3(auno paramauno, URL paramURL, File paramFile, String paramString) {}
  
  public void run()
  {
    try
    {
      if (HttpDownloadUtil.a(this.this$0.mApp, this.val$url, this.val$file))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TimLebaHelper", 2, "Download icon key = " + this.val$key + "suc--------");
        }
        Bitmap localBitmap = auno.a(this.this$0, this.val$file);
        List localList;
        int i;
        if (localBitmap != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TimLebaHelper", 2, "Download icon key = " + this.val$key + "notify UI++++++++");
          }
          localList = this.this$0.La;
          i = 0;
        }
        try
        {
          while (i < this.this$0.La.size())
          {
            ((aehu)this.this$0.La.get(i)).s(this.val$key, localBitmap);
            i += 1;
          }
          auno.a(this.this$0, this.val$key);
          return;
        }
        finally {}
      }
      this.this$0.dv.remove(this.val$key);
    }
    catch (Exception localException)
    {
      this.this$0.dv.remove(this.val$key);
      auno.b(this.this$0, this.val$key);
      return;
    }
    auno.b(this.this$0, this.val$key);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.timleba.TimLebaHelper.3
 * JD-Core Version:    0.7.0.1
 */