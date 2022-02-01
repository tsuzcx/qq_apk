package com.tencent.open.agent.report;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import aroi;
import arts;
import artu;
import arwo;
import arxs;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ReportCenter$3
  implements Runnable
{
  public ReportCenter$3(arts paramarts, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    int j = 1;
    for (;;)
    {
      try
      {
        localObject1 = new Bundle();
        Object localObject3 = arwo.bE(aroi.a().getContext());
        ((Bundle)localObject1).putString("apn", (String)localObject3);
        ((Bundle)localObject1).putString("appid", this.val$appid);
        ((Bundle)localObject1).putString("commandid", this.cCk);
        ((Bundle)localObject1).putString("detail", this.val$detail);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("network=").append((String)localObject3).append('&');
        localObject3 = localStringBuilder.append("sdcard=");
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          i = 1;
          ((StringBuilder)localObject3).append(i).append('&');
          localStringBuilder.append("wifi=").append(arwo.bH(aroi.a().getContext()));
          ((Bundle)localObject1).putString("deviceInfo", localStringBuilder.toString());
          i = 100 / this.this$0.kJ(this.bdX);
          if (i > 0) {
            continue;
          }
          i = j;
          ((Bundle)localObject1).putString("frequency", i + "");
          ((Bundle)localObject1).putString("reqSize", this.awy + "");
          ((Bundle)localObject1).putString("resultCode", this.bdX + "");
          ((Bundle)localObject1).putString("rspSize", this.awz + "");
          ((Bundle)localObject1).putString("timeCost", this.val$timeCost + "");
          ((Bundle)localObject1).putString("uin", this.val$uin + "");
          ((Bundle)localObject1).putString("from_opensdk", Boolean.toString(this.dda));
          localObject1 = new BaseData((Bundle)localObject1);
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        int k;
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReportCenter", 2, "-->reportCgi, exception in sub thread.", localException);
        return;
      }
      try
      {
        this.this$0.Du.add(localObject1);
        k = this.this$0.Du.size();
        m = artu.a().fv("report_cgi");
        j = arxs.a(aroi.a().getContext(), null).getInt("Agent_ReportTimeInterval");
        i = j;
        if (j == 0) {
          i = 10000;
        }
        if ((!this.this$0.at("report_cgi", m + k)) && (!this.ddb)) {
          break label527;
        }
        this.this$0.Xc("yingyongbao");
        this.this$0.mMainHandler.removeMessages(1000);
        return;
      }
      finally {}
      int i = 0;
      continue;
      if (i > 100)
      {
        i = 100;
        continue;
        label527:
        if (!this.this$0.mMainHandler.hasMessages(1000))
        {
          Message localMessage = Message.obtain();
          localMessage.what = 1000;
          localMessage.obj = "yingyongbao";
          this.this$0.mMainHandler.sendMessageDelayed(localMessage, i);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportCenter.3
 * JD-Core Version:    0.7.0.1
 */