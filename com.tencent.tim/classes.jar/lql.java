import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class lql
  implements View.OnAttachStateChangeListener
{
  lql(lqk paramlqk) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (lqk.a(this.a) != null)
    {
      lqk.a(this.a).onDestroy();
      lqk.a(this.a, null);
    }
    if (lqk.a(this.a) != null)
    {
      lqk.a(this.a).destroy();
      lqk.a(this.a, null);
    }
    if (lqk.a(this.a) != null)
    {
      lqk.a(this.a).onDestroy();
      lqk.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lql
 * JD-Core Version:    0.7.0.1
 */