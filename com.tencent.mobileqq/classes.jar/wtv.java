import android.graphics.Bitmap;

public class wtv
  extends wyj
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public wtv(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
  }
  
  public static wtv a(wtv paramwtv, Bitmap paramBitmap)
  {
    paramBitmap = new wtv(paramwtv.c, paramBitmap);
    paramBitmap.jdField_a_of_type_Int = paramwtv.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Int = paramwtv.jdField_b_of_type_Int;
    paramBitmap.jdField_a_of_type_JavaLangString = paramwtv.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_a_of_type_Boolean = paramwtv.jdField_a_of_type_Boolean;
    paramBitmap.jdField_b_of_type_Boolean = paramwtv.jdField_b_of_type_Boolean;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "PlayerContext{startTime=" + this.jdField_a_of_type_Int + ", endTime=" + this.jdField_b_of_type_Int + ", isMute=" + this.jdField_a_of_type_Boolean + ", isDeleted=" + this.jdField_b_of_type_Boolean + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtv
 * JD-Core Version:    0.7.0.1
 */