import android.animation.TypeEvaluator;
import android.graphics.Matrix;

class ygl
  implements TypeEvaluator<Matrix>
{
  public static TypeEvaluator<Matrix> a;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  float[] b = new float[9];
  
  static
  {
    jdField_a_of_type_AndroidAnimationTypeEvaluator = new ygm();
  }
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
  {
    paramMatrix1.getValues(this.jdField_a_of_type_ArrayOfFloat);
    paramMatrix2.getValues(this.b);
    int i = 0;
    while (i < 9)
    {
      float f1 = this.b[i];
      float f2 = this.jdField_a_of_type_ArrayOfFloat[i];
      this.b[i] = ((f1 - f2) * paramFloat + this.jdField_a_of_type_ArrayOfFloat[i]);
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.b);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ygl
 * JD-Core Version:    0.7.0.1
 */