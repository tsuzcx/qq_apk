import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.ui.ForceUserUpdateActivity;

public class avnx
  implements View.OnClickListener
{
  public avnx(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnx
 * JD-Core Version:    0.7.0.1
 */