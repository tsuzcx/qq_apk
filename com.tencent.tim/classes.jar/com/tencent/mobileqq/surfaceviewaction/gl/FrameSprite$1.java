package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import anyo;
import anyv;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class FrameSprite$1
  implements Runnable
{
  public FrameSprite$1(anyo paramanyo, Context paramContext, SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        long l = System.currentTimeMillis();
        i = 0;
        Object localObject;
        if ((i < anyo.a(this.this$0).length) && (!anyo.a(this.this$0)))
        {
          localObject = new anyv(this.val$context, this.a, anyo.a(this.this$0)[i]);
          anyo.a(this.this$0, i, (anyv)localObject);
          i += 1;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: read time = " + (System.currentTimeMillis() - l));
        }
        l = System.currentTimeMillis();
        i = j;
        if ((i < anyo.a(this.this$0).length) && (!anyo.a(this.this$0)))
        {
          if ((!anyo.b(this.this$0)) || (i % 2 == 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FrameSprite", 2, "FrameSprite: deode:" + i);
            }
            localObject = this.this$0;
            if (anyo.b(this.this$0))
            {
              j = i / 2;
              anyo.a((anyo)localObject, j);
              if ((!anyo.c(this.this$0)) && ((i == this.this$0.dNv - 1) || (i == anyo.a(this.this$0).length - 1)))
              {
                if ((anyo.a(this.this$0) == 20) && ((int)(System.currentTimeMillis() - l) / this.this$0.dNv > 50))
                {
                  this.this$0.setFps(10);
                  anyo.a(this.this$0, true);
                  if (QLog.isColorLevel()) {
                    QLog.d("FrameSprite", 2, "mIsHalf = true");
                  }
                  this.a.al(new FrameSprite.1.1(this));
                }
                this.this$0.dTN();
              }
              if (anyo.a(this.this$0) != null)
              {
                j = anyo.a(this.this$0).size();
                int k = this.this$0.dNv;
                if (j >= k)
                {
                  try
                  {
                    Thread.sleep(16L);
                  }
                  catch (InterruptedException localInterruptedException) {}
                  continue;
                }
              }
            }
            else
            {
              j = i;
              continue;
            }
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrameSprite", 2, "FrameSprite: " + QLog.getStackTraceString(localException));
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.1
 * JD-Core Version:    0.7.0.1
 */