package com.tencent.mobileqq.search.searchengine;

import amvg;
import amvk;
import amwe;
import amwt;
import amwu;
import java.util.List;

public class ContactSearchEngine$4
  implements Runnable
{
  public ContactSearchEngine$4(amvg paramamvg, amwt paramamwt) {}
  
  public void run()
  {
    List localList1 = amvg.a(this.this$0, this.b);
    amwe localamwe = amvg.a(this.this$0);
    amwu localamwu;
    if ((localamwe != null) && (localList1 != null))
    {
      localamwu = new amwu(this.b.keyword, 1);
      if (amvg.a(this.this$0) == null) {
        localamwe.a(localList1, localamwu);
      }
    }
    else
    {
      return;
    }
    localamwe.cR(localList1);
    List localList2 = amvg.a(this.this$0).a(this.b);
    if ((localList2 != null) && (!localList2.isEmpty())) {
      localList1.addAll(localList2);
    }
    localamwe.a(localList1, localamwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.ContactSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */