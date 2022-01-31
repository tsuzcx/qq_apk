import android.graphics.Matrix;
import android.graphics.Path;

public class xho
  extends xhc
{
  public Path a;
  public int b;
  public int c;
  
  public xho(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public xho(xhc paramxhc, float paramFloat)
  {
    super(paramxhc.jdField_a_of_type_Int);
    if ((paramxhc instanceof xho))
    {
      paramxhc = (xho)paramxhc;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramxhc.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramxhc.jdField_a_of_type_Int;
      this.b = paramxhc.b;
      this.c = ((int)(paramxhc.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xho
 * JD-Core Version:    0.7.0.1
 */