import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerEntryItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class yck
  implements View.OnClickListener
{
  public yck(RecommendBannerEntryItemView paramRecommendBannerEntryItemView) {}
  
  public void onClick(View paramView)
  {
    paramView = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
    MiniAppLauncher.startMiniApp(this.a.getContext(), paramView, 2016, null, null);
    bjdt.a();
    zaj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "clk_find", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yck
 * JD-Core Version:    0.7.0.1
 */