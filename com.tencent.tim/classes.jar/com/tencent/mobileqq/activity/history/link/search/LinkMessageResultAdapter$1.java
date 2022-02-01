package com.tencent.mobileqq.activity.history.link.search;

import android.os.Bundle;
import android.os.Message;
import aqht;
import aurf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zjj;

public class LinkMessageResultAdapter$1
  implements Runnable
{
  public LinkMessageResultAdapter$1(zjj paramzjj, String paramString, int paramInt, long paramLong) {}
  
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
      ??? = this.this$0.a(zjj.a(this.this$0), this.val$keyword);
      aqht.im(zjj.a(this.this$0).getCurrentAccountUin(), this.val$keyword);
      localObject2 = new ArrayList();
      localObject4 = zjj.a(this.this$0, (ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.mLock)
      {
        if (zjj.a(this.this$0).equals(this.val$keyword))
        {
          if (this.cdt != 1) {
            continue;
          }
          localzjj = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            zjj.a(localzjj, bool);
            zjj.a(this.this$0, (ChatHistorySearchData)localObject4);
            localObject2 = zjj.a(this.this$0).obtainMessage(2, localObject2);
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
          ??? = this.this$0.a(zjj.b(this.this$0), "");
          break;
        }
        bool = false;
        continue;
        if (this.cdt != 2) {
          continue;
        }
        zjj localzjj = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          zjj.b(localzjj, bool);
          zjj.b(this.this$0, (ChatHistorySearchData)localObject4);
          localObject2 = zjj.b(this.this$0).obtainMessage(2, localObject2);
          ((Message)localObject2).arg1 = 2;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putLong("searchSequence", this.Ld);
          ((Bundle)localObject4).putString("searchKeyword", this.val$keyword);
          ((Message)localObject2).setData((Bundle)localObject4);
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */