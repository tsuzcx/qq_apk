package com.tencent.mobileqq.activity.history.link.search;

import android.os.Bundle;
import android.os.Message;
import aqht;
import aurf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zjk;

public class TroopAllMessageResultAdapter$1
  implements Runnable
{
  public TroopAllMessageResultAdapter$1(zjk paramzjk, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.val$keyword + ", loadType = " + this.cdt);
    }
    ??? = null;
    Object localObject2;
    Object localObject4;
    if (this.cdt == 1)
    {
      ??? = zjk.a(this.this$0).b().a(zjk.a(this.this$0), this.val$keyword);
      aqht.im(zjk.b(this.this$0).getCurrentAccountUin(), this.val$keyword);
      localObject2 = new ArrayList();
      localObject4 = zjk.a(this.this$0, (ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.mLock)
      {
        if (zjk.a(this.this$0).equals(this.val$keyword))
        {
          if (this.cdt != 1) {
            continue;
          }
          localzjk = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            zjk.a(localzjk, bool);
            zjk.a(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = zjk.a(this.this$0).obtainMessage(2, localObject2);
            ((Message)localObject2).arg1 = 1;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putLong("searchSequence", this.Ld);
            ((Bundle)localObject4).putString("searchKeyword", this.val$keyword);
            ((Message)localObject2).setData((Bundle)localObject4);
            ((Message)localObject2).sendToTarget();
          }
        }
        else
        {
          return;
          if (this.cdt != 2) {
            break;
          }
          ??? = zjk.c(this.this$0).b().a(zjk.b(this.this$0), "");
          break;
        }
        bool = false;
        continue;
        if (this.cdt != 2) {
          continue;
        }
        zjk localzjk = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          zjk.b(localzjk, bool);
          zjk.b(this.this$0, (ChatHistorySearchData)localObject4);
          localObject2 = zjk.b(this.this$0).obtainMessage(2, localObject2);
          ((Message)localObject2).arg1 = 2;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putLong("searchSequence", this.Ld);
          ((Bundle)localObject4).putString("searchKeyword", this.val$keyword);
          ((Message)localObject2).setData((Bundle)localObject4);
          ((Message)localObject2).sendToTarget();
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */