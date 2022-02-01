import android.support.annotation.Nullable;

public class xdb
{
  @Nullable
  public String a;
  public xcy a;
  @Nullable
  public xcz a;
  @Nullable
  public String b;
  
  public xdb(@Nullable xcy paramxcy, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.jdField_a_of_type_Xcy = paramxcy;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public xdb(xdb paramxdb)
  {
    this.jdField_a_of_type_Xcy = paramxdb.jdField_a_of_type_Xcy;
    this.jdField_a_of_type_JavaLangString = paramxdb.jdField_a_of_type_JavaLangString;
    this.b = paramxdb.b;
    this.jdField_a_of_type_Xcz = paramxdb.jdField_a_of_type_Xcz;
  }
  
  public String toString()
  {
    return "StartInfo{mGroupId=" + this.jdField_a_of_type_Xcy + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", feedId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdb
 * JD-Core Version:    0.7.0.1
 */