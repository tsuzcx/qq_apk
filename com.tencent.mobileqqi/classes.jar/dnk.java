import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;

class dnk
  implements DialogInterface.OnClickListener
{
  dnk(dnh paramdnh) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.b(this.a.a.b);
    SubAccountAssistantForward.a(this.a.a.b);
    SubAccountAssistantForward.a(this.a.a.b, this.a.a, this.a.a.b.getAccount());
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dnk
 * JD-Core Version:    0.7.0.1
 */