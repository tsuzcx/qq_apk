import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class awgm
  implements awgj.a
{
  awgm(awgj paramawgj) {}
  
  public void e(JSONObject paramJSONObject, Bundle paramBundle)
    throws JSONException
  {
    paramJSONObject.put("event_video_album_state", paramBundle.getString("event_video_album_state"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgm
 * JD-Core Version:    0.7.0.1
 */