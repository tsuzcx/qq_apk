import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import org.json.JSONObject;

public final class abif
  implements tzd
{
  public abif(View paramView, tzg paramtzg, long paramLong, int paramInt, String paramString) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login failed," + paramString);
  }
  
  public void onPermission(int paramInt)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location login permision code");
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    ApolloRender.getLocationDoLocation(this.val$view, this.d, this.Nv, this.coW, this.val$appid);
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abif
 * JD-Core Version:    0.7.0.1
 */