import android.graphics.Bitmap;

public class vjh
  extends vju
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public String a;
  public boolean a;
  private long jdField_b_of_type_Long;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public vjh(int paramInt, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public vjh a(Bitmap paramBitmap)
  {
    paramBitmap = new vjh(this.jdField_c_of_type_Int, paramBitmap);
    paramBitmap.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    paramBitmap.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    paramBitmap.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramBitmap.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    paramBitmap.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    paramBitmap.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_Boolean = false;
    return paramBitmap;
  }
  
  public String toString()
  {
    return "Mp4VideoFragmentInfo{index=" + this.jdField_c_of_type_Int + ", bitmap=" + this.jdField_c_of_type_AndroidGraphicsBitmap + ", startTime=" + this.jdField_a_of_type_Long + ", endTime=" + this.jdField_b_of_type_Long + ", mRevertFailed=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vjh
 * JD-Core Version:    0.7.0.1
 */