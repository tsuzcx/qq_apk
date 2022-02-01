package com.tencent.av.ui.chatroom;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import jgf;
import jgg;

public class VideoChatRoomUIContoller$3
  implements Runnable
{
  public VideoChatRoomUIContoller$3(jgg paramjgg) {}
  
  public void run()
  {
    if ((QLog.isDevelopLevel()) && (jgg.a(this.this$0) != null))
    {
      if (jgg.a(this.this$0) == null) {
        jgg.a(this.this$0, new StringBuilder(300));
      }
      jgg.a(this.this$0).setLength(0);
      jgg.a(this.this$0).append("updateChatRoomMsgList, list[");
      Iterator localIterator = jgg.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        jgf localjgf = (jgf)localIterator.next();
        if (localjgf != null) {
          jgg.a(this.this$0).append(localjgf.getMsgId()).append(", ");
        }
      }
      jgg.a(this.this$0).append("]");
      QLog.i("ChatRoomUtil", 4, jgg.a(this.this$0).toString());
    }
    if ((jgg.a(this.this$0) != null) && (jgg.a(this.this$0) != null)) {
      jgg.a(this.this$0).l(jgg.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3
 * JD-Core Version:    0.7.0.1
 */