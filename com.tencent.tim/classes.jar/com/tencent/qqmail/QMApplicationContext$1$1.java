package com.tencent.qqmail;

import android.content.SharedPreferences.Editor;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.network.filter.BackOffFilter;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolResult;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.QMUMAError;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService.PushStartUpReason;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Date;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

class QMApplicationContext$1$1
  implements Runnable
{
  QMApplicationContext$1$1(QMApplicationContext.1 param1, CloudProtocolResult paramCloudProtocolResult) {}
  
  public void run()
  {
    QMLog.log(4, "QMApplicationContext", "registerVid error code:" + this.val$result.error_code_);
    if (this.val$result.error_code_ == 0)
    {
      QMLog.log(4, "QMApplicationContext", "registerVid done");
      BackOffFilter.resetError(QMMath.hashInt("INIT_VID"));
      Object localObject1 = Long.valueOf(this.val$result.uma_id_);
      Object localObject2 = this.val$result.psw_;
      QMSharedPreferenceManager.getInstance().setVid(((Long)localObject1).longValue());
      QMSharedPreferenceManager.getInstance().setVidPwd((String)localObject2);
      QMLog.log(4, "QMApplicationContext", "registerVid: " + localObject1 + "; " + (String)localObject2);
      CrashReport.setUserId(QMApplicationContext.sharedInstance(), String.valueOf(this.this$1.this$0.getVid()) + ";" + CloudProtocolHelper.getDeviceId());
      QMServiceManager.startPushService(QMPushService.PushStartUpReason.OTHER);
      QMPrivateProtocolManager.sharedInstance().updateConfig(true, 8, null);
      AddAccountLocalLogUtil.timeLineAccountChange("OTHER", "registervid success:" + localObject1);
      QMLogStream.logWithoutUma(-40004, "vid:" + this.this$1.this$0.getVid(), "Event_App_Get_Vid_Success");
      localObject1 = DeviceUtil.getDeviceInfos();
      localObject2 = DeviceUtil.getScreenWidthHeight(QMApplicationContext.sharedInstance());
      QMLogStream.logWithoutUma(-40029, ((DeviceInfo)localObject1).MANUFACTURER + ";" + ((DeviceInfo)localObject1).BRAND + ";" + ((DeviceInfo)localObject1).MODEL + ";" + localObject2[0] + "*" + localObject2[1], "Event_Error");
      QMLogStream.submitLog(false, true);
      AppStatusUtil.logWakeup();
      if (AccountManager.shareInstance().getAccountList().size() != 0)
      {
        QMPrivateProtocolManager.sharedInstance().alignAccount();
        QMSettingManager.sharedInstance().setAlignAccountLatestTime(new Date().getTime());
      }
      KvHelper.registerVid(new double[0]);
      if (AppConfig.isBeta()) {
        OssHelper.activeVid(new Object[] { "reg_vid" });
      }
      SPManager.getEditor("user_info").putLong("reg_vid_time", System.currentTimeMillis()).apply();
      QMApplicationContext.access$000(this.this$1.this$0, false);
      return;
    }
    QMLogStream.logWithoutUma(-40000, "errcode" + this.val$result.error_code_, "Event_App_Get_Vid_Fail");
    new QMUMAError(this.val$result.error_code_, "CloudProtocolService.Register. network:" + QMNetworkUtils.isNetworkConnected(QMApplicationContext.sharedInstance()));
    int i = BackOffFilter.whenToRetry(QMMath.hashInt("INIT_VID"), true) * 1000 / 10;
    Threads.runInBackground(new QMApplicationContext.1.1.1(this), i);
    QMLog.log(5, "QMApplicationContext", "register fail. delay:" + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QMApplicationContext.1.1
 * JD-Core Version:    0.7.0.1
 */