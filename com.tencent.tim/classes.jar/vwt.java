import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;

public class vwt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public vwt(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.this$0.a.mRootView.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.this$0.a.mRootView.getRootView().getHeight();
    int j = i - ((Rect)localObject).bottom;
    if ((this.this$0.hg != null) && (this.this$0.mKeyboardHeight != j))
    {
      localObject = (RelativeLayout.LayoutParams)this.this$0.hg.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, j);
      this.this$0.hg.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.mKeyboardHeight = j;
    }
    if (j > i / 3)
    {
      if (this.this$0.baG) {
        this.this$0.yc(false);
      }
      for (;;)
      {
        if (this.this$0.bKY == 2) {
          this.this$0.dB.setVisibility(0);
        }
        i = (int)jll.a(BaseApplicationImpl.getApplication(), this.this$0.bKZ + j);
        return;
        this.this$0.yc(true);
      }
    }
    this.this$0.yc(false);
    if (this.this$0.bKY == 2) {
      this.this$0.dB.setVisibility(8);
    }
    if (this.this$0.bKY == 2) {
      i = (int)jll.a(BaseApplicationImpl.getApplication(), this.this$0.bKZ);
    }
    for (;;)
    {
      this.this$0.baH = false;
      return;
      if (this.this$0.bKY != 1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vwt
 * JD-Core Version:    0.7.0.1
 */