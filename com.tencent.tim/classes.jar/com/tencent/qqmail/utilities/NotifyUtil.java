package com.tencent.qqmail.utilities;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotifyUtil
{
  private static final String CONF_MAIL_IDS = "mailIds_v3";
  
  public static boolean isNotifiedMailId(int paramInt, long paramLong)
  {
    return QMServiceManager.getWebPushSP().getString("mailIds_v3", "").contains(paramInt + "_" + paramLong);
  }
  
  public static void removeMailId(int paramInt, long paramLong)
  {
    QMPushMailNotify.getInstance().cancelNotifyNewMail(paramInt, paramLong);
    QMServiceManager.getWebPushEditor().putString("mailIds_v3", Pattern.compile(paramInt + "_" + paramLong + ";").matcher(QMServiceManager.getWebPushSP().getString("mailIds_v3", "")).replaceFirst("")).apply();
  }
  
  public static void saveLatestMailId(int paramInt, long paramLong)
  {
    String str1 = paramInt + "_" + paramLong + ";";
    String str2 = QMServiceManager.getWebPushSP().getString("mailIds_v3", "");
    if (str2.contains(str1)) {
      return;
    }
    if (str2.split(";").length <= 100) {}
    for (str1 = str2 + str1;; str1 = str2.substring(str2.indexOf(";") + 1) + str1)
    {
      QMServiceManager.getWebPushEditor().putString("mailIds_v3", str1).apply();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.NotifyUtil
 * JD-Core Version:    0.7.0.1
 */