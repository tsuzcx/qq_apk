package com.tencent.mobileqq.activity.aio.rebuild;

import acfv;
import apmp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import yam;

public class HotChatPie$16
  implements Runnable
{
  public HotChatPie$16(yam paramyam, HotChatInfo paramHotChatInfo) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Apmp == null) {
      this.this$0.jdField_a_of_type_Apmp = new apmp(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, yam.b(this.this$0), yam.b(this.this$0), this.this$0.jdField_a_of_type_Apat, this.this$0.aaR, null);
    }
    acfv localacfv = (acfv)this.this$0.app.getBusinessHandler(35);
    if (this.c.userCreate == 1) {
      localacfv.kh(this.c.troopUin);
    }
    while (this.c.uuid == null) {
      return;
    }
    localacfv.c(this.c.uuid.getBytes(), this.c.troopUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */