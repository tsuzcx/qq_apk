import android.support.annotation.Nullable;

public class uvr
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public uvr(String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public uvr(String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int != 1) && ((this.jdField_a_of_type_Int != 2) || (this.jdField_b_of_type_Int != 0));
  }
  
  public String toString()
  {
    return "FeedCommentSync{feedId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mNextCookie='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mSource=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uvr
 * JD-Core Version:    0.7.0.1
 */