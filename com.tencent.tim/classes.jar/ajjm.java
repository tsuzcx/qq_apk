import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import java.lang.ref.WeakReference;

class ajjm
  implements View.OnLongClickListener
{
  ajjm(ajjl paramajjl) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.b.aE != null)
    {
      paramView = (MultiCardItemFragment)this.b.aE.get();
      if (paramView != null) {
        paramView.c(this.b);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjm
 * JD-Core Version:    0.7.0.1
 */