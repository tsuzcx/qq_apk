import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import org.json.JSONObject;

public class zus
  extends zuu
{
  public zus(TestAppFragment paramTestAppFragment) {}
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    super.onSuccess(paramJSONObject);
    paramJSONObject.optString("openid", "");
    this.a.a.a("getAppFriends", null, new zut(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zus
 * JD-Core Version:    0.7.0.1
 */