import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

public final class avrl
  implements DialogInterface.OnClickListener
{
  public avrl(Context paramContext, int paramInt, String paramString, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!avpw.a(this.val$activity, this.eya, Long.valueOf(this.val$uin).longValue(), "com.qzonex.app.tab.QZoneTabActivity")) {
      avpw.p(this.val$intent.getStringExtra("sid"), this.val$activity);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avrl
 * JD-Core Version:    0.7.0.1
 */