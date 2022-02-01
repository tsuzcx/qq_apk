import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ListView;
import java.io.File;
import org.json.JSONObject;

public class tyl
{
  @Nullable
  private tym a;
  
  public static void a(JSONObject paramJSONObject)
  {
    tvi.a.a(tuz.a.d());
    tve.a.a();
    tvg.a.a(paramJSONObject, true, "supermask path not exist", "", "resource_use_key");
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void a(Activity paramActivity, ListView paramListView, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("res_path");
    String str2 = paramJSONObject.optString("animFileName");
    str1 = str1 + File.separator + str2;
    int i = paramJSONObject.optInt("superMaskType");
    if (!FileUtil.isFileExists(str1))
    {
      tvg.a.a("fileNotExists");
      a(paramJSONObject);
      return;
    }
    if (!new tvk().a())
    {
      a(paramJSONObject);
      return;
    }
    twp.a("ReadInJoySuperMaskAd", "real show superMask");
    this.a = new tym(paramActivity, paramListView, str1);
    this.a.a(i);
    tvg.a.a(paramJSONObject, true, "no error", "", "resource_use_key");
    tvd.a.b(tvi.a.b());
    tvi.a.a(tuz.a.c());
  }
  
  public boolean a()
  {
    return (this.a != null) && (tym.a(this.a));
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.setVisibility(8);
      twp.a("ReadInJoySuperMaskAd", "real gone mask " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyl
 * JD-Core Version:    0.7.0.1
 */