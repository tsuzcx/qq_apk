package com.tencent.qqmail.model.protocol;

import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;

class QMPrivateProtocolManager$30
  extends SimpleOnProtocolListener
{
  QMPrivateProtocolManager$30(QMPrivateProtocolManager paramQMPrivateProtocolManager, QMGeneralCallback paramQMGeneralCallback, CloudProtocolInfo paramCloudProtocolInfo) {}
  
  public void onCloudResult(CloudProtocolResult paramCloudProtocolResult)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "SetUserSetting error code:" + paramCloudProtocolResult.error_code_);
    if (paramCloudProtocolResult.error_code_ == 0)
    {
      BackOffFilter.resetError(QMMath.hashInt("SetUserSetting" + QMApplicationContext.sharedInstance().getVid()));
      paramCloudProtocolResult = paramCloudProtocolResult.set_user_setting_rsp_version_;
      if (!StringExtention.isNullOrEmpty(paramCloudProtocolResult)) {
        SPManager.getEditor("user_info").putString("configtype_" + 3, paramCloudProtocolResult).apply();
      }
      if (this.val$callback != null) {
        this.val$callback.onSuccess();
      }
      return;
    }
    long l = BackOffFilter.whenToRetryOrAbort(QMMath.hashInt("SetUserSetting" + QMApplicationContext.sharedInstance().getVid()), true) * 1000L;
    if (l == 0L)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "go SetUserSetting");
      this.this$0.setUserSetting(this.val$info, this.val$callback);
    }
    for (;;)
    {
      new QMUMAError(paramCloudProtocolResult.error_code_, "CloudProtocolService.SetUserSetting");
      return;
      if (l > 0L)
      {
        QMLog.log(4, "QMPrivateProtocolManager", "SetUserSetting wait for " + l);
        Threads.runInBackground(new QMPrivateProtocolManager.30.1(this), l);
      }
      else
      {
        QMLog.log(5, "QMPrivateProtocolManager", "SetUserSetting wait so long. do not try again.");
        if (this.val$callback != null) {
          this.val$callback.onError();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager.30
 * JD-Core Version:    0.7.0.1
 */