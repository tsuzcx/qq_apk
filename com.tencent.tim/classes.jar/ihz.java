import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.app.DeviceCapabilityExamination;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.videoeffect.VideoEffectTest.a;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ihz
  implements VideoEffectTest.a
{
  public ihz(DeviceCapabilityExamination paramDeviceCapabilityExamination) {}
  
  public void b(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (AudioHelper.aCz()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed onFinish result: " + paramInt + ", timeConsuming: " + paramLong + ", gpuVendor: " + paramString1 + ", gpuModel: " + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpu", Build.HARDWARE);
    localHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("manufacturer", Build.MANUFACTURER);
    localHashMap.put("model", Build.MODEL);
    localHashMap.put("product", Build.PRODUCT);
    localHashMap.put("fingerprint", Build.FINGERPRINT);
    localHashMap.put("gpu_vendor", paramString1);
    localHashMap.put("gpu_model", paramString2);
    localHashMap.put("result", String.valueOf(paramInt));
    localHashMap.put("time_consuming", String.valueOf(paramLong));
    if (AudioHelper.aCz()) {
      QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed reportByRoomId " + localHashMap);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(this.a.mApp.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihz
 * JD-Core Version:    0.7.0.1
 */