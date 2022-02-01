package com.tencent.mobileqq.search.searchengine;

import amux;
import amwe;
import amwt;
import java.util.List;

public class ApproximateSearchEngine$2
  implements Runnable
{
  public ApproximateSearchEngine$2(amux paramamux, amwt paramamwt) {}
  
  public void run()
  {
    List localList = amux.a(this.this$0, this.b);
    amwe localamwe = amux.a(this.this$0);
    if ((localamwe != null) && (localList != null)) {
      localamwe.s(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */