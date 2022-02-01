import android.graphics.Matrix;
import android.graphics.Path;

public class yfv
  extends yfj
{
  public Path a;
  public int b;
  public int c;
  
  public yfv(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public yfv(yfj paramyfj, float paramFloat)
  {
    super(paramyfj.jdField_a_of_type_Int);
    if ((paramyfj instanceof yfv))
    {
      paramyfj = (yfv)paramyfj;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramyfj.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramyfj.jdField_a_of_type_Int;
      this.b = paramyfj.b;
      this.c = ((int)(paramyfj.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfv
 * JD-Core Version:    0.7.0.1
 */