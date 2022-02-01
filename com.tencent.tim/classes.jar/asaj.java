import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.open.filedownload.ApkFileDownloadFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asaj
  implements View.OnClickListener
{
  public asaj(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    arwk.b(arwm.a().a("200").k(ApkFileDownloadFragment.a(this.a).pageId).j("1").l("0").m(ApkFileDownloadFragment.a(this.a).via).a(ApkFileDownloadFragment.a(this.a).name).b(ApkFileDownloadFragment.a(this.a).packageName).g(ApkFileDownloadFragment.a(this.a).url));
    ApkFileDownloadFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asaj
 * JD-Core Version:    0.7.0.1
 */