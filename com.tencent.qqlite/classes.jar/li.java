import android.content.Context;
import com.tencent.biz.common.offline.AsyncCallBack;
import com.tencent.qphone.base.util.QLog;

public final class li
  extends Thread
{
  public li(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HtmlCheckUpdate", 2, "Begin transThread:");
    }
    new lp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     li
 * JD-Core Version:    0.7.0.1
 */