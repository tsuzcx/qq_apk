package com.tencent.mobileqq.activity.contact.newfriend;

import java.util.Iterator;
import java.util.LinkedList;
import ysf;
import ysf.a;
import ysi;

public class NewFriendManager$3$1
  implements Runnable
{
  public NewFriendManager$3$1(ysi paramysi, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$success) {
      synchronized (ysf.a(this.a.this$0))
      {
        Iterator localIterator = ysf.a(this.a.this$0).iterator();
        if (localIterator.hasNext()) {
          ((ysf.a)localIterator.next()).bLU();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.3.1
 * JD-Core Version:    0.7.0.1
 */