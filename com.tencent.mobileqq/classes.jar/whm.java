import android.graphics.Bitmap;

class whm
  implements xct
{
  whm(whl paramwhl, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (whl.a(this.jdField_a_of_type_Whl))
    {
      paramString = bfvo.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        whl.a(this.jdField_a_of_type_Whl, false);
        return;
      }
      bool = yoy.a(paramString, whl.a(this.jdField_a_of_type_Whl));
      paramString.recycle();
      whl.b(this.jdField_a_of_type_Whl, bool);
      return;
    }
    boolean bool = yoy.a(paramBitmap, whl.a(this.jdField_a_of_type_Whl));
    whl.c(this.jdField_a_of_type_Whl, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    xvv.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    whl.d(this.jdField_a_of_type_Whl, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whm
 * JD-Core Version:    0.7.0.1
 */