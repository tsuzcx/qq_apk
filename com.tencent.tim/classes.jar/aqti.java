import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class aqti
  extends aqtg
{
  public aqti(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockHardwareCanvas();
  }
  
  public boolean aFC()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqti
 * JD-Core Version:    0.7.0.1
 */