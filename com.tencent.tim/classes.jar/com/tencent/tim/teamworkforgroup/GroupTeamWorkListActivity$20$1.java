package com.tencent.tim.teamworkforgroup;

import aqmj;
import aumm;
import com.tencent.mobileqq.app.QQAppInterface;

public class GroupTeamWorkListActivity$20$1
  implements Runnable
{
  public GroupTeamWorkListActivity$20$1(aumm paramaumm) {}
  
  public void run()
  {
    if (aqmj.aX(this.a.this$0, this.a.this$0.app.getCurrentAccountUin())) {
      this.a.this$0.runOnUiThread(new GroupTeamWorkListActivity.20.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity.20.1
 * JD-Core Version:    0.7.0.1
 */