public class chb
{
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public chb(String paramString)
  {
    paramString = paramString.split(" ");
    if (paramString.length == 1)
    {
      this.jdField_a_of_type_JavaLangString = paramString[0];
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if (paramString.length == 4)
    {
      this.b = paramString[0];
      this.c = paramString[1];
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = paramString[3];
      return;
    }
    throw new RuntimeException("format error!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chb
 * JD-Core Version:    0.7.0.1
 */