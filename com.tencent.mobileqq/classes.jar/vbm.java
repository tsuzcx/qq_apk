import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class vbm
  extends vbi
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public vbm(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public vbm(vbi paramvbi, float paramFloat)
  {
    super(paramvbi.jdField_a_of_type_Int);
    if ((paramvbi instanceof vbm))
    {
      paramvbi = (vbm)paramvbi;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramvbi.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramvbi.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramvbi.jdField_b_of_type_Int;
      this.c = ((int)(paramvbi.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vbm
 * JD-Core Version:    0.7.0.1
 */