import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

public class ytr
  implements View.OnClickListener
{
  public ytr(GdtBannerAd paramGdtBannerAd, ytv paramytv) {}
  
  public void onClick(View paramView)
  {
    yxs.b("GdtBannerAd", "onClick");
    ytv localytv = this.jdField_a_of_type_Ytv;
    paramView = ytv.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      yxs.b("GdtBannerAd", "onclick:" + GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    GdtHandler.a(GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
    GdtBannerAd.access$100(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytr
 * JD-Core Version:    0.7.0.1
 */