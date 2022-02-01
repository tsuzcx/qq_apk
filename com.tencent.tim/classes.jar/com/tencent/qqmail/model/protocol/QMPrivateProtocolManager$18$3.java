package com.tencent.qqmail.model.protocol;

import com.tencent.qqmail.account.callback.LoginCallback;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class QMPrivateProtocolManager$18$3
  implements LoginCallback
{
  QMPrivateProtocolManager$18$3(QMPrivateProtocolManager.18 param18) {}
  
  public void loginFail()
  {
    QMLog.log(6, "QMPrivateProtocolManager", "handle addAccountCallback fail:" + this.this$1.val$email);
  }
  
  public void loginSuccess()
  {
    QMLog.log(4, "QMPrivateProtocolManager", "handle addAccountCallback success:" + this.this$1.val$email);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (SharedPreferenceUtil.isWtlogin())
    {
      localObject1 = localObject2;
      if (!this.this$1.val$isBiz)
      {
        localObject2 = new StringBuilder().append(QMWtLoginManager.getInstance().getA2(this.this$1.val$acc.getUin())).append("\t");
        if (this.this$1.val$acc.getSecondPassword() != null) {
          break label185;
        }
      }
    }
    label185:
    for (localObject1 = "";; localObject1 = this.this$1.val$acc.getSecondPassword())
    {
      localObject1 = Aes.encode((String)localObject1, Aes.getServerKey());
      this.this$1.this$0.addAccount(this.this$1.val$profile, this.this$1.val$domain, this.this$1.val$email, (String)localObject1, this.this$1.val$accountId, this.this$1.val$nick, this.this$1.val$bitmap, this.this$1.val$isUpgrade, this.this$1.val$isBiz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.18.3
 * JD-Core Version:    0.7.0.1
 */