import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.qphone.base.util.QLog;

public class zqg
  implements DialogInterface.OnClickListener
{
  public zqg(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
    }
    this.this$0.f.b(BindVerifyActivity.a(this.this$0), BindVerifyActivity.b(this.this$0), 0, BindVerifyActivity.a(this.this$0), BindVerifyActivity.b(this.this$0));
    this.this$0.j(2131719519, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zqg
 * JD-Core Version:    0.7.0.1
 */