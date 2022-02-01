import android.support.v7.widget.RecyclerView;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;

public class ozz
  implements ViewTreeObserver.OnPreDrawListener
{
  public ozz(QCircleBaseTabFragment paramQCircleBaseTabFragment, RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public boolean onPreDraw()
  {
    if (this.j.getChildCount() > 0)
    {
      this.j.getViewTreeObserver().removeOnPreDrawListener(this);
      this.this$0.a(this.j, this.val$pos, this.dS);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ozz
 * JD-Core Version:    0.7.0.1
 */