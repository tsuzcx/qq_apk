import UserGrowth.stGlobalConfig;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogf
  implements View.OnClickListener
{
  ogf(ogd paramogd, Context paramContext, String paramString) {}
  
  public void onClick(View paramView)
  {
    ooz.i("WSUserAuthDialog", "jump to miniApp to set auth switch");
    String str2 = "";
    stGlobalConfig localstGlobalConfig = ohy.a().a();
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
    ooz.i("WSUserAuthDialog", "miniAppSchema = " + str1);
    ogj.a(this.val$context, str1, new ogg(this));
    WSPublicAccReport.getInstance().reportCallDialog("gzh_click", this.apZ, "authorized_window", 1000007);
    ogd.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogf
 * JD-Core Version:    0.7.0.1
 */