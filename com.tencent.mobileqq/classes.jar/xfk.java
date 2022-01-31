import android.support.annotation.FloatRange;

public class xfk
{
  private float jdField_a_of_type_Float = 1.0F;
  private xfj jdField_a_of_type_Xfj = new xfj();
  
  public xfj a()
  {
    xfj.b(this.jdField_a_of_type_Xfj, this.jdField_a_of_type_Float - xfj.a(this.jdField_a_of_type_Xfj));
    return this.jdField_a_of_type_Xfj;
  }
  
  public xfk a(@FloatRange(from=0.01D) float paramFloat)
  {
    xfj.a(this.jdField_a_of_type_Xfj, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfk
 * JD-Core Version:    0.7.0.1
 */