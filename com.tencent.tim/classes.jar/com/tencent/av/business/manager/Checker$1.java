package com.tencent.av.business.manager;

import aqhq;
import ijr;
import ijr.a;

public class Checker$1
  implements Runnable
{
  public Checker$1(ijr paramijr, ijr.a parama, String paramString) {}
  
  public void run()
  {
    if (aqhq.fileExists(this.a.zipPath)) {
      this.this$0.b(this.val$id, this.a);
    }
    ijr.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker.1
 * JD-Core Version:    0.7.0.1
 */