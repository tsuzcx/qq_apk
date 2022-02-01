import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class vlw
  implements DialogInterface.OnClickListener
{
  vlw(vlu paramvlu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!aqiw.isNetSupport(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131696348);
      return;
    }
    if (this.a.a.d == null)
    {
      this.a.a.d = new vlx(this);
      this.a.a.app.registObserver(this.a.a.d);
    }
    PhoneUnityChangeActivity.a(this.a.a).bi(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131719519, 0L, true);
    anot.a(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vlw
 * JD-Core Version:    0.7.0.1
 */