package com.tencent.mobileqq.activity.messagesearch;

import android.os.Bundle;
import android.os.Message;
import aqht;
import aurf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import zkx;

public class C2CLinkMessageResultAdapter$1
  implements Runnable
{
  public C2CLinkMessageResultAdapter$1(zkx paramzkx, String paramString, int paramInt, long paramLong) {}
  
  public void run()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("C2CLinkMessageResultAdapter", 2, "loadMessageResult, run(), keyword = " + this.val$keyword + ", loadType = " + this.cdt);
    }
    ??? = null;
    Object localObject2;
    Object localObject4;
    if (this.cdt == 1)
    {
      ??? = this.this$0.a(this.this$0.mSessionInfo, this.val$keyword);
      aqht.im(this.this$0.app.getCurrentAccountUin(), this.val$keyword);
      localObject2 = new ArrayList();
      localObject4 = this.this$0.b((ChatHistorySearchData)???, (ArrayList)localObject2);
      if (QLog.isColorLevel()) {
        QLog.i("C2CLinkMessageResultAdapter", 2, "loadMessageResult, get: messageItems[] = " + localObject2);
      }
    }
    for (;;)
    {
      synchronized (this.this$0.mLock)
      {
        if (this.this$0.ban.equals(this.val$keyword))
        {
          if (this.cdt != 1) {
            continue;
          }
          localzkx = this.this$0;
          if (((ArrayList)localObject2).size() < 20)
          {
            localzkx.mEnded = bool;
            this.this$0.a = ((ChatHistorySearchData)localObject4);
            localObject2 = this.this$0.b.obtainMessage(2, localObject2);
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
          ??? = this.this$0.a(this.this$0.mSessionInfo, "");
          break;
        }
        bool = false;
        continue;
        if (this.cdt != 2) {
          continue;
        }
        zkx localzkx = this.this$0;
        if (((ArrayList)localObject2).size() < 20)
        {
          bool = true;
          localzkx.mEnded = bool;
          this.this$0.a = ((ChatHistorySearchData)localObject4);
          localObject2 = this.this$0.b.obtainMessage(2, localObject2);
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
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */