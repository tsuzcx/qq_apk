package com.tencent.mobileqq.ar.model;

import adcl;
import adec;
import adib;
import adku;
import anot;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$16
  implements Runnable
{
  public QQARSession$16(adku paramadku, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    int j;
    if (((!this.bOv) || (!this.i.aeg())) && (adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null))
    {
      adib localadib = adku.a(this.this$0);
      if (this.bOv)
      {
        j = 4;
        localadib.hq(1, j);
      }
    }
    else
    {
      if (adku.a(this.this$0) != null)
      {
        QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult post task for handle timeout");
        adku.removeTask(adku.a(this.this$0));
        adku.a(this.this$0, null);
      }
      if (this.bOv) {
        break label161;
      }
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end.");
      this.this$0.cSq();
      ThreadManager.getUIHandler().post(new QQARSession.16.1(this));
    }
    for (;;)
    {
      return;
      j = 5;
      break;
      label161:
      QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadComplete end. isNeedInternalRender = " + this.i.aek() + ", isNeedExternalRender = " + this.i.ael() + ", isNeedWaitUserOperation = " + this.i.aem());
      if (this.i.aeg())
      {
        if ((adku.b(this.this$0)) && (this.this$0.cHX == 2)) {
          this.this$0.g = this.i;
        }
      }
      else
      {
        if ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null)) {}
        try
        {
          anot.a(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, this.i.picId + "", "2", "", "");
          adku.a(this.this$0).a(2L, new adec(this.i));
          if (this.i.aei())
          {
            this.this$0.cSq();
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.i("AREngine_QQARSession", 1, "0X80081DE. error = " + localException.getMessage());
          }
          if (this.i.aek())
          {
            adcl.a().KA(2);
            if (this.i.aeo()) {
              adku.c(this.this$0, false);
            }
            adku.a(this.this$0, 2L, this.i, -1, 0.0F, 0.0F, 0.0F);
            return;
          }
          if ((this.i.aem()) || (this.i.ael()))
          {
            if ((this.i.ael()) && (this.i.aeo())) {
              adku.c(this.this$0, true);
            }
          }
          else {
            this.this$0.cSq();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.16
 * JD-Core Version:    0.7.0.1
 */