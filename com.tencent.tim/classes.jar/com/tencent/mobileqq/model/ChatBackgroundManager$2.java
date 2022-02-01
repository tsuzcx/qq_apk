package com.tencent.mobileqq.model;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ChatBackgroundManager$2
  implements Runnable
{
  ChatBackgroundManager$2(ChatBackgroundManager paramChatBackgroundManager, String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatBackgroundManager.bQL = this.this$0.lR(null);
    Message localMessage = ChatBackgroundManager.reportHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new Object[] { this.val$selfUin, this.val$app };
    if (QLog.isColorLevel())
    {
      QLog.d("ThemeDownloadTrace", 2, "bgin to report chat bg info");
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + ChatBackgroundManager.bQL);
    }
    ChatBackgroundManager.reportHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.2
 * JD-Core Version:    0.7.0.1
 */