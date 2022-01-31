import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;

final class ykx
  implements View.OnClickListener
{
  ykx(yku paramyku, ykt paramykt) {}
  
  public void onClick(View paramView)
  {
    yku localyku = this.jdField_a_of_type_Yku;
    paramView = yku.a.onClick(paramView);
    if (!TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_Ykt.jdField_a_of_type_Yjs.a = paramView;
      yny.d("GdtBannerViewBuilder", "onclick:" + this.jdField_a_of_type_Ykt.jdField_a_of_type_Yjs.a);
    }
    if (this.jdField_a_of_type_Ykt.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick != null) {
      this.jdField_a_of_type_Ykt.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick.a();
    }
    yjr.a(this.jdField_a_of_type_Ykt.jdField_a_of_type_Yjs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykx
 * JD-Core Version:    0.7.0.1
 */