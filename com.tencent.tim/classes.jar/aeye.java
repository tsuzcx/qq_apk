import android.graphics.Canvas;
import android.view.View.OnTouchListener;

public abstract interface aeye
{
  public abstract void a(aeye.a parama);
  
  public abstract float aZ();
  
  public abstract void destroy();
  
  public abstract Canvas lockCanvas();
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void unlock();
  
  public abstract void unlockCanvasAndPost(Canvas paramCanvas);
  
  public static abstract interface a
  {
    public abstract void cXL();
    
    public abstract void cXM();
    
    public abstract void cXN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeye
 * JD-Core Version:    0.7.0.1
 */