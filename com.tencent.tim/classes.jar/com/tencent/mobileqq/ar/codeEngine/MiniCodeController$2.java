package com.tencent.mobileqq.ar.codeEngine;

import adjn;
import adjv;

public class MiniCodeController$2
  implements Runnable
{
  public MiniCodeController$2(adjn paramadjn) {}
  
  public void run()
  {
    long l1 = adjv.h("report_tag_detect_supporttype", 0L);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 86400000L)
    {
      adjv.hs(adjn.a(this.this$0), -1);
      adjv.af("report_tag_detect_supporttype", l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.2
 * JD-Core Version:    0.7.0.1
 */