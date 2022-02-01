package com.tencent.mobileqq.ar.arengine;

import adgy;
import adgy.a;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$10
  implements Runnable
{
  public ARCloudControl$10(adgy paramadgy) {}
  
  public void run()
  {
    if ((adgy.a(this.this$0) != null) && (adgy.e(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation timeout.");
      if (!adgy.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    adgy.a(this.this$0, true);
    adgy.a(this.this$0).b(1, null);
    adgy.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.10
 * JD-Core Version:    0.7.0.1
 */