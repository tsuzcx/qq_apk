package com.tencent.mobileqq.activity.history.link.search;

import android.os.Message;
import aurf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import zjk;
import zmc;

public class TroopAllMessageResultAdapter$3
  implements Runnable
{
  public void run()
  {
    int j = 0;
    Object localObject = zjk.h(this.this$0).b().a(zjk.f(this.this$0), this.val$keyword);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (zjk.c(this.this$0, localMessageRecord))
        {
          this.this$0.uk.add(new zmc(zjk.i(this.this$0), localMessageRecord));
          this.this$0.by.add(Long.valueOf(localMessageRecord.shmsgseq));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = zjk.j(this.this$0).b().a(zjk.g(this.this$0).aTl, zjk.h(this.this$0).cZ, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (zjk.d(this.this$0, localMessageRecord))
          {
            this.this$0.uk.add(new zmc(zjk.k(this.this$0), localMessageRecord));
            this.this$0.by.add(Long.valueOf(localMessageRecord.shmsgseq));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "localCacheMsgs size: " + this.this$0.uk.size());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.val$keyword);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.Le));
    zjk.d(this.this$0).obtainMessage(8, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter.3
 * JD-Core Version:    0.7.0.1
 */