import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

class tkt
  implements DialogInterface.OnClickListener
{
  tkt(tkr paramtkr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!NetworkUtil.d(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131434629);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new tku(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).b(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131434469, 0L, true);
    ReportController.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tkt
 * JD-Core Version:    0.7.0.1
 */