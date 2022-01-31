import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountHandler.IWeatherInfoListener;
import org.json.JSONException;
import org.json.JSONObject;

public class vuq
  implements PublicAccountHandler.IWeatherInfoListener
{
  public vuq(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(String paramString)
  {
    int j = 0;
    String str = "";
    Object localObject = str;
    label106:
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        localObject = str;
        paramString = localJSONObject.getString("area");
        localObject = paramString;
        int i = localJSONObject.getInt("area_id");
        int k;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          k = localJSONObject.getInt("switch");
          j = k;
          localObject = Message.obtain();
          ((Message)localObject).what = 6;
          ((Message)localObject).arg1 = i;
          ((Message)localObject).arg2 = j;
          ((Message)localObject).obj = paramString;
          this.a.a.sendMessage((Message)localObject);
          return;
        }
        catch (JSONException localJSONException2)
        {
          break label106;
        }
        localJSONException1 = localJSONException1;
        i = 0;
        paramString = (String)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vuq
 * JD-Core Version:    0.7.0.1
 */