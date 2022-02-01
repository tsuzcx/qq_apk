package com.tencent.mobileqq.ar;

class ScanningSurfaceView$4
  implements Runnable
{
  ScanningSurfaceView$4(ScanningSurfaceView paramScanningSurfaceView) {}
  
  public void run()
  {
    while (ScanningSurfaceView.a(this.this$0))
    {
      long l = System.currentTimeMillis();
      ScanningSurfaceView.a(this.this$0);
      try
      {
        Thread.sleep(Math.max(0L, ScanningSurfaceView.a(this.this$0) - (System.currentTimeMillis() - l)));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (ScanningSurfaceView.b(this.this$0)) {
      ScanningSurfaceView.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanningSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */