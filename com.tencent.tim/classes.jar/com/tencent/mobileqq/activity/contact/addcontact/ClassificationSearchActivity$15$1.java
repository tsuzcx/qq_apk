package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;
import ynq;

public class ClassificationSearchActivity$15$1
  implements Runnable
{
  public ClassificationSearchActivity$15$1(ynq paramynq) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.a.this$0.app.a().createEntityManager();
    List localList = localEntityManager.query(ReadInJoySearchHistoryEntity.class);
    if (localList == null) {
      return;
    }
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localEntityManager.remove((ReadInJoySearchHistoryEntity)((Iterator)localObject).next());
    }
    localList.clear();
    localObject = this.a.this$0.mHandler.obtainMessage(1);
    ((Message)localObject).obj = localList;
    this.a.this$0.mHandler.sendMessage((Message)localObject);
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.15.1
 * JD-Core Version:    0.7.0.1
 */