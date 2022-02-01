package com.tencent.mobileqq.ar.arengine;

import adgy;
import adic;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;

public class ARCloudControl$3
  implements Runnable
{
  public ARCloudControl$3(adgy paramadgy, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.dg == null)
    {
      adgy.a(this.this$0, true);
      adgy.b(this.this$0, true);
    }
    while (this.this$0.b.recognitions == null) {
      return;
    }
    adic.a().reset();
    adic.a().starTime = System.currentTimeMillis();
    adgy.a(this.this$0, this.dg, this.this$0.b.recognitions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl.3
 * JD-Core Version:    0.7.0.1
 */