public class yql
{
  private static volatile yql jdField_a_of_type_Yql;
  private yqm jdField_a_of_type_Yqm;
  
  public static yql a()
  {
    if (jdField_a_of_type_Yql == null) {}
    try
    {
      if (jdField_a_of_type_Yql == null) {
        jdField_a_of_type_Yql = new yql();
      }
      return jdField_a_of_type_Yql;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yqm != null) {
      this.jdField_a_of_type_Yqm.a();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Yqm != null) {
      this.jdField_a_of_type_Yqm.a(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yql
 * JD-Core Version:    0.7.0.1
 */