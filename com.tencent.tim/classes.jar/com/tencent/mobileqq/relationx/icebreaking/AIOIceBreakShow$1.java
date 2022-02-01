package com.tencent.mobileqq.relationx.icebreaking;

import alur;
import aluu;
import com.tencent.qphone.base.util.QLog;

class AIOIceBreakShow$1
  implements Runnable
{
  AIOIceBreakShow$1(AIOIceBreakShow paramAIOIceBreakShow, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.val$type == 1)
    {
      AIOIceBreakShow.a(this.this$0).Pc(this.val$uin);
      AIOIceBreakShow.a(this.this$0).dJQ();
    }
    for (;;)
    {
      QLog.d("AIOIceBreakShow", 1, String.format("markEnteredFlag, type = %s, uin = %s", new Object[] { Integer.valueOf(this.val$type), this.val$uin }));
      return;
      if (aluu.kX(this.val$type))
      {
        AIOIceBreakShow.a(this.this$0).Pa(this.val$uin);
        AIOIceBreakShow.a(this.this$0).dJR();
      }
      else
      {
        AIOIceBreakShow.a(this.this$0).Pb(this.val$uin);
        AIOIceBreakShow.a(this.this$0).dJP();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.1
 * JD-Core Version:    0.7.0.1
 */