import android.graphics.Bitmap;

class qbp
  implements qpm.a
{
  qbp(qbo paramqbo, String paramString) {}
  
  public void h(String paramString, Throwable paramThrowable)
  {
    ram.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.val$imageUrl });
    qbo.d(this.a, false);
  }
  
  public void m(String paramString, Bitmap paramBitmap)
  {
    if (qbo.a(this.a))
    {
      paramString = aqhu.r(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        qbo.a(this.a, false);
        return;
      }
      bool = rop.d(paramString, qbo.a(this.a));
      paramString.recycle();
      qbo.b(this.a, bool);
      return;
    }
    boolean bool = rop.d(paramBitmap, qbo.a(this.a));
    qbo.c(this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qbp
 * JD-Core Version:    0.7.0.1
 */