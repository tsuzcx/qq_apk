import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.EUCountryUtils;
import mqq.app.MobileQQ;

public class ehv
  implements DialogInterface.OnClickListener
{
  public ehv(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      EUCountryUtils.c(this.a.a.b.a());
      EUCountryUtils.c(this.a.a.b.getApplication().getProperty(this.a.a.b.a()));
      this.a.a(this.a.a, this.a.a.b, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ehv
 * JD-Core Version:    0.7.0.1
 */