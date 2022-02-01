package com.tencent.mobileqq.activity.aio.item;

import anbb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import java.util.Iterator;
import java.util.List;

class LightVideoItemBuilder$2
  implements Runnable
{
  LightVideoItemBuilder$2(LightVideoItemBuilder paramLightVideoItemBuilder, MessageForLightVideo paramMessageForLightVideo) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.b().f(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (((localChatMessage instanceof MessageForLightVideo)) && (localChatMessage.uniseq == this.b.uniseq)) {
          localChatMessage.saveExtInfoToExtStr(anbb.cdd, "1");
        }
      }
    }
    this.this$0.app.b().a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extStr", this.b.extStr);
    this.this$0.app.b().a(this.b.frienduin, this.b.istroop, this.b.uniseq, "extLong", Integer.valueOf(this.b.extLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */