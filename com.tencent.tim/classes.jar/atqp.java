import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.cloudfile.QfileCloudFileTabView;

class atqp
  implements View.OnClickListener
{
  atqp(atqo paramatqo) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a.this$0, false);
    this.a.this$0.onGetMore();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atqp
 * JD-Core Version:    0.7.0.1
 */