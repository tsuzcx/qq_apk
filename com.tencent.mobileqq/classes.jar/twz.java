public class twz
  extends twl
{
  public int a;
  public tff a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public twz(String paramString)
  {
    super(paramString);
  }
  
  static twz a(tff paramtff)
  {
    twz localtwz = new twz(paramtff.jdField_a_of_type_JavaLangString);
    localtwz.jdField_a_of_type_Tff = paramtff;
    if (paramtff.jdField_a_of_type_Int == 12)
    {
      localtwz.d = paramtff.e;
      localtwz.c = paramtff.i;
    }
    return localtwz;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Tff != null) {
      return this.jdField_a_of_type_Tff.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Tff != null) && (this.jdField_a_of_type_Tff.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twz
 * JD-Core Version:    0.7.0.1
 */