package com.tencent.av.service;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import jia;

class QQServiceForAV$QQServiceForAVBinder$4
  implements Runnable
{
  QQServiceForAV$QQServiceForAVBinder$4(QQServiceForAV.e parame, Bundle paramBundle, ResultReceiver paramResultReceiver) {}
  
  public void run()
  {
    jia.a((QQAppInterface)this.a.a.getAppRuntime(), this.val$bundle, this.val$resultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.QQServiceForAVBinder.4
 * JD-Core Version:    0.7.0.1
 */