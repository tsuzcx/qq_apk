import android.graphics.Bitmap;

class vhc
  extends vju
{
  public Bitmap a;
  public Bitmap b;
  
  public vhc(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public vhc(vju paramvju, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramvju.jdField_c_of_type_Int, paramvju.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhc
 * JD-Core Version:    0.7.0.1
 */