package com.tencent.mobileqq.surfaceviewaction.gl;

import anyv;
import com.tencent.qphone.base.util.QLog;

public class Texture$1
  implements Runnable
{
  public Texture$1(anyv paramanyv) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Texture", 2, "runOnSurfaceViewThread load()");
    }
    this.this$0.load();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.Texture.1
 * JD-Core Version:    0.7.0.1
 */