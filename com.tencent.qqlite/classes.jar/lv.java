import android.text.TextUtils;
import com.tencent.biz.common.util.LoadedCallBack;
import com.tencent.mobileqq.app.QQAppInterface;

public final class lv
  implements Runnable
{
  public lv(QQAppInterface paramQQAppInterface, LoadedCallBack paramLoadedCallBack) {}
  
  public void run()
  {
    Object localObject = null;
    int i = 0;
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (i < 10))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.jdField_a_of_type_ComTencentBizCommonUtilLoadedCallBack.a((String)localObject);
        }
      }
      else
      {
        return;
      }
      try
      {
        Thread.sleep(200L);
        label49:
        i += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label49;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lv
 * JD-Core Version:    0.7.0.1
 */