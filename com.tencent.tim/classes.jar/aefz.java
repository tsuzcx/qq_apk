import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class aefz
  implements DialogInterface.OnDismissListener
{
  public aefz(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    LocationSelectActivity.a(this.this$0).setRightTextColor(2);
    if (AppSetting.enableTalkBack)
    {
      LocationSelectActivity.b(this.this$0).setContentDescription(acfp.m(2131707905) + LocationSelectActivity.a(this.this$0).name);
      LocationSelectActivity.a(this.this$0).setContentDescription(acfp.m(2131707903) + LocationSelectActivity.a(this.this$0).a().getText());
    }
    paramDialogInterface = LocationSelectActivity.a(this.this$0);
    if (LocationSelectActivity.a(this.this$0) == 0)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "0X8004248", "0X8004248", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
      return;
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X800424A", "0X800424A", 0, 0, paramDialogInterface[0], paramDialogInterface[1], paramDialogInterface[2], "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefz
 * JD-Core Version:    0.7.0.1
 */