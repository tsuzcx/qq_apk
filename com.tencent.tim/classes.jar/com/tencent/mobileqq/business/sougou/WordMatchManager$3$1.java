package com.tencent.mobileqq.business.sougou;

import java.util.ArrayList;
import java.util.Iterator;

class WordMatchManager$3$1
  implements Runnable
{
  WordMatchManager$3$1(WordMatchManager.3 param3) {}
  
  public void run()
  {
    this.a.this$0.bSf = this.a.cS;
    this.a.this$0.bSg = this.a.cS;
    this.a.this$0.bSh = false;
    this.a.this$0.bSi = false;
    Iterator localIterator = this.a.this$0.vc.iterator();
    while (localIterator.hasNext())
    {
      WordMatchManager.e locale = (WordMatchManager.e)localIterator.next();
      if (locale != null) {
        locale.a(this.a.this$0.a);
      }
    }
    this.a.this$0.vc.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.3.1
 * JD-Core Version:    0.7.0.1
 */