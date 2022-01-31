import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

class dlj
  extends SubAccountObserver
{
  dlj(dli paramdli, SimpleAccount paramSimpleAccount, SubAccountAssistantManager paramSubAccountAssistantManager) {}
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Dli.a.b.a(), "actSBDLoginGetkey", false, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack: key is empty? why? shit");
      }
      this.jdField_a_of_type_Dli.a.runOnUiThread(new dlk(this));
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Dli.a.b.a(), "actSBDLoginGetkey", true, 0L, 0L, paramString1, "");
      this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_a_of_type_Dli.a.b, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), paramString3);
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack:getA2 subAccount = " + paramString2 + ".....subA2 = " + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dlj
 * JD-Core Version:    0.7.0.1
 */