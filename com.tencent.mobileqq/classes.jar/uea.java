import UserGrowth.stGlobalConfig;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class uea
  implements View.OnClickListener
{
  uea(udy paramudy, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    upe.a("WSUserAuthDialog", "jump to miniApp to set auth switch");
    String str2 = "";
    stGlobalConfig localstGlobalConfig = ugb.a().a();
    String str1 = str2;
    if (localstGlobalConfig != null)
    {
      str1 = str2;
      if (localstGlobalConfig.user_auth != null)
      {
        str1 = str2;
        if (localstGlobalConfig.user_auth.schema != null) {
          str1 = localstGlobalConfig.user_auth.schema.miniAppSchema;
        }
      }
    }
    upe.a("WSUserAuthDialog", "miniAppSchema = " + str1);
    uee.a(this.jdField_a_of_type_AndroidContentContext, str1, new ueb(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.jdField_a_of_type_JavaLangString, "authorized_window", 1000007);
    udy.a(this.jdField_a_of_type_Udy);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uea
 * JD-Core Version:    0.7.0.1
 */