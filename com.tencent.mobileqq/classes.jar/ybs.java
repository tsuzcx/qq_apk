public class ybs
{
  private static volatile ybs jdField_a_of_type_Ybs;
  private ybt jdField_a_of_type_Ybt;
  
  public static ybs a()
  {
    if (jdField_a_of_type_Ybs == null) {}
    try
    {
      if (jdField_a_of_type_Ybs == null) {
        jdField_a_of_type_Ybs = new ybs();
      }
      return jdField_a_of_type_Ybs;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ybt = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ybt != null) {
      this.jdField_a_of_type_Ybt.a(paramString1, paramString2);
    }
  }
  
  public void a(ybt paramybt)
  {
    this.jdField_a_of_type_Ybt = paramybt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ybt != null) {
      this.jdField_a_of_type_Ybt.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ybs
 * JD-Core Version:    0.7.0.1
 */