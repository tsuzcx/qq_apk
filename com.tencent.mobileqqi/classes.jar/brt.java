import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.EUCountryUtils;
import java.util.List;

public class brt
  implements View.OnClickListener
{
  public brt(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), "", "", "");
    if (!PhoneNumLoginImpl.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a)) {}
    do
    {
      return;
      AccountManageActivity.a(this.a, SubAccountAssistantManager.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
      paramView = paramView.getTag();
      if (paramView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Switch_Account", 2, "switch a non-existing account");
    return;
    int i = ((Integer)paramView).intValue();
    paramView = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(i);
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "switch uin:" + paramView.getUin());
    }
    if ((paramView != null) && (!paramView.getUin().equals(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())))
    {
      if (!EUCountryUtils.e(paramView.getUin()))
      {
        QQToast.a(this.a, 2131563354, 0).a();
        return;
      }
      this.a.g();
      this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramView;
      this.a.jdField_b_of_type_Boolean = true;
      AccountManageActivity.b(this.a, true);
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.switchAccount(paramView);
      if (QQPlayerService.a())
      {
        paramView = new Intent();
        paramView.setAction("qqplayer_exit_action");
        this.a.sendBroadcast(paramView);
      }
    }
    AlbumUtil.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     brt
 * JD-Core Version:    0.7.0.1
 */