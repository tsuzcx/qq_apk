package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import java.util.Iterator;
import java.util.List;
import kaw;
import ycd;

public class PublicAccountChatPie$46
  implements Runnable
{
  public PublicAccountChatPie$46(ycd paramycd) {}
  
  public void run()
  {
    if (kaw.a().a(this.this$0.app, this.this$0.sessionInfo.aTl) != 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = this.this$0.app.b().f(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForStructing)) || ((localObject2 instanceof MessageForPubAccount)))
          {
            localObject2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("pa_msgId");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              try
              {
                long l = Long.parseLong((String)localObject2);
                if (l > 0L)
                {
                  kaw.a().a(this.this$0.app, this.this$0.sessionInfo.aTl, l);
                  return;
                }
              }
              catch (Exception localException) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.46
 * JD-Core Version:    0.7.0.1
 */