import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import org.json.JSONException;
import org.json.JSONObject;

public class yhm
  extends yho
{
  int bZb = 100;
  
  public yhm(yho.a parama)
  {
    super(parama);
  }
  
  public void aB(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("moneylimit"))) {}
    try
    {
      this.bZb = paramJSONObject.getInt("moneylimit");
      BaseApplicationImpl.getApplication().getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).edit().putInt("HONGBAO_SCENES_MONEY_LIMIT", this.bZb).apply();
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yhm
 * JD-Core Version:    0.7.0.1
 */