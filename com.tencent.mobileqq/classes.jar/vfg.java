import android.graphics.Bitmap;

public class vfg
  extends vju
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public vfg(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
  }
  
  public static vfg a(vfg paramvfg, Bitmap paramBitmap)
  {
    paramBitmap = new vfg(paramvfg.c, paramBitmap);
    paramBitmap.jdField_a_of_type_Int = paramvfg.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Int = paramvfg.jdField_b_of_type_Int;
    paramBitmap.jdField_a_of_type_JavaLangString = paramvfg.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_a_of_type_Boolean = paramvfg.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_Boolean = paramvfg.jdField_b_of_type_Boolean;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "PlayerContext{startTime=" + this.jdField_a_of_type_Int + ", endTime=" + this.jdField_b_of_type_Int + ", isMute=" + this.jdField_a_of_type_Boolean + ", isDeleted=" + this.jdField_b_of_type_Boolean + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfg
 * JD-Core Version:    0.7.0.1
 */