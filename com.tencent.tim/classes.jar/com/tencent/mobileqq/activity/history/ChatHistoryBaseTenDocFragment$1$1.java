package com.tencent.mobileqq.activity.history;

import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import zen;

public class ChatHistoryBaseTenDocFragment$1$1
  implements Runnable
{
  public ChatHistoryBaseTenDocFragment$1$1(zen paramzen, List paramList) {}
  
  public void run()
  {
    if (this.ud.size() == 1) {
      this.a.this$0.mApp.b().b(((TencentDocItem)this.ud.get(0)).mRecord, false);
    }
    for (;;)
    {
      Object localObject = ChatHistoryBaseTenDocFragment.a(this.a.this$0).obtainMessage(5678, this.ud);
      ChatHistoryBaseTenDocFragment.a(this.a.this$0).sendMessage((Message)localObject);
      return;
      if (this.ud.size() > 1)
      {
        localObject = new ArrayList();
        Iterator localIterator = this.ud.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((TencentDocItem)localIterator.next()).mRecord);
        }
        this.a.this$0.mApp.b().V((List)localObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.1.1
 * JD-Core Version:    0.7.0.1
 */