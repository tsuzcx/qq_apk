import android.graphics.Bitmap;

public class wxz
  extends wyj
{
  public final long a;
  public final long b;
  public final long c;
  public final long d;
  
  public wxz(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Bitmap paramBitmap)
  {
    super(paramInt, paramBitmap);
    this.a = paramLong1;
    this.b = paramLong2;
    this.jdField_c_of_type_Long = paramLong3;
    this.d = paramLong4;
  }
  
  public wxz a(Bitmap paramBitmap)
  {
    return new wxz(this.jdField_c_of_type_Int, this.a, this.b, this.jdField_c_of_type_Long, this.d, paramBitmap);
  }
  
  public String toString()
  {
    return "RecordVideoBlockInfo{index:" + this.jdField_c_of_type_Int + ", vfFrame: " + this.a + " ~ " + this.b + ", afTime: " + this.jdField_c_of_type_Long + " ~ " + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxz
 * JD-Core Version:    0.7.0.1
 */