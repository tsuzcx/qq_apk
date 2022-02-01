import android.graphics.Matrix;
import android.graphics.Path;

public class zaz
  extends zan
{
  public Path a;
  public int b;
  public int c;
  
  public zaz(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public zaz(zan paramzan, float paramFloat)
  {
    super(paramzan.jdField_a_of_type_Int);
    if ((paramzan instanceof zaz))
    {
      paramzan = (zaz)paramzan;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramzan.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramzan.jdField_a_of_type_Int;
      this.b = paramzan.b;
      this.c = ((int)(paramzan.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */