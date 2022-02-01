import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class aqtp
  implements SensorEventListener
{
  aqtp(aqtm paramaqtm) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.this$0.cwX = ("Current step data:" + String.valueOf(paramSensorEvent.values[0]));
    QLog.d("HealthStepCounterPlugin", 1, "onSensorChanged:" + this.this$0.cwX);
    if ((aqtm.ecA == 1) && (aqtm.cVY))
    {
      this.this$0.ecB = ((int)paramSensorEvent.values[0]);
      aqtm.cVY = false;
    }
    if (aqtm.ecA == 3)
    {
      aqtm.ecA = 0;
      this.this$0.ecC = ((int)paramSensorEvent.values[0]);
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        paramSensorEvent = new JSONObject();
        paramSensorEvent.put("retCode", 0);
        paramSensorEvent.put("step", this.this$0.ecC - this.this$0.ecB);
        localJSONObject = new JSONObject();
        localJSONObject.put("source", "none");
        paramSensorEvent = WebViewPlugin.toJsScript("StepsDetect", paramSensorEvent, localJSONObject);
        if (aqtm.cVX)
        {
          this.this$0.mRuntime.getWebView().loadUrl("javascript:" + paramSensorEvent);
          QLog.d("HealthStepCounterPlugin", 1, "Steps detect:" + (this.this$0.ecC - this.this$0.ecB));
          aqtm.cVX = false;
        }
        aqtm.cVY = true;
        return;
      }
      catch (Exception paramSensorEvent)
      {
        paramSensorEvent = new JSONObject();
      }
      try
      {
        paramSensorEvent.put("retCode", -1);
        paramSensorEvent.put("step", 0);
        localJSONObject = new JSONObject();
        localJSONObject.put("source", "none");
        this.this$0.dispatchJsEvent("StepsDetect", paramSensorEvent, localJSONObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("HealthStepCounterPlugin", 2, "Err StepsDetect");
      }
      catch (JSONException paramSensorEvent)
      {
        for (;;)
        {
          paramSensorEvent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtp
 * JD-Core Version:    0.7.0.1
 */