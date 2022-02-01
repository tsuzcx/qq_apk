import android.graphics.Matrix;
import android.graphics.Path;

public class zeu
  extends zei
{
  public Path a;
  public int b;
  public int c;
  
  public zeu(Path paramPath, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public zeu(zei paramzei, float paramFloat)
  {
    super(paramzei.jdField_a_of_type_Int);
    if ((paramzei instanceof zeu))
    {
      paramzei = (zeu)paramzei;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramzei.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramzei.jdField_a_of_type_Int;
      this.b = paramzei.b;
      this.c = ((int)(paramzei.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zeu
 * JD-Core Version:    0.7.0.1
 */