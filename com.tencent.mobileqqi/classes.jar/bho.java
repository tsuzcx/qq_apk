import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;

class bho
  implements AsyncBack
{
  bho(bhn parambhn, long paramLong) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "OfflineDownloader code:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0)
    {
      HtmlOffline.a(bhn.a(this.jdField_a_of_type_Bhn), bhn.a(this.jdField_a_of_type_Bhn));
      if (2 == this.jdField_a_of_type_Bhn.jdField_a_of_type_Int)
      {
        HtmlOffline.a(bhn.a(this.jdField_a_of_type_Bhn));
        bhn.a(this.jdField_a_of_type_Bhn, -1);
      }
    }
    for (;;)
    {
      HtmlOffline.a(bhn.a(this.jdField_a_of_type_Bhn), paramInt, l, OfflineDownloader.a(bhn.a(this.jdField_a_of_type_Bhn)));
      return;
      if (this.jdField_a_of_type_Bhn.jdField_a_of_type_Boolean) {
        HtmlOffline.a(bhn.a(this.jdField_a_of_type_Bhn));
      }
      bhn.a(this.jdField_a_of_type_Bhn, 0);
      continue;
      bhn.a(this.jdField_a_of_type_Bhn, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bho
 * JD-Core Version:    0.7.0.1
 */