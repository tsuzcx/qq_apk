import android.os.Build;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.JsonUploadRunnable;
import com.tencent.mfsdk.reporter.QCloudFileUploadRunnable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class tyw
  implements tyv
{
  private static final String aKa = "https://sngapm.qq.com/entrance/%d/uploadFile/" + MagnifierSDK.getProductId();
  private static final String aKb = "https://sngapm.qq.com/entrance/%d/uploadJson/" + MagnifierSDK.getProductId();
  private MqqHandler b;
  
  public tyw(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.b = new MqqHandler(paramHandlerThread.getLooper());
    }
  }
  
  public boolean a(ResultObject paramResultObject, tyv.a parama)
  {
    if (this.b == null) {
      return false;
    }
    JSONObject localJSONObject = paramResultObject.params;
    Object localObject3 = localJSONObject.optJSONObject("fileObj");
    Object localObject1 = localJSONObject.optJSONObject("clientinfo");
    int i;
    String str1;
    for (;;)
    {
      try
      {
        if (localJSONObject.has("newplugin"))
        {
          i = localJSONObject.getInt("newplugin");
          localObject2 = ((JSONObject)localObject1).keys();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          str1 = (String)((Iterator)localObject2).next();
          localJSONObject.put(str1, ((JSONObject)localObject1).getString(str1));
          continue;
        }
        i = ((JSONObject)localObject1).getInt("plugin");
      }
      catch (Throwable paramResultObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Magnifier_QCloudReporter", 2, "[qcloud_report] exception: ", paramResultObject);
        }
        return false;
      }
    }
    localJSONObject.put("version", MagnifierSDK.version);
    localJSONObject.put("manu", Build.BRAND);
    localJSONObject.put("device", Build.MODEL);
    Object localObject2 = ((JSONObject)localObject1).getString("rdmuuid");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "0";
    }
    localJSONObject.put("rdmuuid", localObject1);
    localJSONObject.put("api_ver", 1);
    localJSONObject.put("plugin_ver", 1);
    localJSONObject.put("client_identify", UUID.randomUUID());
    localJSONObject.put("platform", "android");
    localJSONObject.put("plugin", i);
    localJSONObject.remove("clientinfo");
    localObject1 = new StringBuffer(1024);
    if (localObject3 != null)
    {
      localObject2 = ((JSONObject)localObject3).getString("fileObj1");
      localJSONObject.put("fileObj", localObject2);
      localObject3 = localJSONObject.keys();
      str1 = (String)((Iterator)localObject3).next();
      String str2 = localJSONObject.getString(str1);
      ((StringBuffer)localObject1).append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      while (((Iterator)localObject3).hasNext())
      {
        str1 = (String)((Iterator)localObject3).next();
        str2 = localJSONObject.getString(str1);
        ((StringBuffer)localObject1).append("&").append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      }
      ((StringBuffer)localObject1).append("&a=1");
      localObject1 = aKa + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] file url: " + (String)localObject1);
      }
      paramResultObject = new QCloudFileUploadRunnable(new URL((String)localObject1), (String)localObject2, localJSONObject, parama, paramResultObject.dbId, this.b);
      this.b.post(paramResultObject);
    }
    else
    {
      ((StringBuffer)localObject1).append("p_id=").append(localJSONObject.getString("p_id")).append("&plugin=").append(i);
      ((StringBuffer)localObject1).append("&version=").append(URLEncoder.encode(MagnifierSDK.version, "UTF-8")).append("&a=1");
      localObject1 = aKb + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] json url: " + (String)localObject1 + " jsonObj: " + localJSONObject.toString());
      }
      paramResultObject = new JsonUploadRunnable(new URL((String)localObject1), localJSONObject, parama, paramResultObject.dbId, this.b);
      this.b.post(paramResultObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tyw
 * JD-Core Version:    0.7.0.1
 */