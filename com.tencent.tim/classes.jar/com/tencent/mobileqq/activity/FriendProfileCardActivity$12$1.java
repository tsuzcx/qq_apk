package com.tencent.mobileqq.activity;

import acff;
import alcn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import uyp;

public class FriendProfileCardActivity$12$1
  implements Runnable
{
  public FriendProfileCardActivity$12$1(uyp paramuyp) {}
  
  public void run()
  {
    Card localCard = ((acff)this.a.this$0.app.getManager(51)).b(this.a.this$0.a.e.uin);
    this.a.this$0.a.d = localCard;
    if (localCard != null) {
      this.a.this$0.runOnUiThread(new FriendProfileCardActivity.12.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1
 * JD-Core Version:    0.7.0.1
 */