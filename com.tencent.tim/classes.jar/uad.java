import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class uad
  extends tzh
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      SosoInterface.a(new uad.c(paramtzd, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
    for (;;)
    {
      return true;
      SosoInterface.a(new uad.b(paramtzd, paramJSONObject.optInt("allowCacheTime", 10) * 1000L));
    }
  }
  
  static abstract class a
    extends SosoInterface.a
  {
    tzd c;
    boolean mIsActive;
    long mStartRequestTime;
    long rj;
    
    public a(tzd paramtzd, int paramInt, long paramLong)
    {
      super(true, true, paramLong, true, false, "Doraemon");
      this.c = paramtzd;
      this.rj = 10000L;
      this.mStartRequestTime = System.currentTimeMillis();
      this.mIsActive = true;
    }
    
    public void onConsecutiveFailure(int paramInt1, int paramInt2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.sensor.location", 2, "onConsecutiveFailure: errCode=" + paramInt1 + ", failCount=" + paramInt2);
      }
      if ((paramInt2 * 2000 < this.rj) || (!this.mIsActive)) {
        return;
      }
      this.mIsActive = false;
      ubu.a(this.c, paramInt1, "error " + paramInt1);
      Long.toString(System.currentTimeMillis() - this.mStartRequestTime);
      SosoInterface.c(this);
    }
  }
  
  static class b
    extends uad.a
  {
    public b(tzd paramtzd, long paramLong)
    {
      super(3, paramLong);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.mIsActive);
      }
      if (!this.mIsActive) {
        return;
      }
      this.mIsActive = false;
      if (paramInt == 0)
      {
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("nation", paramSosoLbsInfo.a.nation);
          localJSONObject.put("province", paramSosoLbsInfo.a.province);
          localJSONObject.put("city", paramSosoLbsInfo.a.city);
          localJSONObject.put("district", paramSosoLbsInfo.a.district);
          ubu.a(this.c, localJSONObject);
          return;
        }
        catch (JSONException paramSosoLbsInfo)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("DoraemonOpenAPI.sensor", 2, paramSosoLbsInfo.getMessage(), paramSosoLbsInfo);
            }
          }
        }
      }
      ubu.a(this.c, paramInt, "error " + paramInt);
    }
  }
  
  static class c
    extends uad.a
  {
    public c(tzd paramtzd, long paramLong)
    {
      super(0, paramLong);
    }
    
    public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.sensor.location", 2, "onLocationFinish: errCode=" + paramInt + ", info=" + paramSosoLbsInfo + ", isActive=" + this.mIsActive);
      }
      if (!this.mIsActive) {
        return;
      }
      this.mIsActive = false;
      if (paramInt == 0)
      {
        double d1 = paramSosoLbsInfo.a.cd;
        double d2 = paramSosoLbsInfo.a.ce;
        double d3 = paramSosoLbsInfo.a.speed;
        double d4 = paramSosoLbsInfo.a.accuracy;
        double d5 = paramSosoLbsInfo.a.altitude;
        paramSosoLbsInfo = new JSONObject();
        try
        {
          paramSosoLbsInfo.put("latitude", d1);
          paramSosoLbsInfo.put("longitude", d2);
          paramSosoLbsInfo.put("speed", d3);
          paramSosoLbsInfo.put("accuracy", d4);
          paramSosoLbsInfo.put("altitude", d5);
          paramSosoLbsInfo.put("verticalAccuracy", 0.0D);
          paramSosoLbsInfo.put("horizontalAccuracy", d4);
          ubu.a(this.c, paramSosoLbsInfo);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("DoraemonOpenAPI.sensor", 2, localJSONException.getMessage(), localJSONException);
            }
          }
        }
      }
      ubu.a(this.c, paramInt, "error " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */