import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agdl
  implements View.OnClickListener
{
  public agdl(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.e != null)
    {
      this.this$0.e.dismiss();
      this.this$0.e = null;
    }
    if (UniformDownloadActivity.a(this.this$0)) {
      aryb.a().d(UniformDownloadActivity.a(this.this$0), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3009", false);
    }
    for (;;)
    {
      this.this$0.finish();
      this.this$0.overridePendingTransition(0, 0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aryb.a().d(UniformDownloadActivity.a(this.this$0), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3006", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdl
 * JD-Core Version:    0.7.0.1
 */