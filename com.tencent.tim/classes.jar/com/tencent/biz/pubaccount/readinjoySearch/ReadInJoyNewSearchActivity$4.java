package com.tencent.biz.pubaccount.readinjoySearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ReadInJoySearchHistoryEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyNewSearchActivity$4
  implements Runnable
{
  ReadInJoyNewSearchActivity$4(ReadInJoyNewSearchActivity paramReadInJoyNewSearchActivity) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.this$0.app.a().createEntityManager();
    List localList = localEntityManager.query(ReadInJoySearchHistoryEntity.class, true, null, null, null, null, " timestamp DESC ", null);
    Message localMessage = this.this$0.mHandler.obtainMessage(1);
    localMessage.obj = localList;
    this.this$0.mHandler.sendMessage(localMessage);
    localEntityManager.close();
    if (localList != null) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNewSearchActivity", 2, "lookupHistory size: " + localList.size());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyNewSearchActivity", 2, "history is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoySearch.ReadInJoyNewSearchActivity.4
 * JD-Core Version:    0.7.0.1
 */