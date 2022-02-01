package com.tencent.mobileqq.doutu;

import afdw;
import com.tencent.mobileqq.persistence.EntityManager;

public class DoutuManager$10
  implements Runnable
{
  public DoutuManager$10(afdw paramafdw) {}
  
  public void run()
  {
    if (afdw.a(this.this$0) != null) {
      afdw.a(this.this$0).drop(DoutuData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.10
 * JD-Core Version:    0.7.0.1
 */