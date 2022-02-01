import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akbb
  implements View.OnClickListener
{
  akbb(akba paramakba) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (StartLiveTopicLabelListView.a(this.a.a) != null) {
        StartLiveTopicLabelListView.a(this.a.a).tf();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbb
 * JD-Core Version:    0.7.0.1
 */