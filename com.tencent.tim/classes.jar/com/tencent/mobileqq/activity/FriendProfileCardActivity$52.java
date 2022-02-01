package com.tencent.mobileqq.activity;

import acff;
import alcs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;

class FriendProfileCardActivity$52
  implements Runnable
{
  FriendProfileCardActivity$52(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = ((acff)this.this$0.app.getManager(51)).b(this.this$0.app.getCurrentAccountUin());
    if (localObject == null) {
      this.this$0.aNl = "-1";
    }
    for (;;)
    {
      this.this$0.aNl = "-1";
      return;
      if (((Card)localObject).lCurrentStyleId == alcs.agc)
      {
        localObject = (QZoneCover)this.this$0.app.a().createEntityManager().find(QZoneCover.class, this.this$0.app.getCurrentAccountUin());
        if (localObject != null) {
          this.this$0.aNl = ((QZoneCover)localObject).type;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.52
 * JD-Core Version:    0.7.0.1
 */