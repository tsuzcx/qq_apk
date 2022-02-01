import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class zuf
  implements View.OnClickListener
{
  zuf(zuc paramzuc, TroopGiftPanel paramTroopGiftPanel) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Zuc.c();
    this.jdField_a_of_type_Zuc.b();
    if (this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c) {
      this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((BaseChatPie)this.jdField_a_of_type_Zuc.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.get()).hideGiftPanel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuf
 * JD-Core Version:    0.7.0.1
 */