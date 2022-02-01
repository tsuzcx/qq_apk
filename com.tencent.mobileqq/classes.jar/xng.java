public class xng
  extends xms
{
  public int a;
  public wvn a;
  public boolean a;
  public String c = "";
  public String d = "";
  
  public xng(String paramString)
  {
    super(paramString);
  }
  
  static xng a(wvn paramwvn)
  {
    xng localxng = new xng(paramwvn.jdField_a_of_type_JavaLangString);
    localxng.jdField_a_of_type_Wvn = paramwvn;
    if (paramwvn.jdField_a_of_type_Int == 12)
    {
      localxng.d = paramwvn.e;
      localxng.c = paramwvn.i;
    }
    return localxng;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Wvn != null) {
      return this.jdField_a_of_type_Wvn.jdField_a_of_type_JavaLangString;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Wvn != null) && (this.jdField_a_of_type_Wvn.jdField_a_of_type_Int == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */