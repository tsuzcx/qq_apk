package com.tencent.qqmail.activity.setting;

import android.graphics.Bitmap;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingAccountActivity$6
  implements AvatarSelector.OnAvatarChange
{
  SettingAccountActivity$6(SettingAccountActivity paramSettingAccountActivity) {}
  
  public void onAvatarChange(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (!QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance())) {
        Threads.runOnMainThread(new SettingAccountActivity.6.1(this));
      }
    }
    else {
      return;
    }
    SettingAccountActivity.access$602(this.this$0, paramBitmap);
    this.this$0.getTips().showLoading(this.this$0.getString(2131719639));
    Profile localProfile = SettingAccountActivity.access$000(this.this$0).getProfile();
    QMLog.log(4, "SettingAccountActivity", "AvatarSelector profile: ");
    StringBuilder localStringBuilder;
    if (SettingAccountActivity.access$000(this.this$0).isQQMail())
    {
      if ((!SharedPreferenceUtil.isWtlogin()) || (SettingAccountActivity.access$000(this.this$0).isBizMail())) {
        break label233;
      }
      localStringBuilder = new StringBuilder().append(QMWtLoginManager.getInstance().getA2(SettingAccountActivity.access$000(this.this$0).getUin())).append("\t");
      if (SettingAccountActivity.access$000(this.this$0).getSecondPassword() != null) {
        break label219;
      }
      paramBitmap = "";
    }
    label219:
    label233:
    for (localProfile.QQPassword = Aes.encode(paramBitmap, Aes.getServerKey());; localProfile.QQPassword = StringExtention.encodeURI(Aes.encode(SettingAccountActivity.access$000(this.this$0).getPwd(), Aes.getServerKey())))
    {
      QMLog.log(4, "SettingAccountActivity", "AvatarSelector setAccountPhoto: ");
      QMPrivateProtocolManager.sharedInstance().setAccountPhoto(SettingAccountActivity.access$300(this.this$0), localProfile, SettingAccountActivity.access$000(this.this$0).getEmail(), SettingAccountActivity.access$600(this.this$0), Profile.getProtocol(localProfile));
      DataCollector.logEvent("DetailEvent_ModifyAvatar");
      return;
      paramBitmap = SettingAccountActivity.access$000(this.this$0).getSecondPassword();
      break;
    }
  }
  
  public void onDefaultAvatar(Bitmap paramBitmap)
  {
    SettingAccountActivity.access$100(this.this$0).setAvatar(paramBitmap, SettingAccountActivity.access$000(this.this$0).getName());
    SettingAccountActivity.access$200(this.this$0).setDetail(SettingAccountActivity.access$100(this.this$0).getBitmap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingAccountActivity.6
 * JD-Core Version:    0.7.0.1
 */