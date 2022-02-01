package com.tencent.mobileqq.activity.chathistory;

import android.os.Handler;
import aqht;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ymm;

public class SearchHistoryAdapter$1
  implements Runnable
{
  public void run()
  {
    String[] arrayOfString = aqht.w(this.this$0.mApp.getCurrentAccountUin());
    if (QLog.isColorLevel()) {
      QLog.i("chatHistory.searchHistory", 2, "loadHistory, histories = " + arrayOfString);
    }
    this.this$0.mHandler.post(new SearchHistoryAdapter.1.1(this, arrayOfString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SearchHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */