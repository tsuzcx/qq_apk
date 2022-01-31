import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class zqg
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  volatile boolean jdField_a_of_type_Boolean;
  volatile int jdField_b_of_type_Int = 0;
  volatile boolean jdField_b_of_type_Boolean = false;
  volatile int c = 5;
  
  private zqg(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    BaseApplicationImpl.sUiHandler.postDelayed(this, 100L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "set progress, actual = " + paramInt1 + ", expected = " + paramInt2);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    BaseApplicationImpl.sUiHandler.removeCallbacks(this);
    BaseApplicationImpl.sUiHandler.postDelayed(this, 20L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    BaseApplicationImpl.sUiHandler.removeCallbacks(this);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "run progress, isCanceled = " + this.jdField_a_of_type_Boolean + ", bindState = " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int);
    }
    Object localObject;
    if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int == 8) || (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int == 4)) && (this.jdField_a_of_type_Int + 1 < this.c))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      PhoneContactManagerImp.b((PhoneContactManagerImp)localObject, i);
      if (this.jdField_b_of_type_Boolean)
      {
        PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, 7);
        this.jdField_b_of_type_Boolean = false;
      }
      localObject = BaseApplicationImpl.sUiHandler;
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
        break label166;
      }
    }
    label166:
    for (long l = 20L;; l = 100L)
    {
      ((MqqHandler)localObject).postDelayed(this, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zqg
 * JD-Core Version:    0.7.0.1
 */