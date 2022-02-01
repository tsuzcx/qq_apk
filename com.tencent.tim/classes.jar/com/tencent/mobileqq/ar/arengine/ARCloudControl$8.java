package com.tencent.mobileqq.ar.arengine;

import adgy;
import adgy.a;
import adhf;
import adhr;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$8
  implements Runnable
{
  public ARCloudControl$8(adgy paramadgy) {}
  
  public void run()
  {
    if ((adgy.a(this.this$0) != null) && (adgy.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      SosoInterface.c(this.this$0.g);
      if (!adgy.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    adhf localadhf = new adhf();
    localadhf.retCode = 2;
    adhr.a(this.this$0.b.recognitions, adgy.a(this.this$0), localadhf);
    if (adgy.a(this.this$0) != null) {
      adgy.a(this.this$0).b(0, adgy.a(this.this$0));
    }
    adgy.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.8
 * JD-Core Version:    0.7.0.1
 */