import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class aife
  implements Manager
{
  private QQAppInterface mApp;
  
  public aife(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void aD(String paramString)
  {
    int j = 0;
    if (aqmr.isEmpty(paramString))
    {
      paramString = BaseApplicationImpl.getContext().getSharedPreferences("now_download_config", 4);
      paramString.edit().putInt("key_now_download_engine", 0).commit();
      paramString.edit().putInt("key_now_channel", 0).commit();
      QLog.e("NowGeneralConfigManager", 4, "NowGeneralConfigManager----parseJson---downloadEngine = 0");
      return;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("now_download_engine"))
        {
          i = paramString.getInt("now_download_engine");
          if (paramString.has("now_channel")) {
            j = paramString.getInt("now_channel");
          }
          QLog.e("NowGeneralConfigManager", 4, "NowGeneralConfigManager----parseJson---downloadEngine = " + i + ", nowChannel = " + j);
          paramString = BaseApplicationImpl.getContext().getSharedPreferences("now_download_config", 4);
          paramString.edit().putInt("key_now_download_engine", i).commit();
          paramString.edit().putInt("key_now_channel", j).commit();
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aife
 * JD-Core Version:    0.7.0.1
 */