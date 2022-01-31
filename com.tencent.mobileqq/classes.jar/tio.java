import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tio
  extends CardObserver
{
  public tio(QQSettingMe paramQQSettingMe) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQSettingMe.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onSetMedal");
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new tip(this));
        ThreadManager.post(new tiq(this), 5, null, true);
        return;
      }
    } while ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!(paramObject instanceof Card)) || (this.a.c) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)));
    ThreadManager.post(new tir(this, (Card)paramObject), 5, null, true);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      this.a.a(paramString);
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManager.getUIHandler().post(new tis(this));
    }
  }
  
  protected void m(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      QQSettingMe.a(this.a, false);
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onGetMedal medalSwitchDisable= " + paramBoolean2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tio
 * JD-Core Version:    0.7.0.1
 */