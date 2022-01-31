import android.graphics.Bitmap;

class tpo
  implements ulb
{
  tpo(tpn paramtpn, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (tpn.a(this.jdField_a_of_type_Tpn))
    {
      paramString = bbef.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        tpn.a(this.jdField_a_of_type_Tpn, false);
        return;
      }
      bool = vxv.a(paramString, tpn.a(this.jdField_a_of_type_Tpn));
      paramString.recycle();
      tpn.b(this.jdField_a_of_type_Tpn, bool);
      return;
    }
    boolean bool = vxv.a(paramBitmap, tpn.a(this.jdField_a_of_type_Tpn));
    tpn.c(this.jdField_a_of_type_Tpn, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    ved.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    tpn.d(this.jdField_a_of_type_Tpn, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpo
 * JD-Core Version:    0.7.0.1
 */