import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class arbp
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  arbp(arbo paramarbo, View paramView) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.Jt.getWindowVisibleDisplayFrame(localRect);
    int i = this.Jt.getRootView().getHeight() - localRect.height();
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "heightDiff:" + i);
    }
    if (i > 150)
    {
      this.this$0.ayo = true;
      this.this$0.bK(false, 0);
    }
    while (!this.this$0.ayo) {
      return;
    }
    this.this$0.ayo = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbp
 * JD-Core Version:    0.7.0.1
 */