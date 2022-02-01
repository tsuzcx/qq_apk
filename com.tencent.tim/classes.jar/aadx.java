import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleView;

public abstract class aadx
{
  protected DoodleView a;
  protected Rect bg = new Rect();
  protected Context context;
  
  public aadx(DoodleView paramDoodleView)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadx
 * JD-Core Version:    0.7.0.1
 */