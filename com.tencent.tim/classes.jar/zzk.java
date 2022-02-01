import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;

public class zzk
  implements DialogInterface.OnClickListener
{
  public zzk(SendHbActivity paramSendHbActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("hb_id", SendHbActivity.a(this.a));
    paramDialogInterface.putExtra("send_uin", SendHbActivity.b(this.a));
    paramDialogInterface.putExtra("hb_type", "1");
    paramDialogInterface.putExtra("forward_text", this.a.getString(2131699262));
    if (SendHbActivity.a(this.a)) {
      paramDialogInterface.putExtra("item", 1);
    }
    paramDialogInterface.putExtra("forward_type", 17);
    paramDialogInterface.putExtra("invoke_from", "qwallet");
    ahgq.P(this.a, paramDialogInterface);
    this.a.c(SendHbActivity.b(this.a), this.a.yv(), "hongbao.wrapped.send", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zzk
 * JD-Core Version:    0.7.0.1
 */