import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;

public class afvf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean aFm;
  private Rect mRect = new Rect();
  private int mUsableHeightPrevious;
  
  public afvf(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void onGlobalLayout()
  {
    ExtendFriendProfileEditFragment.b(this.this$0).getWindowVisibleDisplayFrame(this.mRect);
    int i = this.mRect.bottom - this.mRect.top;
    if (i != this.mUsableHeightPrevious)
    {
      int j = ExtendFriendProfileEditFragment.b(this.this$0).getRootView().getHeight();
      int k = j - i;
      if (k <= j / 4) {
        break label90;
      }
      ExtendFriendProfileEditFragment.c(this.this$0, k);
      this.aFm = true;
      ExtendFriendProfileEditFragment.d(this.this$0);
    }
    for (;;)
    {
      this.mUsableHeightPrevious = i;
      return;
      label90:
      if (this.aFm) {
        ExtendFriendProfileEditFragment.e(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvf
 * JD-Core Version:    0.7.0.1
 */