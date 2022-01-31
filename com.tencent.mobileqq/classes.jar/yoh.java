import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;

public class yoh
  implements TouchWebView.OnScrollChangedListener
{
  public yoh(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (GameCenterAPIJavaScript.access$000(this.a) != null) {
      GameCenterAPIJavaScript.access$000(this.a).scrollBy(0, paramInt2 - paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yoh
 * JD-Core Version:    0.7.0.1
 */