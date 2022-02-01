package com.tencent.mobileqq.activity;

import akwh;
import android.database.Cursor;
import android.os.Message;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;
import top;

class ChatHistory$ChatHistoryAdapter$10
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$10(ChatHistory.a parama, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    switch (this.ael)
    {
    default: 
      localObject1 = "ORDER BY time asc , longMsgIndex asc";
    }
    for (;;)
    {
      int i = this.bFq;
      label68:
      Object localObject3;
      String str;
      if (this.bFq < this.b.this$0.bFl)
      {
        this.b.this$0.aTP = true;
        localObject1 = "( msgtype " + top.ox() + " and isValid=1 ) " + (String)localObject1 + " limit " + i + "," + String.valueOf(8);
        localObject3 = MessageRecord.getTableName(this.aLV, this.ael);
        str = MessageRecord.getOldTableName(this.aLV, this.ael);
      }
      try
      {
        if (!this.b.this$0.aTP) {}
        for (localObject1 = this.b.this$0.a((String)localObject3, str, (String)localObject1);; localObject1 = this.b.this$0.b.a((String)localObject3, (String)localObject1))
        {
          localObject3 = localObject1;
          if (localObject1 != null)
          {
            ((Cursor)localObject1).getCount();
            localObject3 = localObject1;
          }
          localObject1 = this.b.this$0.o.obtainMessage(8);
          ((Message)localObject1).obj = localObject3;
          this.b.this$0.o.sendMessage((Message)localObject1);
          return;
          localObject1 = "ORDER BY shmsgseq";
          break;
          localObject1 = "ORDER BY shmsgseq";
          break;
          this.b.this$0.aTP = false;
          i = this.bFq - this.b.this$0.bFl;
          break label68;
          if (this.b.this$0.b == null) {
            break label306;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject3 = null;
          continue;
          label306:
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.10
 * JD-Core Version:    0.7.0.1
 */