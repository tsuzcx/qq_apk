package com.tencent.mobileqq.apollo.store.webview;

import abvd;
import com.tencent.qphone.base.util.QLog;

public final class ApolloWebDataHandler$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    if (!abvd.Zl()) {
      abvd.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloWebDataHandler.1
 * JD-Core Version:    0.7.0.1
 */