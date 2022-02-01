import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asam
  implements View.OnClickListener
{
  public asam(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    ApkFileDownloadFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asam
 * JD-Core Version:    0.7.0.1
 */