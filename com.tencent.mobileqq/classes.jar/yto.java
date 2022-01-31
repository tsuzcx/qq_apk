import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

public class yto
  implements View.OnClickListener
{
  public yto(GdtBannerAd paramGdtBannerAd, yts paramyts) {}
  
  public void onClick(View paramView)
  {
    yxp.b("GdtBannerAd", "onClick");
    yts localyts = this.jdField_a_of_type_Yts;
    paramView = yts.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      yxp.b("GdtBannerAd", "onclick:" + GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    GdtHandler.a(GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
    GdtBannerAd.access$100(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yto
 * JD-Core Version:    0.7.0.1
 */