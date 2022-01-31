import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mobileqq.app.MQPIntChkHandler;
import com.tencent.qphone.base.util.QLog;

public class fdl
  extends BroadcastReceiver
{
  public fdl(MQPIntChkHandler paramMQPIntChkHandler, DownloadManager paramDownloadManager) {}
  
  @SuppressLint({"NewApi"})
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("extra_download_id", -1L);
    if (MQPIntChkHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppMQPIntChkHandler) == l)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("IntChk", 4, "download complete.");
      }
      paramIntent = "";
      Object localObject = new DownloadManager.Query();
      ((DownloadManager.Query)localObject).setFilterById(new long[] { l });
      localObject = this.jdField_a_of_type_AndroidAppDownloadManager.query((DownloadManager.Query)localObject);
      if (((Cursor)localObject).moveToFirst()) {
        paramIntent = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("local_filename"));
      }
      ((Cursor)localObject).close();
      if ((paramIntent != null) && (paramIntent != ""))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("IntChk", 4, "install downloaded package:" + paramIntent);
        }
        localObject = new Intent("android.intent.action.VIEW");
        ((Intent)localObject).setDataAndType(Uri.parse("file://" + paramIntent), "application/vnd.android.package-archive");
        ((Intent)localObject).setFlags(268435456);
        paramContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fdl
 * JD-Core Version:    0.7.0.1
 */