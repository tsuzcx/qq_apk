package cooperation.readinjoy;

import awit;
import com.tencent.qphone.base.util.QLog;
import kbp;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public final class ReadInJoyHelper$5
  implements Runnable
{
  public ReadInJoyHelper$5(AppRuntime paramAppRuntime, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      awit.cj(localJSONObject);
      kbp.a(null, this.val$runtime.getAccount(), "0X8009662", "0X8009662", 0, 0, String.valueOf(this.eBg), String.valueOf(this.eBh), "", localJSONObject.toString(), false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadInJoyHelper", 2, "only kandian tab switch, report error:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.readinjoy.ReadInJoyHelper.5
 * JD-Core Version:    0.7.0.1
 */