import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class xgu
  implements Runnable
{
  public xgu(RedPacketRecordFragment paramRedPacketRecordFragment, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.a()) {
      return;
    }
    label48:
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.c.setText("识别成功");
      RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.f();
      if (RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment))
      {
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.getActivity().app;
        if (!this.jdField_a_of_type_Boolean) {
          break label230;
        }
      }
    }
    label230:
    for (int i = 1;; i = 0)
    {
      ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "162", "sound.grap.result", 0, i, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title.length() + "", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.getActivity().app.getCurrentAccountUin(), DeviceInfoUtil.f() + "|" + DeviceInfoUtil.j(), "");
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
      if (RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment) == null) {
        break;
      }
      RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment).removeCallbacksAndMessages(null);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.c.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.getResources().getString(2131432352));
      break label48;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgu
 * JD-Core Version:    0.7.0.1
 */