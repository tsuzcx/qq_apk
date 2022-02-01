import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

final class awfd
  implements DialogInterface.OnClickListener
{
  awfd(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (avpq.getQUA3().indexOf("GM") < 0) {
        awfb.q(QzoneConfig.getInstance().getConfig("H5Url", "DownloadQzoneClient", "https://m.qzone.com/client/fwd?bid=update&_wv=7"), this.val$context);
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("showQzoneAppDownloadDialog", 2, "simpleBrowserJump exception", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awfd
 * JD-Core Version:    0.7.0.1
 */