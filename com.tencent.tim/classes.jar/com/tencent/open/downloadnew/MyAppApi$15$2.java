package com.tencent.open.downloadnew;

import arwt;
import arwy;
import arzk;
import arzo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

public class MyAppApi$15$2
  implements Runnable
{
  public MyAppApi$15$2(arzo paramarzo) {}
  
  public void run()
  {
    this.a.b.destory();
    if (this.a.this$0.b != null)
    {
      if (this.a.this$0.getApiLevel() <= 2) {
        ((TMAssistantCallYYB_V1)this.a.this$0.a()).startToAuthorized(this.a.val$activity, this.a.this$0.b, "2");
      }
      for (;;)
      {
        this.a.this$0.b = null;
        return;
        ((TMAssistantCallYYB_V2)this.a.this$0.a()).startToAuthorized(this.a.val$activity, this.a.this$0.b, "2");
      }
    }
    arwt.e("MyAppApi", "startToAuthorizedDirect->onGetA1Fail mLastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.15.2
 * JD-Core Version:    0.7.0.1
 */