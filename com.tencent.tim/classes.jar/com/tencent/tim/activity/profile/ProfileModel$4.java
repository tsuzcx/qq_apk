package com.tencent.tim.activity.profile;

import atbj;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;

public class ProfileModel$4
  implements Runnable
{
  public ProfileModel$4(atbj paramatbj) {}
  
  public void run()
  {
    try
    {
      FriendProfileCardActivity.a(this.this$0.mApp, this.this$0.c);
      FriendProfileCardActivity.b(this.this$0.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.activity.profile.ProfileModel.4
 * JD-Core Version:    0.7.0.1
 */