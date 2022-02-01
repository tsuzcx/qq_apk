package com.tencent.mobileqq.magicface.model;

import aiyc;
import aiyc.a;

public class MagicfaceDecoder$1
  implements Runnable
{
  public MagicfaceDecoder$1(aiyc paramaiyc) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    this.this$0.cmH = true;
    if (this.this$0.a != null) {
      this.this$0.a.dvm();
    }
    this.this$0.dvr();
    this.this$0.cmH = false;
    if (this.this$0.a != null) {
      this.this$0.a.dvn();
    }
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.MagicfaceDecoder.1
 * JD-Core Version:    0.7.0.1
 */