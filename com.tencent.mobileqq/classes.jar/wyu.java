public class wyu
{
  private static volatile wyu jdField_a_of_type_Wyu;
  private wyv jdField_a_of_type_Wyv;
  
  public static wyu a()
  {
    if (jdField_a_of_type_Wyu == null) {}
    try
    {
      if (jdField_a_of_type_Wyu == null) {
        jdField_a_of_type_Wyu = new wyu();
      }
      return jdField_a_of_type_Wyu;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wyv = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Wyv != null) {
      this.jdField_a_of_type_Wyv.a(paramString1, paramString2);
    }
  }
  
  public void a(wyv paramwyv)
  {
    this.jdField_a_of_type_Wyv = paramwyv;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Wyv != null) {
      this.jdField_a_of_type_Wyv.ac_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */