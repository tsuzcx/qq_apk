package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import wct;

public class TroopRequestActivity$14$1
  implements Runnable
{
  public TroopRequestActivity$14$1(wct paramwct, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.app != null)
    {
      localObject = (acff)this.a.this$0.app.getManager(51);
      if (localObject != null)
      {
        localObject = ((acff)localObject).b(this.val$uin);
        if (localObject != null) {
          this.a.this$0.runOnUiThread(new TroopRequestActivity.14.1.1(this, (Card)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onUpdateFriendInfo app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.14.1
 * JD-Core Version:    0.7.0.1
 */