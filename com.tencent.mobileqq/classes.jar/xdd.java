public class xdd
{
  private static volatile xdd jdField_a_of_type_Xdd;
  private xde jdField_a_of_type_Xde;
  
  public static xdd a()
  {
    if (jdField_a_of_type_Xdd == null) {}
    try
    {
      if (jdField_a_of_type_Xdd == null) {
        jdField_a_of_type_Xdd = new xdd();
      }
      return jdField_a_of_type_Xdd;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xde = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Xde != null) {
      this.jdField_a_of_type_Xde.a(paramString1, paramString2);
    }
  }
  
  public void a(xde paramxde)
  {
    this.jdField_a_of_type_Xde = paramxde;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Xde != null) {
      this.jdField_a_of_type_Xde.Z_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdd
 * JD-Core Version:    0.7.0.1
 */