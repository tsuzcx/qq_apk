public class uxj
{
  private static volatile uxj jdField_a_of_type_Uxj;
  private uxk jdField_a_of_type_Uxk;
  
  public static uxj a()
  {
    if (jdField_a_of_type_Uxj == null) {}
    try
    {
      if (jdField_a_of_type_Uxj == null) {
        jdField_a_of_type_Uxj = new uxj();
      }
      return jdField_a_of_type_Uxj;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Uxk = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Uxk != null) {
      this.jdField_a_of_type_Uxk.a(paramString1, paramString2);
    }
  }
  
  public void a(uxk paramuxk)
  {
    this.jdField_a_of_type_Uxk = paramuxk;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Uxk != null) {
      this.jdField_a_of_type_Uxk.W_();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxj
 * JD-Core Version:    0.7.0.1
 */