import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class voy
  implements View.OnClickListener
{
  public voy(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mActionSheet == null)
    {
      this.a.mActionSheet = ((ausj)auss.a(this.a, null));
      this.a.mActionSheet.addButton(2131700238);
      this.a.mActionSheet.addButton(2131693407);
      this.a.mActionSheet.addCancelButton(2131721058);
      this.a.mActionSheet.a(new voz(this));
    }
    if (!this.a.mActionSheet.isShowing()) {
      this.a.mActionSheet.show();
    }
    anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     voy
 * JD-Core Version:    0.7.0.1
 */