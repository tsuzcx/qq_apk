package com.tencent.mobileqq.apollo.debug;

import abkj;
import abkj.a;
import abkr;
import java.lang.ref.WeakReference;

public class CmGameDebugManager$1
  implements Runnable
{
  public CmGameDebugManager$1(abkj paramabkj, abkr paramabkr) {}
  
  public void run()
  {
    if ((abkj.a(this.this$0) != null) && (abkj.a(this.this$0).get() != null)) {
      ((abkj.a)abkj.a(this.this$0).get()).Ho(this.a.logLevel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugManager.1
 * JD-Core Version:    0.7.0.1
 */