package com.tencent.qqmail.popularize;

import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.thread.Threads;

class JSApiUitil$3$3
  implements JSApiUitil.JSAPIConentCallback
{
  JSApiUitil$3$3(JSApiUitil.3 param3, Account paramAccount) {}
  
  public void onError(String paramString) {}
  
  public void onSuccess(String paramString)
  {
    Threads.runOnMainThread(new JSApiUitil.3.3.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.JSApiUitil.3.3
 * JD-Core Version:    0.7.0.1
 */