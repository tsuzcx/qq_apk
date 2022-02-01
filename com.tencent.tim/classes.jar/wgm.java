import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class wgm
  implements aqrw.a
{
  public wgm(VisitorsActivity paramVisitorsActivity, String paramString) {}
  
  public void bPb()
  {
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", this.aRV, "");
    Intent localIntent = new Intent(this.this$0, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    localIntent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    this.this$0.startActivity(localIntent);
  }
  
  public void bPc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorsActivity", 2, "ZanDoubleDialog: onRightClick: ");
    }
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", this.aRV, "");
    aqrf.a(this.this$0, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
    VisitorsActivity.a(this.this$0).set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wgm
 * JD-Core Version:    0.7.0.1
 */