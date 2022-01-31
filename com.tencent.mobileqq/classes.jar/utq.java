import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

public class utq
{
  final int jdField_a_of_type_Int;
  public final Bundle a;
  String jdField_a_of_type_JavaLangString = "";
  HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  boolean jdField_a_of_type_Boolean = true;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = true;
  
  public utq(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static utq a()
  {
    return new utq(20);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     utq
 * JD-Core Version:    0.7.0.1
 */