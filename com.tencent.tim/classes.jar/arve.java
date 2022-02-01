import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;
import com.tencent.open.downloadnew.DownloadInfo;

public class arve
  implements DialogInterface.OnClickListener
{
  public arve(DownloadJSApi.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      paramDialogInterface = this.a.bC.getString(aryv.PARAM_SNG_APPID);
      String str1 = this.a.bC.getString(aryv.PARAM_URL);
      String str2 = this.a.bC.getString(aryv.PARAM_TASK_PACKNAME);
      String str3 = this.a.bC.getString(aryv.PARAM_VIA);
      String str4 = this.a.bC.getString(aryv.PARAM_APPNAME);
      boolean bool = this.a.bC.getBoolean(aryv.PARAM_IS_APK, true);
      paramDialogInterface = new DownloadInfo(paramDialogInterface, str1.trim(), str2, str4, str3, null, this.a.arC, bool);
      aryy.a().b(10, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arve
 * JD-Core Version:    0.7.0.1
 */