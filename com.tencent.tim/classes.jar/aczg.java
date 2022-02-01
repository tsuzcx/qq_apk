import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.3.1;
import com.tencent.mobileqq.app.soso.SosoInterface.3.2;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public final class aczg
  implements TencentLocationListener
{
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramTencentLocation == null) {}
    int k;
    do
    {
      return;
      k = paramTencentLocation.getExtra().getInt("qq_level");
      if ((3 != k) || (paramInt != 0)) {
        break label202;
      }
      if (!TextUtils.isEmpty(paramTencentLocation.getCityCode())) {
        break;
      }
      SosoInterface.access$602(SosoInterface.access$600() + 1);
      if (SosoInterface.access$600() >= 12)
      {
        paramTencentLocation = new HashMap();
        paramTencentLocation.put("level_3_no_citycode", String.valueOf(SosoInterface.access$600()));
        paramString = afem.getCurrentUin();
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "actSoSoNoCityCodeTimeout", true, 0L, 0L, paramTencentLocation, "");
      }
    } while (!QLog.isColorLevel());
    QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null");
    return;
    Object localObject1;
    Object localObject2;
    if (SosoInterface.access$600() > 0)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("level_3_no_citycode", String.valueOf(SosoInterface.access$600()));
      localObject2 = afem.getCurrentUin();
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance((String)localObject2, "actSoSoNoCityCode", true, 0L, 0L, (HashMap)localObject1, "");
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null, count : " + SosoInterface.access$600());
      }
    }
    label202:
    SosoInterface.access$602(0);
    SosoInterface.access$200().removeMessages(1001);
    boolean bool2;
    long l;
    String str;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    Object localObject5;
    label346:
    Object localObject3;
    label385:
    int i;
    label447:
    label504:
    int m;
    TencentLocation localTencentLocation;
    Object localObject8;
    Object localObject6;
    Object localObject7;
    Object localObject4;
    Object localObject9;
    if (paramInt == 0)
    {
      bool2 = true;
      SosoInterface.dh(paramInt);
      l = SystemClock.elapsedRealtime() - SosoInterface.fi() - SosoInterface.access$900();
      SosoInterface.M(SystemClock.elapsedRealtime());
      SosoInterface.access$902(SosoInterface.cAD);
      str = paramTencentLocation.getExtra().getString("qq_caller");
      localObject2 = paramTencentLocation.getExtra().getString("qq_caller_route");
      bool1 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
      bool3 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      bool4 = paramTencentLocation.getExtra().getBoolean("qq_allowGps");
      localObject5 = TencentExtraKeys.getRawData(paramTencentLocation);
      SosoInterface.Kr(paramInt);
      if (bool3)
      {
        if (!bool2) {
          break label934;
        }
        SosoInterface.gL(0);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("onLocationChanged() err=").append(paramInt);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label941;
        }
        localObject1 = "";
        localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append(" caller=").append(str).append(" level=").append(k).append(" reqLocation=").append(bool3).append(" consume=").append(l).append(" rawData=");
        if (localObject5 != null) {
          break label966;
        }
        i = 0;
        localObject1 = ((StringBuilder)localObject1).append(i).append(" isGoonCallback=").append(bool1).append(" failInt=").append(SosoInterface.access$1100()).append(" caller rote: ").append((String)localObject2).append(" verify key length:");
        if (paramTencentLocation.getVerifyKey() != null) {
          break label974;
        }
        i = 0;
        QLog.d("SOSO.LBS", 2, i + " source:" + paramTencentLocation.getSourceProvider() + " adcode :" + paramTencentLocation.getCityCode() + " lon*lat :" + (int)(paramTencentLocation.getLongitude() * paramTencentLocation.getLatitude()));
      }
      m = 0;
      bool1 = false;
      localTencentLocation = null;
      localObject8 = null;
      localObject6 = null;
      localObject1 = null;
      localObject7 = null;
      localObject3 = null;
      localObject4 = null;
      localObject2 = null;
      localObject9 = SosoInterface.z();
      if ((paramInt == 0) && (!bool3)) {}
    }
    int j;
    for (;;)
    {
      try
      {
        SosoInterface.b(k, paramTencentLocation, str);
        if ((localObject5 != null) && (localObject5.length > 0)) {
          SosoInterface.i(paramTencentLocation.getProvider(), (byte[])localObject5);
        }
        if (SosoInterface.cJ().size() <= 0) {
          break label1411;
        }
        if (bool3)
        {
          localObject5 = SosoInterface.a(k, true);
          j = SosoInterface.cJ().size() - 1;
          paramTencentLocation = localObject8;
          localObject4 = localObject2;
          localObject7 = localObject3;
          localObject6 = localObject1;
          localTencentLocation = paramTencentLocation;
          m = bool1;
          if (j < 0) {
            break label1411;
          }
          localObject4 = (SosoInterface.a)SosoInterface.cJ().get(j);
          if ((((SosoInterface.a)localObject4).reqLocation == bool3) && ((!((SosoInterface.a)localObject4).reqLocation) || (((SosoInterface.a)localObject4).level <= k)))
          {
            if (!((SosoInterface.a)localObject4).uiThread) {
              continue;
            }
            SosoInterface.b((SosoInterface.a)localObject4, paramInt, (SosoInterface.SosoLbsInfo)localObject5);
            if (!TextUtils.isEmpty(str)) {
              break label1014;
            }
            i = 0;
            label774:
            if (i == 0) {
              break label1033;
            }
            SosoInterface.b(bool2, bool3, l, paramInt, str, paramString, bool4, k, true);
            if (!((SosoInterface.a)localObject4).goonListener) {
              break label1054;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.a)localObject4).tag + " goon...");
            }
          }
          if (SosoInterface.a.access$1500((SosoInterface.a)localObject4)) {
            break label1820;
          }
          if (!((SosoInterface.a)localObject4).goonListener) {
            break label1135;
          }
          if (localObject3 != null) {
            break label1115;
          }
          localObject3 = localObject4;
          label872:
          if (!SosoInterface.a.access$1600((SosoInterface.a)localObject4)) {
            break label1814;
          }
          localObject2 = localObject4;
          label884:
          if (SosoInterface.access$1100() <= 0) {
            break label1801;
          }
          ((SosoInterface.a)localObject4).onConsecutiveFailure(paramInt, SosoInterface.access$1100());
          localObject4 = localObject1;
          localObject1 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject4;
          label909:
          j -= 1;
          localObject4 = localObject1;
          localObject1 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject4;
          continue;
          bool2 = false;
          break;
          label934:
          SosoInterface.Bo();
          break label346;
          label941:
          localObject1 = " reason=" + paramString;
          break label385;
          label966:
          i = localObject5.length;
          break label447;
          label974:
          i = paramTencentLocation.getVerifyKey().length();
          break label504;
        }
        localObject5 = SosoInterface.a(true);
        continue;
        ((SosoInterface.a)localObject4).onLocationFinish(paramInt, (SosoInterface.SosoLbsInfo)localObject5);
        continue;
        if (str.equals(((SosoInterface.a)localObject4).tag)) {
          break label1833;
        }
      }
      finally {}
      label1014:
      i = 1;
      continue;
      label1033:
      SosoInterface.b(bool2, bool3, l, paramInt, str, paramString, bool4, k, false);
      continue;
      label1054:
      SosoInterface.cJ().remove(j);
      SosoInterface.a.access$1502((SosoInterface.a)localObject4, true);
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.a)localObject4).tag + " removed normally.");
        continue;
        label1115:
        if (((SosoInterface.a)localObject3).level >= ((SosoInterface.a)localObject4).level) {
          break label1817;
        }
        localObject3 = localObject4;
      }
    }
    label1135:
    if (SystemClock.elapsedRealtime() - ((SosoInterface.a)localObject4).sTime > 30000L)
    {
      SosoInterface.cJ().remove(j);
      SosoInterface.a.access$1502((SosoInterface.a)localObject4, true);
      if (((SosoInterface.a)localObject4).reqLocation)
      {
        localObject6 = SosoInterface.a(((SosoInterface.a)localObject4).level, true);
        break label1839;
        ((SosoInterface.a)localObject4).onLocationFinish(i, (SosoInterface.SosoLbsInfo)localObject6);
        if (!QLog.isColorLevel()) {
          break label1852;
        }
        QLog.d("SOSO.LBS", 2, "lis=" + ((SosoInterface.a)localObject4).tag + " err_timeout.reqRaw=" + ((SosoInterface.a)localObject4).reqLocation + ". Force 2 remove it.");
        break label1852;
      }
      else
      {
        localObject6 = SosoInterface.a(true);
      }
    }
    else if (((SosoInterface.a)localObject4).reqLocation)
    {
      if (localObject1 == null)
      {
        localObject6 = localObject4;
        localObject1 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject6;
      }
    }
    for (;;)
    {
      label1189:
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.a)localObject4).tag + " goon=" + ((SosoInterface.a)localObject4).goonListener + " reqLocation=" + ((SosoInterface.a)localObject4).reqLocation + " hasReqRaw=" + bool1);
        break label1871;
        if (((SosoInterface.a)localObject1).level < ((SosoInterface.a)localObject4).level)
        {
          localObject1 = localObject4;
          localObject6 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject1;
          localObject1 = localObject6;
          continue;
          if (paramTencentLocation == null) {
            break label1874;
          }
          if (!((SosoInterface.a)localObject4).askGPS) {
            break label1877;
          }
          break label1874;
          if (SosoInterface.cJ().size() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SOSO.LBS", 4, "listener is empty.");
            }
            SosoInterface.access$100();
            return;
          }
          if (m != 0)
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("onLocationChanged()");
              if (localObject7 != null) {
                break label1544;
              }
            }
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + localObject7.tag)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:reqRawData");
              if (localObject4 != null) {
                SosoInterface.a.access$1602((SosoInterface.a)localObject4, false);
              }
              if (localTencentLocation != null)
              {
                SosoInterface.a().tag = localTencentLocation.tag;
                SosoInterface.a().askGPS = localTencentLocation.askGPS;
              }
              SosoInterface.access$100();
              SosoInterface.a(SosoInterface.a());
              return;
            }
          }
          if (localObject6 != null)
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("onLocationChanged()");
              if (localObject7 != null) {
                break label1660;
              }
            }
            label1660:
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + localObject7.tag)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:" + ((SosoInterface.a)localObject6).tag);
              if (localObject4 != null) {
                SosoInterface.a.access$1602((SosoInterface.a)localObject4, false);
              }
              SosoInterface.access$100();
              ((SosoInterface.a)localObject6).maxCacheInterval = 0L;
              SosoInterface.a((SosoInterface.a)localObject6);
              return;
            }
          }
          if (localObject7 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "onLocationChanged() goonLis goon after 1000ms:" + localObject7.tag);
          }
          if ((localObject4 != null) && (localObject4 != localObject7)) {
            SosoInterface.a.access$1602((SosoInterface.a)localObject4, false);
          }
          if ((SosoInterface.a.access$1600(localObject7)) || (SosoInterface.a.access$1500(localObject7))) {
            break;
          }
          SosoInterface.access$100();
          ThreadManager.getSubThreadHandler().postDelayed(new SosoInterface.3.2(this, localObject7), 2000L);
          return;
        }
        localObject6 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject6;
        continue;
        localObject4 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject4;
        break label909;
        break label884;
        break label872;
        localObject4 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject4;
        break label909;
        label1833:
        i = 0;
        break label774;
        label1839:
        if (localObject6 == null)
        {
          i = -10000;
          break label1189;
          label1852:
          localObject4 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject1;
          localObject1 = localObject4;
          break label909;
        }
        i = 0;
        break label1189;
      }
      label1411:
      label1544:
      label1801:
      label1814:
      label1817:
      label1820:
      label1871:
      break label909;
      label1874:
      paramTencentLocation = (TencentLocation)localObject4;
      label1877:
      localObject6 = paramTencentLocation;
      bool1 = true;
      paramTencentLocation = (TencentLocation)localObject1;
      localObject1 = localObject6;
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onStatusUpdate name: " + paramString1 + " status: " + paramInt + " desc: " + paramString2);
    }
    for (;;)
    {
      int i;
      SosoInterface.a locala;
      synchronized (SosoInterface.z())
      {
        if (SosoInterface.cJ().isEmpty()) {
          return;
        }
        i = SosoInterface.cJ().size() - 1;
        if (i < 0) {
          break label157;
        }
        locala = (SosoInterface.a)SosoInterface.cJ().get(i);
        if (locala == null) {
          break label161;
        }
        if (locala.uiThread) {
          ThreadManager.getUIHandler().post(new SosoInterface.3.1(this, locala, paramString1, paramInt, paramString2));
        }
      }
      locala.onStatusUpdate(paramString1, paramInt, paramString2);
      break label161;
      label157:
      return;
      label161:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczg
 * JD-Core Version:    0.7.0.1
 */