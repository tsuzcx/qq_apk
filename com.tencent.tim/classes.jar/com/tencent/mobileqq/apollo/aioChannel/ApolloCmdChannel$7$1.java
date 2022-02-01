package com.tencent.mobileqq.apollo.aioChannel;

import abjk;
import abmt;
import abos;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import java.nio.ByteBuffer;

public class ApolloCmdChannel$7$1
  extends IApolloRunnableTask
{
  public ApolloCmdChannel$7$1(abjk paramabjk, int paramInt, Bitmap paramBitmap, ByteBuffer paramByteBuffer) {}
  
  public String aV()
  {
    return "getOpenApiHead";
  }
  
  public void run()
  {
    if ((abmt.b() != null) && (abmt.b().YM())) {
      this.a.this$0.nativeOpenApiGetHeadCallBack(this.a.NE, this.a.bgB, this.val$code, this.eD.getWidth(), this.eD.getWidth(), this.q.array());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.7.1
 * JD-Core Version:    0.7.0.1
 */