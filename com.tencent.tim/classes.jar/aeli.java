import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aeli
{
  private long Wj;
  private boolean bUV;
  private boolean bUW;
  
  public static aeli a(aeic[] paramArrayOfaeic)
  {
    aeli localaeli = new aeli();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramArrayOfaeic.length) {
          break label187;
        }
        String str = paramArrayOfaeic[i].content;
        if (TextUtils.isEmpty(str))
        {
          QLog.d("OpenSdkConfProcessor", 1, "parse, content empty");
        }
        else
        {
          JSONObject localJSONObject = new JSONObject(str);
          if (localJSONObject.has("enable_third_app_share_big_image_by_server"))
          {
            if (localJSONObject.optInt("enable_third_app_share_big_image_by_server", 0) == 1)
            {
              bool = true;
              localaeli.bUV = bool;
            }
          }
          else
          {
            if (localJSONObject.has("sdk_share_verify_appinfo_timeout_duration")) {
              localaeli.Wj = localJSONObject.optInt("sdk_share_verify_appinfo_timeout_duration", 0);
            }
            if (localJSONObject.has("sdk_login_use_third_transform_pkg_name"))
            {
              if (localJSONObject.optInt("sdk_login_use_third_transform_pkg_name", 0) != 1) {
                break label182;
              }
              bool = true;
              localaeli.bUW = bool;
            }
            localStringBuilder.append("config: ").append(str).append(",");
          }
        }
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.e("OpenSdkConfProcessor", 1, "parse, failed!", paramArrayOfaeic);
        return null;
      }
      boolean bool = false;
      continue;
      label182:
      bool = false;
      continue;
      label187:
      QLog.d("OpenSdkConfProcessor", 1, "parse, content:" + localStringBuilder.toString());
      return localaeli;
      i += 1;
    }
  }
  
  public boolean ahe()
  {
    return this.bUV;
  }
  
  public boolean ahf()
  {
    return this.bUW;
  }
  
  public long fu()
  {
    return this.Wj;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("serverShareImageEnable:").append(this.bUV);
    localStringBuilder.append("timeout_duration:").append(this.Wj);
    localStringBuilder.append("useThirdTransformPkgName:").append(this.bUW);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeli
 * JD-Core Version:    0.7.0.1
 */