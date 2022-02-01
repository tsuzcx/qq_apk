package com.tencent.biz.TroopRedpoint;

import aqgo;
import aqhq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jnv;
import mqq.app.MobileQQ;

public class TroopRedTouchManager$4
  implements Runnable
{
  public TroopRedTouchManager$4(jnv paramjnv, String paramString) {}
  
  public void run()
  {
    String str = new File(this.this$0.mAppInterface.getApplication().getFilesDir(), "TroopRedTouchManager2_All" + this.this$0.mAppInterface.getCurrentAccountUin()).getAbsolutePath();
    synchronized (this.this$0)
    {
      try
      {
        aqhq.a(str, aqgo.encode(this.TD.getBytes(), 0), false);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(this.this$0.TAG + "Q.qqstory.redPoint", 2, "saveLocalFileList Exception,e =" + localException.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.4
 * JD-Core Version:    0.7.0.1
 */