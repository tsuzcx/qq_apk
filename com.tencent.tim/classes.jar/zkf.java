import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;

class zkf
  implements DialogInterface.OnClickListener
{
  zkf(zju paramzju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.a.getIntent().removeExtra("if_check_account_same");
    this.this$0.x.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkf
 * JD-Core Version:    0.7.0.1
 */