import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment.a;
import org.json.JSONObject;

public class ubn
  extends TestAppFragment.a
{
  public ubn(TestAppFragment paramTestAppFragment) {}
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    super.onSuccess(paramJSONObject);
    paramJSONObject.optString("openid", "");
    this.a.c.a("getAppFriends", null, new ubo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubn
 * JD-Core Version:    0.7.0.1
 */