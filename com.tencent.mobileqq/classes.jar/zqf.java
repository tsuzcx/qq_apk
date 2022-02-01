class zqf
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
  
  public zqf(String paramString)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Double = -1.0D;
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public zqf a()
  {
    return (zqf)super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqf
 * JD-Core Version:    0.7.0.1
 */