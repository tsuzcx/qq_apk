package com.tencent.av.utils;

import aiyw;
import android.text.TextUtils;
import aqlr;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

final class VideoMsgTools$2
  implements Runnable
{
  VideoMsgTools$2(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean1, String paramString1, String paramString2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoMsgTools", 2, "addMessage");
    }
    Object localObject = this.val$app;
    if ((!QQAppInterface.isAppOnForeground(this.val$app.getApp())) || (aqlr.isScreenLocked(this.val$app.getApp()))) {
      this.val$app.a().e(this.a, this.aam);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.SS)) {
        aiyw.a(this.val$app, this.a.frienduin, this.alR, this.aal, "qav");
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoMsgTools", 2, "addMessage end");
      }
      return;
      localObject = this.val$app.b();
      if ((localObject != null) && (this.a != null) && (!TextUtils.isEmpty(this.a.frienduin))) {
        ((QQMessageFacade)localObject).b(this.a, this.val$selfUin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.2
 * JD-Core Version:    0.7.0.1
 */