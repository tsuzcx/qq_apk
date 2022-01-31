import android.content.Context;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class bno
  extends Thread
{
  public bno(int paramInt, String paramString1, Context paramContext, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    bnr localbnr = new bnr(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      localbnr.a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bno
 * JD-Core Version:    0.7.0.1
 */