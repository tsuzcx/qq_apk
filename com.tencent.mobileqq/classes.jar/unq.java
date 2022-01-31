import com.tencent.biz.qqstory.base.ErrorMessage;

public class unq
{
  public int a;
  public final long a;
  public final String a;
  public boolean a;
  public String b = "";
  
  public unq(String paramString)
  {
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public ErrorMessage a()
  {
    return new ErrorMessage(this.jdField_a_of_type_Int, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     unq
 * JD-Core Version:    0.7.0.1
 */