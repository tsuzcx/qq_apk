package com.tencent.tim.cloudfile.anima;

import android.widget.ImageView;
import ateh;
import com.tencent.mobileqq.app.QQAppInterface;

class CloudTeamWorkAnimActivity$2
  implements Runnable
{
  CloudTeamWorkAnimActivity$2(CloudTeamWorkAnimActivity paramCloudTeamWorkAnimActivity) {}
  
  public void run()
  {
    CloudTeamWorkAnimActivity.a(this.this$0).postInvalidate();
    CloudTeamWorkAnimActivity.a(this.this$0).setVisibility(0);
    ((ateh)this.this$0.app.getBusinessHandler(180)).notifyUI(31, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.2
 * JD-Core Version:    0.7.0.1
 */