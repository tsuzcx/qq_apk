package com.tencent.mobileqq.teamworkforgroup;

import aodw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class GroupTeamWorkListActivity$3
  implements Runnable
{
  GroupTeamWorkListActivity$3(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.this$0.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT())) {
      localWebProcessManager.a(101, new aodw(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.3
 * JD-Core Version:    0.7.0.1
 */