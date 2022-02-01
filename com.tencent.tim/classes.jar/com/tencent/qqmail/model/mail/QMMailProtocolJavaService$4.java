package com.tencent.qqmail.model.mail;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.moai.mailsdk.util.SPDelegate;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

class QMMailProtocolJavaService$4
  implements SPDelegate
{
  QMMailProtocolJavaService$4(QMMailProtocolJavaService paramQMMailProtocolJavaService) {}
  
  public String getValue(String paramString)
  {
    if (!StringExtention.isNullOrEmpty(paramString)) {
      return SPManager.getSp("protocol_mail").getString(paramString, "");
    }
    return "";
  }
  
  public void saveValue(String paramString1, String paramString2)
  {
    if (!StringExtention.isNullOrEmpty(paramString1)) {
      SPManager.getSp("protocol_mail").edit().putString(paramString1, paramString2).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolJavaService.4
 * JD-Core Version:    0.7.0.1
 */