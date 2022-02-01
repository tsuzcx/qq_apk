package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import zsz;

final class ForwardUtils$3
  implements Runnable
{
  ForwardUtils$3(String paramString, SessionInfo paramSessionInfo, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    String str = this.aSW;
    int i = this.a.cZ;
    int j = this.bPc;
    QQAppInterface localQQAppInterface = this.val$app;
    zsz.a(new String[] { str }, i, false, true, j, localQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.3
 * JD-Core Version:    0.7.0.1
 */