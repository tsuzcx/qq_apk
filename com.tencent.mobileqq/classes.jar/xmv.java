import android.support.annotation.Nullable;

public class xmv
{
  @Nullable
  public String a;
  public xms a;
  @Nullable
  public xmt a;
  @Nullable
  public String b;
  
  public xmv(@Nullable xms paramxms, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_Xms = paramxms;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public xmv(xmv paramxmv)
  {
    this.jdField_a_of_type_Xms = paramxmv.jdField_a_of_type_Xms;
    this.jdField_a_of_type_JavaLangString = paramxmv.jdField_a_of_type_JavaLangString;
    this.b = paramxmv.b;
    this.jdField_a_of_type_Xmt = paramxmv.jdField_a_of_type_Xmt;
  }
  
  public String toString()
  {
    return "StartInfo{mGroupId=" + this.jdField_a_of_type_Xms + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmv
 * JD-Core Version:    0.7.0.1
 */