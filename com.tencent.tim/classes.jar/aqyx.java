import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;

public class aqyx
{
  private aqza a;
  public long aug;
  public long auh;
  public long aui;
  public long auj;
  public long auk;
  public long aul;
  
  public aqyx(aqza paramaqza)
  {
    this.a = paramaqza;
  }
  
  public void a(Bundle paramBundle, AppInterface paramAppInterface, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_init_webview_plugin", true))) {
      this.a.preInitWebviewPlugin();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("pre_get_key", true))) {
      WebAccelerateHelper.getInstance().preGetKey(paramIntent, paramAppInterface);
    }
    long l2 = System.currentTimeMillis();
    this.a.buildLayout();
    long l1 = System.currentTimeMillis();
    this.auh = (l1 - l2);
    this.a.buildContentView(paramBundle);
    l2 = System.currentTimeMillis();
    this.auk = (l2 - l1);
    this.a.buildTitleBar();
    l1 = System.currentTimeMillis();
    this.aui = (l1 - l2);
    this.a.buildBottomBar();
    l2 = System.currentTimeMillis();
    this.auj = (l2 - l1);
    this.a.buildWebView(paramAppInterface);
    l1 = System.currentTimeMillis();
    this.aug = (l1 - l2);
    this.a.buildData();
    this.aul = (System.currentTimeMillis() - l1);
    if (QLog.isColorLevel()) {
      QLog.i("WebViewDirector", 2, "buildLayoutTime : " + this.auh + ", buildContentTime " + this.auk + ", buildTitleTime " + this.aui + ", buildWebViewTime " + this.aug + ", buildBottomTime " + this.auj + ", buildDataTime " + this.aul);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqyx
 * JD-Core Version:    0.7.0.1
 */