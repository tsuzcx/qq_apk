package com.tencent.mobileqq.activity.contact.newfriend;

import java.util.Iterator;
import java.util.LinkedList;
import ysf;
import ysf.a;

public class NewFriendManager$5
  implements Runnable
{
  public NewFriendManager$5(ysf paramysf, int paramInt) {}
  
  public void run()
  {
    synchronized (ysf.a(this.this$0))
    {
      Iterator localIterator = ysf.a(this.this$0).iterator();
      if (localIterator.hasNext()) {
        ((ysf.a)localIterator.next()).Az(this.val$count);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.5
 * JD-Core Version:    0.7.0.1
 */