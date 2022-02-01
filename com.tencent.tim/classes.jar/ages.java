import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ages
  implements View.OnClickListener
{
  ages(ager paramager) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a.this$0, false);
    this.a.this$0.onGetMore();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ages
 * JD-Core Version:    0.7.0.1
 */