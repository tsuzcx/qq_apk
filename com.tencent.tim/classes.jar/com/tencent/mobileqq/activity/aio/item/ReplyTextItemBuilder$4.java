package com.tencent.mobileqq.activity.aio.item;

import aezc;
import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;
import xmb;
import xmb.e;

public final class ReplyTextItemBuilder$4
  implements Runnable
{
  public ReplyTextItemBuilder$4(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, xmb.e parame, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    Object localObject4 = null;
    Object localObject2;
    Object localObject1;
    if ((this.b instanceof aezc))
    {
      localObject2 = (aezc)this.b;
      localObject1 = ((aezc)localObject2).getSourceMsgInfo();
      ((aezc)localObject2).getHasPulledSourceMsg();
    }
    for (;;)
    {
      if (localObject1 == null) {
        return;
      }
      if (0 == 0) {}
      for (localObject1 = this.val$app.b().c(this.b.frienduin, this.b.istroop, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq);; localObject1 = null)
      {
        localObject2 = localObject1;
        Object localObject3 = localObject4;
        MessageRecord localMessageRecord;
        if (this.b.istroop != 0) {
          if (!(localObject1 instanceof MessageForText))
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (!(localObject1 instanceof MessageForMixedMsg)) {}
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (((MessageRecord)localObject1).isLongMsg())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localMessageRecord = xmb.b(this.val$app, this.b, (MessageRecord)localObject1, localStringBuilder);
              localObject2 = localObject1;
              localObject3 = localObject4;
              if (localMessageRecord != null)
              {
                if (localStringBuilder == null) {
                  break label189;
                }
                localObject3 = localStringBuilder.toString();
                localObject2 = localMessageRecord;
              }
            }
          }
        }
        for (;;)
        {
          ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.4.1(this, (MessageRecord)localObject2, (String)localObject3));
          return;
          label189:
          localObject2 = localMessageRecord;
          localObject3 = localObject4;
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */