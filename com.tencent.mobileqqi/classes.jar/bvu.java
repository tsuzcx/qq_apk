public class bvu
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  private long b;
  private long c = -1L;
  
  public bvu(long paramLong1, String paramString, long paramLong2, Throwable paramThrowable)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramLong2;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvu
 * JD-Core Version:    0.7.0.1
 */