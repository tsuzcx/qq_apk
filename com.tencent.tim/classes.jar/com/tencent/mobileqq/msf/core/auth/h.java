package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class h
  implements Runnable
{
  h(d paramd, String paramString) {}
  
  public void run()
  {
    Object localObject = this.b.e.d().iterator();
    SimpleAccount localSimpleAccount;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
    } while ((!this.a.equals(localSimpleAccount.getUin())) || (!localSimpleAccount.isLogined()));
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        QLog.w("MSF.C.TokenChecker", 1, "skip removed uin: " + MsfSdkUtils.getShortUin(this.a));
        return;
      }
      localObject = new ToServiceMsg("", this.a, "login.chgTok_WEBVIEW_KEY");
      ((ToServiceMsg)localObject).setMsfCommand(MsfCommand._msf_refreToken);
      ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
      ((ToServiceMsg)localObject).setAppId(this.b.e.a.getMsfAppid());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).getAttributes().put("refresh_token_src", "AccountTokenChecker");
      this.b.e.a.changeTokenAfterLogin((ToServiceMsg)localObject, true);
      QLog.d("MSF.C.TokenChecker", 1, "refresh webKey indeed");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.h
 * JD-Core Version:    0.7.0.1
 */