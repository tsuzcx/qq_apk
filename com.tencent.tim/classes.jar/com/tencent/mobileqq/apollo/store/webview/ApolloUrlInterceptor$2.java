package com.tencent.mobileqq.apollo.store.webview;

import abvc;
import abve;
import com.tencent.qphone.base.util.QLog;

public class ApolloUrlInterceptor$2
  implements Runnable
{
  public ApolloUrlInterceptor$2(abvc paramabvc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    abve localabve = abvc.a(this.this$0);
    long l = System.currentTimeMillis();
    localabve.OJ = l;
    abvc.a(this.this$0);
    abvc.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    abvc.a(this.this$0).OK = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */