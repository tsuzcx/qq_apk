import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.AbsListView;

public final class hux
  implements Runnable
{
  public hux(AbsListView paramAbsListView) {}
  
  public void run()
  {
    Object localObject;
    int i;
    boolean bool;
    if (this.a.ab == 0)
    {
      this.a.ab = 1;
      localObject = this.a.getChildAt(this.a.W - this.a.ap);
      if ((localObject != null) && (!((View)localObject).hasFocusable()))
      {
        this.a.P = 0;
        if (this.a.p) {
          break label249;
        }
        ((View)localObject).setPressed(true);
        this.a.setPressed(true);
        this.a.i();
        this.a.a(this.a.W, (View)localObject);
        this.a.refreshDrawableState();
        i = ViewConfiguration.getLongPressTimeout();
        bool = this.a.isLongClickable();
        if (this.a.c != null)
        {
          localObject = this.a.c.getCurrent();
          if ((localObject != null) && ((localObject instanceof TransitionDrawable)))
          {
            if (!bool) {
              break label230;
            }
            ((TransitionDrawable)localObject).startTransition(i);
          }
        }
      }
    }
    while (bool)
    {
      if (AbsListView.a(this.a) == null) {
        AbsListView.a(this.a, new huw(this.a, null));
      }
      AbsListView.a(this.a).a();
      this.a.postDelayed(AbsListView.a(this.a), i);
      return;
      label230:
      ((TransitionDrawable)localObject).resetTransition();
    }
    this.a.ab = 2;
    return;
    label249:
    this.a.ab = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hux
 * JD-Core Version:    0.7.0.1
 */