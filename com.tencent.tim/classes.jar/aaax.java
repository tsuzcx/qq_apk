import android.app.Activity;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.QzoneHbFragment;

public class aaax
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aaax(QzoneHbFragment paramQzoneHbFragment, Activity paramActivity) {}
  
  public void onGlobalLayout()
  {
    Button localButton;
    int j;
    int i;
    if (this.val$context.getWindowManager().getDefaultDisplay().getWidth() <= 480)
    {
      localButton = QzoneHbFragment.b(this.this$0);
      Object localObject = new Rect();
      this.val$context.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int k = this.val$context.getWindow().getDecorView().getRootView().getHeight();
      j = k - ((Rect)localObject).bottom;
      i = j;
      if (j - this.this$0.getNavigationBarHeight(this.val$context) == 0) {
        i = 0;
      }
      j = this.this$0.mActivity.getWindow().getDecorView().getScrollY();
      if ((localButton == null) || (i == 0)) {
        break label204;
      }
      localObject = new int[2];
      localButton.getLocationOnScreen((int[])localObject);
      m = localObject[1];
      i = localButton.getMeasuredHeight() + m + i - k - j;
      if (i > 0) {
        this.this$0.mActivity.getWindow().getDecorView().scrollBy(0, i + 5);
      }
      QzoneHbFragment.a(this.this$0, true);
    }
    label204:
    while (i != 0)
    {
      int m;
      return;
      localButton = QzoneHbFragment.a(this.this$0);
      break;
    }
    this.this$0.mActivity.getWindow().getDecorView().scrollBy(0, -j);
    QzoneHbFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaax
 * JD-Core Version:    0.7.0.1
 */