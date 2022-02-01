import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vox
  implements View.OnClickListener
{
  public vox(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.bTs();
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vox
 * JD-Core Version:    0.7.0.1
 */