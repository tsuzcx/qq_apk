public class vkc
{
  private static volatile vkc jdField_a_of_type_Vkc;
  private vkd jdField_a_of_type_Vkd;
  
  public static vkc a()
  {
    if (jdField_a_of_type_Vkc == null) {}
    try
    {
      if (jdField_a_of_type_Vkc == null) {
        jdField_a_of_type_Vkc = new vkc();
      }
      return jdField_a_of_type_Vkc;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vkd = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Vkd != null) {
      this.jdField_a_of_type_Vkd.a(paramString1, paramString2);
    }
  }
  
  public void a(vkd paramvkd)
  {
    this.jdField_a_of_type_Vkd = paramvkd;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Vkd != null) {
      this.jdField_a_of_type_Vkd.U_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vkc
 * JD-Core Version:    0.7.0.1
 */