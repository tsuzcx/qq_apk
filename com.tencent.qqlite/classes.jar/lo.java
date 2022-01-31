import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;

class lo
  implements AsyncBack
{
  lo(ln paramln, long paramLong) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "OfflineDownloader code:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0)
    {
      HtmlOffline.a(ln.a(this.jdField_a_of_type_Ln), ln.a(this.jdField_a_of_type_Ln));
      if (2 == this.jdField_a_of_type_Ln.jdField_a_of_type_Int)
      {
        HtmlOffline.c(ln.a(this.jdField_a_of_type_Ln));
        ln.a(this.jdField_a_of_type_Ln, -1);
      }
    }
    for (;;)
    {
      HtmlOffline.a(ln.a(this.jdField_a_of_type_Ln), paramInt, l, OfflineDownloader.a(ln.a(this.jdField_a_of_type_Ln)));
      return;
      if (this.jdField_a_of_type_Ln.jdField_a_of_type_Boolean) {
        HtmlOffline.c(ln.a(this.jdField_a_of_type_Ln));
      }
      ln.a(this.jdField_a_of_type_Ln, 0);
      continue;
      ln.a(this.jdField_a_of_type_Ln, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lo
 * JD-Core Version:    0.7.0.1
 */