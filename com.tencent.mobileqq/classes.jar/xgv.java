import android.content.res.Resources;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketRecordFragment;
import com.tencent.mobileqq.activity.qwallet.voice.RecordMicView;

public class xgv
  implements Runnable
{
  public xgv(RedPacketRecordFragment paramRedPacketRecordFragment, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.a()) {
      return;
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.getResources().getString(2131432352);
    String str1;
    if (this.jdField_a_of_type_Int == 2) {
      str1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.c.setText(str1);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceRecordMicView.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment);
      if (RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment) == null) {
        break;
      }
      RedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment).removeCallbacksAndMessages(null);
      return;
      str1 = str2;
      if (this.jdField_a_of_type_Int == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedPacketRecordFragment.getActivity());
        str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xgv
 * JD-Core Version:    0.7.0.1
 */