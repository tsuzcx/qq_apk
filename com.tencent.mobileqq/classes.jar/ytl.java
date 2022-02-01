import android.graphics.Bitmap;

class ytl
  extends ywd
{
  public Bitmap a;
  public Bitmap b;
  
  public ytl(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public ytl(ywd paramywd, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramywd.jdField_c_of_type_Int, paramywd.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytl
 * JD-Core Version:    0.7.0.1
 */