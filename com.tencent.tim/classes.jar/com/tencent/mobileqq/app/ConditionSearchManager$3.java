package com.tencent.mobileqq.app;

import accv;
import accv.b;
import java.util.Iterator;
import java.util.LinkedList;

public class ConditionSearchManager$3
  implements Runnable
{
  public ConditionSearchManager$3(accv paramaccv, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.bHa = false;
    if (this.this$0.J != null)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).addAll(this.this$0.J);
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((accv.b)((Iterator)localObject).next()).D(1, this.val$isSuccess);
      }
    }
    if ((this.val$isSuccess) && (this.this$0.bHb)) {
      this.this$0.gt(this.this$0.Ai());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.3
 * JD-Core Version:    0.7.0.1
 */