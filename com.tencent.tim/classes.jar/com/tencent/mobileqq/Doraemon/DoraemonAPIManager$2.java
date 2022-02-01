package com.tencent.mobileqq.Doraemon;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tzd;
import tzg;

public class DoraemonAPIManager$2
  implements Runnable
{
  public DoraemonAPIManager$2(tzg paramtzg, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.qe.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      tzg.a(this.this$0, (String)arrayOfObject[0], (JSONObject)arrayOfObject[1], (tzd)arrayOfObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonAPIManager.2
 * JD-Core Version:    0.7.0.1
 */