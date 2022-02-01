package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.FriendInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import ufj;

class AddRequestActivity$8$1$1
  implements Runnable
{
  AddRequestActivity$8$1$1(AddRequestActivity.8.1 param1, Card paramCard) {}
  
  public void run()
  {
    if ((this.a.a.this$0.a != null) && (this.a.a.this$0.a.msg != null) && (this.a.a.this$0.a.msg.friend_info.has()) && (this.a.a.this$0.a.msg.friend_info.msg_joint_friend.has() == true))
    {
      AddRequestActivity.a(this.a.a.this$0).setText(this.a.a.this$0.a.msg.friend_info.msg_joint_friend.get());
      AddRequestActivity.a(this.a.a.this$0).setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.AddRequestActivity", 2, "Card find Uin :" + this.a.a.this$0.aKN + "age:" + this.c.age + "gender:" + this.c.shGender);
      }
      return;
      AddRequestActivity.a(this.a.a.this$0).setVisibility(8);
      this.a.a.this$0.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8.1.1
 * JD-Core Version:    0.7.0.1
 */