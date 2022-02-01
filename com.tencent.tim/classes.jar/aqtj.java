import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;

public class aqtj
  implements TouchWebView.OnScrollChangedListener
{
  public aqtj(HealthBusinessPlugin paramHealthBusinessPlugin) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.this$0.cc != null) {
      this.this$0.cc.scrollBy(0, paramInt2 - paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtj
 * JD-Core Version:    0.7.0.1
 */