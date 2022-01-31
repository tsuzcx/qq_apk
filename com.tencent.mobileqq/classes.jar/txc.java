public class txc
  extends two
{
  public int a;
  public tfi a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public txc(String paramString)
  {
    super(paramString);
  }
  
  static txc a(tfi paramtfi)
  {
    txc localtxc = new txc(paramtfi.jdField_a_of_type_JavaLangString);
    localtxc.jdField_a_of_type_Tfi = paramtfi;
    if (paramtfi.jdField_a_of_type_Int == 12)
    {
      localtxc.d = paramtfi.e;
      localtxc.c = paramtfi.i;
    }
    return localtxc;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Tfi != null) {
      return this.jdField_a_of_type_Tfi.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Tfi != null) && (this.jdField_a_of_type_Tfi.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txc
 * JD-Core Version:    0.7.0.1
 */