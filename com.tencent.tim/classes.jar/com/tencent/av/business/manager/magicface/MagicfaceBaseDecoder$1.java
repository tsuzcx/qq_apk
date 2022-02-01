package com.tencent.av.business.manager.magicface;

import ijy;
import ijz;

public class MagicfaceBaseDecoder$1
  implements Runnable
{
  public MagicfaceBaseDecoder$1(ijy paramijy) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    String str = this.this$0.a.getId();
    this.this$0.RS = true;
    this.this$0.iV(str);
    int j = this.this$0.kT();
    this.this$0.RS = false;
    this.this$0.a.stop();
    this.this$0.af(str, j);
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1
 * JD-Core Version:    0.7.0.1
 */