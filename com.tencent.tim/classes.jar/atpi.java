import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;

public class atpi
  implements DialogInterface.OnClickListener
{
  public atpi(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    auen.bl(this.val$app, "0X8008B7C");
    paramDialogInterface = new Bundle();
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(this.a, 1, this.a.getResources().getString(2131693900), 0).show();
      paramDialogInterface.putBoolean("_not_upload_to_cloud_", true);
    }
    while (!AppNetConnInfo.isMobileConn())
    {
      WpsFileEditManager.a().c(WpsFileEditSaveDlgActivity.a(this.a), paramDialogInterface);
      WpsFileEditSaveDlgActivity.a(this.a).dismiss();
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
    }
    WpsFileEditSaveDlgActivity.a(this.a).dismiss();
    WpsFileEditSaveDlgActivity.a(this.a, 2, this.a.getResources().getString(2131693895));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpi
 * JD-Core Version:    0.7.0.1
 */