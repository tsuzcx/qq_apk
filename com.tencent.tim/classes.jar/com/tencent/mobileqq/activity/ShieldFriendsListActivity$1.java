package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class ShieldFriendsListActivity$1
  implements Runnable
{
  ShieldFriendsListActivity$1(ShieldFriendsListActivity paramShieldFriendsListActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((acff)this.this$0.app.getManager(51)).cn();
    this.this$0.runOnUiThread(new ShieldFriendsListActivity.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity.1
 * JD-Core Version:    0.7.0.1
 */