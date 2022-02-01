import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppDownloadModule.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;

public class adni
  implements DialogInterface.OnClickListener
{
  adni(adnc paramadnc, WadlParams paramWadlParams, Context paramContext, double paramDouble) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("ark.download.module", 1, new Object[] { "ark.dctrl [StartDownload] dialog callback appid=", this.c.appId, ",name=", this.c.appName, ",which:", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      ArkAppCenter.a().post(this.this$0.mAppName, new ArkAppDownloadModule.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adni
 * JD-Core Version:    0.7.0.1
 */