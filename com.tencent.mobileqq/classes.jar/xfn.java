import android.support.annotation.FloatRange;

public class xfn
{
  private float jdField_a_of_type_Float = 1.0F;
  private xfm jdField_a_of_type_Xfm = new xfm();
  
  public xfm a()
  {
    xfm.b(this.jdField_a_of_type_Xfm, this.jdField_a_of_type_Float - xfm.a(this.jdField_a_of_type_Xfm));
    return this.jdField_a_of_type_Xfm;
  }
  
  public xfn a(@FloatRange(from=0.01D) float paramFloat)
  {
    xfm.a(this.jdField_a_of_type_Xfm, paramFloat);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xfn
 * JD-Core Version:    0.7.0.1
 */