import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;

class arwb
  implements DialogInterface.OnClickListener
{
  arwb(arvz paramarvz, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    arvz.a(this.this$0, this.bC, this.arC, this.b);
    anot.a(null, "dc00898", "", "", "0X8008F7C", "0X8008F7C", 0, 0, "", "", "", "");
    paramDialogInterface = this.bC.getString(aryv.PARAM_TASK_PACKNAME) + "_" + this.bC.getString(aryv.PARAM_TASK_APPID) + "_" + this.bC.getString(aryv.PARAM_TASK_APK_ID);
    paramDialogInterface = System.currentTimeMillis() / 1000L + "|" + 101 + "|" + paramDialogInterface;
    arub.a().postReport(25, paramDialogInterface);
    paramDialogInterface = this.bC.getString("pageId") + "_" + this.bC.getString("moduleId") + "_" + this.bC.getString(aryv.PARAM_TASK_PACKNAME) + "_" + this.bC.getString(aryv.PARAM_TASK_APPID) + "_" + this.bC.getString(aryv.PARAM_TASK_APK_ID);
    arwk.q("6006", "2", "0", this.bC.getString(aryv.PARAM_VIA), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arwb
 * JD-Core Version:    0.7.0.1
 */