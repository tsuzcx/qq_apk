import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uyp
  implements View.OnClickListener
{
  uyp(uyn paramuyn, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    vmp.a("WSUserAuthDialog", "jump to miniApp to set auth switch");
    String str2 = "";
    stUserAuth localstUserAuth = vau.a().a();
    String str1 = str2;
    if (localstUserAuth != null)
    {
      str1 = str2;
      if (localstUserAuth.schema != null) {
        str1 = localstUserAuth.schema.miniAppSchema;
      }
    }
    vmp.a("WSUserAuthDialog", "miniAppSchema = " + str1);
    uyt.a(this.jdField_a_of_type_AndroidContentContext, str1, new uyq(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000007);
    uyn.a(this.jdField_a_of_type_Uyn);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyp
 * JD-Core Version:    0.7.0.1
 */