import android.graphics.Bitmap;

class vip
  implements wec
{
  vip(vio paramvio, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (vio.a(this.jdField_a_of_type_Vio))
    {
      paramString = bdhj.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        vio.a(this.jdField_a_of_type_Vio, false);
        return;
      }
      bool = xqw.a(paramString, vio.a(this.jdField_a_of_type_Vio));
      paramString.recycle();
      vio.b(this.jdField_a_of_type_Vio, bool);
      return;
    }
    boolean bool = xqw.a(paramBitmap, vio.a(this.jdField_a_of_type_Vio));
    vio.c(this.jdField_a_of_type_Vio, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    wxe.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    vio.d(this.jdField_a_of_type_Vio, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vip
 * JD-Core Version:    0.7.0.1
 */