import android.graphics.Bitmap;

class ynk
  extends yqa
{
  public Bitmap a;
  public Bitmap b;
  
  public ynk(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public ynk(yqa paramyqa, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramyqa.jdField_c_of_type_Int, paramyqa.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynk
 * JD-Core Version:    0.7.0.1
 */