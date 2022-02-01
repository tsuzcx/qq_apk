package com.tencent.mobileqq.app.automator.step;

import aewh;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import igg;
import java.io.File;

public class QAVStep
  extends AsyncStep
{
  public int od()
  {
    String str1 = igg.gu();
    String str2 = File.separator + "config.xml";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qav_config_flag", 0);
    int i = localSharedPreferences.getInt("flag_delete", 0);
    if (i != 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QQInitHandler", 1, "QAVStep, flag_delete[" + i + "]");
      }
      return 7;
    }
    aqhq.cn(str1 + 106);
    aqhq.deleteFile(str1 + 132 + str2);
    aqhq.deleteFile(str1 + 176 + str2);
    aqhq.deleteFile(str1 + 216 + str2);
    aqhq.cn(str1 + 263);
    aqhq.cn(str1 + 270);
    aqhq.deleteFile(str1 + 370 + str2);
    aqhq.deleteFile(str1 + "beauty" + File.separator + "beauty_config.json");
    aqhq.cn(str1 + "signal_strength");
    i = aewh.getVersionCode(BaseApplicationImpl.getContext());
    localSharedPreferences.edit().putInt("flag_delete", i).commit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.QAVStep
 * JD-Core Version:    0.7.0.1
 */