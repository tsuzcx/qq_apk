import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.qphone.base.util.QLog;

public class zpy
  implements DialogInterface.OnClickListener
{
  public zpy(BindNumberActivity paramBindNumberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BindNumberActivity", 2, "new user guild confirm unbind");
    }
    this.this$0.report("dc00898", "0X8009F16", 0);
    this.this$0.f.b(this.this$0.countryCode, this.this$0.baz, 0, this.this$0.bsj, this.this$0.bsk);
    this.this$0.j(2131719519, 1000L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zpy
 * JD-Core Version:    0.7.0.1
 */