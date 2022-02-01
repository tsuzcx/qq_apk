import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class yug
  extends yuc
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public yug(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public yug(yuc paramyuc, float paramFloat)
  {
    super(paramyuc.jdField_a_of_type_Int);
    if ((paramyuc instanceof yug))
    {
      paramyuc = (yug)paramyuc;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramyuc.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramyuc.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramyuc.jdField_b_of_type_Int;
      this.c = ((int)(paramyuc.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yug
 * JD-Core Version:    0.7.0.1
 */