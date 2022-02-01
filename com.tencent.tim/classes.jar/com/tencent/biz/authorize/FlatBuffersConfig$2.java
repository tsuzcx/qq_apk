package com.tencent.biz.authorize;

import java.io.File;
import java.nio.ByteBuffer;
import joo;

public class FlatBuffersConfig$2
  implements Runnable
{
  public FlatBuffersConfig$2(joo paramjoo, ByteBuffer paramByteBuffer, File paramFile, boolean paramBoolean) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if ((i >= 3) || (this.this$0.a(this.k, this.A, this.aaS))) {
        return;
      }
      try
      {
        Thread.sleep(100L);
        label36:
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label36;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.authorize.FlatBuffersConfig.2
 * JD-Core Version:    0.7.0.1
 */