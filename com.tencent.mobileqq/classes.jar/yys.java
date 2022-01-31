import android.support.annotation.FloatRange;

public class yys
{
  private float jdField_a_of_type_Float = 1.0F;
  private yyr jdField_a_of_type_Yyr = new yyr();
  
  public yyr a()
  {
    yyr.b(this.jdField_a_of_type_Yyr, this.jdField_a_of_type_Float - yyr.a(this.jdField_a_of_type_Yyr));
    return this.jdField_a_of_type_Yyr;
  }
  
  public yys a(@FloatRange(from=0.01D) float paramFloat)
  {
    yyr.a(this.jdField_a_of_type_Yyr, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yys
 * JD-Core Version:    0.7.0.1
 */