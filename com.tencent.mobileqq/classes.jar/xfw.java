import android.graphics.Bitmap;

class xfw
  implements ybi
{
  xfw(xfv paramxfv, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (xfv.a(this.jdField_a_of_type_Xfv))
    {
      paramString = bhmq.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        xfv.a(this.jdField_a_of_type_Xfv, false);
        return;
      }
      bool = zoc.a(paramString, xfv.a(this.jdField_a_of_type_Xfv));
      paramString.recycle();
      xfv.b(this.jdField_a_of_type_Xfv, bool);
      return;
    }
    boolean bool = zoc.a(paramBitmap, xfv.a(this.jdField_a_of_type_Xfv));
    xfv.c(this.jdField_a_of_type_Xfv, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    yuk.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    xfv.d(this.jdField_a_of_type_Xfv, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfw
 * JD-Core Version:    0.7.0.1
 */