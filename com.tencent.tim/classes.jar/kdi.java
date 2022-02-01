import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

public class kdi
  implements TouchWebView.OnScrollChangedListener
{
  public kdi(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    paramInt1 = paramInt2 - paramInt4;
    if (paramInt1 > 0)
    {
      if (this.a.aHW < 0) {
        this.a.aHW = 0;
      }
      paramView = this.a;
      paramView.aHW = (paramInt1 + paramView.aHW);
      if ((this.a.aHW > this.a.aHX) && (this.a.aej))
      {
        this.a.aej = false;
        if (this.a.jr != null)
        {
          this.a.A(this.a.js, 0);
          this.a.jr.clearAnimation();
          this.a.jr.startAnimation(this.a.a);
        }
      }
    }
    do
    {
      do
      {
        return;
        if (this.a.aHW > 0) {
          this.a.aHW = 0;
        }
        paramView = this.a;
        paramView.aHW = (paramInt1 + paramView.aHW);
      } while ((-this.a.aHW <= this.a.aHX) || (this.a.aej));
      this.a.aej = true;
    } while (this.a.jr == null);
    this.a.jr.clearAnimation();
    this.a.jr.startAnimation(this.a.S);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdi
 * JD-Core Version:    0.7.0.1
 */