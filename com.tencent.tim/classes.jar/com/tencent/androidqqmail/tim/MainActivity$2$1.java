package com.tencent.androidqqmail.tim;

import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class MainActivity$2$1
  implements TimMailLoginManager.GetTicketCallback
{
  MainActivity$2$1(MainActivity.2 param2) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    Threads.runOnMainThread(new MainActivity.2.1.2(this, paramString));
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    String str1 = QMWtLoginManager.getInstance().getA2(paramString2);
    String str2 = QMWtLoginManager.getInstance().getSkey(paramString2);
    if (str1 != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (str2 != null) {
        bool2 = true;
      }
      QMLog.log(4, "MainActivity", String.format("first login from tim: ssoAccount[%s], uin[%s], a2[%b], skey[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      SharedPreferenceUtil.setWtlogin(true);
      Threads.runOnMainThread(new MainActivity.2.1.1(this, paramString1, str1, str2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.2.1
 * JD-Core Version:    0.7.0.1
 */