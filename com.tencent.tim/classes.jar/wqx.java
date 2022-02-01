import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;

class wqx
  implements skj.a
{
  wqx(wqw paramwqw) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == 73)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.a.s.isFinishing()) || (!this.a.c.isDestroyed)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131721289, 0).show(this.a.c.getTitleBarHeight());
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131721286, 0).show(this.a.c.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqx
 * JD-Core Version:    0.7.0.1
 */