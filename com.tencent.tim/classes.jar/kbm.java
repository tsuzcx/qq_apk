import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountMenuBar;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kbm
  implements View.OnClickListener
{
  public kbm(PublicAccountMenuBar paramPublicAccountMenuBar, boolean paramBoolean, mobileqq_mp.ButtonInfo paramButtonInfo, soo paramsoo) {}
  
  public void onClick(View paramView)
  {
    if (this.adv) {
      PublicAccountMenuBar.a(this.b, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ButtonInfo);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PublicAccountMenuBar.a(this.b, this.jdField_a_of_type_Soo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbm
 * JD-Core Version:    0.7.0.1
 */