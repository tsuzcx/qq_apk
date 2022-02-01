package com.tencent.mobileqq.register;

import acfp;
import altw;
import android.content.Intent;
import anot;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;

public class QueryAccount$1
  implements Runnable
{
  public QueryAccount$1(altw paramaltw, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.bYr;
    if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
      return;
    }
    Object localObject1 = localObject2;
    if (!((String)localObject2).startsWith("http://")) {
      localObject1 = "http://" + (String)localObject2;
    }
    localObject2 = new Intent(this.this$0.a, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("selfSet_leftViewText", acfp.m(2131712624));
    this.this$0.a.startActivity(((Intent)localObject2).putExtra("url", (String)localObject1));
    anot.a(this.this$0.app, "CliOper", "", "", "0X800665B", "0X800665B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.register.QueryAccount.1
 * JD-Core Version:    0.7.0.1
 */