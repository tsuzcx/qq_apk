package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import aqhq;
import com.tencent.qphone.base.util.QLog;
import kbp;

class KandianReportSoLoader$1$1
  implements Runnable
{
  KandianReportSoLoader$1$1(KandianReportSoLoader.1 param1) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        aqhq.cn(KandianReportSoLoader.access$100());
        boolean bool = KandianReportSoLoader.access$200();
        if (!bool) {
          continue;
        }
        i = 1;
        kbp.a(null, "", "0X8009A1C", "0X8009A1C", 0, i, "", "", "", "copy file step", false);
        if (!bool)
        {
          QLog.d("kandianreport.KandianReportSoLoader", 1, "copy fail, delete so");
          aqhq.cn(KandianReportSoLoader.access$300());
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        kbp.a(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", "", "copy file exception : " + localThrowable.toString(), false);
        QLog.d("kandianreport.KandianReportSoLoader", 1, "jscjni downloadSoFiles read so config fail");
        continue;
      }
      if (this.this$0.val$runnable != null) {
        this.this$0.val$runnable.run();
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.KandianReportSoLoader.1.1
 * JD-Core Version:    0.7.0.1
 */