import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

final class anxn
  implements DialogInterface.OnClickListener
{
  anxn(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anxj.ea(this.val$app);
    anxj.dZ(this.val$app);
    anxj.eb(this.val$app);
    anxj.ec(this.val$app);
    paramDialogInterface = new Intent(this.q, SplashActivity.class);
    paramDialogInterface.putExtra("tab_index", MainFragment.bIk);
    paramDialogInterface.setFlags(67108864);
    this.q.startActivity(paramDialogInterface);
    this.q.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anxn
 * JD-Core Version:    0.7.0.1
 */