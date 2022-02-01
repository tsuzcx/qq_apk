import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;

public class dmj
  implements CompoundButton.OnCheckedChangeListener
{
  public dmj(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SubAccountAssistantImpl.a().a(this.a.b, paramBoolean);
    QQAppInterface localQQAppInterface = this.a.b;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Bind_account", "Top_bind_account", 0, 0, paramCompoundButton, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmj
 * JD-Core Version:    0.7.0.1
 */