public class tmm
{
  public String a;
  public tmh a;
  public String b;
  
  public tmm(String paramString, tmh paramtmh, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Tmh = paramtmh;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    this.b = paramString;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return this.b;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tmm
 * JD-Core Version:    0.7.0.1
 */