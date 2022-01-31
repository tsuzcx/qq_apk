import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;

public class fgv
  implements Runnable
{
  public fgv(DownloadManager paramDownloadManager, Bundle paramBundle, Activity paramActivity, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2) {}
  
  public void run()
  {
    Object localObject = new fgw(this);
    fgx localfgx = new fgx(this);
    LogUtility.b(DownloadManager.a, "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131362108)).setPositiveButton(2131362106, localfgx).setNegativeButton(2131362107, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fgv
 * JD-Core Version:    0.7.0.1
 */