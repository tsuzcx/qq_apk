import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.activity.SubaccountUgActivity;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;

class dnd
  implements DialogInterface.OnClickListener
{
  dnd(dnc paramdnc) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.b(this.a.a.b);
    SubAccountAssistantForward.a(this.a.a.b);
    this.a.a.a().setTitle("");
    paramDialogInterface = new Intent(this.a.a.a(), SubaccountUgActivity.class);
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnd
 * JD-Core Version:    0.7.0.1
 */