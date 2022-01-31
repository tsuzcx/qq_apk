import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

final class ytv
  implements View.OnClickListener
{
  ytv(yts paramyts, ytr paramytr) {}
  
  public void onClick(View paramView)
  {
    yts localyts = this.jdField_a_of_type_Yts;
    paramView = yts.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Ytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramView;
      yxp.d("GdtBannerViewBuilder", "onclick:" + this.jdField_a_of_type_Ytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a);
    }
    if (this.jdField_a_of_type_Ytr.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
      this.jdField_a_of_type_Ytr.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    }
    GdtHandler.a(this.jdField_a_of_type_Ytr.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytv
 * JD-Core Version:    0.7.0.1
 */