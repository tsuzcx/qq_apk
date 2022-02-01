package com.tencent.mobileqq.activity.aio;

import android.os.Build;
import anpc;
import aqmq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tzc;
import wiu;
import wiv;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(wiv paramwiv) {}
  
  public void run()
  {
    Object localObject = wiu.a();
    wiv.a(this.this$0, ((wiu)localObject).vH());
    if (aqmq.atn <= 0L)
    {
      wiv.a(this.this$0);
      return;
    }
    String str = "";
    switch (wiv.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((wiu)localObject).bNE)
      {
      default: 
        if (tzc.a().isSupported())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(tzc.a().getState()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      anpc.a(BaseApplication.getContext()).collectPerformance(null, str, true, aqmq.atn, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.TAG, 4, "reportAIOTime: " + str + " cost : " + aqmq.atn);
      }
      wiv.a(this.this$0);
      return;
      if (!wiv.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = wiv.access$300();
        break;
      }
      str = wiv.access$400();
      break;
      if (!wiv.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = wiv.access$500();
        break;
      }
      str = wiv.access$600();
      break;
      switch (((wiu)localObject).bNE)
      {
      }
      for (;;)
      {
        break;
        if (!wiv.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = wiv.access$700();
        }
        else
        {
          str = wiv.access$800();
          continue;
          if (!wiv.a(this.this$0).equalsIgnoreCase("0")) {
            str = wiv.access$900();
          } else {
            str = wiv.access$1000();
          }
        }
      }
      switch (((wiu)localObject).bNE)
      {
      }
      for (;;)
      {
        break;
        if (!wiv.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = wiv.pe();
        }
        else
        {
          str = wiv.ga();
          continue;
          if (!wiv.a(this.this$0).equalsIgnoreCase("0")) {
            str = wiv.eh();
          } else {
            str = wiv.ei();
          }
        }
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */