import android.text.TextUtils;

public class vqz
{
  public int a;
  public final long a;
  public final String a;
  public final String b;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof vqz)) {
      return TextUtils.equals(((vqz)paramObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(this.jdField_a_of_type_JavaLangString));
    localStringBuilder.append("\n");
    localStringBuilder.append("-t ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  -dt ");
    localStringBuilder.append(String.valueOf(this.jdField_a_of_type_Long));
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqz
 * JD-Core Version:    0.7.0.1
 */