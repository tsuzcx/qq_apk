package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;

class HotChatManager$2
  implements Runnable
{
  HotChatManager$2(HotChatManager paramHotChatManager) {}
  
  public void run()
  {
    CardHandler localCardHandler = (CardHandler)this.this$0.app.getBusinessHandler(2);
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    Oidb_0x66b.ReqBody localReqBody1 = new Oidb_0x66b.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.this$0.app.getCurrentAccountUin())));
    localReqBody.rpt_uint64_uins.set(localArrayList);
    localReqBody1.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localReqBody1.uint32_req_pansocialinfo.set(1);
    localCardHandler.a(localReqBody1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager.2
 * JD-Core Version:    0.7.0.1
 */