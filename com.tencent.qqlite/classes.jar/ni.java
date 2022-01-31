import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.google.zxing.client.android.wifi.BizWifiConfigManager;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ni
  extends Thread
{
  public ni(SensorAPIJavaScript paramSensorAPIJavaScript, Context paramContext, String paramString) {}
  
  public void run()
  {
    int k = 2;
    int j = 15;
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i = k;
    if (j > 0)
    {
      localObject2 = localObject1;
      i = k;
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
          break label204;
        }
        i = k;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("SensorApi", 4, "run check end: " + i);
        }
        localObject1 = new Message();
        ((Message)localObject1).what = 0;
        if (i != 0) {
          break label274;
        }
        j = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.a();
      }
      for (((Message)localObject1).obj = ("javascript: " + this.jdField_a_of_type_JavaLangString + "('" + i + "', '" + localObject2 + "',  '" + j + "')");; ((Message)localObject1).obj = ("javascript: " + this.jdField_a_of_type_JavaLangString + "('" + i + "')")) {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
          this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.c = false;
          return;
          label204:
          if (QLog.isDevelopLevel()) {
            QLog.d("SensorApi", 4, "run check: " + j);
          }
          localObject1 = BizWifiConfigManager.a(this.jdField_a_of_type_AndroidContentContext);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = 0;
            localObject2 = localObject1;
            break;
          }
          try
          {
            Thread.sleep(2000L);
            j -= 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            label274:
            Object localObject3 = localObject1;
            i = k;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ni
 * JD-Core Version:    0.7.0.1
 */