package com.tencent.mobileqq.profile.view;

import alcn;
import android.widget.ImageView;
import anot;
import aqgm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class ProfileBaseView$1$1
  implements Runnable
{
  ProfileBaseView$1$1(ProfileBaseView.1 param1, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    if ((this.d != null) && (this.d.isPendantValid()))
    {
      ProfileBaseView.a(this.a.this$0).setVisibility(0);
      this.a.this$0.pendantId = this.d.pendantId;
      AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.a.this$0.app.getManager(46);
      if (aqgm.cT(this.a.this$0.pendantId)) {
        localAvatarPendantManager.a(this.a.this$0.pendantId).a(ProfileBaseView.a(this.a.this$0), 2, PendantInfo.ebM, this.a.b.e.uin, this.d.pendantDiyId);
      }
      for (;;)
      {
        if (this.a.cwI) {
          anot.a(this.a.this$0.app, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        }
        return;
        localAvatarPendantManager.a(this.a.this$0.pendantId).a(ProfileBaseView.a(this.a.this$0), 1, PendantInfo.ebM, this.a.b.e.uin, this.d.pendantDiyId);
      }
    }
    ProfileBaseView.a(this.a.this$0).setVisibility(4);
    this.a.this$0.pendantId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView.1.1
 * JD-Core Version:    0.7.0.1
 */