import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

final class arys
  implements DialogInterface.OnClickListener
{
  arys(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    aryr.b(this.bC, this.arC, this.b);
    anot.a(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.bC.getString(aryv.PARAM_TASK_PACKNAME) + "_" + this.bC.getString(aryv.PARAM_TASK_APPID) + "_" + this.bC.getString(aryv.PARAM_TASK_APK_ID);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    arub.a().postReport(25, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arys
 * JD-Core Version:    0.7.0.1
 */