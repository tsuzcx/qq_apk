package com.tencent.qqmail.model.protocol;

import android.graphics.Bitmap;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class QMPrivateProtocolManager$19
  implements QMGeneralCallback
{
  QMPrivateProtocolManager$19(QMPrivateProtocolManager paramQMPrivateProtocolManager, Account paramAccount, Profile paramProfile, String paramString1, String paramString2, Bitmap paramBitmap) {}
  
  public void onError()
  {
    QMLog.log(6, "QMPrivateProtocolManager", "retryUmaLoginAddAccount fail");
  }
  
  public void onSuccess()
  {
    QMLog.log(4, "QMPrivateProtocolManager", "retryUmaLoginAddAccount success");
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (SharedPreferenceUtil.isWtlogin())
    {
      localObject1 = localObject2;
      if (!this.val$acc.isBizMail())
      {
        localObject2 = new StringBuilder().append(QMWtLoginManager.getInstance().getA2(this.val$acc.getUin())).append("\t");
        if (this.val$acc.getSecondPassword() != null) {
          break label135;
        }
      }
    }
    label135:
    for (localObject1 = "";; localObject1 = this.val$acc.getSecondPassword())
    {
      localObject1 = Aes.encode((String)localObject1, Aes.getServerKey());
      this.this$0.addAccount(this.val$profile, this.val$domain, this.val$acc.getEmail(), (String)localObject1, this.val$acc.getId(), this.val$nick, this.val$bitmap, false, this.val$acc.isBizMail());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.19
 * JD-Core Version:    0.7.0.1
 */