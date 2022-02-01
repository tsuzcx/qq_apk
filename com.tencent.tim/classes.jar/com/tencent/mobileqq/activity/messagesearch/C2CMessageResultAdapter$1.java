package com.tencent.mobileqq.activity.messagesearch;

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
import zlg;
import zmc;

public class C2CMessageResultAdapter$1
  implements Runnable
{
  public C2CMessageResultAdapter$1(zlg paramzlg, String paramString, long paramLong, List paramList) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = this.this$0.app.b().a(this.this$0.mSessionInfo, this.val$keyword);
    int i;
    MessageRecord localMessageRecord;
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null) && (!((ChatHistorySearchData)localObject).mSearchData1.isEmpty()))
    {
      i = 0;
      while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
      {
        localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
        if (this.this$0.Q(localMessageRecord)) {
          this.this$0.uk.add(new zmc(this.this$0.app, localMessageRecord));
        }
        i += 1;
      }
    }
    if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData2 != null) && (!((ChatHistorySearchData)localObject).mSearchData2.isEmpty()))
    {
      localObject = this.this$0.app.b().a(this.this$0.mSessionInfo.aTl, this.this$0.mSessionInfo.cZ, ((ChatHistorySearchData)localObject).mSearchData2);
      if ((localObject != null) && (((ChatHistorySearchData)localObject).mSearchData1 != null))
      {
        i = j;
        while (i < ((ChatHistorySearchData)localObject).mSearchData1.size())
        {
          localMessageRecord = (MessageRecord)((ChatHistorySearchData)localObject).mSearchData1.get(i);
          if (this.this$0.Q(localMessageRecord)) {
            this.this$0.uk.add(new zmc(this.this$0.app, localMessageRecord));
          }
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "localCacheMsgs size: " + this.this$0.uk.size());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("keyword", this.val$keyword);
    ((HashMap)localObject).put("sequence", Long.valueOf(this.Le));
    ((HashMap)localObject).put("data", this.um);
    this.this$0.b.obtainMessage(6, localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter.1
 * JD-Core Version:    0.7.0.1
 */