package com.tencent.mobileqq.ar.arengine;

import adgy;
import adgy.a;
import com.tencent.qphone.base.util.QLog;

public class ARCloudControl$5
  implements Runnable
{
  public ARCloudControl$5(adgy paramadgy) {}
  
  public void run()
  {
    if ((adgy.a(this.this$0) != null) && (adgy.b(this.this$0)))
    {
      QLog.i("AREngine_ARCloudControl", 1, "onARCloudUploadImgComplete .isTimeOut= ");
      if (!adgy.a(this.this$0)) {}
    }
    else
    {
      return;
    }
    adgy.a(this.this$0, true);
    adgy.a(this.this$0).b(1, null);
    this.this$0.mStartTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.5
 * JD-Core Version:    0.7.0.1
 */