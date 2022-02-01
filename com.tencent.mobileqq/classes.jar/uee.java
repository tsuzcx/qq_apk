import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class uee
  implements DialogInterface.OnCancelListener
{
  uee(uea paramuea, String paramString) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    uqf.a("WSUserAuthDialog", "dialog cancel");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uee
 * JD-Core Version:    0.7.0.1
 */