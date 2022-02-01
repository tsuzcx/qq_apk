import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wfh
  implements View.OnClickListener
{
  public wfh(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.bXH();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     wfh
 * JD-Core Version:    0.7.0.1
 */