import android.text.TextUtils;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSReportTo1160;
import com.tencent.qphone.base.util.QLog;

public class lvu
  implements PTSNativeModuleRegistry.IPTSReportTo1160
{
  public final String TAG = "PTSReportTo1160Module";
  
  public void reportTo1160(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3, String paramString4)
  {
    QLog.i("PTSReportTo1160Module", 1, "[reportTo1160], event = " + paramString1 + ", toUin = " + paramString2 + ", r2 = " + paramLong + ", r3 = " + paramInt + ", r4 = " + paramString3 + ", r5 = " + paramString4);
    if (!TextUtils.isEmpty(paramString1)) {
      lwc.f(paramString1, "" + paramLong, "" + paramInt, paramString3, new lwc.a(paramString4).build());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvu
 * JD-Core Version:    0.7.0.1
 */