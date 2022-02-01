package com.tencent.biz;

import java.util.concurrent.atomic.AtomicBoolean;
import jml;

public class AuthorizeConfig$6
  implements Runnable
{
  public AuthorizeConfig$6(jml paramjml) {}
  
  public void run()
  {
    this.this$0.ayi();
    if (this.this$0.H == null) {
      this.this$0.aye();
    }
    if (jml.aj.compareAndSet(false, true)) {
      this.this$0.ayb();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.6
 * JD-Core Version:    0.7.0.1
 */