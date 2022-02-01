package com.tencent.av.random;

import irg;
import java.util.Iterator;
import java.util.List;

public class RandomController$2$1
  implements Runnable
{
  public RandomController$2$1(irg paramirg) {}
  
  public void run()
  {
    Iterator localIterator = RandomController.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((RandomController.a)localIterator.next()).apJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.random.RandomController.2.1
 * JD-Core Version:    0.7.0.1
 */