import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class uyr
  implements DialogInterface.OnCancelListener
{
  uyr(uyn paramuyn, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    vmp.a("WSUserAuthDialog", "dialog cancel");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyr
 * JD-Core Version:    0.7.0.1
 */