package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class FriendProfileMoreInfoActivity$6
  implements Runnable
{
  FriendProfileMoreInfoActivity$6(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void run()
  {
    Card localCard = ((acff)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    this.this$0.app.runOnUiThread(new FriendProfileMoreInfoActivity.6.1(this, localCard));
    this.this$0.c.cHq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */