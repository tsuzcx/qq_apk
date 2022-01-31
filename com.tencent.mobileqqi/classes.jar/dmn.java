import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;

class dmn
  implements DialogInterface.OnClickListener
{
  dmn(dml paramdml) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.d();
      SubAccountSettingActivity.a(this.a.a, true);
      SubAccountAssistantManager.a().a(this.a.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dmn
 * JD-Core Version:    0.7.0.1
 */