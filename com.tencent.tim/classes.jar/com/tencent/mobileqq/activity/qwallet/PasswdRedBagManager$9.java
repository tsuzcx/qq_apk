package com.tencent.mobileqq.activity.qwallet;

import java.util.Iterator;
import java.util.List;
import zxh;
import zxi;
import zxj;

public class PasswdRedBagManager$9
  implements Runnable
{
  public PasswdRedBagManager$9(zxj paramzxj) {}
  
  public void run()
  {
    Iterator localIterator = zxj.a(this.this$0).ds().iterator();
    while (localIterator.hasNext())
    {
      zxi localzxi = (zxi)localIterator.next();
      zxj.a(this.this$0, localzxi);
      this.this$0.r(false, localzxi.redBagId, localzxi.redBagIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.9
 * JD-Core Version:    0.7.0.1
 */