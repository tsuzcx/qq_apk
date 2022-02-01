import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;

public class araw
  extends arar
{
  Activity activity;
  private agjj.a b;
  
  public araw(AppInterface paramAppInterface, Activity paramActivity, aqzw paramaqzw, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    super(paramAppInterface, paramaqzw, paramIntent, paramTouchWebView);
    this.activity = paramActivity;
    initDownloader();
  }
  
  public araw(AppInterface paramAppInterface, Activity paramActivity, aqzw paramaqzw, Intent paramIntent, boolean paramBoolean)
  {
    super(paramAppInterface, paramaqzw, paramIntent, paramActivity, paramBoolean);
    this.activity = paramActivity;
    initDownloader();
  }
  
  public void initDownloader()
  {
    boolean bool = this.intent.getBooleanExtra("fromArkAppDownload", false);
    this.b = new agjj.a(this.appInterface, this.activity, this.j);
    this.b.Ja(bool);
    this.j.setDownloadListener(this.b);
  }
  
  protected boolean isFinish()
  {
    return (this.activity != null) && (this.activity.isFinishing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     araw
 * JD-Core Version:    0.7.0.1
 */