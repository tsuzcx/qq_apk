package com.tencent.biz.pubaccount.readinjoy;

import java.io.File;
import kfn;
import kfn.a;
import kfn.b;
import mfk;

public class KanDianViewController$PullRefreshCompleteListener$2
  implements Runnable
{
  public KanDianViewController$PullRefreshCompleteListener$2(kfn.a parama) {}
  
  public void run()
  {
    String str = mfk.jK();
    if ((str != null) && (new File(str).exists()))
    {
      kfn.a(this.a.this$0, str);
      kfn.a(this.a.this$0).removeMessages(3);
      kfn.a(this.a.this$0).sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener.2
 * JD-Core Version:    0.7.0.1
 */