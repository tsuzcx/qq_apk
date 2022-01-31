import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class vof
  extends vob
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public vof(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public vof(vob paramvob, float paramFloat)
  {
    super(paramvob.jdField_a_of_type_Int);
    if ((paramvob instanceof vof))
    {
      paramvob = (vof)paramvob;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramvob.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramvob.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramvob.jdField_b_of_type_Int;
      this.c = ((int)(paramvob.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vof
 * JD-Core Version:    0.7.0.1
 */