import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tim.filemanager.activity.WpsFileEditSaveDlgActivity;
import com.tencent.tim.filemanager.core.WpsFileEditManager;

public class atph
  implements DialogInterface.OnClickListener
{
  public atph(WpsFileEditSaveDlgActivity paramWpsFileEditSaveDlgActivity, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    auen.bl(this.val$app, "0X8008B7D");
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(this.a, 1, this.a.getResources().getString(2131693900), 0).show();
    }
    for (;;)
    {
      WpsFileEditSaveDlgActivity.a(this.a).dismiss();
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
      if (AppNetConnInfo.isMobileConn())
      {
        WpsFileEditSaveDlgActivity.a(this.a).dismiss();
        WpsFileEditSaveDlgActivity.a(this.a, 1, this.a.getResources().getString(2131693895));
        return;
      }
      WpsFileEditManager.a().b(WpsFileEditSaveDlgActivity.a(this.a), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atph
 * JD-Core Version:    0.7.0.1
 */