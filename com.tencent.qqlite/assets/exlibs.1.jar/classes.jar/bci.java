import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class bci
  implements Runnable
{
  public bci(QQBrowserActivity paramQQBrowserActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      String str = HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, MsfSdkUtils.insertMtype("Web", this.jdField_a_of_type_JavaLangString), "POST", null, null);
      if ((str != null) && (!"".equals(str.trim()))) {
        Message.obtain(QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity), 100, str).sendToTarget();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bci
 * JD-Core Version:    0.7.0.1
 */