package com.tencent.mobileqq.apollo.aioChannel;

import abjm;
import abjq;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

public class ApolloRenderRunner$1
  extends IApolloRunnableTask
{
  public ApolloRenderRunner$1(abjm paramabjm, abjq paramabjq, long paramLong, ApolloCmdChannel paramApolloCmdChannel, int paramInt, String paramString1, String paramString2) {}
  
  public String aV()
  {
    return "callbackEngine_" + this.val$cmd;
  }
  
  public void run()
  {
    if ((this.b != null) && (this.NH == this.b.getRuntimeState()))
    {
      this.a.callbackEngineWrapper(this.b.isJsRuntime(), this.NH, this.val$errCode, this.val$cmd, this.bgE);
      if (QLog.isColorLevel()) {
        QLog.d("apollochannel_JsRenderRunner", 2, "apolloSurfaceView.queueEvent mNativeSSOReqMgr.callbackEngine cmd:" + this.val$cmd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloRenderRunner.1
 * JD-Core Version:    0.7.0.1
 */