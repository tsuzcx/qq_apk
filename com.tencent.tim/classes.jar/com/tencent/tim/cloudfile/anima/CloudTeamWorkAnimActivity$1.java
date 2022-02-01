package com.tencent.tim.cloudfile.anima;

import com.tencent.qphone.base.util.QLog;

class CloudTeamWorkAnimActivity$1
  implements Runnable
{
  CloudTeamWorkAnimActivity$1(CloudTeamWorkAnimActivity paramCloudTeamWorkAnimActivity) {}
  
  public void run()
  {
    if (!CloudTeamWorkAnimActivity.a(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CloudTeamWorkAnimActivity", 1, "doOnActivityResult, but anim bitmap is null.");
      }
      this.this$0.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity.1
 * JD-Core Version:    0.7.0.1
 */