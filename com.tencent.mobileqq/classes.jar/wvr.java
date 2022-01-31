import android.graphics.Bitmap;

class wvr
  extends wyj
{
  public Bitmap a;
  public Bitmap b;
  
  public wvr(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public wvr(wyj paramwyj, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramwyj.jdField_c_of_type_Int, paramwyj.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wvr
 * JD-Core Version:    0.7.0.1
 */