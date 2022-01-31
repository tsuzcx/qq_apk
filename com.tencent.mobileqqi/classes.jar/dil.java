import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class dil
  implements View.OnClickListener
{
  public dil(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null)
    {
      this.a.a = ((ActionSheet)ActionSheetHelper.a(this.a, null));
      this.a.a.c(2131560772);
      this.a.a.d(2131561746);
      this.a.a.a(new dim(this));
    }
    if (!this.a.a.isShowing()) {
      this.a.a.show();
    }
    ReportController.a(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "click_menu", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dil
 * JD-Core Version:    0.7.0.1
 */