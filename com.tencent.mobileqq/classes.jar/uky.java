public class uky
{
  private static volatile uky jdField_a_of_type_Uky;
  public static boolean a;
  ukz jdField_a_of_type_Ukz = null;
  
  public static uky a()
  {
    if (jdField_a_of_type_Uky == null) {}
    try
    {
      if (jdField_a_of_type_Uky == null) {
        jdField_a_of_type_Uky = new uky();
      }
      return jdField_a_of_type_Uky;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ukz != null) {
      this.jdField_a_of_type_Ukz.a(paramInt, paramBoolean);
    }
  }
  
  public void a(ukz paramukz)
  {
    this.jdField_a_of_type_Ukz = paramukz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uky
 * JD-Core Version:    0.7.0.1
 */