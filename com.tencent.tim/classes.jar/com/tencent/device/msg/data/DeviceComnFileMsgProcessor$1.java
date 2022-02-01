package com.tencent.device.msg.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;
import szw;

public class DeviceComnFileMsgProcessor$1
  implements Runnable
{
  public DeviceComnFileMsgProcessor$1(szw paramszw, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (szw.a(this.this$0).containsKey(Long.valueOf(this.a.uSessionID)))
    {
      this.a.nFileStatus = 23;
      this.a.serial();
      szw.a(this.this$0).b().c(this.a.frienduin, 9501, this.a.uniseq, this.a.msgData);
      szw.a(this.this$0, this.a);
      szw.a(this.this$0).remove(Long.valueOf(this.a.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */