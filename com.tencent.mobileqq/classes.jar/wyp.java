import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.TopayManager;
import com.tencent.mobileqq.activity.qwallet.TopayManager.5;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wyp
  implements Runnable
{
  public wyp(TopayManager.5 param5, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    SelectMemberActivity localSelectMemberActivity = (SelectMemberActivity)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localSelectMemberActivity == null) || (localSelectMemberActivity.isFinishing())) {
      return;
    }
    TopayManager.a(localSelectMemberActivity, false);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.jdField_a_of_type_AndroidOsResultReceiver.send(1, null);
      ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.aio.send", 0, 0, "", "", "", "");
      int i = localSelectMemberActivity.getIntent().getIntExtra("iPayFrom", -1);
      if (QLog.isColorLevel()) {
        QLog.e("TopayManager", 2, "iPayFrom : " + i);
      }
      if (i == 1)
      {
        TopayManager.a(localSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.b);
        return;
      }
      TopayManager.b(localSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletTopayManager$5.b);
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("retmsg");; str = null)
    {
      if (TextUtils.isEmpty(str)) {
        str = localSelectMemberActivity.getResources().getString(2131435586);
      }
      for (;;)
      {
        DialogUtil.a(localSelectMemberActivity, 231, null, str, localSelectMemberActivity.getResources().getString(2131432999), null, null, new wyq(this)).show();
        ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.errwinshow", 0, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyp
 * JD-Core Version:    0.7.0.1
 */