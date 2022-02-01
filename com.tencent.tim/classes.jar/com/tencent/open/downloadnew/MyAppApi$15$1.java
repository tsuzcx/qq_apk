package com.tencent.open.downloadnew;

import android.content.DialogInterface.OnClickListener;
import arwt;
import arwy;
import arzk;
import arzo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

public class MyAppApi$15$1
  implements Runnable
{
  public MyAppApi$15$1(arzo paramarzo, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.a.b.destory();
    if (this.a.this$0.b != null) {
      for (;;)
      {
        try
        {
          if ((this.hp != null) && (this.hp.length != 0)) {
            localStringBuilder = new StringBuilder();
          }
        }
        catch (Exception localException2)
        {
          StringBuilder localStringBuilder;
          String str;
          Object localObject;
          localException2.printStackTrace();
          continue;
          ((TMAssistantCallYYB_V2)this.a.this$0.a()).startToAuthorized(this.a.val$activity, this.a.this$0.b, "2");
          continue;
        }
        try
        {
          str = util.buf_to_string(this.hp);
          this.a.this$0.b.uin = (this.val$uin + "&identity=" + str);
          this.a.this$0.awQ = this.a.awR;
          if (this.a.this$0.getApiLevel() <= 2)
          {
            ((TMAssistantCallYYB_V1)this.a.this$0.a()).startToAuthorized(this.a.val$activity, this.a.this$0.b, "2");
            this.a.this$0.b = null;
            if (this.a.ae != null) {
              this.a.ae.onClick(null, 0);
            }
            return;
          }
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject = null;
        }
      }
    }
    arwt.e("MyAppApi", "startToAuthorizedDirect->onGetA1 mLastAuthorizeParam = null, needCarryQQIdentity = true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.15.1
 * JD-Core Version:    0.7.0.1
 */