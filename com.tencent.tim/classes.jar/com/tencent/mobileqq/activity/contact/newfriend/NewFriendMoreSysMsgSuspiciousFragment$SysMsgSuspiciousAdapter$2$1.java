package com.tencent.mobileqq.activity.contact.newfriend;

import android.view.View;
import java.util.List;

class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2$1
  implements Runnable
{
  NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$2$1(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2 param2, List paramList) {}
  
  public void run()
  {
    NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0, this.td);
    if ((NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0) == null) || (NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0).isEmpty())) {
      if (NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0) != null) {
        NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0).setVisibility(0);
      }
    }
    for (;;)
    {
      this.a.this$0.notifyDataSetChanged();
      return;
      if (NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0) != null) {
        NewFriendMoreSysMsgSuspiciousFragment.a.a(this.a.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */