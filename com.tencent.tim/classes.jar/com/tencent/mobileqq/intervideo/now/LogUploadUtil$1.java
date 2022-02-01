package com.tencent.mobileqq.intervideo.now;

import aifa;
import aifb;
import android.util.Log;
import java.io.IOException;

public final class LogUploadUtil$1
  implements Runnable
{
  public LogUploadUtil$1(String paramString) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      aifb.gq(aifb.access$000(), aifb.access$100());
      Log.i("FileUtil", "compress time " + (System.currentTimeMillis() - l));
      aifa.upload(this.val$uin, aifb.access$100());
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("FileUtil", localIOException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.LogUploadUtil.1
 * JD-Core Version:    0.7.0.1
 */