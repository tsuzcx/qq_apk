import android.support.annotation.FloatRange;

public class yud
{
  private float jdField_a_of_type_Float = 1.0F;
  private yuc jdField_a_of_type_Yuc = new yuc();
  
  public yuc a()
  {
    yuc.b(this.jdField_a_of_type_Yuc, this.jdField_a_of_type_Float - yuc.a(this.jdField_a_of_type_Yuc));
    return this.jdField_a_of_type_Yuc;
  }
  
  public yud a(@FloatRange(from=0.01D) float paramFloat)
  {
    yuc.a(this.jdField_a_of_type_Yuc, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yud
 * JD-Core Version:    0.7.0.1
 */