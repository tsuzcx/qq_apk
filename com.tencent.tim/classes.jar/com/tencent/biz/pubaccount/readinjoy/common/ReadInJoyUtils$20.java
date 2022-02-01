package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ujt;

public final class ReadInJoyUtils$20
  implements Runnable
{
  public ReadInJoyUtils$20(String paramString, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = this.VD;
    localSessionInfo.cZ = 1008;
    ujt.a(this.val$app, localSessionInfo);
    this.val$app.b().ca(this.VD, 1008);
    QLog.d("ReadInJoyUtils", 2, "puin<" + this.VD + "> msg setRead !");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.20
 * JD-Core Version:    0.7.0.1
 */