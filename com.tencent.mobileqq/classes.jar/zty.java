import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class zty
  implements View.OnClickListener
{
  public zty(TroopGiftPanel paramTroopGiftPanel, ztb paramztb, ztg paramztg, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onClick(View paramView)
  {
    String str1 = this.jdField_a_of_type_Ztb.b;
    String str2 = this.jdField_a_of_type_Ztg.jdField_a_of_type_JavaLangString;
    float f = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getProgress();
    Iterator localIterator = this.jdField_a_of_type_Ztb.a.iterator();
    while (localIterator.hasNext())
    {
      zta localzta = (zta)localIterator.next();
      if ((f >= localzta.jdField_a_of_type_Float) && (f < localzta.b))
      {
        str1 = localzta.d;
        str2 = localzta.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(str1);
      bcef.b(null, "dc00899", "grp_lbs", "", "qq_gift", "aio_top_click", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", "", str2);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zty
 * JD-Core Version:    0.7.0.1
 */