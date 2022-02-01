package com.tencent.imcore.message;

import android.os.Handler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tnu;
import top;

public class BaseMessageManagerForTroopAndDisc$4
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$4(tnu paramtnu, QQMessageFacade.b paramb, String paramString, int paramInt, long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.b(this.a);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage begin");
    }
    int k = 0;
    int j = 0;
    k += 1;
    Object localObject = this.this$0.f(this.val$uin, this.val$type);
    ChatMessage localChatMessage;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localChatMessage = (ChatMessage)((Iterator)localObject).next();
      } while (top.s(localChatMessage));
    }
    for (int i = (int)localChatMessage.shmsgseq;; i = 0)
    {
      if (i <= this.EF + 1L) {}
      for (boolean bool = true; (j == i) || (i <= this.EF); bool = false)
      {
        if ((bool) && (this.aPV)) {
          tnu.a(this.this$0, this.val$type, this.val$uin, this.EF, this.this$0.f(this.val$uin, this.val$type));
        }
        this.a.isSuccess = bool;
        this.this$0.b.as(this.a);
        this.this$0.b.mUIHandler.post(new BaseMessageManagerForTroopAndDisc.4.1(this));
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "refreshTroopUnreadMessage end");
        }
        return;
      }
      if ((k % 500 == 0) && (QLog.isColorLevel())) {
        QLog.w("Q.msg.BaseMessageManager", 2, "dead loop warning, firstSeq: " + this.EG + " seq: " + i + ", unread: " + this.EF);
      }
      int m = (int)(i - this.EF);
      j = m;
      if (this.this$0.a(this.val$uin, this.val$type, m).size() != m)
      {
        j = m;
        if (m > 15) {
          j = 15;
        }
      }
      this.a.count = j;
      this.a.aaU = 0;
      this.this$0.b(this.val$uin, this.val$type, j, this.a);
      j = i;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.4
 * JD-Core Version:    0.7.0.1
 */