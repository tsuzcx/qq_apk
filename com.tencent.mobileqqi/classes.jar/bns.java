import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;

class bns
  implements AsyncBack
{
  bns(bnr parambnr, long paramLong) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "OfflineDownloader code:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0)
    {
      HtmlOffline.a(bnr.a(this.jdField_a_of_type_Bnr), bnr.a(this.jdField_a_of_type_Bnr));
      if (2 == this.jdField_a_of_type_Bnr.jdField_a_of_type_Int)
      {
        HtmlOffline.a(bnr.a(this.jdField_a_of_type_Bnr));
        bnr.a(this.jdField_a_of_type_Bnr, -1);
      }
    }
    for (;;)
    {
      HtmlOffline.a(bnr.a(this.jdField_a_of_type_Bnr), paramInt, l, OfflineDownloader.a(bnr.a(this.jdField_a_of_type_Bnr)));
      return;
      if (this.jdField_a_of_type_Bnr.jdField_a_of_type_Boolean) {
        HtmlOffline.a(bnr.a(this.jdField_a_of_type_Bnr));
      }
      bnr.a(this.jdField_a_of_type_Bnr, 0);
      continue;
      bnr.a(this.jdField_a_of_type_Bnr, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bns
 * JD-Core Version:    0.7.0.1
 */