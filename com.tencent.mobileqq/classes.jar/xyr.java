import android.graphics.Bitmap;

class xyr
  extends ybh
{
  public Bitmap a;
  public Bitmap b;
  
  public xyr(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public xyr(ybh paramybh, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramybh.jdField_c_of_type_Int, paramybh.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xyr
 * JD-Core Version:    0.7.0.1
 */