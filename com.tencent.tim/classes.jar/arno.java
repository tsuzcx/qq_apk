import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil.1.1;

public final class arno
  implements DialogInterface.OnClickListener
{
  arno(String paramString1, int paramInt1, int paramInt2, QQMessageFacade paramQQMessageFacade, String paramString2, int paramInt3, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    anot.a(null, "P_CliOper", "Safe_SensMsg", this.aUY, "Alert_Dialog", "Other", this.val$id, this.eky, "", "", "", "");
    ThreadManager.executeOnSubThread(new MQPSensitiveMsgUtil.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arno
 * JD-Core Version:    0.7.0.1
 */