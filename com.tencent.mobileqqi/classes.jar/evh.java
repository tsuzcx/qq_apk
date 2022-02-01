import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class evh
  implements DialogInterface.OnClickListener
{
  public evh(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("uin", this.a.b.a());
    this.a.startActivity(paramDialogInterface.putExtra("url", "http://mp.imqq.com/user/charge"));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     evh
 * JD-Core Version:    0.7.0.1
 */