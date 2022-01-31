import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class wqm
  implements DialogInterface.OnClickListener
{
  public wqm(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    if (this.a.a.getIntent().getExtras() != null) {
      paramDialogInterface.putExtras(this.a.a.getIntent().getExtras());
    }
    paramDialogInterface.addFlags(268435456);
    paramDialogInterface.addFlags(67108864);
    this.a.a.startActivity(paramDialogInterface);
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */