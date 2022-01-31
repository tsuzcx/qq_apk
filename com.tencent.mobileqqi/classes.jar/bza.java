import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

public class bza
  extends AccountObserver
{
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  
  public bza(AccountManageActivity paramAccountManageActivity, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onDeleteAccount(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "DelHistoryAccountObserver onDeleteAccount isSuccess " + paramBoolean + ",peerUin:" + this.jdField_a_of_type_JavaLangString + ",isDeleteHistory:" + this.jdField_a_of_type_Boolean);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bza
 * JD-Core Version:    0.7.0.1
 */