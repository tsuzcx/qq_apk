package com.tencent.mobileqq.search.mostused;

import amrg;
import amrk;
import com.tencent.qphone.base.util.QLog;

public class MostUsedSearchResultManager$1
  implements Runnable
{
  public MostUsedSearchResultManager$1(amrk paramamrk, MostUsedSearchItem paramMostUsedSearchItem) {}
  
  public void run()
  {
    if (amrk.a(this.this$0) != null)
    {
      amrk.a(this.this$0).a(amrk.a(this.this$0), this.b);
      amrk.a(this.this$0).dN(amrk.a(this.this$0));
      return;
    }
    QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
 * JD-Core Version:    0.7.0.1
 */