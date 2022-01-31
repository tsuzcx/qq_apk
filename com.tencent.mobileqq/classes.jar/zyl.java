import com.tencent.mobileqq.ar.ObjectSurfaceView;

public class zyl
  implements Runnable
{
  public zyl(ObjectSurfaceView paramObjectSurfaceView) {}
  
  public void run()
  {
    while (ObjectSurfaceView.a(this.a))
    {
      long l = System.currentTimeMillis();
      ObjectSurfaceView.a(this.a);
      try
      {
        Thread.sleep(Math.max(0L, ObjectSurfaceView.a(this.a) - (System.currentTimeMillis() - l)));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (ObjectSurfaceView.b(this.a)) {
      ObjectSurfaceView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyl
 * JD-Core Version:    0.7.0.1
 */