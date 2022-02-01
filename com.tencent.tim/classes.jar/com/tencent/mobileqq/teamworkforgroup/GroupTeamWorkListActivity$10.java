package com.tencent.mobileqq.teamworkforgroup;

import android.os.Message;
import aoed;
import java.util.List;
import mqq.os.MqqHandler;

class GroupTeamWorkListActivity$10
  implements Runnable
{
  GroupTeamWorkListActivity$10(GroupTeamWorkListActivity paramGroupTeamWorkListActivity, int paramInt) {}
  
  public void run()
  {
    List localList;
    if (this.this$0.a != null)
    {
      if (this.cdt == 1) {
        this.this$0.a.bk(this.this$0.aoW);
      }
      localList = this.this$0.a.gv();
      if (localList == null) {}
    }
    synchronized (this.this$0.GX)
    {
      GroupTeamWorkListActivity.b(this.this$0, localList);
      ??? = this.this$0.uiHandler.obtainMessage(115, 0, 0, null);
      this.this$0.uiHandler.sendMessage((Message)???);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.10
 * JD-Core Version:    0.7.0.1
 */