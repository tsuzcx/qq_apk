import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class amyy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  amyy(amyx.a parama) {}
  
  public void onGlobalLayout()
  {
    if (amyx.a.a(this.b) != null)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        amyx.a.a(this.b).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
      ViewGroup.LayoutParams localLayoutParams = amyx.a.a(this.b).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = ((int)(amyx.a.a(this.b).getWidth() / 2.3F));
        amyx.a.a(this.b).requestLayout();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyy
 * JD-Core Version:    0.7.0.1
 */