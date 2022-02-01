import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity.3.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

public class vvz
  extends SubAccountObserver
{
  vvz(vvy paramvvy, SimpleAccount paramSimpleAccount) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "SubBind");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.a.a.app.getCurrentAccountUin(), "actSBDLoginGetkey", false, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack: key is empty");
      }
      this.a.a.runOnUiThread(new SubAccountBindActivity.3.1.1(this));
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "SubBind");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.a.a.app.getCurrentAccountUin(), "actSBDLoginGetkey", true, 0L, 0L, paramString1, "");
      paramString1 = (anxo)this.a.a.app.getManager(28);
      if (paramString1 != null) {
        paramString1.aV(this.d.getUin(), paramString3, this.a.a.aOa);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack:getA2 subAccount = " + paramString2 + ".....subA2 = " + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vvz
 * JD-Core Version:    0.7.0.1
 */