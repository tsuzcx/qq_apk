import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

class oce
  implements skj.a
{
  oce(obw paramobw, String paramString, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.this$0.activity != null) {
        this.this$0.cancleProgressDailog();
      }
      String str = paramBundle.getString("pic_server_id");
      this.this$0.aR(paramBundle);
      if ("-1".equals(str)) {
        paramBundle = new JSONObject();
      }
    }
    else
    {
      try
      {
        paramBundle.put("retCode", -1);
        paramBundle.put("msg", "fail");
        this.this$0.callJs(this.val$callback, new String[] { paramBundle.toString() });
        if (this.awl)
        {
          kbp.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D27", "0X8005D27", 0, -1, "1", "", "", "", false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D30", "0X8005D30", 0, -1, "1", "", "", "");
        return;
      }
    }
    this.this$0.a(localJSONException, this.awl, this.val$callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oce
 * JD-Core Version:    0.7.0.1
 */