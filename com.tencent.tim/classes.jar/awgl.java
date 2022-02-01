import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class awgl
  implements awgj.a
{
  awgl(awgj paramawgj) {}
  
  public void e(JSONObject paramJSONObject, Bundle paramBundle)
    throws JSONException
  {
    paramJSONObject.put("status", paramBundle.getInt("status", 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awgl
 * JD-Core Version:    0.7.0.1
 */