package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import ysf;

class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2
  implements Runnable
{
  NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2(NewFriendMoreSysMsgSuspiciousFragment.a parama) {}
  
  public void run()
  {
    List localList = NewFriendMoreSysMsgSuspiciousFragment.a.a(this.this$0).cS();
    ThreadManager.getUIHandler().post(new NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2
 * JD-Core Version:    0.7.0.1
 */