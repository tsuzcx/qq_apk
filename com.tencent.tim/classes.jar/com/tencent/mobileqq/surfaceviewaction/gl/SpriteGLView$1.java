package com.tencent.mobileqq.surfaceviewaction.gl;

import anyt;
import java.util.List;

class SpriteGLView$1
  implements Runnable
{
  SpriteGLView$1(SpriteGLView paramSpriteGLView) {}
  
  public void run()
  {
    this.this$0.dTV();
    Object[] arrayOfObject = SpriteGLView.a(this.this$0).toArray();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof anyt)) {
        ((anyt)localObject).release();
      }
      i += 1;
    }
    SpriteGLView.a(this.this$0).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView.1
 * JD-Core Version:    0.7.0.1
 */