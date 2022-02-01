import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class avnt
  extends avnl
{
  public avnt(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(avnk paramavnk)
  {
    int j = 0;
    i = 0;
    paramavnk = paramavnk.f();
    if ((paramavnk == null) || (paramavnk.length() == 0)) {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: FetchTabConfigData response illegal: " + paramavnk);
    }
    for (;;)
    {
      if (i == 0) {
        ForceUserUpdateActivity.b(this.this$0, "拉取新书城配置失败，请检查网络重试");
      }
      return;
      for (;;)
      {
        for (;;)
        {
          try
          {
            localObject = (JSONArray)paramavnk.get("tabList");
            if ((localObject != null) && (((JSONArray)localObject).length() > 0))
            {
              avoc.i("ForceUserUpdateActivity", "onReceiveData: FetchTabConfigData succeed, length = " + ((JSONArray)localObject).length());
              localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
              ForceUserUpdateActivity.a(this.this$0).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + (String)localObject, paramavnk.toString()).apply();
              avob.a.W(ForceUserUpdateActivity.a(this.this$0), true);
            }
          }
          catch (Exception paramavnk)
          {
            Object localObject;
            i = j;
          }
          try
          {
            ForceUserUpdateActivity.b(this.this$0);
            i = 1;
          }
          catch (Exception paramavnk)
          {
            for (;;)
            {
              i = 1;
            }
          }
        }
        ForceUserUpdateActivity.a(this.this$0, "onReceiveData: FetchTabConfigData empty: " + localObject);
        i = 0;
      }
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: FetchTabConfigData parse failed: " + paramavnk.getMessage());
    }
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.this$0, "onConnectionError: FetchTabConfigData error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnt
 * JD-Core Version:    0.7.0.1
 */