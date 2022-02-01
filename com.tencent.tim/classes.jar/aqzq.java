import android.view.View;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

class aqzq
  implements TouchWebView.OnScrollChangedListener
{
  int baD = 0;
  
  aqzq(aqzl paramaqzl) {}
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_SwiftIphoneTitleBarUI", 2, "-->onScrollChanged:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1) {}
    for (paramInt1 = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());; paramInt1 = 0)
    {
      paramInt1 = paramInt1 + aqcx.dip2px(BaseApplicationImpl.getApplication(), 50.0F) + 180;
      if (Math.abs(paramInt2 - this.baD) > 20) {
        if (paramInt2 < paramInt1 / 3) {
          this.this$0.a.cYF = true;
        }
      }
      while (paramInt2 >= paramInt1 / 3) {
        for (;;)
        {
          this.baD = paramInt2;
          this.this$0.egC();
          return;
          if (paramInt2 >= paramInt1) {
            this.this$0.a.cYF = false;
          }
        }
      }
      this.this$0.a.cYF = true;
      this.baD = paramInt2;
      this.this$0.egC();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzq
 * JD-Core Version:    0.7.0.1
 */