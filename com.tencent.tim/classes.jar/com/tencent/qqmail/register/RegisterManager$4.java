package com.tencent.qqmail.register;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import moai.core.watcher.Watchers;

final class RegisterManager$4
  implements QMCallback.IErrorCallback
{
  RegisterManager$4(String paramString1, String paramString2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(4, "RegisterManager", "checkPhoneAndUinRelationship onError:" + paramQMNetworkResponse + ",error:" + paramQMNetworkError);
    ((CheckPhoneWatcher)Watchers.of(CheckPhoneWatcher.class)).onError(this.val$phone, this.val$uin, paramQMNetworkError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterManager.4
 * JD-Core Version:    0.7.0.1
 */