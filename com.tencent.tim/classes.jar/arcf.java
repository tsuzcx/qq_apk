import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class arcf
  implements TouchWebView.OnScrollChangedListener
{
  arcf(arcd paramarcd) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (System.currentTimeMillis() - this.b.avp > 1000L)
    {
      paramInt1 = paramInt2 - paramInt4;
      if (paramInt1 <= 0) {
        break label55;
      }
      if (Math.abs(paramInt1) > 50)
      {
        this.b.ff(false);
        this.b.avp = System.currentTimeMillis();
      }
    }
    label55:
    while (Math.abs(paramInt1) <= 50) {
      return;
    }
    this.b.ff(true);
    this.b.avp = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arcf
 * JD-Core Version:    0.7.0.1
 */