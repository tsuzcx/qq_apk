class xoq
  implements Cloneable
{
  public double a;
  public int a;
  public String a;
  public int b = -1;
  public String b;
  public int c = -1;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f = "0";
  
  public xoq(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public xoq a()
  {
    return (xoq)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xoq
 * JD-Core Version:    0.7.0.1
 */