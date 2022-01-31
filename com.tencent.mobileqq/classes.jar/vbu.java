import android.graphics.Matrix;
import android.graphics.Path;

public class vbu
  extends vbi
{
  public Path a;
  public int b;
  public int c;
  
  public vbu(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public vbu(vbi paramvbi, float paramFloat)
  {
    super(paramvbi.jdField_a_of_type_Int);
    if ((paramvbi instanceof vbu))
    {
      paramvbi = (vbu)paramvbi;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramvbi.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramvbi.jdField_a_of_type_Int;
      this.b = paramvbi.b;
      this.c = ((int)(paramvbi.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbu
 * JD-Core Version:    0.7.0.1
 */