import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;

class dsd
  implements DialogInterface.OnClickListener
{
  dsd(dsc paramdsc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      SubAccountAssistantForward.a(this.a.a.b, this.a.a.a(), this.a.a.b.getAccount());
      this.a.a.f();
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dsd
 * JD-Core Version:    0.7.0.1
 */