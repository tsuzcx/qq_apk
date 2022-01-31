import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.maproam.activity.RoamingActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

public class gfz
  implements Runnable
{
  public gfz(RoamingActivity paramRoamingActivity) {}
  
  public void run()
  {
    Object localObject = new File(AppConstants.aK + "roamconfig");
    try
    {
      HttpDownloadUtil.a(this.a.b, "http://imgcache.qq.com/club/mobile/roam/roam_guide.json", (File)localObject);
      String str = FileUtils.a((File)localObject);
      ((File)localObject).delete();
      if (str != null)
      {
        localObject = new JSONArray(str);
        if (((JSONArray)localObject).length() > 0)
        {
          localObject = ((JSONArray)localObject).getJSONObject(0);
          long l1 = ((JSONObject)localObject).optLong("begin_time", 0L);
          long l2 = ((JSONObject)localObject).optLong("end_time", 0L);
          this.a.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("svip_lat", 0);
          this.a.C = ((JSONObject)localObject).optInt("svip_lon", 0);
          this.a.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("svip_place_name", "");
          localObject = ((JSONObject)localObject).optString("svip_guide_text", "");
          if (QLog.isColorLevel()) {
            QLog.i("IphoneTitleBarActivity", 2, "beginTime:" + l1 + ", endTime:" + l2 + ", mSvipLat:" + this.a.jdField_g_of_type_Int + ", mSvipLon:" + this.a.C + ", svipGuildText:" + (String)localObject);
          }
          long l3 = System.currentTimeMillis();
          new Handler(Looper.getMainLooper()).post(new gga(this, l3, l1, l2, (String)localObject));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      this.a.a = Boolean.valueOf(false);
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gfz
 * JD-Core Version:    0.7.0.1
 */