package com.tencent.mobileqq.profile.view;

import acff;
import alcn;
import android.os.Message;
import aqgm;
import aurf;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class ProfileHeaderView$8
  implements Runnable
{
  ProfileHeaderView$8(ProfileHeaderView paramProfileHeaderView, alcn paramalcn, boolean paramBoolean) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((acff)this.this$0.app.getManager(51)).a(this.b.e.uin);
    Message localMessage = this.this$0.i.obtainMessage(ProfileHeaderView.dtj, localExtensionInfo);
    this.this$0.i.sendMessage(localMessage);
    if ((this.cwI) && (localExtensionInfo != null) && (aqgm.cU(localExtensionInfo.pendantId))) {
      aqgm.bg(this.this$0.app, this.b.e.uin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.8
 * JD-Core Version:    0.7.0.1
 */