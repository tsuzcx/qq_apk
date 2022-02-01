import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

class aweb
  extends aczc.b
  implements awdw
{
  private static ConcurrentHashMap<String, aweb> ag = new ConcurrentHashMap();
  private static long hl;
  private static Object lock = new Object();
  private String mBusinessId;
  private Handler mHandler;
  
  private aweb(String paramString)
  {
    super(paramString, false);
    this.mBusinessId = paramString;
  }
  
  public static aweb a(String paramString)
  {
    Object localObject1 = (aweb)ag.get(paramString);
    if (localObject1 == null) {
      synchronized (lock)
      {
        aweb localaweb = (aweb)ag.get(paramString);
        localObject1 = localaweb;
        if (localaweb == null)
        {
          localObject1 = new aweb(paramString);
          ag.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public static LbsDataV2.GpsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.accuracy);
    localGpsInfo.alt = ((int)paramSosoLocation.altitude);
    if ((paramSosoLocation.cg == 0.0D) && (paramSosoLocation.cf == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.cd * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.ce * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.cf * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.cg * 1000000.0D));
    return localGpsInfo;
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("QzoneNewLiveInitLocation.NewLbsInterface", 1, "[QZLIVE_LBS_MODULE]----Info");
    long l1 = System.currentTimeMillis();
    long l2 = hl;
    avzj.j(paramInt, this.mBusinessId, l1 - l2);
    if (this.mHandler == null) {
      return;
    }
    Message localMessage = this.mHandler.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_initlocation_success", false);
    if (paramInt == 0)
    {
      SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if ((localSosoLocation != null) && (paramSosoLbsInfo != null) && (!TextUtils.isEmpty(localSosoLocation.city)) && (!localSosoLocation.city.equalsIgnoreCase("unknown")))
      {
        localBundle.putBoolean("key_initlocation_success", true);
        localBundle.putString("key_select_poi_name", localSosoLocation.city.trim());
        localBundle.putString("key_select_poi_default_name", localSosoLocation.name);
        localBundle.putInt("key_select_latitude", paramSosoLbsInfo.lat);
        localBundle.putInt("key_select_longtitude", paramSosoLbsInfo.lon);
        localBundle.putInt("key_select_altitude", paramSosoLbsInfo.alt);
        localBundle.putInt("key_select_gpstype", paramSosoLbsInfo.gpsType);
        QLog.i("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]#onGetDeviceData succeed! just location--->" + paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localMessage.obj = localBundle;
      this.mHandler.sendMessage(localMessage);
      return;
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]location failed: error in force gps info update..");
    }
  }
  
  public void v(Handler paramHandler)
  {
    this.mHandler = paramHandler;
    try
    {
      hl = System.currentTimeMillis();
      aczc.a(this);
      return;
    }
    catch (Exception paramHandler)
    {
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]exception ", paramHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aweb
 * JD-Core Version:    0.7.0.1
 */