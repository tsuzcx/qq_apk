package com.tencent.qqmail.popularize;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;

class JSApiUitil$3$3$1
  implements Runnable
{
  JSApiUitil$3$3$1(JSApiUitil.3.3 param3, String paramString) {}
  
  public void run()
  {
    Intent localIntent = ComposeMailActivity.createIntentForPopularize(this.this$1.val$account.getId(), this.val$resultContent, 2);
    JSApiUitil.3.access$500(this.this$1.this$0).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.3.3.1
 * JD-Core Version:    0.7.0.1
 */