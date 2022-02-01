import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.webviewplugin.Hole;

class aqzh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  aqzh(aqzg paramaqzg, View paramView, DisplayMetrics paramDisplayMetrics) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.val$contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      this.this$0.a.setHole((this.this$0.AM.getLeft() + this.this$0.AM.getRight()) / 2 - 1, (this.this$0.AM.getTop() + this.this$0.AM.getBottom()) / 2 - 1, (int)(30.0F * this.i.density));
      this.this$0.a.invalidate();
      return;
      this.val$contentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzh
 * JD-Core Version:    0.7.0.1
 */