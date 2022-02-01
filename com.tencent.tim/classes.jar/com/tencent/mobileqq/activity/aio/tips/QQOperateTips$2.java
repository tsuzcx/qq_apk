package com.tencent.mobileqq.activity.aio.tips;

import aeve;
import aevg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;
import wki;
import yja;

public class QQOperateTips$2
  implements Runnable
{
  public QQOperateTips$2(yja paramyja) {}
  
  public void run()
  {
    Object localObject2 = yja.a(this.this$0).getList();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (yja.a(this.this$0).cZ == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > yja.a(this.this$0)))
          {
            if (localChatMessage.uniseq != yja.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              yja.a(this.this$0, localChatMessage.time);
            }
          }
        }
      }
      else if (yja.a(this.this$0).cZ == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > yja.a(this.this$0)))
          {
            if (localChatMessage.uniseq != yja.b(this.this$0)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              yja.a(this.this$0, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (yja.a(this.this$0).cZ != 0) {
            break label408;
          }
          yja.a(this.this$0, ((ChatMessage)localObject2).time);
          yja.b(this.this$0, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = aeve.a(yja.a(this.this$0));
      localObject1 = ((aeve)localObject2).a(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ, yja.a(this.this$0), (List)localObject1, false, -1);
      if (((aevg)localObject1).bWC)
      {
        localObject1 = ((aevg)localObject1).taskList;
        ((aeve)localObject2).a(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ, (ArrayList)localObject1, yja.a(this.this$0));
      }
      return;
      label408:
      if (yja.a(this.this$0).cZ == 3000)
      {
        yja.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        yja.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.2
 * JD-Core Version:    0.7.0.1
 */