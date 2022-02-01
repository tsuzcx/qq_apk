public class xjl
  extends xix
{
  public int a;
  public wrs a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public xjl(String paramString)
  {
    super(paramString);
  }
  
  static xjl a(wrs paramwrs)
  {
    xjl localxjl = new xjl(paramwrs.jdField_a_of_type_JavaLangString);
    localxjl.jdField_a_of_type_Wrs = paramwrs;
    if (paramwrs.jdField_a_of_type_Int == 12)
    {
      localxjl.d = paramwrs.e;
      localxjl.c = paramwrs.i;
    }
    return localxjl;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Wrs != null) {
      return this.jdField_a_of_type_Wrs.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Wrs != null) && (this.jdField_a_of_type_Wrs.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjl
 * JD-Core Version:    0.7.0.1
 */