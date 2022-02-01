package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.IErrorCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class SettingIndependentNickActivity$3$2
  implements QMCallback.IErrorCallback
{
  SettingIndependentNickActivity$3$2(SettingIndependentNickActivity.3 param3) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse, QMNetworkError paramQMNetworkError)
  {
    QMLog.log(6, "SettingIndependentNickActivity", "set alias indep failed" + paramQMNetworkError.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingIndependentNickActivity.3.2
 * JD-Core Version:    0.7.0.1
 */