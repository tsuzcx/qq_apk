import android.graphics.Matrix;
import android.graphics.Path;

public class yuo
  extends yuc
{
  public Path a;
  public int b;
  public int c;
  
  public yuo(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public yuo(yuc paramyuc, float paramFloat)
  {
    super(paramyuc.jdField_a_of_type_Int);
    if ((paramyuc instanceof yuo))
    {
      paramyuc = (yuo)paramyuc;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramyuc.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramyuc.jdField_a_of_type_Int;
      this.b = paramyuc.b;
      this.c = ((int)(paramyuc.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yuo
 * JD-Core Version:    0.7.0.1
 */