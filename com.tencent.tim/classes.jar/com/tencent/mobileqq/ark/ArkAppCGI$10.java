package com.tencent.mobileqq.ark;

import adqb;
import adqb.b;
import adqb.e;
import java.util.ArrayList;

public class ArkAppCGI$10
  implements Runnable
{
  public ArkAppCGI$10(adqb paramadqb, adqb.e parame, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (adqb.a(this.this$0))
    {
      adqb.a(this.this$0).remove(this.a);
      this.a.a.b(this.a, this.val$success, this.val$bufReply);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.10
 * JD-Core Version:    0.7.0.1
 */