import android.graphics.Matrix;
import android.graphics.Path;

public class von
  extends vob
{
  public Path a;
  public int b;
  public int c;
  
  public von(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public von(vob paramvob, float paramFloat)
  {
    super(paramvob.jdField_a_of_type_Int);
    if ((paramvob instanceof von))
    {
      paramvob = (von)paramvob;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramvob.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramvob.jdField_a_of_type_Int;
      this.b = paramvob.b;
      this.c = ((int)(paramvob.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     von
 * JD-Core Version:    0.7.0.1
 */