package com.tencent.qqmail.popularize;

import android.content.Context;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.thread.Threads;

final class JSApiUitil$1
  implements JSApiUitil.JSAPIConentCallback
{
  JSApiUitil$1(Account paramAccount, Context paramContext, JSApiUitil.JSAsyncCallback paramJSAsyncCallback, String paramString) {}
  
  public void onError(String paramString)
  {
    Threads.runOnMainThread(new JSApiUitil.1.2(this));
  }
  
  public void onSuccess(String paramString)
  {
    Threads.runOnMainThread(new JSApiUitil.1.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.1
 * JD-Core Version:    0.7.0.1
 */