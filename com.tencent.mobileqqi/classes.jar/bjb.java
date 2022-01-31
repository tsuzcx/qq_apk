import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bjb
  extends Thread
{
  public bjb(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int k = 2;
    int i = 15;
    int j = k;
    if (i > 0)
    {
      j = k;
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          break label157;
        }
        j = k;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SensorApi", 4, "run check end: " + j);
          }
          Message localMessage = new Message();
          localMessage.what = 0;
          localMessage.obj = ("javascript: " + this.jdField_a_of_type_JavaLangString + "('" + j + "')");
          this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
        }
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.b = false;
        return;
        label157:
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check: " + i);
        }
        if (BizWifiConfigManager.a(this.jdField_a_of_type_AndroidContentContext)) {
          j = 0;
        } else {
          try
          {
            Thread.sleep(2000L);
            i -= 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            j = k;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bjb
 * JD-Core Version:    0.7.0.1
 */