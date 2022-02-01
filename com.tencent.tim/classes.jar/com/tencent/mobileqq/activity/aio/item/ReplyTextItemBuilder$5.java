package com.tencent.mobileqq.activity.aio.item;

import aezc;
import android.content.Context;
import android.os.Bundle;
import aqiw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import top;
import xmb;
import xmb.e;

public final class ReplyTextItemBuilder$5
  implements Runnable
{
  public ReplyTextItemBuilder$5(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, xmb.e parame, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1;
    Object localObject4;
    boolean bool;
    if ((this.b instanceof aezc))
    {
      localObject1 = (aezc)this.b;
      localObject4 = ((aezc)localObject1).getSourceMsgInfo();
      bool = ((aezc)localObject1).getHasPulledSourceMsg();
    }
    for (;;)
    {
      if (localObject4 == null) {
        return;
      }
      if (0 == 0) {}
      label452:
      Object localObject3;
      for (localObject1 = this.val$app.b().c(this.b.frienduin, this.b.istroop, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq);; localObject3 = null)
      {
        Object localObject5;
        if ((localObject1 == null) && (!bool) && (this.b.frienduin != null))
        {
          if ((this.b instanceof aezc)) {
            ((aezc)this.b).setPulledSourceMsg();
          }
          Bundle localBundle = new Bundle();
          QQMessageFacade localQQMessageFacade = this.val$app.b();
          localObject5 = new ArrayList();
          int j = localQQMessageFacade.ax.addAndGet(1);
          localBundle.putInt("counter", j);
          localBundle.putBoolean("success", false);
          localQQMessageFacade.cP.put(Integer.valueOf(j), localObject5);
          this.val$app.a().a(this.b.frienduin, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq, true, localBundle, 0);
          localQQMessageFacade.cQ.put(top.u(this.b.frienduin, this.b.istroop), Boolean.valueOf(false));
          if (!aqiw.isNetworkAvailable(BaseApplication.getContext())) {}
        }
        label458:
        label468:
        for (;;)
        {
          try
          {
            localObject5.wait(35000L);
            if ((((List)localObject5).size() <= 0) || (i >= ((List)localObject5).size())) {
              break label468;
            }
            if (((MessageRecord)((List)localObject5).get(i)).shmsgseq == ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq)
            {
              localObject1 = (MessageRecord)((List)localObject5).get(i);
              if ((this.b.istroop == 0) || ((!(localObject1 instanceof MessageForText)) && (!(localObject1 instanceof MessageForMixedMsg))) || (!((MessageRecord)localObject1).isLongMsg())) {
                break label458;
              }
              localObject5 = new StringBuilder();
              localObject4 = xmb.b(this.val$app, this.b, (MessageRecord)localObject1, (StringBuilder)localObject5);
              if (localObject4 == null) {
                break label458;
              }
              if (localObject5 == null) {
                break label452;
              }
              localObject1 = ((StringBuilder)localObject5).toString();
              ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.5.1(this, (MessageRecord)localObject4, (String)localObject1));
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
          finally {}
          i += 1;
          continue;
          localObject3 = null;
          continue;
          localObject4 = localObject3;
          localObject3 = null;
        }
      }
      bool = false;
      localObject4 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */