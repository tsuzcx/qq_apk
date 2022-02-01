package dov.com.qq.im.ae.play;

import com.tencent.ttpic.openapi.filter.SimpleGLThread;

public final class FaceChangeUtils$4
  implements Runnable
{
  public FaceChangeUtils$4(Runnable paramRunnable, SimpleGLThread paramSimpleGLThread) {}
  
  public void run()
  {
    try
    {
      this.val$runnable.run();
      return;
    }
    finally
    {
      this.a.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.4
 * JD-Core Version:    0.7.0.1
 */