import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;

public class acnt
  implements DialogInterface.OnClickListener
{
  public acnt(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QQAppInterface localQQAppInterface = this.val$app;
    paramInt = this.alR;
    int i = this.val$type;
    if (!this.Pd) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(localQQAppInterface, paramInt, i, bool, this.SO, this.aem, this.bJG, null, true, new Object[0]);
      paramDialogInterface.dismiss();
      jjk.P(this.val$app.isBackground_Pause, this.Pd);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acnt
 * JD-Core Version:    0.7.0.1
 */