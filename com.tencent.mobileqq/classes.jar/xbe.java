import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class xbe
  implements View.OnFocusChangeListener
{
  public xbe(GoldMsgAioState paramGoldMsgAioState, QQCustomDialog paramQQCustomDialog, Context paramContext) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      GoldMsgAioState.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.getWindow(), this.jdField_a_of_type_AndroidContentContext, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbe
 * JD-Core Version:    0.7.0.1
 */