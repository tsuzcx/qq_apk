package com.tencent.mobileqq.teamwork.spread;

import agne;
import aocs.a;
import aocu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BuddyFileAIOMsgTips$1
  implements Runnable
{
  public BuddyFileAIOMsgTips$1(aocu paramaocu, aocs.a parama) {}
  
  public void run()
  {
    List localList = this.this$0.mApp.a().av(this.this$0.mUin);
    if ((localList == null) || (localList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("BuddyFileAIOMsgTips", 1, "current AIO has not File,peerType[" + this.this$0.dNX + "]");
      }
      this.a.mv(new ArrayList());
      return;
    }
    ThreadManager.post(new BuddyFileAIOMsgTips.1.1(this, localList), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.spread.BuddyFileAIOMsgTips.1
 * JD-Core Version:    0.7.0.1
 */