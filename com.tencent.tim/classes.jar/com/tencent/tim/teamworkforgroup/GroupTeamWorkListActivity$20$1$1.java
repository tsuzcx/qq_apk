package com.tencent.tim.teamworkforgroup;

import aqha;
import aqju;
import aqmj;
import aumm;
import aumn;
import com.tencent.mobileqq.app.QQAppInterface;

public class GroupTeamWorkListActivity$20$1$1
  implements Runnable
{
  GroupTeamWorkListActivity$20$1$1(GroupTeamWorkListActivity.20.1 param1) {}
  
  public void run()
  {
    GroupTeamWorkListActivity.a(this.a.a.this$0);
    GroupTeamWorkListActivity.a(this.a.a.this$0, aqha.a(this.a.a.this$0, 230).setMessage(this.a.a.this$0.getString(2131689827)));
    GroupTeamWorkListActivity.a(this.a.a.this$0).setPositiveButton(this.a.a.this$0.getString(2131689826), new aumn(this));
    GroupTeamWorkListActivity.a(this.a.a.this$0).show();
    aqmj.J(this.a.a.this$0, this.a.a.this$0.app.getCurrentAccountUin(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity.20.1.1
 * JD-Core Version:    0.7.0.1
 */