package com.tencent.mobileqq.profile.view;

import alcn;
import android.widget.ImageView;
import aqgm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileQVipDiyView$1$1
  implements Runnable
{
  ProfileQVipDiyView$1$1(ProfileQVipDiyView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    AvatarPendantManager localAvatarPendantManager;
    if ((this.d != null) && (this.d.isPendantValid()))
    {
      this.a.CH.setVisibility(0);
      this.a.this$0.pendantId = this.d.pendantId;
      localAvatarPendantManager = (AvatarPendantManager)this.a.this$0.app.getManager(46);
      if (aqgm.cT(this.a.this$0.pendantId)) {
        localAvatarPendantManager.a(this.a.this$0.pendantId).a(this.a.CH, 2, PendantInfo.ebM, this.a.b.e.uin, this.d.pendantDiyId);
      }
    }
    for (;;)
    {
      ProfileQVipDiyView.a(this.a.this$0, this.d);
      return;
      localAvatarPendantManager.a(this.a.this$0.pendantId).a(this.a.CH, 1, PendantInfo.ebM, this.a.b.e.uin, this.d.pendantDiyId);
      continue;
      this.a.CH.setVisibility(8);
      this.a.this$0.pendantId = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipDiyView.1.1
 * JD-Core Version:    0.7.0.1
 */