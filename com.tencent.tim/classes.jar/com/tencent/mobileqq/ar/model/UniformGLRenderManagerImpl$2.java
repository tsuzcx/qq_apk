package com.tencent.mobileqq.ar.model;

import adcy;
import addc;
import addf;
import adky;
import com.tencent.qphone.base.util.QLog;

public class UniformGLRenderManagerImpl$2
  implements Runnable
{
  public UniformGLRenderManagerImpl$2(adky paramadky, adcy paramadcy, addc paramaddc) {}
  
  public void run()
  {
    adcy localadcy = this.f;
    adky localadky = this.this$0;
    int i = adky.screenWidth;
    localadky = this.this$0;
    localadcy.setWidthAndHeight(i, adky.screenHeight);
    localadcy = this.this$0.d;
    this.this$0.d = this.f;
    if (QLog.isColorLevel()) {
      QLog.d("HSRender", 2, "onARStateChanged, queueEvent");
    }
    if ((localadcy != null) && (localadcy != this.this$0.d)) {
      localadcy.onDestroy();
    }
    if (this.this$0.d == null) {
      return;
    }
    if ((this.a.cCE == 5) && ((this.a.Sl == 2L) || (this.a.Sl == 2048L))) {}
    for (boolean bool = true;; bool = false)
    {
      this.this$0.b.reset();
      this.this$0.b.a(bool, this.a);
      this.this$0.d.init();
      this.this$0.d.start();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.UniformGLRenderManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */