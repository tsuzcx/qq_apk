import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;

class zrf
  implements DialogInterface.OnClickListener
{
  zrf(zrd paramzrd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.this$0.ceB == 2) {
      this.a.this$0.cN("0X8005B8A", 1);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (aqiw.isNetSupport(this.a.this$0)) {
        break;
      }
      this.a.this$0.showToast(2131696348);
      return;
      if (this.a.this$0.ceB == 6) {
        this.a.this$0.cN("0X8005B8A", 2);
      } else if (this.a.this$0.ceB == 7) {
        this.a.this$0.cN("0X8005B8A", 3);
      }
    }
    paramDialogInterface = this.a.this$0.f.a();
    if ((paramDialogInterface == null) || (paramDialogInterface.nationCode == null) || (paramDialogInterface.mobileNo == null))
    {
      this.a.this$0.setResult(0);
      this.a.this$0.finish();
      return;
    }
    if (this.a.this$0.l == null)
    {
      this.a.this$0.l = new zrg(this);
      this.a.this$0.app.registObserver(this.a.this$0.l);
    }
    this.a.this$0.f.dQ(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
    this.a.this$0.j(2131719519, 300L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zrf
 * JD-Core Version:    0.7.0.1
 */