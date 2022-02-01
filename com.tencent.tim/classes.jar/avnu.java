import android.content.res.Resources;
import android.widget.TextView;
import cooperation.qqreader.net.BaseCgiTask;
import cooperation.qqreader.ui.ForceUserUpdateActivity;
import org.json.JSONObject;

public class avnu
  extends avnl
{
  public avnu(ForceUserUpdateActivity paramForceUserUpdateActivity) {}
  
  public void a(avnk paramavnk)
  {
    JSONObject localJSONObject = paramavnk.f();
    if (localJSONObject == null) {}
    try
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: QueryGrayUpdate response json is null");
      return;
    }
    catch (Exception paramavnk)
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: QueryGrayUpdate parse failed: " + paramavnk.getMessage());
      return;
    }
    int i = localJSONObject.getInt("ret");
    paramavnk = localJSONObject.getString("msg");
    localJSONObject = localJSONObject.getJSONObject("data");
    if ((i != 0) || (localJSONObject == null) || (localJSONObject.length() == 0))
    {
      ForceUserUpdateActivity.a(this.this$0, "onReceiveData: QueryGrayUpdate ret=" + i + "|msg=" + paramavnk);
      return;
    }
    i = localJSONObject.optInt("gray_level", 0);
    int j = localJSONObject.optInt("updateStatus", 0);
    int k = localJSONObject.optInt("updateStatus", 0);
    int m = localJSONObject.optInt("remainMaxTime", 0);
    avob.a.bb(ForceUserUpdateActivity.a(this.this$0), i);
    avob.a.bc(ForceUserUpdateActivity.a(this.this$0), j);
    avob.a.bd(ForceUserUpdateActivity.a(this.this$0), k);
    avob.a.be(ForceUserUpdateActivity.a(this.this$0), m);
    avoc.i("ForceUserUpdateActivity", "onReceiveData: QueryGrayUpdate result: level=" + i + "|status=" + j + "|remain=" + m + "|interval=" + k);
    if (j == 1)
    {
      ForceUserUpdateActivity.c(this.this$0);
      return;
    }
    if (j == 2)
    {
      ForceUserUpdateActivity.a(this.this$0, k);
      ForceUserUpdateActivity.a(this.this$0).setText(this.this$0.getResources().getString(2131717141, new Object[] { Integer.valueOf(m) }));
      return;
    }
    ForceUserUpdateActivity.d(this.this$0);
    avob.a.bc(ForceUserUpdateActivity.a(this.this$0), 2);
  }
  
  public void a(BaseCgiTask paramBaseCgiTask, String paramString)
  {
    ForceUserUpdateActivity.a(this.this$0, "onConnectionError: QueryGrayUpdate error: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnu
 * JD-Core Version:    0.7.0.1
 */