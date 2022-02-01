package com.tencent.qqmail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

class BaseActivityImpl$33
  implements DialogInterface.OnDismissListener
{
  BaseActivityImpl$33(BaseActivityImpl paramBaseActivityImpl, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = QMApplicationContext.sharedInstance().getSharedPreferences("user_info", 0);
    boolean bool = paramDialogInterface.getBoolean("isShowingCloseQQWx", false);
    if (bool) {
      paramDialogInterface.edit().putBoolean("isShowingCloseQQWx", false).commit();
    }
    if (!BaseActivityImpl.access$1700(this.this$0))
    {
      QMSettingManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, false);
      QMMailManager.sharedInstance().setOnlyPushMailApp(this.val$accountId, false);
    }
    QMLog.log(4, "BaseActivityImpl", "isShowingXqqwx is : " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.33
 * JD-Core Version:    0.7.0.1
 */