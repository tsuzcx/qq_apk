import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.subscribe.other.story.RankListModule.1;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class sfe
  extends sfa
{
  public String getModuleName()
  {
    return "rankList";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    try
    {
      if ("showRankListEntry".equals(paramString))
      {
        if (paramJSONObject == null) {
          paramInvokeCallback.exec(4);
        }
        QLog.d("rankList", 2, "json:" + paramJSONObject);
        new Handler(Looper.getMainLooper()).post(new RankListModule.1(this));
        return true;
      }
    }
    catch (Exception paramInvokeCallback)
    {
      QLog.e("BaseModuleForStoryGame", 1, "handleJsRequest failed! method = " + paramString + ";param = " + paramJSONObject, paramInvokeCallback);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfe
 * JD-Core Version:    0.7.0.1
 */