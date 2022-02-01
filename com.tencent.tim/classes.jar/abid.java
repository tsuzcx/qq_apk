import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import org.json.JSONObject;

public final class abid
  implements tzd
{
  public abid(View paramView, tzg paramtzg, long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, this.bQ, this.bR, this.bS, this.bT, this.bU, this.bV, "", paramInt, "location city failed");
  }
  
  public void onPermission(int paramInt)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, this.bQ, this.bR, this.bS, this.bT, this.bU, this.bV, "", paramInt, "location city failed permission");
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("city", "");
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, this.bQ, this.bR, this.bS, this.bT, this.bU, this.bV, paramJSONObject, 0, "location success");
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abid
 * JD-Core Version:    0.7.0.1
 */