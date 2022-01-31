public class vkf
{
  private static volatile vkf jdField_a_of_type_Vkf;
  private vkg jdField_a_of_type_Vkg;
  
  public static vkf a()
  {
    if (jdField_a_of_type_Vkf == null) {}
    try
    {
      if (jdField_a_of_type_Vkf == null) {
        jdField_a_of_type_Vkf = new vkf();
      }
      return jdField_a_of_type_Vkf;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vkg = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Vkg != null) {
      this.jdField_a_of_type_Vkg.a(paramString1, paramString2);
    }
  }
  
  public void a(vkg paramvkg)
  {
    this.jdField_a_of_type_Vkg = paramvkg;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vkg != null) {
      this.jdField_a_of_type_Vkg.U_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkf
 * JD-Core Version:    0.7.0.1
 */