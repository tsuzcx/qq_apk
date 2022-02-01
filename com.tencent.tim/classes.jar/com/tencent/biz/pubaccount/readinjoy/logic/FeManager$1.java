package com.tencent.biz.pubaccount.readinjoy.logic;

import java.util.concurrent.atomic.AtomicBoolean;
import lgs;
import lgt;
import lgu;

public class FeManager$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.this$0.jdField_a_of_type_Lgt.S(this.val$app);
    }
    catch (Exception localException2)
    {
      try
      {
        this.this$0.jdField_a_of_type_Lgu.T(this.val$app);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            lgs.a(this.this$0, System.currentTimeMillis());
            lgs.a(this.this$0, lgs.a(this.this$0));
            if (this.this$0.ajZ) {
              this.this$0.ajZ = false;
            }
            lgs.a(this.this$0).set(false);
            return;
            localException1 = localException1;
            localException1.printStackTrace();
            continue;
            localException2 = localException2;
            localException2.printStackTrace();
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            localException3.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager.1
 * JD-Core Version:    0.7.0.1
 */