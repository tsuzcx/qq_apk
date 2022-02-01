public class twx
{
  private static volatile twx jdField_a_of_type_Twx;
  public static boolean a;
  twy jdField_a_of_type_Twy = null;
  
  public static twx a()
  {
    if (jdField_a_of_type_Twx == null) {}
    try
    {
      if (jdField_a_of_type_Twx == null) {
        jdField_a_of_type_Twx = new twx();
      }
      return jdField_a_of_type_Twx;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Twy != null) {
      this.jdField_a_of_type_Twy = null;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Twy != null) {
      this.jdField_a_of_type_Twy.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Twy != null) {
      this.jdField_a_of_type_Twy.a(paramInt, paramBoolean);
    }
  }
  
  public void a(twy paramtwy)
  {
    this.jdField_a_of_type_Twy = paramtwy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twx
 * JD-Core Version:    0.7.0.1
 */