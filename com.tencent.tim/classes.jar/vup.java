import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SigCommentListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vup
  implements View.OnClickListener
{
  public vup(SigCommentListActivity paramSigCommentListActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.aV(true, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vup
 * JD-Core Version:    0.7.0.1
 */