import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.OnPriceSelectedListener;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.activity.qwallet.widget.NumAnim;
import com.tencent.mobileqq.app.QQAppInterface;

public class xbb
  implements PriceSettingDialog.OnPriceSelectedListener
{
  public xbb(GoldMsgAioState paramGoldMsgAioState, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void a(long paramLong)
  {
    GoldMsgChatHelper.GoldMsgChatState localGoldMsgChatState = GoldMsgChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if (localGoldMsgChatState != null) {
      localGoldMsgChatState.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramLong, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a.setText(NumAnim.formatNumber(paramLong / 100.0D, false) + "元");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbb
 * JD-Core Version:    0.7.0.1
 */