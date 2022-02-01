package com.tencent.qqmail.popularize;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;

class JSApiUitil$1$1
  implements Runnable
{
  JSApiUitil$1$1(JSApiUitil.1 param1, String paramString) {}
  
  public void run()
  {
    Intent localIntent = ComposeMailActivity.createIntentForPopularize(this.this$0.val$account.getId(), this.val$resultContent, 1);
    this.this$0.val$context.startActivity(localIntent);
    this.this$0.val$callback.onSuccess(JSApiUitil.handleJsCallBack(true, "send mail success", this.this$0.val$callbackId));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.1.1
 * JD-Core Version:    0.7.0.1
 */