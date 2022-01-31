import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadManager;

public class hna
  implements Runnable
{
  public hna(DownloadManager paramDownloadManager, Bundle paramBundle, Activity paramActivity, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2) {}
  
  public void run()
  {
    Object localObject = new hnb(this);
    hnc localhnc = new hnc(this);
    LogUtility.b(DownloadManager.a, "dialog create and show");
    localObject = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131560018)).setPositiveButton(2131560016, localhnc).setNegativeButton(2131560017, (DialogInterface.OnClickListener)localObject).create();
    ((Dialog)localObject).setCanceledOnTouchOutside(false);
    ((Dialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hna
 * JD-Core Version:    0.7.0.1
 */