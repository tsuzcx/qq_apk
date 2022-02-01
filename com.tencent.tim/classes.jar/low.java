import android.view.View;
import android.view.View.OnAttachStateChangeListener;

class low
  implements View.OnAttachStateChangeListener
{
  low(lot paramlot) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (lot.a(this.a) != null)
    {
      lot.a(this.a).onDestroy();
      lot.a(this.a, null);
    }
    if (lot.a(this.a) != null)
    {
      lot.a(this.a).destroy();
      lot.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     low
 * JD-Core Version:    0.7.0.1
 */