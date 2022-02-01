package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.util.LRULinkedHashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import ujt;

class BaseChatPie$76
  implements Runnable
{
  BaseChatPie$76(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    ujt.a(this.this$0.app, this.this$0.sessionInfo);
    this.this$0.app.b().b(this.c, false);
    Object localObject = EmojiStickerManager.a(this.c);
    if (localObject != null)
    {
      EmojiStickerManager.a().bGd = 0;
      EmojiStickerManager.a().r.put(localObject, Boolean.valueOf(true));
      localObject = EmojiStickerManager.a().c(this.c);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Long localLong = (Long)((Iterator)localObject).next();
          this.this$0.app.b().t(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, localLong.longValue());
        }
      }
    }
    this.this$0.uiHandler.post(new BaseChatPie.76.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.76
 * JD-Core Version:    0.7.0.1
 */