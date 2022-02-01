package com.tencent.mobileqq.apollo.aioChannel;

import abjk;
import abmt;
import abos;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloCmdChannel$7$2
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$7$2(abjk paramabjk, int paramInt) {}
  
  public String aV()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((abmt.b() != null) && (abmt.b().YM())) {
      this.a.this$0.nativeOpenApiGetHeadCallBack(this.a.NE, this.a.bgB, this.val$code, 0, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.2
 * JD-Core Version:    0.7.0.1
 */