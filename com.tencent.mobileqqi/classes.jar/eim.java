import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class eim
  extends Handler
{
  public eim(MainAssistObserver paramMainAssistObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.b.isLogin())) {}
    label288:
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        }
        paramMessage = paramMessage.getData();
      } while (paramMessage == null);
      int i = paramMessage.getInt("result");
      if ((i == -1) || (i == -2))
      {
        String str;
        if (i == -1)
        {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131562823);
          str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563058);
        }
        for (;;)
        {
          try
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
            {
              if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
                this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
              }
              this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
            }
            if (i != -1) {
              break label288;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new ein(this), null);
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new eio(this));
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new eip(this));
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563056);
          str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131563057);
          continue;
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new eiq(this), null);
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new eir(this));
          this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new eis(this));
        }
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eim
 * JD-Core Version:    0.7.0.1
 */