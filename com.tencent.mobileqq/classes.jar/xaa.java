import android.graphics.Bitmap;

class xaa
  extends xcs
{
  public Bitmap a;
  public Bitmap b;
  
  public xaa(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public xaa(xcs paramxcs, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramxcs.jdField_c_of_type_Int, paramxcs.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xaa
 * JD-Core Version:    0.7.0.1
 */