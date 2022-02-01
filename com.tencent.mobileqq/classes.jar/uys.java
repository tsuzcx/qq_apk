import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uys
  implements View.OnClickListener
{
  uys(uyn paramuyn, String paramString) {}
  
  public void onClick(View paramView)
  {
    vmp.a("WSUserAuthDialog", "dialog click ok");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
    uyn.a(this.jdField_a_of_type_Uyn);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uys
 * JD-Core Version:    0.7.0.1
 */