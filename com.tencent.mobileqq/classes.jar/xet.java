import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDialog;
import com.tencent.mobileqq.nearby.widget.ButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog.OnClickListener;

public class xet
  implements View.OnClickListener
{
  public xet(GoldMsgDialog paramGoldMsgDialog, ButtonInfo paramButtonInfo) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgDialog.dismiss();
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetButtonInfo.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyWidgetButtonInfo.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xet
 * JD-Core Version:    0.7.0.1
 */