import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class zov
  implements DialogInterface.OnClickListener
{
  public zov(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.this$0.VE()) {
      ((aqrb)this.this$0.app.getBusinessHandler(71)).R(this.this$0.Ll, this.this$0.a.ebe, -1);
    }
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
    anot.a(this.this$0.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.this$0.Ll), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zov
 * JD-Core Version:    0.7.0.1
 */