package com.tencent.mobileqq.activity;

import aajg;
import java.util.ArrayList;
import java.util.Iterator;
import ush;

public class Conversation$26$5
  implements Runnable
{
  public Conversation$26$5(ush paramush, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.a.this$0.a != null)
    {
      Iterator localIterator = this.pc.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.a.this$0.a.bp(str, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.26.5
 * JD-Core Version:    0.7.0.1
 */