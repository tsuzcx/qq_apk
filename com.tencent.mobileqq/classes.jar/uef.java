import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uef
  implements View.OnClickListener
{
  uef(uea paramuea, String paramString) {}
  
  public void onClick(View paramView)
  {
    uqf.a("WSUserAuthDialog", "dialog click ok");
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000001);
    uea.a(this.jdField_a_of_type_Uea);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uef
 * JD-Core Version:    0.7.0.1
 */