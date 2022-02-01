import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.5;
import com.tencent.qphone.base.util.QLog;

public class adnj
  implements DialogInterface.OnClickListener
{
  public adnj(ArkAppDownloadModule.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = false;
    adnc.a(this.a.this$0, true);
    awok.a().eF(this.a.val$from, this.a.val$appId);
    anot.c(null, "dc00898", "", "", "0X8009E13", "0X8009E13", 0, 0, "7", "", this.a.val$appId, "");
    if ((paramDialogInterface instanceof aqju))
    {
      if (!((aqju)paramDialogInterface).getCheckBoxState()) {
        bool = true;
      }
      if (this.a.val$sp == null) {}
    }
    try
    {
      this.a.val$sp.edit().putBoolean(this.a.val$key, bool).apply();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ark.download.module", 1, "ark.dctrl.continue download sp error : ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adnj
 * JD-Core Version:    0.7.0.1
 */