package com.tencent.qqmail.account.helper;

import com.tencent.androidqqmail.tim.TimMailLoginManager.GetTicketCallback;
import com.tencent.qqmail.account.callback.WtLoginCallback;
import com.tencent.qqmail.utilities.log.QMLog;

final class QMWtLoginManager$2
  implements TimMailLoginManager.GetTicketCallback
{
  QMWtLoginManager$2(WtLoginCallback paramWtLoginCallback) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    QMLog.log(6, "QMWtLoginManager", String.format("getNewWtLoginTicket: uin[%s], ret[%d]", new Object[] { paramString, Integer.valueOf(paramInt2) }));
    if (this.val$callback != null) {
      this.val$callback.onError(paramInt2, "", paramString);
    }
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    QMLog.log(4, "QMWtLoginManager", "getNewWtLoginTicket: requestA2AndSkey success:" + paramString1);
    if (this.val$callback != null) {
      this.val$callback.onSuccess(0, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.QMWtLoginManager.2
 * JD-Core Version:    0.7.0.1
 */