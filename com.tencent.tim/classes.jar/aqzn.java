import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;

class aqzn
  implements TouchWebView.OnScrollChangedListener
{
  aqzn(aqzl paramaqzl) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.this$0.edR = paramInt2;
    this.this$0.cg(this.this$0.edR, this.this$0.cXp);
    paramView = this.this$0.a.a();
    if ((paramView != null) && (!TextUtils.isEmpty(this.this$0.cyK))) {
      paramView.callJs(this.this$0.cyK, new String[] { String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(paramInt3), String.valueOf(paramInt4) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzn
 * JD-Core Version:    0.7.0.1
 */