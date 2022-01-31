import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;

public class fek
  implements Runnable
{
  public fek(DownloadManager paramDownloadManager, Bundle paramBundle, Activity paramActivity, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2) {}
  
  public void run()
  {
    Object localObject = new fel(this);
    fem localfem = new fem(this);
    LogUtility.b(DownloadManager.a, "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131362111)).setPositiveButton(2131362109, localfem).setNegativeButton(2131362110, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      ((Dialog)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fek
 * JD-Core Version:    0.7.0.1
 */