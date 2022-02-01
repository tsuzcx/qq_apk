package com.tencent.mobileqq.profile.view;

import acff;
import alcn;
import aqgm;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class ProfileQVipV5View$1
  implements Runnable
{
  ProfileQVipV5View$1(ProfileQVipV5View paramProfileQVipV5View, alcn paramalcn, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.this$0.app.getManager(51)).a(this.b.e.uin);
    ProfileQVipV5View.1.1 local1 = new ProfileQVipV5View.1.1(this, localExtensionInfo);
    ThreadManager.getUIHandler().post(local1);
    if ((this.cwI) && (localExtensionInfo != null) && (aqgm.cU(localExtensionInfo.pendantId)))
    {
      this.this$0.app.addObserver(this.this$0.g);
      aqgm.bg(this.this$0.app, this.b.e.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileQVipV5View.1
 * JD-Core Version:    0.7.0.1
 */