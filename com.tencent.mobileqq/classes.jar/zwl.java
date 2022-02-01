import android.support.annotation.FloatRange;

public class zwl
{
  private float jdField_a_of_type_Float = 1.0F;
  private zwk jdField_a_of_type_Zwk = new zwk();
  
  public zwk a()
  {
    zwk.b(this.jdField_a_of_type_Zwk, this.jdField_a_of_type_Float - zwk.a(this.jdField_a_of_type_Zwk));
    return this.jdField_a_of_type_Zwk;
  }
  
  public zwl a(@FloatRange(from=0.01D) float paramFloat)
  {
    zwk.a(this.jdField_a_of_type_Zwk, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zwl
 * JD-Core Version:    0.7.0.1
 */