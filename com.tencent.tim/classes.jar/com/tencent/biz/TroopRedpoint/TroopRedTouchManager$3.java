package com.tencent.biz.TroopRedpoint;

import aqhq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jnv;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x791.oidb_0x791.GetRedDotRes;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class TroopRedTouchManager$3
  implements Runnable
{
  public TroopRedTouchManager$3(jnv paramjnv, oidb_0x791.GetRedDotRes paramGetRedDotRes) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1 = new File(this.this$0.mAppInterface.getApplication().getFilesDir(), "TroopRedTouchManager2_" + this.this$0.mAppInterface.getCurrentAccountUin()).getAbsolutePath();
    synchronized (this.this$0)
    {
      try
      {
        aqhq.a((String)localObject1, this.b.toByteArray(), false);
        localObject1 = new StringBuilder("saveLocalFile==>");
        while (i < this.b.rpt_msg_reddot_info.size())
        {
          ((StringBuilder)localObject1).append(jnv.a((oidb_0x791.RedDotInfo)this.b.rpt_msg_reddot_info.get(i)));
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG + "Q.qqstory.redPoint", 2, localObject2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchManager.3
 * JD-Core Version:    0.7.0.1
 */