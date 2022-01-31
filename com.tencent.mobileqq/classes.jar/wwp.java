import android.support.annotation.FloatRange;

public class wwp
{
  private float jdField_a_of_type_Float = 1.0F;
  private wwo jdField_a_of_type_Wwo = new wwo();
  
  public wwo a()
  {
    wwo.b(this.jdField_a_of_type_Wwo, this.jdField_a_of_type_Float - wwo.a(this.jdField_a_of_type_Wwo));
    return this.jdField_a_of_type_Wwo;
  }
  
  public wwp a(@FloatRange(from=0.01D) float paramFloat)
  {
    wwo.a(this.jdField_a_of_type_Wwo, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wwp
 * JD-Core Version:    0.7.0.1
 */