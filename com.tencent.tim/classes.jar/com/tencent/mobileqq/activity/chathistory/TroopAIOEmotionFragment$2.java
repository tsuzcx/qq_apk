package com.tencent.mobileqq.activity.chathistory;

import afrq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class TroopAIOEmotionFragment$2
  implements Runnable
{
  TroopAIOEmotionFragment$2(TroopAIOEmotionFragment paramTroopAIOEmotionFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = TroopAIOEmotionFragment.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((ChatMessage)((afrq)((Iterator)localObject).next()).h);
    }
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        if (localArrayList.size() != 1) {
          break label122;
        }
        ((QQAppInterface)localObject).b().b((MessageRecord)localArrayList.get(0), false);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new TroopAIOEmotionFragment.2.1(this));
        return;
        label122:
        if (localArrayList.size() > 1) {
          ((QQAppInterface)localObject).b().V(localArrayList, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment.2
 * JD-Core Version:    0.7.0.1
 */