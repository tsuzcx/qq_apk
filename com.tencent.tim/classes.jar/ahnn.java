import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.widget.OverCoverFrameLayout;

public class ahnn
  implements TouchWebView.OnScrollChangedListener
{
  public ahnn(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (paramInt4 > paramInt2) {
      if (paramInt2 == 0) {
        this.this$0.a.arT();
      }
    }
    while ((paramInt4 >= paramInt2) || (paramInt2 < this.this$0.Dp.getHeight())) {
      return;
    }
    this.this$0.a.arS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnn
 * JD-Core Version:    0.7.0.1
 */