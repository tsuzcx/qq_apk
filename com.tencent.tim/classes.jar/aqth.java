import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class aqth
  extends aqtg
{
  public aqth(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockCanvas();
  }
  
  public boolean aFC()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqth
 * JD-Core Version:    0.7.0.1
 */