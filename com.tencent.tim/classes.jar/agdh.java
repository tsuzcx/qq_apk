import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agdh
  implements View.OnClickListener
{
  public agdh(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agdh
 * JD-Core Version:    0.7.0.1
 */