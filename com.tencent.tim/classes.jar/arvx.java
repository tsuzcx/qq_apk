import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.open.appstore.dl.DownloadManagerV2.19;

public class arvx
  implements DialogInterface.OnClickListener
{
  public arvx(DownloadManagerV2.19 param19) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.bC.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
    arvz.a().d(this.a.G, this.a.bC, this.a.arC, this.a.b, this.a.ela);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvx
 * JD-Core Version:    0.7.0.1
 */