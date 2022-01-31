import android.content.Context;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class bhm
  implements AsyncBack
{
  public bhm(long paramLong, Context paramContext, String paramString, LoadedBack paramLoadedBack) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.b(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "js call downloadUpdate callback:" + paramInt + ", time:" + l);
    }
    if (paramInt == 0)
    {
      HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (HtmlOffline.a(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(0);
      }
    }
    for (;;)
    {
      HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
      HtmlOffline.a(this.jdField_a_of_type_JavaLangString, paramInt, l, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext));
      return;
      this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(6);
      continue;
      this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bhm
 * JD-Core Version:    0.7.0.1
 */