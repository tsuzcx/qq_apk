package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import acff;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import pwm;

public class FriendNodeViewHolder$1
  implements Runnable
{
  public FriendNodeViewHolder$1(pwm parampwm, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((acff)this.val$app.getManager(51)).e(this.val$uin) == null) {
      ((FriendListHandler)this.val$app.getBusinessHandler(1)).DG(this.val$uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1
 * JD-Core Version:    0.7.0.1
 */