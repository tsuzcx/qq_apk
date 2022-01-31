import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.statistics.ReportController;

public class ber
  implements View.OnClickListener
{
  public ber(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    this.a.o();
    ReportController.b(this.a.a, "CliOper", "", "", "Setting_tab", "Clk_myalbum", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ber
 * JD-Core Version:    0.7.0.1
 */