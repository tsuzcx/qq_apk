package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import kfn;
import kfn.b;
import mfk;

public class KanDianViewController$2
  implements Runnable
{
  public KanDianViewController$2(kfn paramkfn) {}
  
  public void run()
  {
    String str = mfk.jK();
    if ((str != null) && (new File(str).exists()))
    {
      kfn.a(this.this$0).removeMessages(2);
      kfn.a(this.this$0).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.2
 * JD-Core Version:    0.7.0.1
 */