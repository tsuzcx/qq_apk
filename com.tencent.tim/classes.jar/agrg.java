import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView;

class agrg
  implements DialogInterface.OnClickListener
{
  agrg(agre paramagre, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    agrd.a(this.a.b).userStatistics(this.bIX);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.a.val$activity.getString(2131696538));
    paramDialogInterface.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
    paramDialogInterface.putString("big_brother_source_key", "biz_src_jc_file");
    localIntent.putExtra("param", paramDialogInterface);
    localIntent.putExtra("url", this.bIY);
    this.a.val$activity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agrg
 * JD-Core Version:    0.7.0.1
 */