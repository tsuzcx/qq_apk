package com.tencent.mobileqq.earlydownload.handler;

import affc;
import android.text.TextUtils;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import xks;

public class PokeResHandler$1
  implements Runnable
{
  public PokeResHandler$1(affc paramaffc, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.val$imagePath)) {}
    try
    {
      aqhq.delete(this.val$imagePath, false);
      aqhq.W(this.val$srcPath, this.val$imagePath, false);
      xks.xX(this.val$imagePath);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PokeResHandler_0625", 2, localIOException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1
 * JD-Core Version:    0.7.0.1
 */