import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.SplashActivity;

class zkg
  implements DialogInterface.OnClickListener
{
  zkg(zju paramzju) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.this$0.a, LoginActivity.class);
    paramDialogInterface.putExtra("is_change_account", true);
    if (this.this$0.a.getIntent().getExtras() != null) {
      paramDialogInterface.putExtras(this.this$0.a.getIntent().getExtras());
    }
    paramDialogInterface.addFlags(268435456);
    paramDialogInterface.addFlags(67108864);
    this.this$0.a.startActivity(paramDialogInterface);
    this.this$0.x.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zkg
 * JD-Core Version:    0.7.0.1
 */