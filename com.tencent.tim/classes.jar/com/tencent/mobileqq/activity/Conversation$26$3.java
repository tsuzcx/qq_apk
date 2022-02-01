package com.tencent.mobileqq.activity;

import aajg;
import java.util.HashSet;
import java.util.Iterator;
import ush;

public class Conversation$26$3
  implements Runnable
{
  public Conversation$26$3(ush paramush, HashSet paramHashSet) {}
  
  public void run()
  {
    if (this.a.this$0.a != null)
    {
      Iterator localIterator = this.aw.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.a.this$0.a.bp(str, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26.3
 * JD-Core Version:    0.7.0.1
 */