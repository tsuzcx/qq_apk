package com.tencent.mobileqq.ark;

import adqb;
import adqb.e;
import aoll;
import aolm;
import com.tencent.mobileqq.app.QQAppInterface;
import jqi;
import mqq.app.MobileQQ;

public class ArkAppCGI$8
  implements Runnable
{
  public ArkAppCGI$8(adqb paramadqb, QQAppInterface paramQQAppInterface, adqb.e parame, aoll paramaoll) {}
  
  public void run()
  {
    if ((adqb.a(this.this$0) == null) || (!jqi.isNetworkAvailable(this.val$app.getApplication().getApplicationContext())))
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "runTask_retry, network not available");
      adqb.a(this.this$0, this.a, false, null);
      return;
    }
    adqb.a(this.this$0).a(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.8
 * JD-Core Version:    0.7.0.1
 */