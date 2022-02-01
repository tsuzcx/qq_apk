import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.appcommon.now.download.local.DownloadNativeApi.1;

public class arvj
  implements DialogInterface.OnClickListener
{
  public arvj(DownloadNativeApi.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface.dismiss();
      label6:
      arvh.a(this.a.this$0).onDownloadCancel(this.a.f);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label6;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvj
 * JD-Core Version:    0.7.0.1
 */