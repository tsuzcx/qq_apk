import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ucd
  implements View.OnClickListener
{
  public ucd(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.this$0.x != null) && (this.this$0.x.isShowing())) {
      this.this$0.x.dismiss();
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X800433B", "0X800433B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ucd
 * JD-Core Version:    0.7.0.1
 */