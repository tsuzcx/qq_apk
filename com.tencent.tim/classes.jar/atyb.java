import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.tbs.reader.TbsReaderView;

class atyb
  implements DialogInterface.OnClickListener
{
  atyb(atxz paramatxz, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    atxy.a(this.a.this$0).userStatistics(this.bIX);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("_filename_from_dlg", this.a.val$activity.getString(2131696538));
    Intent localIntent = new Intent("com.tencent.qfile_unifromdownload");
    localIntent.putExtra("param", paramDialogInterface);
    localIntent.putExtra("url", this.bIY);
    this.a.val$activity.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyb
 * JD-Core Version:    0.7.0.1
 */