package com.tencent.mobileqq.scribble;

import amiy;
import amiz;
import amja;
import com.tencent.mobileqq.data.MessageForScribble;

public class ScribbleDownloader$1
  implements Runnable
{
  public ScribbleDownloader$1(amja paramamja, amiz paramamiz) {}
  
  public void run()
  {
    amja.a(this.this$0, "dowmthreak", "start download ,uniseq:" + this.a.c.uniseq);
    new amiy(this.this$0.mApp).a(this.a.c, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleDownloader.1
 * JD-Core Version:    0.7.0.1
 */