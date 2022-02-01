import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ycz
  implements View.OnClickListener
{
  ycz(ycd paramycd) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    this.this$0.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    if (this.this$0.rG != null) {
      this.this$0.rG.setVisibility(0);
    }
    if (this.this$0.rH != null) {
      this.this$0.rH.setVisibility(0);
    }
    this.this$0.bIi();
    if (this.this$0.b.aI(this.this$0.oL()) != 0) {
      anot.a(this.this$0.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.this$0.sessionInfo.aTl, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycz
 * JD-Core Version:    0.7.0.1
 */