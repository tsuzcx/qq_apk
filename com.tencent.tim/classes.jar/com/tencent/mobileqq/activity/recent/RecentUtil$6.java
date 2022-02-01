package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import anot;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public final class RecentUtil$6
  implements Runnable
{
  public RecentUtil$6(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    QQMessageFacade.Message localMessage = this.val$app.b().a(this.val$uin, 1008);
    String str1 = "0";
    if (localMessage != null)
    {
      localObject = localMessage.getExtInfoFromExtStr("gdt_msgClick");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).has("ad_id")) {
        str1 = ((JSONObject)localObject).getString("ad_id");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str3;
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "from_enterchat");
        }
        String str2 = "0";
        continue;
        localObject = "0X8005C39";
      }
    }
    str3 = localMessage.getExtInfoFromExtStr("pa_msgId");
    if (this.val$type == 1)
    {
      localObject = "0X8005C36";
      anot.b(this.val$app, "P_CliOper", "Pb_account_lifeservice", "" + localMessage.frienduin, (String)localObject, (String)localObject, 0, 1, 0, str3, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.6
 * JD-Core Version:    0.7.0.1
 */