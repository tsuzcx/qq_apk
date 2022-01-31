import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class xhg
  extends xhc
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public xhg(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public xhg(xhc paramxhc, float paramFloat)
  {
    super(paramxhc.jdField_a_of_type_Int);
    if ((paramxhc instanceof xhg))
    {
      paramxhc = (xhg)paramxhc;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramxhc.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramxhc.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramxhc.jdField_b_of_type_Int;
      this.c = ((int)(paramxhc.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhg
 * JD-Core Version:    0.7.0.1
 */