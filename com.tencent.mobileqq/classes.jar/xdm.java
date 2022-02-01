public class xdm
  extends xcy
{
  public int a;
  public wly a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public xdm(String paramString)
  {
    super(paramString);
  }
  
  static xdm a(wly paramwly)
  {
    xdm localxdm = new xdm(paramwly.jdField_a_of_type_JavaLangString);
    localxdm.jdField_a_of_type_Wly = paramwly;
    if (paramwly.jdField_a_of_type_Int == 12)
    {
      localxdm.d = paramwly.e;
      localxdm.c = paramwly.i;
    }
    return localxdm;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Wly != null) {
      return this.jdField_a_of_type_Wly.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Wly != null) && (this.jdField_a_of_type_Wly.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdm
 * JD-Core Version:    0.7.0.1
 */