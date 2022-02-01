package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import aojs;
import aqhq;
import aqxn;
import aqxp;
import aqxr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class BaseChatpieHelper$IMECommandListener$1
  implements Runnable
{
  BaseChatpieHelper$IMECommandListener$1(BaseChatpieHelper.a parama, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, Context paramContext, View paramView) {}
  
  public void run()
  {
    long l = 0L;
    Object localObject1 = QQRecorder.a();
    Object localObject2 = aojs.a(this.val$app.getCurrentAccountUin(), null, 2, null);
    localObject2 = MessageForPtt.getLocalFilePath(((QQRecorder.RecorderParam)localObject1).mAudioType, (String)localObject2);
    String str = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(".")).concat(".pcm");
    if (!aqhq.copyFile(this.aLK, str)) {
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "copy failed, return");
      }
    }
    do
    {
      return;
      BaseChatpieHelper.a.a(this.this$0).Fq = 0L;
      Object localObject3 = new File(str);
      if (((File)localObject3).exists()) {
        l = ((File)localObject3).length();
      }
      double d = QQRecorder.a(this.bEO, 2, 2, l);
      if (QLog.isColorLevel()) {
        QLog.d("sougouptt", 2, "file size = " + l + " timelength = " + d);
      }
      localObject3 = new aqxn((String)localObject2, this.bEO, ((QQRecorder.RecorderParam)localObject1).mBitRate, ((QQRecorder.RecorderParam)localObject1).mAudioType, 0);
      aqxp.a(this.val$app.getApp(), (aqxn)localObject3, null, null, aqxr.a(str));
      BaseChatpieHelper.a.a(this.this$0).a((String)localObject2, (int)d, (QQRecorder.RecorderParam)localObject1, this.aLL);
      localObject1 = (InputMethodManager)this.val$mContext.getSystemService("input_method");
    } while (localObject1 == null);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("PCMFilePath", this.aLK);
    ((InputMethodManager)localObject1).sendAppPrivateCommand(this.rN, "com.tencent.mobileqq_handleCompleted", (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatpieHelper.IMECommandListener.1
 * JD-Core Version:    0.7.0.1
 */