import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appcenter.QZoneAppCenterActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class hka
  implements View.OnClickListener
{
  public hka(QZoneAppCenterActivity paramQZoneAppCenterActivity) {}
  
  public void onClick(View paramView)
  {
    LogUtility.b("AppViewBaseActivity", "button onClick!!!");
    if (TextUtils.isEmpty(QZoneAppCenterActivity.a(this.a)))
    {
      this.a.d();
      this.a.e = "";
      this.a.f = "";
      QZoneAppCenterActivity.a(this.a);
      QZoneAppCenterActivity.a(this.a).sendEmptyMessage(3);
      return;
    }
    this.a.a.loadUrl("javascript:JsBridge.callback(\"" + QZoneAppCenterActivity.b(this.a) + "\");void(0);");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hka
 * JD-Core Version:    0.7.0.1
 */