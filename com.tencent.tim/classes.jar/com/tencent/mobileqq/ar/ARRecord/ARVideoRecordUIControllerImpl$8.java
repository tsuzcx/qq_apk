package com.tencent.mobileqq.ar.ARRecord;

import adch;
import adcl;
import adcn;

public class ARVideoRecordUIControllerImpl$8
  implements Runnable
{
  public ARVideoRecordUIControllerImpl$8(adcl paramadcl, int paramInt) {}
  
  public void run()
  {
    if (adcl.a(this.this$0) != null) {
      adcl.a(this.this$0).KE(0);
    }
    if (this.cCv == 0) {
      if (adcl.a(this.this$0) != -1) {
        switch (adcl.a(this.this$0))
        {
        case 5: 
        default: 
          adcl.a(this.this$0, -1);
        }
      }
    }
    for (;;)
    {
      adcl.b(this.this$0, false);
      if (!adcl.c(this.this$0)) {
        adcl.a(this.this$0);
      }
      return;
      adcl.lO("0X8008A56");
      adch.fm("AR视频已保存", adcl.brT);
      break;
      adch.bU(adcl.brW, true);
      break;
      adcl.lO("0X8008A56");
      adch.bU(adcl.brW, true);
      break;
      if (adcl.b(this.this$0) == true)
      {
        adcl.a(this.this$0, false);
      }
      else
      {
        adcl.lO("0X8008A56");
        adch.bU(adcl.brW, true);
        continue;
        adcl.lO("0X8008A56");
        if (this.cCv == 1) {
          adch.fm("AR视频已保存", adcl.brU);
        } else {
          adch.fm("AR视频已保存", adcl.brV);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl.8
 * JD-Core Version:    0.7.0.1
 */