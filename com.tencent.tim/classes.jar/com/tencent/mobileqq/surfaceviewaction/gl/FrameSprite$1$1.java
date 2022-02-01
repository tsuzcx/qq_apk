package com.tencent.mobileqq.surfaceviewaction.gl;

import anyo;
import anyv;
import java.util.LinkedList;

class FrameSprite$1$1
  implements Runnable
{
  FrameSprite$1$1(FrameSprite.1 param1) {}
  
  public void run()
  {
    for (;;)
    {
      int j;
      synchronized (this.a.this$0)
      {
        anyv[] arrayOfanyv = anyo.a(this.a.this$0);
        if ((arrayOfanyv == null) || (anyo.a(this.a.this$0))) {
          return;
        }
        anyo.a(this.a.this$0, new anyv[anyo.a(this.a.this$0).length / 2]);
        j = 0;
        int i = 0;
        if (j < anyo.a(this.a.this$0).length)
        {
          if (j % 2 == 0)
          {
            anyo localanyo2 = this.a.this$0;
            int k = i + 1;
            anyo.a(localanyo2, i, arrayOfanyv[j]);
            i = k;
          }
          else
          {
            anyo.a(this.a.this$0).remove(arrayOfanyv[j]);
            arrayOfanyv[j].release();
          }
        }
        else {
          return;
        }
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1.1
 * JD-Core Version:    0.7.0.1
 */