package com.tencent.mobileqq.search.searchengine;

import acps;
import amwe;
import amwf;
import amwg;
import amwt;
import java.util.List;

public class MessageSearchEngine$1
  implements Runnable
{
  public MessageSearchEngine$1(amwf paramamwf, amwe paramamwe, amwt paramamwt) {}
  
  public void run()
  {
    amwg localamwg = null;
    if (this.d != null)
    {
      localamwg = new amwg(this);
      this.this$0.b.addObserver(localamwg);
    }
    List localList = this.this$0.a(this.b);
    if (localamwg != null) {
      this.this$0.b.deleteObserver(localamwg);
    }
    if (this.d != null) {
      this.d.s(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.MessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */