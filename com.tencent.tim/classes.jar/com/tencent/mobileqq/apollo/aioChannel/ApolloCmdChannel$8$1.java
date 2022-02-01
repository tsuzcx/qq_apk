package com.tencent.mobileqq.apollo.aioChannel;

import abjl;
import abmt;
import abos;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloCmdChannel$8$1
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$8$1(abjl paramabjl, String paramString) {}
  
  public String aV()
  {
    return "getOpenApiNick";
  }
  
  public void run()
  {
    if ((abmt.b() != null) && (abmt.b().YM())) {
      this.a.this$0.nativeOpenApiGetNickCallBack(this.a.NE, this.a.bgB, 0, this.val$nick);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.8.1
 * JD-Core Version:    0.7.0.1
 */