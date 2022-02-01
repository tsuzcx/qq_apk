package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import izg;
import java.util.ArrayList;

public class GAudioMembersCtrlActivity$2$1
  implements Runnable
{
  public GAudioMembersCtrlActivity$2$1(izg paramizg) {}
  
  public void run()
  {
    if ((GAudioMembersCtrlActivity.a(this.a.this$0) != null) && (GAudioMembersCtrlActivity.a(this.a.this$0).size() != 0))
    {
      this.a.this$0.notifyDataChange();
      return;
    }
    QLog.d("GAudioMembersCtrlActivity", 1, "mInviteMemberInfoChange null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.2.1
 * JD-Core Version:    0.7.0.1
 */