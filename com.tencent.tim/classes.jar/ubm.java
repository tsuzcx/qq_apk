import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment.a;
import org.json.JSONException;
import org.json.JSONObject;

public class ubm
  extends TestAppFragment.a
{
  public ubm(TestAppFragment paramTestAppFragment, EditText paramEditText, JSONObject paramJSONObject)
  {
    super(paramEditText);
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    super.onSuccess(paramJSONObject);
    try
    {
      this.aQ.put("rankingID", 11002);
      this.aQ.put("topCount", 11);
      this.a.c.a("getRankingList", this.aQ, new TestAppFragment.a(this.a.al));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubm
 * JD-Core Version:    0.7.0.1
 */