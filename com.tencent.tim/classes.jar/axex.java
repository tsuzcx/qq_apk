import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class axex
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  axex(axeu paramaxeu, View paramView1, View paramView2, View paramView3) {}
  
  public void onGlobalLayout()
  {
    Log.d("AEGIFTextEditFragment", "onGlobalLayout");
    Rect localRect = new Rect();
    this.Mw.getWindowVisibleDisplayFrame(localRect);
    if (this.Mw.getRootView().getHeight() - localRect.bottom > 150)
    {
      int[] arrayOfInt = new int[2];
      this.Mx.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1];
      int j = this.Mx.getHeight();
      int k = localRect.bottom;
      if (!axeu.b(this.this$0))
      {
        this.Mx.scrollBy(0, i + j - k);
        axeu.a(this.this$0, this.My, localRect.bottom / 2);
      }
      axeu.a(this.this$0, true);
      return;
    }
    this.Mx.scrollTo(0, 0);
    if (axeu.b(this.this$0)) {
      axeu.a(this.this$0, this.My, localRect.bottom / 2);
    }
    axeu.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axex
 * JD-Core Version:    0.7.0.1
 */