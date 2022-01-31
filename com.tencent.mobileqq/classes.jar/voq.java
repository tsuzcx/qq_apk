import android.graphics.Matrix;
import android.graphics.Path;

public class voq
  extends voe
{
  public Path a;
  public int b;
  public int c;
  
  public voq(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public voq(voe paramvoe, float paramFloat)
  {
    super(paramvoe.jdField_a_of_type_Int);
    if ((paramvoe instanceof voq))
    {
      paramvoe = (voq)paramvoe;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramvoe.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramvoe.jdField_a_of_type_Int;
      this.b = paramvoe.b;
      this.c = ((int)(paramvoe.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     voq
 * JD-Core Version:    0.7.0.1
 */