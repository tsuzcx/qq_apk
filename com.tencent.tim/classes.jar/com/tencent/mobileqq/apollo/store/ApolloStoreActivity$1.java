package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloStoreActivity$1
  implements Runnable
{
  ApolloStoreActivity$1(ApolloStoreActivity paramApolloStoreActivity) {}
  
  public void run()
  {
    if (!ApolloEngine.BJ())
    {
      QLog.e("ApolloStoreActivity", 1, "error engine not ready");
      return;
    }
    this.this$0.b.sendEmptyMessage(258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.1
 * JD-Core Version:    0.7.0.1
 */