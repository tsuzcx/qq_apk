import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;

public class ntl
  implements View.OnLayoutChangeListener
{
  public ntl(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((CommonSuspensionGestureLayout.a(this.this$0) != null) && ((CommonSuspensionGestureLayout.a(this.this$0).getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      paramView = (FrameLayout.LayoutParams)CommonSuspensionGestureLayout.a(this.this$0).getLayoutParams();
      CommonSuspensionGestureLayout.a(this.this$0, CommonSuspensionGestureLayout.getNavigationBarHeight(CommonSuspensionGestureLayout.a(this.this$0)));
      if (paramView.bottomMargin != CommonSuspensionGestureLayout.a(this.this$0))
      {
        paramView.gravity = 80;
        paramView.bottomMargin = CommonSuspensionGestureLayout.getNavigationBarHeight(CommonSuspensionGestureLayout.a(this.this$0));
        CommonSuspensionGestureLayout.a(this.this$0).setLayoutParams(paramView);
      }
      this.this$0.bbk();
    }
    this.this$0.baY();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntl
 * JD-Core Version:    0.7.0.1
 */