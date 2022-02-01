import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class avmv
  extends avnl
{
  avmv(avmt paramavmt) {}
  
  public void a(avnk paramavnk)
  {
    paramavnk = paramavnk.f();
    if (paramavnk == null) {
      avoc.e("ReaderTabConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramavnk.length() == 0)
      {
        avoc.e("ReaderTabConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!avmt.a(this.a, paramavnk, false));
    avmt.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_TAB_CONFIG_DATA" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramavnk.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmv
 * JD-Core Version:    0.7.0.1
 */