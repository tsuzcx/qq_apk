import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.5.1;
import com.tencent.mobileqq.identification.IdentificationPoseReflect.5.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitFrameworkEventListener;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYtSDKKitNetResponseParser;
import java.util.HashMap;
import org.json.JSONObject;

public class aiax
  implements YtSDKKitFramework.IYtSDKKitFrameworkEventListener
{
  aiax(aiav paramaiav) {}
  
  public void onFrameworkEvent(HashMap<String, Object> paramHashMap)
  {
    aiav.a(this.this$0, new IdentificationPoseReflect.5.1(this, paramHashMap));
  }
  
  public void onNetworkRequestEvent(String paramString1, String paramString2, HashMap<String, String> paramHashMap, YtSDKKitFramework.IYtSDKKitNetResponseParser paramIYtSDKKitNetResponseParser)
  {
    paramHashMap = aibb.a().h(5);
    if (paramHashMap == null) {
      QLog.e("qq_Identification.Model", 1, "post face data error : config is empty");
    }
    do
    {
      return;
      paramHashMap = paramHashMap.optString("result_api_url", "");
      if (TextUtils.isEmpty(paramHashMap))
      {
        QLog.e("qq_Identification.Model", 1, "post face data error : config url is empty");
        return;
      }
    } while (!paramHashMap.equals(paramString1));
    QLog.d("qq_Identification.Model", 1, "start upload face data");
    if (this.this$0.a == null) {
      this.this$0.a = new aiah(aiav.a(this.this$0), paramString2, this.this$0.b);
    }
    for (;;)
    {
      aiav.a(this.this$0, new IdentificationPoseReflect.5.2(this));
      if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getApplication())) {
        break;
      }
      ((aiah)this.this$0.a).drK();
      return;
      ((aiah)this.this$0.a).KT(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiax
 * JD-Core Version:    0.7.0.1
 */