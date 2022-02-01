import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class thb
  implements View.OnClickListener
{
  public thb(GdtBannerAd paramGdtBannerAd, the paramthe) {}
  
  public void onClick(View paramView)
  {
    tkw.i("GdtBannerAd", "onClick");
    Object localObject = this.jdField_a_of_type_The;
    localObject = the.a.onClick(paramView);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).c.antiSpamParams = ((String)localObject);
      tkw.i("GdtBannerAd", "onclick:" + GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).c.antiSpamParams);
    }
    GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).a.click();
    GdtHandler.a(GdtBannerAd.access$000(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd).c);
    GdtBannerAd.access$100(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     thb
 * JD-Core Version:    0.7.0.1
 */