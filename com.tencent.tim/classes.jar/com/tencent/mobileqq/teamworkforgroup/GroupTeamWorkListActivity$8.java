package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import aoed;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$8
  implements Runnable
{
  GroupTeamWorkListActivity$8(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    List localList;
    if (this.this$0.a != null)
    {
      if (this.cdt == 1) {
        this.this$0.a.bk(this.this$0.aoW);
      }
      localList = this.this$0.a.gu();
      if (localList == null) {}
    }
    synchronized (this.this$0.aa)
    {
      GroupTeamWorkListActivity.a(this.this$0, localList);
      Collections.sort(this.this$0.aa, this.this$0.ae);
      if (this.cdt == 1) {
        GroupTeamWorkListActivity.a(this.this$0, this.this$0.aoW, 0, 20, 1);
      }
      ??? = this.this$0.uiHandler.obtainMessage(113, 0, this.cdt, null);
      this.this$0.uiHandler.sendMessage((Message)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.8
 * JD-Core Version:    0.7.0.1
 */