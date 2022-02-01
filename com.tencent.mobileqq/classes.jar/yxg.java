import android.graphics.Bitmap;

class yxg
  extends yzy
{
  public Bitmap a;
  public Bitmap b;
  
  public yxg(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramBitmap1);
    this.b = paramBitmap2;
    this.a = paramBitmap3;
  }
  
  public yxg(yzy paramyzy, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this(paramyzy.jdField_c_of_type_Int, paramyzy.jdField_c_of_type_AndroidGraphicsBitmap, paramBitmap1, paramBitmap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxg
 * JD-Core Version:    0.7.0.1
 */