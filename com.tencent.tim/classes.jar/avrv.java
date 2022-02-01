import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class avrv
  implements View.OnClickListener
{
  public avrv(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneVerticalVideoDownloadActivity.access$200(this.this$0))
    {
      QzoneVerticalVideoDownloadActivity.access$300(this.this$0, false, false);
      QzoneVerticalVideoDownloadActivity.access$400(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrv
 * JD-Core Version:    0.7.0.1
 */