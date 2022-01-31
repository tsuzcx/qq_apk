import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;

public class fce
  extends fcu
{
  private String a;
  
  public fce()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
  }
  
  protected void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fce
 * JD-Core Version:    0.7.0.1
 */