import android.graphics.Matrix;
import android.graphics.Path;

public class xdf
  extends xct
{
  public Path a;
  public int b;
  public int c;
  
  public xdf(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public xdf(xct paramxct, float paramFloat)
  {
    super(paramxct.jdField_a_of_type_Int);
    if ((paramxct instanceof xdf))
    {
      paramxct = (xdf)paramxct;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramxct.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramxct.jdField_a_of_type_Int;
      this.b = paramxct.b;
      this.c = ((int)(paramxct.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdf
 * JD-Core Version:    0.7.0.1
 */