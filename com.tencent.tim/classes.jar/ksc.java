import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;

public class ksc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public ksc(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.this$0.mRootLayout.getWindowVisibleDisplayFrame(localRect);
    int j = localRect.bottom;
    int i = j;
    if (!this.this$0.ahf) {
      i = j - this.this$0.mStatusBarHeight;
    }
    if (i != this.this$0.aLt)
    {
      this.this$0.aLt = i;
      this.this$0.mLayoutParams.height = this.this$0.aLt;
      this.this$0.mRootLayout.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ksc
 * JD-Core Version:    0.7.0.1
 */