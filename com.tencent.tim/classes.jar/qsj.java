import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class qsj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean aFm;
  private Rect mRect = new Rect();
  private int mUsableHeightPrevious;
  
  qsj(qsi paramqsi) {}
  
  public void onGlobalLayout()
  {
    qsi.a(this.this$0).getWindowVisibleDisplayFrame(this.mRect);
    int i = this.mRect.bottom - this.mRect.top;
    if (i != this.mUsableHeightPrevious)
    {
      int j = qsi.a(this.this$0).getRootView().getHeight();
      if (j - i <= j / 4) {
        break label79;
      }
      this.aFm = true;
      qsi.a(this.this$0);
    }
    for (;;)
    {
      this.mUsableHeightPrevious = i;
      return;
      label79:
      if (this.aFm) {
        qsi.b(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qsj
 * JD-Core Version:    0.7.0.1
 */