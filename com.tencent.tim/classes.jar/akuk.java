import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class akuk
  extends SosoInterface.a
{
  private WeakReference<akuk.a> e;
  private Intent mIntent;
  private int mType;
  
  public akuk(int paramInt, Intent paramIntent, akuk.a parama)
  {
    super(4, true, true, 60000L, false, false, "QQSettingRedesign");
    this.mType = paramInt;
    this.mIntent = paramIntent;
    this.e = new WeakReference(parama);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d3 = 0.0D;
    long l = System.currentTimeMillis();
    Object localObject;
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null) && (paramSosoLbsInfo.a.address != null))
    {
      localObject = paramSosoLbsInfo.a.address;
      if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
        break label301;
      }
    }
    label301:
    for (double d1 = paramSosoLbsInfo.a.cd;; d1 = 0.0D)
    {
      double d2 = d3;
      if (paramSosoLbsInfo != null)
      {
        d2 = d3;
        if (paramSosoLbsInfo.a != null) {
          d2 = paramSosoLbsInfo.a.ce;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatus", 2, "onLocationFinish() latitude=" + d1 + " longitude=" + d2 + ", address=" + (String)localObject);
      }
      paramSosoLbsInfo = String.format("/ws/geocoder/v1/?get_poi=0&key=%s&location=%s,%s", new Object[] { "7B5BZ-MNDHR-SKFWQ-WAXND-2P45Z-4FFNM", String.valueOf(d1), String.valueOf(d2) });
      localObject = MD5.toMD5(paramSosoLbsInfo + "MaZnPqbKJxWQLLVDEGMXiYarddkxX2Wl").toLowerCase();
      paramSosoLbsInfo = "https://apis.map.qq.com" + paramSosoLbsInfo + "&sig=" + (String)localObject;
      localObject = new HashMap();
      ((HashMap)localObject).put("BUNDLE", new Bundle());
      ((HashMap)localObject).put("CONTEXT", BaseApplicationImpl.getApplication().getApplicationContext());
      new aprc(paramSosoLbsInfo, "GET", new akul(this, d1, d2, l), 1000, null).J((HashMap)localObject);
      return;
      localObject = "";
      break;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(JSONObject paramJSONObject, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, Intent paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akuk
 * JD-Core Version:    0.7.0.1
 */