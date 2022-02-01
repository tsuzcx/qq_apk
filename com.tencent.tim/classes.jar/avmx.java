import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class avmx
  extends avnl
{
  avmx(avmw paramavmw) {}
  
  public void a(@NonNull avnk paramavnk)
  {
    paramavnk = paramavnk.f();
    if (paramavnk == null) {
      avoc.e("ReaderUrlConfigDataHelper", "Response json is null");
    }
    do
    {
      return;
      if (paramavnk.length() == 0)
      {
        avoc.e("ReaderUrlConfigDataHelper", "后台数据异常");
        return;
      }
    } while (!avmw.a(this.a, paramavnk));
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    avmw.a(this.a).getSharedPreferences("CGI_RESPONSE", 0).edit().putString("SP_URL_CONFIG_DATA" + str, paramavnk.toString()).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmx
 * JD-Core Version:    0.7.0.1
 */