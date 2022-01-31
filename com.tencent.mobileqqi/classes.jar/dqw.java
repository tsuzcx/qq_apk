import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;

class dqw
  implements DialogInterface.OnClickListener
{
  dqw(dqv paramdqv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.a.d();
      SubAccountBindActivity.a(this.a.a, true);
      SubAccountAssistantManager.a().a(this.a.a.b);
      this.a.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dqw
 * JD-Core Version:    0.7.0.1
 */