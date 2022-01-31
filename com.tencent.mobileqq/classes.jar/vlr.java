public class vlr
  extends vld
{
  public int a;
  public utx a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public vlr(String paramString)
  {
    super(paramString);
  }
  
  static vlr a(utx paramutx)
  {
    vlr localvlr = new vlr(paramutx.jdField_a_of_type_JavaLangString);
    localvlr.jdField_a_of_type_Utx = paramutx;
    if (paramutx.jdField_a_of_type_Int == 12)
    {
      localvlr.d = paramutx.e;
      localvlr.c = paramutx.i;
    }
    return localvlr;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Utx != null) {
      return this.jdField_a_of_type_Utx.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Utx != null) && (this.jdField_a_of_type_Utx.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlr
 * JD-Core Version:    0.7.0.1
 */