import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;

public class arvd
  implements DialogInterface.OnClickListener
{
  public arvd(DownloadJSApi.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.bC.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
    arvc.a(this.a.G, this.a.bC, this.a.arC, this.a.b, this.a.ela);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvd
 * JD-Core Version:    0.7.0.1
 */