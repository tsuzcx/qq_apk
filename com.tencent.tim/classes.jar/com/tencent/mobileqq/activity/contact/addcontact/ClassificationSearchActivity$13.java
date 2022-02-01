package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ClassificationSearchActivity$13
  implements Runnable
{
  ClassificationSearchActivity$13(ClassificationSearchActivity paramClassificationSearchActivity, String paramString) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    Object localObject2 = localEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Object localObject1;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (ReadInJoySearchHistoryEntity)localIterator.next();
        if (((ReadInJoySearchHistoryEntity)localObject1).keyWord.equals(this.aoJ)) {
          localEntityManager.remove((Entity)localObject1);
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((List)localObject2).remove(localObject1);
      }
      if (((List)localObject2).size() == 20)
      {
        localEntityManager.remove((Entity)((List)localObject2).get(((List)localObject2).size() - 1));
        ((List)localObject2).remove(((List)localObject2).size() - 1);
      }
      for (localObject1 = localObject2;; localObject1 = new ArrayList())
      {
        localObject2 = new ReadInJoySearchHistoryEntity();
        ((ReadInJoySearchHistoryEntity)localObject2).keyWord = this.aoJ;
        ((ReadInJoySearchHistoryEntity)localObject2).timestamp = System.currentTimeMillis();
        localEntityManager.persist((Entity)localObject2);
        ((List)localObject1).add(0, localObject2);
        localEntityManager.close();
        localObject2 = this.this$0.mHandler.obtainMessage(1);
        ((Message)localObject2).obj = localObject1;
        this.this$0.mHandler.sendMessage((Message)localObject2);
        return;
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.13
 * JD-Core Version:    0.7.0.1
 */