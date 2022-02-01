import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qfp
  implements View.OnClickListener
{
  public qfp(QQStoryWarningActivity paramQQStoryWarningActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.superFinish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qfp
 * JD-Core Version:    0.7.0.1
 */