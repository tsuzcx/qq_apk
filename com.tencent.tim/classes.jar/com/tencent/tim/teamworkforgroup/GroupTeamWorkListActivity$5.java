package com.tencent.tim.teamworkforgroup;

import aumr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class GroupTeamWorkListActivity$5
  implements Runnable
{
  GroupTeamWorkListActivity$5(GroupTeamWorkListActivity paramGroupTeamWorkListActivity) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.this$0.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT())) {
      localWebProcessManager.a(101, new aumr(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity.5
 * JD-Core Version:    0.7.0.1
 */