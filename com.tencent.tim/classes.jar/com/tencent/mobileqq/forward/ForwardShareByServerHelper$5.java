package com.tencent.mobileqq.forward;

import ahlj;
import ahlw;
import aqha;
import aqju;

public class ForwardShareByServerHelper$5
  implements Runnable
{
  public ForwardShareByServerHelper$5(ahlj paramahlj, String paramString) {}
  
  public void run()
  {
    ahlw.x("KEY_STAGE_2_TOTAL", false);
    if (ahlj.a(this.this$0) == null) {
      ahlj.a(this.this$0, aqha.a(ahlj.a(this.this$0), 230));
    }
    ahlj.a(this.this$0).setMessage(this.val$errorMsg);
    ahlj.a(this.this$0).setPositiveButton(2131721079, this.this$0.P);
    ahlj.a(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper.5
 * JD-Core Version:    0.7.0.1
 */