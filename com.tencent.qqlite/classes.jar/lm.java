import android.content.Context;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class lm
  implements AsyncBack
{
  public lm(long paramLong, Context paramContext, String paramString, LoadedBack paramLoadedBack) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(paramInt);
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
      if (HtmlOffline.c(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(0, null);
      }
    }
    for (;;)
    {
      HtmlOffline.b(this.jdField_a_of_type_JavaLangString);
      HtmlOffline.a(this.jdField_a_of_type_JavaLangString, paramInt, l, OfflineDownloader.a(this.jdField_a_of_type_AndroidContentContext));
      return;
      this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(6, null);
      continue;
      this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack.a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lm
 * JD-Core Version:    0.7.0.1
 */