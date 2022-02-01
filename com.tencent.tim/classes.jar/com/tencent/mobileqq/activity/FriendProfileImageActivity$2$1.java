package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class FriendProfileImageActivity$2$1
  implements Runnable
{
  FriendProfileImageActivity$2$1(FriendProfileImageActivity.2 param2, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    this.a.this$0.qa.setVisibility(0);
    ((AvatarPendantManager)this.a.this$0.app.getManager(46)).a(this.a.this$0.pendantId).a(this.a.this$0.qa, 1, PendantInfo.ebN, this.b.uin, this.b.pendantDiyId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2.1
 * JD-Core Version:    0.7.0.1
 */