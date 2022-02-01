import android.graphics.Rect;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class aqzz
  implements View.OnLayoutChangeListener
{
  private Rect cL = new Rect();
  private Rect cM = new Rect();
  
  public aqzz(WebViewFragment paramWebViewFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.cL.set(this.cM);
    paramView.getWindowVisibleDisplayFrame(this.cM);
    if (this.cL.width() == this.cM.width())
    {
      if (this.this$0.j == null) {
        break label100;
      }
      paramView = this.this$0.j.getPluginEngine();
      if (paramView != null)
      {
        paramInt1 = this.cL.height() - this.cM.height();
        if (paramInt1 >= -100) {
          break label105;
        }
        paramView.handleEvent(this.this$0.mUrl, 8589934614L, null);
      }
    }
    label100:
    label105:
    while (paramInt1 <= 100)
    {
      return;
      paramView = null;
      break;
    }
    paramView.handleEvent(this.this$0.mUrl, 8589934613L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzz
 * JD-Core Version:    0.7.0.1
 */