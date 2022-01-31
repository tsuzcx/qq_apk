import android.graphics.Bitmap;

class uug
  extends uwy
{
  public Bitmap a;
  public Bitmap b;
  
  public uug(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public uug(uwy paramuwy, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramuwy.jdField_c_of_type_Int, paramuwy.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uug
 * JD-Core Version:    0.7.0.1
 */