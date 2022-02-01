package com.tencent.mobileqq.ar.model;

import adcl;
import adec;
import adib;
import adku;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$18
  implements Runnable
{
  public QQARSession$18(adku paramadku, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
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
        QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
        adku.removeTask(adku.a(this.this$0));
        adku.a(this.this$0, null);
      }
      if (this.bOv) {
        break label161;
      }
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end.");
      this.this$0.cSt();
      ThreadManager.getUIHandler().post(new QQARSession.18.1(this));
    }
    label161:
    do
    {
      do
      {
        return;
        j = 5;
        break;
        QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadComplete end. isNeedInternalRender = " + this.i.aek() + ", isNeedExternalRender = " + this.i.ael() + ", isNeedWaitUserOperation = " + this.i.aem());
        if (!this.i.aeg()) {
          break label265;
        }
      } while ((!adku.b(this.this$0)) || (this.this$0.cHX != 2));
      this.this$0.g = this.i;
      return;
      if ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null)) {
        adku.a(this.this$0).a(2048L, new adec(this.i));
      }
      if (this.i.aei())
      {
        this.this$0.cSt();
        return;
      }
      if (this.i.aek())
      {
        adcl.a().KA(2);
        if (this.i.aeo()) {
          adku.c(this.this$0, false);
        }
        adku.a(this.this$0, 2048L, this.i, -1, 0.0F, 0.0F, 0.0F);
        return;
      }
      if ((!this.i.aem()) && (!this.i.ael())) {
        break label446;
      }
    } while ((!this.i.ael()) || (!this.i.aeo()));
    label265:
    adku.c(this.this$0, true);
    return;
    label446:
    this.this$0.cSt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.18
 * JD-Core Version:    0.7.0.1
 */