public class tkg
  extends tjs
{
  public int a;
  public ssm a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public tkg(String paramString)
  {
    super(paramString);
  }
  
  static tkg a(ssm paramssm)
  {
    tkg localtkg = new tkg(paramssm.jdField_a_of_type_JavaLangString);
    localtkg.jdField_a_of_type_Ssm = paramssm;
    if (paramssm.jdField_a_of_type_Int == 12)
    {
      localtkg.d = paramssm.e;
      localtkg.c = paramssm.i;
    }
    return localtkg;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Ssm != null) {
      return this.jdField_a_of_type_Ssm.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Ssm != null) && (this.jdField_a_of_type_Ssm.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkg
 * JD-Core Version:    0.7.0.1
 */