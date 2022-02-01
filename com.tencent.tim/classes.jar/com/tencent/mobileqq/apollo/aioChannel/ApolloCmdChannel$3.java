package com.tencent.mobileqq.apollo.aioChannel;

import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class ApolloCmdChannel$3
  extends IApolloRunnableTask
{
  ApolloCmdChannel$3(ApolloCmdChannel paramApolloCmdChannel, String paramString1, String paramString2, int paramInt, long paramLong) {}
  
  public String aV()
  {
    return "callbackGetNick";
  }
  
  public void run()
  {
    ApolloCmdChannel.access$100(this.this$0, this.val$nick, this.val$openId, this.val$type, this.NC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.3
 * JD-Core Version:    0.7.0.1
 */