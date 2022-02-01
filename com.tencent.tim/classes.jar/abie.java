import android.view.View;
import com.tencent.mobileqq.apollo.ApolloRender;
import org.json.JSONObject;

public final class abie
  implements tzd
{
  public abie(View paramView, tzg paramtzg, long paramLong, int paramInt) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location failed," + paramString);
  }
  
  public void onPermission(int paramInt)
  {
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, "", paramInt, "location permision code");
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    double d1 = paramJSONObject.optDouble("altitude", 0.0D);
    double d2 = paramJSONObject.optDouble("latitude", 0.0D);
    double d3 = paramJSONObject.optDouble("longitude", 0.0D);
    double d4 = paramJSONObject.optDouble("horizontalAccuracy", 0.0D);
    paramJSONObject.optDouble("verticalAccuracy", 0.0D);
    paramJSONObject.optDouble("accuracy", 0.0D);
    double d5 = paramJSONObject.optDouble("speed", 0.0D);
    if (this.coW == 1)
    {
      ApolloRender.getLocationCity(this.val$view, this.d, this.Nv, d4, d2, d3, d5, d1, 0.0D);
      return;
    }
    ApolloRender.locationEnd(this.val$view, this.d, this.Nv, d4, d2, d3, d5, d1, 0.0D, "", 0, "location success");
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abie
 * JD-Core Version:    0.7.0.1
 */