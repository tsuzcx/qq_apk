import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uec
  implements View.OnClickListener
{
  uec(uea paramuea, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    uqf.a("WSUserAuthDialog", "jump to miniApp to set auth switch");
    String str2 = "";
    stUserAuth localstUserAuth = ugd.a().a();
    String str1 = str2;
    if (localstUserAuth != null)
    {
      str1 = str2;
      if (localstUserAuth.schema != null) {
        str1 = localstUserAuth.schema.miniAppSchema;
      }
    }
    uqf.a("WSUserAuthDialog", "miniAppSchema = " + str1);
    ueg.a(this.jdField_a_of_type_AndroidContentContext, str1, new ued(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000007);
    uea.a(this.jdField_a_of_type_Uea);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uec
 * JD-Core Version:    0.7.0.1
 */