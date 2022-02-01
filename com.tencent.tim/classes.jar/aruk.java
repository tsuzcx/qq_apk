import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.open.appcommon.js.AppInterface;
import com.tencent.open.appcommon.js.AppInterface.1.1;

public class aruk
  implements DialogInterface.OnClickListener
{
  public aruk(AppInterface paramAppInterface, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "";
    if (paramInt == 2131692669)
    {
      arxt.br("200", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
      paramDialogInterface = aroi.a().getContext().getSharedPreferences("package_scan", 0).edit();
      paramDialogInterface.putBoolean("qqsetting_package_scan_flag", false);
      paramDialogInterface.commit();
      if ((this.this$0.tipDialog != null) && (this.this$0.tipDialog.isShowing())) {
        this.this$0.tipDialog.dismiss();
      }
      paramDialogInterface = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.cCv + "','r':'0','data':'0'});}void(0);";
    }
    for (;;)
    {
      this.this$0.mHandler.post(new AppInterface.1.1(this, paramDialogInterface));
      return;
      if (paramInt == 2131692668)
      {
        if ((this.this$0.tipDialog != null) && (this.this$0.tipDialog.isShowing())) {
          this.this$0.tipDialog.dismiss();
        }
        paramDialogInterface = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.gSetPackageScanSetting',{'guid':'" + this.cCv + "','r':'0','data':'1'});}void(0);";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruk
 * JD-Core Version:    0.7.0.1
 */