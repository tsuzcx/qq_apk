package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import acff;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import pwy;

public class FriendViewHolder$1
  implements Runnable
{
  public FriendViewHolder$1(pwy parampwy, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((acff)this.val$app.getManager(51)).e(this.val$uin) == null) {
      ((FriendListHandler)this.val$app.getBusinessHandler(1)).DG(this.val$uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder.1
 * JD-Core Version:    0.7.0.1
 */