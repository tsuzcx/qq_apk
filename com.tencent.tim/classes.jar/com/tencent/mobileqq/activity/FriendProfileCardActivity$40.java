package com.tencent.mobileqq.activity;

import acff;
import alcn;
import android.os.Message;
import auru;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class FriendProfileCardActivity$40
  implements Runnable
{
  FriendProfileCardActivity$40(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = (acff)this.this$0.app.getManager(51);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label164;
      }
      localObject = new Card();
    }
    label164:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (this.this$0.f != null) {
          this.this$0.f.sendMessage(localMessage);
        }
        i = j;
        if (this.this$0.a.e != null) {
          i = this.this$0.a.e.bJa;
        }
        this.this$0.AQ(i);
        return;
        localObject = ((acff)localObject).b(this.this$0.a.e.uin);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.40
 * JD-Core Version:    0.7.0.1
 */