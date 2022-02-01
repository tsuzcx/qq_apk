package com.tencent.androidqqmail.tim;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.utilities.thread.Threads;

class MainActivity$3
  implements TimMailLoginManager.GetTicketCallback
{
  MainActivity$3(MainActivity paramMainActivity, AccountList paramAccountList, int paramInt) {}
  
  public void onError(String paramString, int paramInt1, int paramInt2)
  {
    Threads.runOnMainThread(new MainActivity.3.2(this));
  }
  
  public void onSuccess(String paramString1, String paramString2)
  {
    Threads.runOnMainThread(new MainActivity.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.MainActivity.3
 * JD-Core Version:    0.7.0.1
 */