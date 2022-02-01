import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

class adoq
  implements DialogInterface.OnClickListener
{
  adoq(adon paramadon, String paramString1, String paramString2, DownloadInfo paramDownloadInfo, boolean paramBoolean, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.d("ArkApp.downloadyyb.module", 1, new Object[] { "ark.dctrl [doDownloadAction] dialog callback appid=", this.val$appId, ",name=", this.val$appName, ",which:", Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      adon.a(this.this$0, this.d, this.bPY, this.Iu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adoq
 * JD-Core Version:    0.7.0.1
 */