import com.tencent.mobileqq.app.GuardManager;

public class fcc
  extends fct
{
  private String a;
  
  public fcc()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  protected void a()
  {
    this.b += 1L;
    this.jdField_a_of_type_Long += 1L;
    if (this.b >= 4L)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(new String[] { "com.tencent.mobileqq:qzone", this.jdField_a_of_type_JavaLangString });
      this.b = 0L;
    }
  }
  
  protected void a(String paramString)
  {
    if (!"com.tencent.mobileqqi".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(3, paramString);
    }
  }
  
  protected void b(String paramString)
  {
    this.b = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.d();
  }
  
  protected void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void d(String paramString)
  {
    if ("com.tencent.mobileqqi".equals(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppGuardManager.a(4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fcc
 * JD-Core Version:    0.7.0.1
 */