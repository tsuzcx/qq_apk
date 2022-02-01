import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class tin
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  tin(tij paramtij, ViewGroup paramViewGroup, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.val$decorView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    tkw.d("GdtMotiveVideoDialog", "onGlobalLayout: l=" + this.val$decorView.getLeft() + ",t=" + this.val$decorView.getTop() + ",r=" + this.val$decorView.getRight() + ",b=" + this.val$decorView.getBottom());
    tkw.d("GdtMotiveVideoDialog", "onGlobalLayout: " + this.qQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tin
 * JD-Core Version:    0.7.0.1
 */