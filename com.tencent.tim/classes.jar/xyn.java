import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class xyn
  implements DialogInterface.OnClickListener
{
  xyn(xym paramxym, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = wja.a(new Intent(this.val$context, SplashActivity.class), null);
    paramDialogInterface.putExtra("uin", this.a.this$0.sessionInfo.aTl);
    paramDialogInterface.putExtra("uintype", 3000);
    this.val$context.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyn
 * JD-Core Version:    0.7.0.1
 */