import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;

class lk
  implements AsyncBack
{
  lk(lj paramlj, long paramLong) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "OfflineDownloader code:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0)
    {
      HtmlOffline.a(lj.a(this.jdField_a_of_type_Lj), lj.a(this.jdField_a_of_type_Lj));
      if (2 == this.jdField_a_of_type_Lj.jdField_a_of_type_Int)
      {
        HtmlOffline.c(lj.a(this.jdField_a_of_type_Lj));
        lj.a(this.jdField_a_of_type_Lj, -1);
      }
    }
    for (;;)
    {
      HtmlOffline.a(lj.a(this.jdField_a_of_type_Lj), paramInt, l, OfflineDownloader.a(lj.a(this.jdField_a_of_type_Lj)));
      return;
      if (this.jdField_a_of_type_Lj.jdField_a_of_type_Boolean) {
        HtmlOffline.c(lj.a(this.jdField_a_of_type_Lj));
      }
      lj.a(this.jdField_a_of_type_Lj, 0);
      continue;
      lj.a(this.jdField_a_of_type_Lj, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lk
 * JD-Core Version:    0.7.0.1
 */