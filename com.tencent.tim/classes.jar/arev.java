import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;

public class arev
  extends argi
{
  private static final int[] pi = { 16842919 };
  private arev.a a;
  private boolean cZJ = true;
  private Drawable mDrawable;
  
  public arev(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    super(null, 0);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(pi, paramDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, paramDrawable1);
    this.mDrawable = localStateListDrawable;
    this.mDrawable.setBounds(0, 0, paramDrawable2.getBounds().right, paramDrawable2.getBounds().bottom);
  }
  
  public void a(arev.a parama)
  {
    this.a = parama;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public boolean isEnable()
  {
    return this.cZJ;
  }
  
  public void iy(View paramView)
  {
    this.mDrawable.setState(StateSet.WILD_CARD);
    paramView.invalidate();
  }
  
  public void iz(View paramView)
  {
    this.mDrawable.setState(pi);
    paramView.invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.cZJ) {}
    int i;
    do
    {
      return false;
      i = paramMotionEvent.getAction();
    } while (i == 2);
    if (i == 0) {
      this.mDrawable.setState(pi);
    }
    for (;;)
    {
      if ((i == 1) && (this.a != null)) {
        this.a.b(this);
      }
      paramView.invalidate();
      return true;
      this.mDrawable.setState(StateSet.WILD_CARD);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.cZJ = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void b(arev paramarev);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arev
 * JD-Core Version:    0.7.0.1
 */