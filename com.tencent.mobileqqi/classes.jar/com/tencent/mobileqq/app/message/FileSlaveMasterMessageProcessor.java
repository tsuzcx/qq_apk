package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;

public class FileSlaveMasterMessageProcessor
  extends BaseMessageProcessor
{
  public FileSlaveMasterMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.FileSlaveMasterMessageProcessor
 * JD-Core Version:    0.7.0.1
 */