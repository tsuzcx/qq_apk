package com.tencent.mobileqq.apollo.aioChannel;

import abjq;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.qphone.base.util.QLog;

class ApolloCmdChannel$5
  extends IApolloRunnableTask
{
  ApolloCmdChannel$5(ApolloCmdChannel paramApolloCmdChannel, abjq paramabjq, String paramString) {}
  
  public String aV()
  {
    return "handleWebEvent";
  }
  
  public void run()
  {
    this.this$0.callbackEngineWrapper(this.a.isJsRuntime(), this.a.getRuntimeState(), 0, "sc.apolloGameWebMessage.local", this.val$data);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.ApolloDataChannel", 2, "handleWebEvent data:" + this.val$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.5
 * JD-Core Version:    0.7.0.1
 */