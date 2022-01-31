import android.graphics.Bitmap;

class veg
  implements vzt
{
  veg(vef paramvef, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (vef.a(this.jdField_a_of_type_Vef))
    {
      paramString = bdda.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        vef.a(this.jdField_a_of_type_Vef, false);
        return;
      }
      bool = xmn.a(paramString, vef.a(this.jdField_a_of_type_Vef));
      paramString.recycle();
      vef.b(this.jdField_a_of_type_Vef, bool);
      return;
    }
    boolean bool = xmn.a(paramBitmap, vef.a(this.jdField_a_of_type_Vef));
    vef.c(this.jdField_a_of_type_Vef, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    wsv.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    vef.d(this.jdField_a_of_type_Vef, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     veg
 * JD-Core Version:    0.7.0.1
 */