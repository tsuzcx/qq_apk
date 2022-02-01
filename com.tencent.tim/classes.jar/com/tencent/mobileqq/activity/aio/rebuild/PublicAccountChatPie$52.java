package com.tencent.mobileqq.activity.aio.rebuild;

import ashy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONObject;
import ycd;

public class PublicAccountChatPie$52
  implements Runnable
{
  public PublicAccountChatPie$52(ycd paramycd) {}
  
  public void run()
  {
    ashy localashy = (ashy)this.this$0.app.getBusinessHandler(85);
    if (!this.this$0.blK) {
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("app", "QD");
      if (this.this$0.aXk != null) {
        ((JSONObject)localObject).put("assignType", Long.parseLong(this.this$0.aXk));
      }
      if (this.this$0.aXl != null) {
        ((JSONObject)localObject).put("assignKey", Long.parseLong(this.this$0.aXl));
      }
      if (this.this$0.aXm != null) {
        ((JSONObject)localObject).put("ext", this.this$0.aXm);
      }
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        String str4;
        int i = 1;
        continue;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    str1 = this.this$0.sessionInfo.aTl;
    str2 = this.this$0.aXj;
    str3 = this.this$0.aXi;
    str4 = this.this$0.aXn;
    if (i != 0)
    {
      localObject = null;
      localashy.r(str1, str2, str3, str4, (String)localObject);
      this.this$0.a().runOnUiThread(new PublicAccountChatPie.52.1(this));
      localashy.iP(this.this$0.sessionInfo.aTl, this.this$0.aXj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52
 * JD-Core Version:    0.7.0.1
 */