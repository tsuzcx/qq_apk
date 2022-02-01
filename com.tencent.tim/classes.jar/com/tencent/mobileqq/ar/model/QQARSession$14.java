package com.tencent.mobileqq.ar.model;

import adcl;
import adec;
import adib;
import adid;
import adku;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class QQARSession$14
  implements Runnable
{
  public QQARSession$14(adku paramadku, boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    if (((!this.bOv) || (!this.i.aef())) && ((!this.bOv) || (!this.i.aeg())) && (adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null))
    {
      localObject = adku.a(this.this$0);
      if (!this.bOv) {
        break label174;
      }
    }
    label174:
    for (int j = 4;; j = 5)
    {
      ((adib)localObject).hq(1, j);
      if (adku.a(this.this$0) != null)
      {
        adku.removeTask(adku.a(this.this$0));
        adku.a(this.this$0, null);
      }
      if (this.bOv) {
        break;
      }
      QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadComplete. download resource failed.");
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end.");
      adku.b(this.this$0, false);
      adku.c(this.this$0);
      ThreadManager.getUIHandler().post(new QQARSession.14.1(this));
      return;
    }
    if (this.i.aef()) {
      if ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null)) {
        adku.a(this.this$0).a(this.i, this.i, 10, 0, null);
      }
    }
    for (;;)
    {
      adku.b(this.this$0, false);
      this.this$0.h = null;
      return;
      if (!this.i.aeg()) {
        break;
      }
      if ((adku.b(this.this$0)) && (this.this$0.cHX == 2)) {
        this.this$0.g = this.i;
      }
    }
    Object localObject = this.i.a.buc;
    String str = this.i.a.bue;
    if ((!this.i.aei()) && (adku.d(this.this$0)))
    {
      if ((adku.b(this.this$0)) && (this.this$0.cHX == 2) && (adku.a(this.this$0) != null)) {
        adku.a(this.this$0).a(1L, new adec(this.i));
      }
      if (!this.i.aek()) {
        break label584;
      }
      if (this.i.aek()) {
        adcl.a().KA(1);
      }
      this.this$0.iM(1L);
      adku.a(this.this$0, 1L, this.i, 0, 0.0F, 0.0F, 0.0F);
      if (this.i.aeo()) {
        adku.c(this.this$0, false);
      }
    }
    for (;;)
    {
      if (this.this$0.a != null)
      {
        this.this$0.a.a((String)localObject, str, this.i);
        adku.a(this.this$0, 0L);
        adku.b(this.this$0, 0L);
      }
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. isNeedInternalRender = " + this.i.aek() + ", isNeedExternalRender = " + this.i.ael() + ", isNeedWaitUserOperation = " + this.i.aem());
      break;
      label584:
      if ((this.i.aem()) || (this.i.ael()))
      {
        if (this.i.ael())
        {
          this.this$0.iM(1L);
          if (this.i.aeo()) {
            adku.c(this.this$0, true);
          }
        }
      }
      else {
        adku.c(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.14
 * JD-Core Version:    0.7.0.1
 */