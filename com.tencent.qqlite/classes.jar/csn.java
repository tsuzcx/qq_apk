import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;

public class csn
  extends ctc
{
  private String a;
  
  public csn()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    super.a();
    if (this.b >= 3L)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(1);
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(bool, new String[] { "com.tencent.qqlite:qzone", this.jdField_a_of_type_JavaLangString });
      this.b = 0L;
      if (!bool) {
        this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.qqlite".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    CoreService.a();
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.e();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.qqlite".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     csn
 * JD-Core Version:    0.7.0.1
 */