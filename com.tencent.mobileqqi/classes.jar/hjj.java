import com.tencent.open.agent.OpenSdkFriendService;
import com.tencent.open.agent.OpenSdkFriendService.CheckAvatarUpdateCallback;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hjj
  implements Runnable
{
  public hjj(OpenSdkFriendService.CheckAvatarUpdateCallback paramCheckAvatarUpdateCallback, int paramInt, JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_Int) {
        try
        {
          String str = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i).getString("openid");
          str = QZonePortraitData.a(this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateCallback.a.f, str);
          ImageLoader.a().a(str);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hjj
 * JD-Core Version:    0.7.0.1
 */