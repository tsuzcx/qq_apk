package com.tencent.mobileqq.leba.core.redtouch;

import aimp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class LebaSpecificRedTouch$2$1
  implements Runnable
{
  LebaSpecificRedTouch$2$1(LebaSpecificRedTouch.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.val$count <= 0)
    {
      this.a.N.dGB();
      this.a.this$0.a(this.a.val$app, this.a.N, this.a.bPc, this.a.bPd, this.a.abJ);
    }
    for (;;)
    {
      this.a.N.dJA();
      return;
      this.a.N.dJz();
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      this.a.N.setMaxNum(99);
      localRedTypeInfo.red_content.set(String.valueOf(this.val$count));
      localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
      localRedTypeInfo.red_type.set(5);
      this.a.N.c(localRedTypeInfo);
      aimp.a(this.a.this$0, this.a.abJ, this.a.N);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.core.redtouch.LebaSpecificRedTouch.2.1
 * JD-Core Version:    0.7.0.1
 */