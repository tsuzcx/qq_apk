import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class ahib
  implements DialogInterface.OnClickListener
{
  ahib(ahhz paramahhz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ahhz.a(this.a).we(true);
      paramDialogInterface = new Intent(ahhz.a(this.a), LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface = wja.a(paramDialogInterface, new int[] { 2 });
      paramDialogInterface.putExtra("key_action", ahhz.class.getSimpleName());
      paramDialogInterface.putExtra("uin", ahhz.a(this.a).aTl);
      paramDialogInterface.putExtra("uintype", ahhz.a(this.a).cZ);
      paramDialogInterface.putExtra("thridparty_pull_aio", true);
      paramDialogInterface.putExtra("pull_aio_audio", ahhz.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ahhz.b(this.a));
      paramDialogInterface.putExtra("openid", ahhz.a(this.a));
      paramDialogInterface.putExtra("appid", ahhz.b(this.a));
      paramDialogInterface.putExtra("pull_aio_audio", ahhz.a(this.a));
      paramDialogInterface.putExtra("pull_aio_video", ahhz.b(this.a));
      paramDialogInterface.putExtra("uinname", ahhz.a(this.a).aTn);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      ahhz.a(this.a).dismiss();
      ahhz.a(this.a).startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahib
 * JD-Core Version:    0.7.0.1
 */