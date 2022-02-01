import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import org.json.JSONException;
import org.json.JSONObject;

public class qej
{
  public long Ak;
  public boolean aBR;
  public String feedId;
  public StoryVideoItem g;
  public boolean isLocal;
  public String vid;
  
  public void ak(@NonNull JSONObject paramJSONObject)
  {
    try
    {
      this.aBR = paramJSONObject.getBoolean("didRead");
      this.feedId = paramJSONObject.getString("feedId");
      this.vid = paramJSONObject.getString("vid");
      this.Ak = paramJSONObject.optLong("videoIndex");
      this.isLocal = paramJSONObject.getBoolean("isLocal");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public JSONObject toJson()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("feedId", this.feedId);
      localJSONObject.put("didRead", this.aBR);
      localJSONObject.put("vid", this.vid);
      localJSONObject.put("videoIndex", this.Ak);
      localJSONObject.put("isLocal", this.isLocal);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public String toString()
  {
    return "MsgTabVideoData{didRead=" + this.aBR + ", feedId='" + this.feedId + '\'' + ", vid='" + this.vid + '\'' + ", videoIndex='" + this.Ak + '\'' + ", storyVideoItem=" + this.g + ", isLocal=" + this.isLocal + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qej
 * JD-Core Version:    0.7.0.1
 */