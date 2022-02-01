import android.graphics.Bitmap;

class wwh
  implements xro
{
  wwh(wwg paramwwg, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (wwg.a(this.jdField_a_of_type_Wwg))
    {
      paramString = bheg.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        wwg.a(this.jdField_a_of_type_Wwg, false);
        return;
      }
      bool = zdr.a(paramString, wwg.a(this.jdField_a_of_type_Wwg));
      paramString.recycle();
      wwg.b(this.jdField_a_of_type_Wwg, bool);
      return;
    }
    boolean bool = zdr.a(paramBitmap, wwg.a(this.jdField_a_of_type_Wwg));
    wwg.c(this.jdField_a_of_type_Wwg, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    ykq.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    wwg.d(this.jdField_a_of_type_Wwg, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwh
 * JD-Core Version:    0.7.0.1
 */