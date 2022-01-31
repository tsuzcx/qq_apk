public class eld
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public eld(String paramString)
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length == 1)
    {
      this.jdField_a_of_type_JavaLangString = arrayOfString[0];
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (arrayOfString.length == 4)
    {
      this.b = arrayOfString[0];
      this.b = this.b.replace("-", " ");
      this.c = arrayOfString[1];
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = arrayOfString[3];
      return;
    }
    throw new RuntimeException("format error!, string: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eld
 * JD-Core Version:    0.7.0.1
 */