import android.view.View;
import android.view.View.OnLongClickListener;
import java.lang.ref.WeakReference;

class ansm
  implements View.OnLongClickListener
{
  ansm(ansl paramansl) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.a.hU != null)
    {
      wlz localwlz = (wlz)this.a.hU.get();
      if (localwlz != null) {
        return localwlz.onLongClick(paramView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ansm
 * JD-Core Version:    0.7.0.1
 */