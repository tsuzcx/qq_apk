package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import ujt;

final class ForwardUtils$2
  implements Runnable
{
  ForwardUtils$2(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, String paramString2, String paramString3, long paramLong, int paramInt1, String paramString4, int paramInt2, MqqHandler paramMqqHandler) {}
  
  public void run()
  {
    ujt.a(this.val$app, this.w, this.a, this.aSS, this.aST, this.aSU, this.HW, this.bPb, this.aSV, this.bES);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate start!");
    }
    Message localMessage = new Message();
    localMessage.what = 57;
    if (this.v != null) {
      this.v.sendMessage(localMessage);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "[@]call instantUpdate end!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils.2
 * JD-Core Version:    0.7.0.1
 */