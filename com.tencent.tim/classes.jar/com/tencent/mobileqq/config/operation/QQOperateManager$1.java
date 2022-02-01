package com.tencent.mobileqq.config.operation;

import aeve;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class QQOperateManager$1
  implements Runnable
{
  public QQOperateManager$1(aeve paramaeve, int paramInt) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(aeve.access$000())) {
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(aeve.access$000() + "QQOperationVoIPRequestCount", this.cPq).commit();
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QQOperateVoIP", 4, "onDestroy.......");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperateManager.1
 * JD-Core Version:    0.7.0.1
 */