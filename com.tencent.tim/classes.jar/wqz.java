import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.doodle.DoodleView;

public abstract class wqz
{
  protected DoodleView a;
  protected Rect bg = new Rect();
  protected Context context;
  
  public wqz(DoodleView paramDoodleView)
  {
    if (paramDoodleView == null) {
      throw new IllegalStateException("DoodleView can not be null.");
    }
    this.context = paramDoodleView.getContext();
    this.a = paramDoodleView;
  }
  
  protected abstract boolean H(MotionEvent paramMotionEvent);
  
  public final boolean M(MotionEvent paramMotionEvent)
  {
    notifyChange();
    return H(paramMotionEvent);
  }
  
  public boolean RI()
  {
    return true;
  }
  
  protected abstract void an(Canvas paramCanvas);
  
  public void cbf() {}
  
  public final void draw(Canvas paramCanvas)
  {
    an(paramCanvas);
  }
  
  public boolean init()
  {
    return RI();
  }
  
  public void notifyChange()
  {
    if (this.a != null) {
      this.a.invalidate();
    }
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.bg.set(0, 0, paramInt1, paramInt2);
  }
  
  public void unInit()
  {
    cbf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqz
 * JD-Core Version:    0.7.0.1
 */