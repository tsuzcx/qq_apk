import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class adsb
  implements adts
{
  public boolean needProcess(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.mArkMessagePreprocessor needProcess=", Boolean.valueOf(true) });
    }
    return true;
  }
  
  public void process(JSONObject paramJSONObject, adtt paramadtt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process msgJson=", paramJSONObject.toString() });
    }
    ThreadManager.getFileThreadHandler().postDelayed(new ArkAsyncShareMiniAppTest.1.1(this, paramJSONObject, paramadtt, paramObject), 20000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adsb
 * JD-Core Version:    0.7.0.1
 */