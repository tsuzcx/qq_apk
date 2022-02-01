import android.graphics.Matrix;
import android.graphics.Path;
import java.util.LinkedList;
import java.util.List;

public class zem
  extends zei
{
  public Path a;
  List<Integer> a;
  public int b;
  List<Integer> b;
  public int c;
  
  public zem(Path paramPath, int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPath = paramPath;
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
  }
  
  public zem(zei paramzei, float paramFloat)
  {
    super(paramzei.jdField_a_of_type_Int);
    if ((paramzei instanceof zem))
    {
      paramzei = (zem)paramzei;
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(paramFloat, paramFloat);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsPath.addPath(paramzei.jdField_a_of_type_AndroidGraphicsPath, localMatrix);
      this.jdField_a_of_type_Int = paramzei.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramzei.jdField_b_of_type_Int;
      this.c = ((int)(paramzei.c * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zem
 * JD-Core Version:    0.7.0.1
 */