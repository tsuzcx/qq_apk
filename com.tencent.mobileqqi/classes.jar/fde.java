import android.os.Process;
import com.tencent.mobileqq.app.GuardManager;

public class fde
  extends fct
{
  protected void a()
  {
    this.jdField_a_of_type_Long += 1L;
    this.b += 1L;
    if (this.jdField_a_of_type_Long >= fco.a().a(this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a, this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(Process.myPid())) / 12000L) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(7, null);
    }
    while (this.b != 1L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.f();
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Long > 2L) {
      this.jdField_a_of_type_Long -= 2L;
    }
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fde
 * JD-Core Version:    0.7.0.1
 */