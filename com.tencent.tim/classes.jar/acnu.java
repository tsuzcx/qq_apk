import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class acnu
  implements DialogInterface.OnClickListener
{
  public acnu(VideoBroadcastReceiver paramVideoBroadcastReceiver, int paramInt1, QQAppInterface paramQQAppInterface, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    jjk.S(false, false);
    if (this.alR == 3000)
    {
      VideoMsgTools.a(this.val$app, this.alR, this.val$type, false, this.bpU, this.bpV, false, null, true, new Object[0]);
      VideoBroadcastReceiver.a(this.b, 3, this.alR, this.bpU, this.Mu, this.bpW);
    }
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    jjk.kZ(this.val$app.isBackground_Pause);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnu
 * JD-Core Version:    0.7.0.1
 */