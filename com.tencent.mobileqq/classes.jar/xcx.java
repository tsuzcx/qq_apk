import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class xcx
  extends xct
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public xcx(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public xcx(xct paramxct, float paramFloat)
  {
    super(paramxct.jdField_a_of_type_Int);
    if ((paramxct instanceof xcx))
    {
      paramxct = (xcx)paramxct;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramxct.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramxct.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramxct.jdField_b_of_type_Int;
      this.c = ((int)(paramxct.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xcx
 * JD-Core Version:    0.7.0.1
 */