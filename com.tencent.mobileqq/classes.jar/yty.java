import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

final class yty
  implements View.OnClickListener
{
  yty(ytv paramytv, ytu paramytu) {}
  
  public void onClick(View paramView)
  {
    ytv localytv = this.jdField_a_of_type_Ytv;
    paramView = ytv.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Ytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      yxs.d("GdtBannerViewBuilder", "onclick:" + this.jdField_a_of_type_Ytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    if (this.jdField_a_of_type_Ytu.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
      this.jdField_a_of_type_Ytu.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    }
    GdtHandler.a(this.jdField_a_of_type_Ytu.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yty
 * JD-Core Version:    0.7.0.1
 */