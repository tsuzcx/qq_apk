package com.tencent.mobileqq.service.message;

import anbg;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class MessagePBElemDecoder$2
  implements Runnable
{
  public MessagePBElemDecoder$2(anbg paramanbg, msg_comm.Msg paramMsg) {}
  
  public void run()
  {
    ((PublicAccountHandler)anbg.a(this.this$0).app.getBusinessHandler(11)).m(String.valueOf(this.a.msg_head.from_uin.get()), 0L, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessagePBElemDecoder.2
 * JD-Core Version:    0.7.0.1
 */