package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;

class ProfileCardMoreActivity$13
  implements Runnable
{
  ProfileCardMoreActivity$13(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = this.this$0.bF(this.this$0.e.uin);
      this.this$0.aZf = false;
      this.this$0.app.runOnUiThread(new ProfileCardMoreActivity.13.1(this, i));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity.13
 * JD-Core Version:    0.7.0.1
 */