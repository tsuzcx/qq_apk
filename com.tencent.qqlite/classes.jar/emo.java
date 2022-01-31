import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class emo
  implements HttpWebCgiAsyncTask.Callback
{
  public emo(TroopFeedsDataManager paramTroopFeedsDataManager) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    int i = 1;
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        int j = paramJSONObject.getInt("retcode");
        if (j != 0) {
          i = 0;
        }
        if (i != 0) {
          continue;
        }
        if (paramInt == 1000)
        {
          TroopFeedsDataManager.b(this.a);
          this.a.notifyObservers(Integer.valueOf(103));
          if (QLog.isColorLevel()) {
            QLog.d("TroopFeedsDataManager", 2, "cgi end(failed): " + System.currentTimeMillis());
          }
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle = paramBundle;
        paramBundle.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopFeedsDataManager", 2, "cgi end(suc): " + System.currentTimeMillis());
        if (paramInt != 1000) {
          continue;
        }
        ThreadManager.b().post(new emp(this, paramJSONObject));
        return;
      }
      finally {}
      if (paramInt == 1001)
      {
        this.a.a.getApplication();
        QQToast.a(MobileQQ.getContext(), "删除失败，请稍后重试", 3000).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     emo
 * JD-Core Version:    0.7.0.1
 */