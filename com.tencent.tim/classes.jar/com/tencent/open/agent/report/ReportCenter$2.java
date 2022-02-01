package com.tencent.open.agent.report;

import alla;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import aroi;
import arts;
import artu;
import arwo;
import arxr;
import arxs;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TimeZone;

public class ReportCenter$2
  implements Runnable
{
  public ReportCenter$2(arts paramarts, String paramString, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", this.val$uin);
      if (this.dda) {
        ??? = "";
      }
      label51:
      label71:
      label91:
      int i;
      for (;;)
      {
        ((Bundle)localObject2).putString("imei", (String)???);
        if (this.dda)
        {
          ??? = "";
          ((Bundle)localObject2).putString("imsi", (String)???);
          if (!this.dda) {
            break label425;
          }
          ??? = "";
          ((Bundle)localObject2).putString("android_id", (String)???);
          if (!this.dda) {
            break label444;
          }
          ??? = "";
          ((Bundle)localObject2).putString("mac", (String)???);
          ((Bundle)localObject2).putString("platform", "4");
          ((Bundle)localObject2).putString("os_ver", Build.VERSION.RELEASE);
          if (!this.dda) {
            break label452;
          }
          ??? = "";
          label130:
          ((Bundle)localObject2).putString("position", (String)???);
          ((Bundle)localObject2).putString("network", arwo.bE(aroi.a().getContext()));
          ((Bundle)localObject2).putString("language", arxr.getLanguage());
          ((Bundle)localObject2).putString("resolution", arxr.getResolution());
          if (!this.dda) {
            break label460;
          }
          ??? = "";
          ((Bundle)localObject2).putString("apn", (String)???);
          ((Bundle)localObject2).putString("model_name", Build.MODEL);
          ((Bundle)localObject2).putString("timezone", TimeZone.getDefault().getID());
          ((Bundle)localObject2).putString("qq_ver", aroi.a().getAppVersionName());
          ((Bundle)localObject2).putString("qua", aroi.a().getQUA3());
          ((Bundle)localObject2).putString("via", "2");
          ((Bundle)localObject2).putString("result", "0");
          if (this.val$bundle != null) {
            ((Bundle)localObject2).putAll(this.val$bundle);
          }
          localObject2 = new BaseData((Bundle)localObject2);
        }
        synchronized (this.this$0)
        {
          this.this$0.Dv.add(localObject2);
          int k = this.this$0.Dv.size();
          int m = artu.a().fv("report_via");
          int j = arxs.a(aroi.a().getContext(), null).getInt("Agent_ReportTimeInterval");
          i = j;
          if (j == 0) {
            i = 10000;
          }
          if ((this.this$0.at("report_via", m + k)) || (this.ddb))
          {
            this.this$0.Ui(this.dda);
            this.this$0.mMainHandler.removeMessages(1001);
            return;
            ??? = arxr.getImei();
            continue;
            ??? = arxr.getImsi();
            break label51;
            label425:
            ??? = alla.getString(aroi.a().getContext().getContentResolver(), "android_id");
            break label71;
            label444:
            ??? = arxr.Dy();
            break label91;
            label452:
            ??? = arxr.getLocation();
            break label130;
            label460:
            ??? = arwo.K(aroi.a().getContext());
          }
        }
      }
      Message localMessage;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ReportCenter", 2, "-->reportVia, exception in sub thread.", localException);
        return;
        if (!this.this$0.mMainHandler.hasMessages(1001))
        {
          localMessage = Message.obtain();
          localMessage.what = 1001;
          localMessage.obj = Boolean.valueOf(this.dda);
          this.this$0.mMainHandler.sendMessageDelayed(localMessage, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.2
 * JD-Core Version:    0.7.0.1
 */