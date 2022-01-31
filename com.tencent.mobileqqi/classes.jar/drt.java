import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;

class drt
  implements DialogInterface.OnClickListener
{
  drt(drs paramdrs) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SubAccountAssistantForward.a(this.a.a.b, this.a.a, this.a.a.b.getAccount());
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     drt
 * JD-Core Version:    0.7.0.1
 */