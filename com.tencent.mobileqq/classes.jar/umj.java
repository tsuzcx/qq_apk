import android.app.Activity;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.widget.ListView;
import java.io.File;
import org.json.JSONObject;

public class umj
{
  @Nullable
  private umk a;
  
  public static void a(JSONObject paramJSONObject)
  {
    ujj.a.a(4);
    uje.a.a();
    ujg.a.a(paramJSONObject, true, "supermask path not exist", "", "resource_use_key");
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
      ujg.a.a("fileNotExists", "");
      a(paramJSONObject);
      return;
    }
    if (!new ujl().a())
    {
      a(paramJSONObject);
      return;
    }
    ukq.a("ReadInJoySuperMaskAd", "real show superMask");
    this.a = new umk(paramActivity, paramListView, str1);
    this.a.a(i);
    ujg.a.a(paramJSONObject, true, "no error", "", "resource_use_key");
    ujd.a.b(ujj.a.b());
    ujj.a.a(2);
  }
  
  public boolean a()
  {
    return (this.a != null) && (umk.a(this.a));
  }
  
  public void b()
  {
    if (this.a != null)
    {
      this.a.setVisibility(8);
      ukq.a("ReadInJoySuperMaskAd", "real gone mask " + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umj
 * JD-Core Version:    0.7.0.1
 */