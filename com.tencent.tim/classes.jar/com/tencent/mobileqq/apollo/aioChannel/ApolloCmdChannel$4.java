package com.tencent.mobileqq.apollo.aioChannel;

import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class ApolloCmdChannel$4
  extends IApolloRunnableTask
{
  ApolloCmdChannel$4(ApolloCmdChannel paramApolloCmdChannel, Bitmap paramBitmap, String paramString, int paramInt, long paramLong) {}
  
  public String aV()
  {
    return "callbackGetHead";
  }
  
  public void run()
  {
    ApolloCmdChannel.access$200(this.this$0, this.eC, this.val$openId, this.val$type, this.NC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.4
 * JD-Core Version:    0.7.0.1
 */