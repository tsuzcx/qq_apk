import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class aqzk
  implements View.OnLayoutChangeListener
{
  aqzk(aqzg paramaqzg, View paramView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.jY.getWindowVisibleDisplayFrame(this.this$0.mRect);
    paramInt2 = this.this$0.mRect.right - this.this$0.mRect.left;
    paramInt4 = this.this$0.mRect.bottom - this.this$0.mRect.top;
    if ((this.this$0.cpO != paramInt2) || (this.this$0.cpP != paramInt4))
    {
      ThreadManager.getUIHandler().post(this.this$0.fy);
      this.this$0.cpO = paramInt2;
      this.this$0.cpP = paramInt4;
    }
    paramInt1 = paramInt3 - paramInt1;
    if (paramInt1 != paramInt7 - paramInt5)
    {
      paramView = (FrameLayout.LayoutParams)this.this$0.AM.getLayoutParams();
      if ((paramView.leftMargin > paramInt1 / 2) && (this.this$0.AM != null) && (8 == this.this$0.AO.getVisibility()))
      {
        paramView.leftMargin = (paramInt1 - this.this$0.AM.getWidth());
        this.this$0.AM.setLayoutParams(paramView);
      }
    }
    this.this$0.mScreenWidth = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzk
 * JD-Core Version:    0.7.0.1
 */