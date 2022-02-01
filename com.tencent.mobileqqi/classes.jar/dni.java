import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;

class dni
  implements DialogInterface.OnClickListener
{
  dni(dnh paramdnh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.d();
      SubLoginActivity.a(this.a.a, true);
      SubAccountAssistantManager.a().a(this.a.a.b);
      this.a.a.f();
    }
    for (;;)
    {
      SubAccountAssistantForward.a(this.a.a.b, 0L);
      return;
      this.a.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dni
 * JD-Core Version:    0.7.0.1
 */