import android.graphics.Bitmap;

class xcb
  implements xxn
{
  xcb(xca paramxca, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (xca.a(this.jdField_a_of_type_Xca))
    {
      paramString = bgmo.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        xca.a(this.jdField_a_of_type_Xca, false);
        return;
      }
      bool = zkh.a(paramString, xca.a(this.jdField_a_of_type_Xca));
      paramString.recycle();
      xca.b(this.jdField_a_of_type_Xca, bool);
      return;
    }
    boolean bool = zkh.a(paramBitmap, xca.a(this.jdField_a_of_type_Xca));
    xca.c(this.jdField_a_of_type_Xca, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    yqp.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    xca.d(this.jdField_a_of_type_Xca, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcb
 * JD-Core Version:    0.7.0.1
 */