import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class ogh
  implements DialogInterface.OnCancelListener
{
  ogh(ogd paramogd, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ooz.i("WSUserAuthDialog", "dialog cancel");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.apZ, "authorized_window", 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogh
 * JD-Core Version:    0.7.0.1
 */