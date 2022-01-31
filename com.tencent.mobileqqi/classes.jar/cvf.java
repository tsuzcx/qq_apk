import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;

class cvf
  implements DialogInterface.OnClickListener
{
  cvf(cve paramcve) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.e();
      LoginVerifyCodeActivity.a(this.a.a, true);
      SubAccountAssistantManager.a().a(this.a.a.b);
      this.a.a.h();
    }
    for (;;)
    {
      SubAccountAssistantForward.a(this.a.a.b, 0L);
      return;
      this.a.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cvf
 * JD-Core Version:    0.7.0.1
 */