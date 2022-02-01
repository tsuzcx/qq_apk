package com.tencent.mobileqq.activity.aio.tips;

import aeve;
import aevg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tog;
import yja;

public class QQOperateTips$1
  implements Runnable
{
  public QQOperateTips$1(yja paramyja) {}
  
  public void run()
  {
    Object localObject1 = yja.a(this.this$0).b().f(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ);
    int j = ((List)localObject1).size();
    Object localObject2;
    int i;
    if ((localObject1 != null) && (j > 0))
    {
      localObject2 = (ChatMessage)((List)localObject1).get(j - 1);
      if (localObject2 != null)
      {
        if (yja.a(this.this$0).cZ != 0) {
          break label333;
        }
        yja.a(this.this$0, ((ChatMessage)localObject2).time);
        yja.b(this.this$0, ((ChatMessage)localObject2).uniseq);
      }
      if (yja.a(this.this$0).a().A(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ) <= 0) {
        break label365;
      }
      i = 1;
      label145:
      if (i != 0) {
        i = j;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i - 1);
        if ((localObject2 == null) || (!((ChatMessage)localObject2).isread)) {}
      }
      else
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, " from aio open .. unreadMsg index = " + yja.a(this.this$0));
        }
        localObject2 = aeve.a(yja.a(this.this$0));
        if (localObject2 != null)
        {
          localObject1 = ((aeve)localObject2).a(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ, yja.a(this.this$0), (List)localObject1, true, yja.a(this.this$0));
          if (((aevg)localObject1).bWC)
          {
            localObject1 = ((aevg)localObject1).taskList;
            ((aeve)localObject2).a(yja.a(this.this$0).aTl, yja.a(this.this$0).cZ, (ArrayList)localObject1, yja.a(this.this$0));
          }
        }
        yja.a(this.this$0, -1);
        return;
        label333:
        if (yja.a(this.this$0).cZ != 3000) {
          break;
        }
        yja.a(this.this$0, ((ChatMessage)localObject2).shmsgseq);
        break;
        label365:
        i = 0;
        break label145;
      }
      yja.a(this.this$0, i - 1);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.QQOperateTips.1
 * JD-Core Version:    0.7.0.1
 */