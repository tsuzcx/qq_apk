import android.content.Context;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.qphone.base.util.QLog;

public final class lg
  extends Thread
{
  public lg(int paramInt, String paramString1, Context paramContext, String paramString2, LoadedBack paramLoadedBack, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQBrowserOffline", 2, "start checkUpThread. delay:" + this.jdField_a_of_type_Int + ", businessId:" + this.jdField_a_of_type_JavaLangString);
    }
    lj locallj = new lj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizCommonUtilLoadedBack, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Int > 0) {}
    try
    {
      Thread.sleep(this.jdField_a_of_type_Int * 1000);
      locallj.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     lg
 * JD-Core Version:    0.7.0.1
 */