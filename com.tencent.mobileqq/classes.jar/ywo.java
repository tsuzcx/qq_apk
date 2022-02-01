public class ywo
{
  private static volatile ywo jdField_a_of_type_Ywo;
  private ywp jdField_a_of_type_Ywp;
  
  public static ywo a()
  {
    if (jdField_a_of_type_Ywo == null) {}
    try
    {
      if (jdField_a_of_type_Ywo == null) {
        jdField_a_of_type_Ywo = new ywo();
      }
      return jdField_a_of_type_Ywo;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ywp = null;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ywp != null) {
      this.jdField_a_of_type_Ywp.a(paramString1, paramString2);
    }
  }
  
  public void a(ywp paramywp)
  {
    this.jdField_a_of_type_Ywp = paramywp;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ywp != null) {
      this.jdField_a_of_type_Ywp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywo
 * JD-Core Version:    0.7.0.1
 */