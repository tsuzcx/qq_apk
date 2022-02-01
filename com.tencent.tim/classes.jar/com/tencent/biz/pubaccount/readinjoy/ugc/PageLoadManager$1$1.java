package com.tencent.biz.pubaccount.readinjoy.ugc;

import java.util.List;
import miw;
import miw.a;

class PageLoadManager$1$1
  implements Runnable
{
  PageLoadManager$1$1(PageLoadManager.1 param1, List paramList) {}
  
  public void run()
  {
    miw.a(this.a.this$0, miw.a(this.a.this$0) + this.in.size());
    miw localmiw = this.a.this$0;
    if (this.in.size() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      miw.a(localmiw, bool);
      if (miw.a(this.a.this$0) != null) {
        miw.a(this.a.this$0).p(this.in, miw.a(this.a.this$0));
      }
      miw.b(this.a.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.PageLoadManager.1.1
 * JD-Core Version:    0.7.0.1
 */