package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class SettingQmDefaultAliasActivity$2$2
  implements QMCallback.IErrorCallback
{
  SettingQmDefaultAliasActivity$2$2(SettingQmDefaultAliasActivity.2 param2) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "SettingQmDefaultAliasActivity", "set default alias failed" + paramQMNetworkError.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingQmDefaultAliasActivity.2.2
 * JD-Core Version:    0.7.0.1
 */