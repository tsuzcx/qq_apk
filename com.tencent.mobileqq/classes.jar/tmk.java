import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tmk
  implements ISpriteDrawerInfoCallback
{
  public tmk(QQSettingMe paramQQSettingMe) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext == null) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(QQSettingMe.a(this.a), this.a.c, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity) != 0) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(QQSettingMe.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.c);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, new Object[] { "[onApolloClick] ", "apolloStatus:", Integer.valueOf(paramInt1), ",clickPart:", Integer.valueOf(paramInt2), ",apolloId:", paramString });
    }
    if (paramInt1 == 0)
    {
      this.a.L();
      return;
    }
    ThreadManager.getUIHandler().post(new tml(this, paramInt2, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmk
 * JD-Core Version:    0.7.0.1
 */