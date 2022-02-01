import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class avnv
  extends avnl
{
  public avnv(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(avnk paramavnk)
  {
    boolean bool = false;
    JSONObject localJSONObject = paramavnk.f();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: UpdateToQQBookstore response json is null");
      return;
    }
    catch (JSONException paramavnk)
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: UpdateToQQBookstore parse failed: " + paramavnk.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    paramavnk = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: UpdateToQQBookstore ret=" + i + "|msg=" + paramavnk);
      return;
    }
    i = localJSONObject.optInt("err_code", 0);
    paramavnk = localJSONObject.optString("err_msg");
    if (i == 0) {
      bool = true;
    }
    avob.a.U(ForceUserUpdateActivity.a(this.this$0), bool);
    if (bool)
    {
      avoc.i("ForceUserUpdateActivity", "onReceiveData: UpdateToQQBookstore succeed");
      ForceUserUpdateActivity.c(this.this$0);
      return;
    }
    ForceUserUpdateActivity.a(this.this$0, "onReceiveData: UpdateToQQBookstore errMsg=" + paramavnk);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.this$0, "onConnectionError: UpdateToQQBookstore error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnv
 * JD-Core Version:    0.7.0.1
 */