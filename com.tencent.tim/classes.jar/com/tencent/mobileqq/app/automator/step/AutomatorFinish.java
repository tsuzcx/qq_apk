package com.tencent.mobileqq.app.automator.step;

import acbn;
import acmq;
import acxu;
import acyd;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.util.Log;
import anmo;
import anpc;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.io.File;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;

public class AutomatorFinish
  extends AsyncStep
{
  public static long Rb = -1L;
  
  public int od()
  {
    int i = 1;
    Rb = System.currentTimeMillis();
    long l = Rb - this.a.Ra;
    anmo.dKf |= 0x20;
    this.a.Ra = 0L;
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_threadOpId", String.valueOf(acmq.a().AZ()));
    anpc.a(this.a.app.getApp()).collectPerformance(null, "actQQInit", true, l, this.a.cyA, (HashMap)localObject, null);
    Log.i("AutoMonitor", "QQInitialize, cost=" + l + ", totalFailCount=" + this.a.cyA);
    try
    {
      BaseApplicationImpl.sApplication.getClassLoader().loadClass("com.tencent.mobileqq.protect.RtRa");
      if (i != 0) {}
      try
      {
        anpc.a(BaseApplicationImpl.sApplication).collectPerformance(this.a.app.getCurrentUin(), "qqDetectAttack", true, 0L, 0L, null, null);
        localObject = BaseApplicationImpl.sApplication.getSharedPreferences("QQDetectAttack", 0);
        i = ((SharedPreferences)localObject).getInt("AttackCount", 0);
        if (i >= 10)
        {
          Intent localIntent = new Intent(BaseApplicationImpl.sApplication, NotificationActivity.class);
          localIntent.setAction("mqq.intent.action.ACCOUNT_KICKED");
          localIntent.putExtra("reason", Constants.LogoutReason.secKicked);
          signature.SignatureKickData localSignatureKickData = new signature.SignatureKickData();
          localSignatureKickData.str_packname.set("pack");
          int j = BaseApplicationImpl.sApplication.getSharedPreferences("SecSig", 0).getInt("SecResEntry", -1);
          localSignatureKickData.u32_check_result.set(j & 0x12);
          Resources localResources = BaseApplicationImpl.sApplication.getResources();
          localSignatureKickData.str_right_button.set(localResources.getString(2131692928));
          localSignatureKickData.str_url.set("https://im.qq.com");
          localIntent.putExtra("data", localSignatureKickData.toByteArray());
          localIntent.putExtra("title", localResources.getString(2131721126));
          localIntent.putExtra("msg", localResources.getString(2131701071));
          MsfSdkUtils.updateSimpleAccount(this.a.getCurrentAccountUin(), false);
          BaseApplicationImpl.sApplication.setSortAccountList(MsfSdkUtils.getLoginedAccountList());
          this.a.app.logout(true);
          localIntent.setFlags(872415232);
          BaseApplicationImpl.sApplication.startActivity(localIntent);
        }
        ((SharedPreferences)localObject).edit().putInt("AttackCount", i + 1).commit();
        localObject = new File(acbn.SDCARD_ROOT + "/tencent/MobileQQ/data/wifi");
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (anmo.cIx)
        {
          localObject = (acyd)this.a.app.a().a(2);
          if (QLog.isColorLevel()) {
            QLog.d("Perf", 0, "after automator finish,fts get the troop list");
          }
          ((acyd)localObject).cOW();
        }
      }
      catch (Throwable localThrowable2)
      {
        label526:
        break label526;
      }
      return 7;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AutomatorFinish
 * JD-Core Version:    0.7.0.1
 */