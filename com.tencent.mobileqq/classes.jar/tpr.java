import android.graphics.Bitmap;

class tpr
  implements ule
{
  tpr(tpq paramtpq, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (tpq.a(this.jdField_a_of_type_Tpq))
    {
      paramString = bbdr.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        tpq.a(this.jdField_a_of_type_Tpq, false);
        return;
      }
      bool = vxy.a(paramString, tpq.a(this.jdField_a_of_type_Tpq));
      paramString.recycle();
      tpq.b(this.jdField_a_of_type_Tpq, bool);
      return;
    }
    boolean bool = vxy.a(paramBitmap, tpq.a(this.jdField_a_of_type_Tpq));
    tpq.c(this.jdField_a_of_type_Tpq, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    veg.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    tpq.d(this.jdField_a_of_type_Tpq, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpr
 * JD-Core Version:    0.7.0.1
 */