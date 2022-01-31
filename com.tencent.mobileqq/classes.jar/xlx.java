import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.managers.MessageRecordManagerImpl;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;

public class xlx
  implements Runnable
{
  public xlx(LoginView paramLoginView, String paramString, QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime() != null))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
          ((AppRuntime)localObject).stopPCActivePolling("deleteAccount");
          ((AccountManager)((AppRuntime)localObject).getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, null);
          HistoryChatMsgSearchKeyUtil.a(this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.a())
          {
            if ((localObject instanceof QQAppInterface)) {
              FTSDBManager.a((QQAppInterface)localObject, this.jdField_a_of_type_JavaLangString, true);
            }
            new MessageRecordManagerImpl().a(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(this.jdField_a_of_type_JavaLangString);
          }
        }
        OpenProxy.a().b(this.jdField_a_of_type_JavaLangString);
        Object localObject = BaseApplicationImpl.getApplication();
        if (Build.VERSION.SDK_INT <= 10) {
          continue;
        }
        i = 4;
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("Last_Login", i);
        if ((localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(this.jdField_a_of_type_JavaLangString)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login");
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new xly(this));
      }
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlx
 * JD-Core Version:    0.7.0.1
 */