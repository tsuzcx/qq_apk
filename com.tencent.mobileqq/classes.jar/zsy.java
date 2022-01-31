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
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public final class zsy
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
      if (3 != k) {
        break label198;
      }
      if (!TextUtils.isEmpty(paramTencentLocation.getCityCode())) {
        break;
      }
      SosoInterface.a(SosoInterface.a() + 1);
      if (SosoInterface.a() >= 12)
      {
        paramTencentLocation = new HashMap();
        paramTencentLocation.put("level_3_no_citycode", String.valueOf(SosoInterface.a()));
        paramString = EarlyDownloadManager.a();
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "actSoSoNoCityCodeTimeout", true, 0L, 0L, paramTencentLocation, "");
      }
    } while (!QLog.isColorLevel());
    QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null");
    return;
    Object localObject1;
    Object localObject2;
    if (SosoInterface.a() > 0)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("level_3_no_citycode", String.valueOf(SosoInterface.a()));
      localObject2 = EarlyDownloadManager.a();
      StatisticCollector.a(BaseApplicationImpl.getContext()).a((String)localObject2, "actSoSoNoCityCode", true, 0L, 0L, (HashMap)localObject1, "");
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS", 2, "onLocationChanged level is 3, adcode is null, count : " + SosoInterface.a());
      }
    }
    label198:
    SosoInterface.a(0);
    SosoInterface.a(true);
    SosoInterface.a().removeMessages(1001);
    boolean bool2;
    long l;
    String str1;
    String str2;
    boolean bool1;
    boolean bool3;
    boolean bool4;
    Object localObject5;
    label342:
    label381:
    int i;
    label452:
    label509:
    int m;
    TencentLocation localTencentLocation;
    Object localObject8;
    Object localObject6;
    Object localObject7;
    Object localObject3;
    Object localObject4;
    Object localObject9;
    if (paramInt == 0)
    {
      bool2 = true;
      com.tencent.mobileqq.app.NearbyHandler.jdField_a_of_type_Int = paramInt;
      l = SystemClock.elapsedRealtime() - SosoInterface.a() - SosoInterface.b();
      SosoInterface.a(SystemClock.elapsedRealtime());
      SosoInterface.b(SosoInterface.jdField_a_of_type_Int);
      str1 = paramTencentLocation.getExtra().getString("qq_caller");
      str2 = paramTencentLocation.getExtra().getString("qq_caller_route");
      bool1 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
      bool3 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      bool4 = paramTencentLocation.getExtra().getBoolean("qq_allowGps");
      localObject5 = TencentExtraKeys.getRawData(paramTencentLocation);
      if (bool3)
      {
        if (!bool2) {
          break label956;
        }
        SosoInterface.c(0);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("onLocationChanged() err=").append(paramInt);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label963;
        }
        localObject1 = "";
        localObject1 = ((StringBuilder)localObject2).append((String)localObject1).append(" detail=").append(paramInt).append(" caller=").append(str1).append(" level=").append(k).append(" reqLocation=").append(bool3).append(" consume=").append(l).append(" rawData=");
        if (localObject5 != null) {
          break label988;
        }
        i = 0;
        localObject1 = ((StringBuilder)localObject1).append(i).append(" isGoonCallback=").append(bool1).append(" failInt=").append(SosoInterface.d()).append(" caller rote: ").append(str2).append(" verify key length:");
        if (paramTencentLocation.getVerifyKey() != null) {
          break label996;
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
      localObject9 = SosoInterface.jdField_a_of_type_JavaLangObject;
      if ((paramInt == 0) && (!bool3)) {}
    }
    int j;
    for (;;)
    {
      try
      {
        SosoInterface.a(k, paramTencentLocation, str1);
        if ((localObject5 != null) && (localObject5.length > 0)) {
          SosoInterface.a(paramTencentLocation.getProvider(), (byte[])localObject5);
        }
        if (SosoInterface.a().size() <= 0) {
          break label1461;
        }
        if (bool3)
        {
          localObject5 = SosoInterface.b();
          j = SosoInterface.a().size() - 1;
          paramTencentLocation = localObject8;
          localObject4 = localObject2;
          localObject7 = localObject3;
          localObject6 = localObject1;
          localTencentLocation = paramTencentLocation;
          m = bool1;
          if (j < 0) {
            break label1461;
          }
          localObject4 = (SosoInterface.OnLocationListener)SosoInterface.a().get(j);
          if (((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean == bool3) {
            if (((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean)
            {
              if (((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_Int != 1) {
                continue;
              }
              if (((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_Int != k) {}
            }
            else
            {
              if (!((SosoInterface.OnLocationListener)localObject4).jdField_e_of_type_Boolean) {
                continue;
              }
              SosoInterface.a((SosoInterface.OnLocationListener)localObject4, paramInt, (SosoInterface.SosoLbsInfo)localObject5);
              if (!TextUtils.isEmpty(str1)) {
                break label1048;
              }
              i = 0;
              label785:
              if (i == 0) {
                break label1067;
              }
              SosoInterface.a(bool2, bool3, l, paramInt, paramInt, str1, paramString, str2, bool4, k, true, ((SosoInterface.OnLocationListener)localObject4).jdField_e_of_type_Long, 0L, 0L, 0L);
              if (!((SosoInterface.OnLocationListener)localObject4).jdField_f_of_type_Boolean) {
                break label1111;
              }
              if (QLog.isColorLevel()) {
                QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_JavaLangString + " goon...");
              }
            }
          }
          if (SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4)) {
            break label1870;
          }
          if (!((SosoInterface.OnLocationListener)localObject4).jdField_f_of_type_Boolean) {
            break label1192;
          }
          if (localObject3 != null) {
            break label1172;
          }
          localObject3 = localObject4;
          label894:
          if (!SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4)) {
            break label1864;
          }
          localObject2 = localObject4;
          label906:
          if (SosoInterface.d() <= 0) {
            break label1851;
          }
          ((SosoInterface.OnLocationListener)localObject4).a(paramInt, SosoInterface.d());
          localObject4 = localObject1;
          localObject1 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject4;
          label931:
          j -= 1;
          localObject4 = localObject1;
          localObject1 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject4;
          continue;
          bool2 = false;
          break;
          label956:
          SosoInterface.c();
          break label342;
          label963:
          localObject1 = " reason=" + paramString;
          break label381;
          label988:
          i = localObject5.length;
          break label452;
          label996:
          i = paramTencentLocation.getVerifyKey().length();
          break label509;
        }
        localObject5 = SosoInterface.a();
        continue;
        if (((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_Int > k) {
          continue;
        }
        continue;
        ((SosoInterface.OnLocationListener)localObject4).a(paramInt, (SosoInterface.SosoLbsInfo)localObject5);
        continue;
        if (str1.equals(((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_JavaLangString)) {
          break label1883;
        }
      }
      finally {}
      label1048:
      i = 1;
      continue;
      label1067:
      SosoInterface.a(bool2, bool3, l, paramInt, paramInt, str1, paramString, str2, bool4, k, false, ((SosoInterface.OnLocationListener)localObject4).jdField_e_of_type_Long, ((SosoInterface.OnLocationListener)localObject4).jdField_f_of_type_Long, ((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Long, ((SosoInterface.OnLocationListener)localObject4).jdField_h_of_type_Long);
      continue;
      label1111:
      SosoInterface.a().remove(j);
      SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4, true);
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_JavaLangString + " removed normally.");
        continue;
        label1172:
        if (localObject3.jdField_c_of_type_Int >= ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_Int) {
          break label1867;
        }
        localObject3 = localObject4;
      }
    }
    label1192:
    if (SystemClock.elapsedRealtime() - ((SosoInterface.OnLocationListener)localObject4).d > 30000L)
    {
      SosoInterface.a().remove(j);
      SosoInterface.OnLocationListener.a((SosoInterface.OnLocationListener)localObject4, true);
      if (((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean)
      {
        localObject6 = SosoInterface.b();
        break label1889;
        label1240:
        ((SosoInterface.OnLocationListener)localObject4).a(i, (SosoInterface.SosoLbsInfo)localObject6);
        if (!QLog.isColorLevel()) {
          break label1902;
        }
        QLog.d("SOSO.LBS", 2, "lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_JavaLangString + " err_timeout.reqRaw=" + ((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean + ". Force 2 remove it.");
        break label1902;
      }
      else
      {
        localObject6 = SosoInterface.a();
      }
    }
    else if (((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean)
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
      if (QLog.isColorLevel())
      {
        QLog.d("SOSO.LBS", 2, "onLocationChanged() lis=" + ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_JavaLangString + " goon=" + ((SosoInterface.OnLocationListener)localObject4).jdField_f_of_type_Boolean + " reqLocation=" + ((SosoInterface.OnLocationListener)localObject4).jdField_g_of_type_Boolean + " hasReqRaw=" + bool1);
        break label1921;
        if (((SosoInterface.OnLocationListener)localObject1).jdField_c_of_type_Int < ((SosoInterface.OnLocationListener)localObject4).jdField_c_of_type_Int)
        {
          localObject1 = localObject4;
          localObject6 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject1;
          localObject1 = localObject6;
          continue;
          if (paramTencentLocation == null) {
            break label1924;
          }
          if (!((SosoInterface.OnLocationListener)localObject4).jdField_h_of_type_Boolean) {
            break label1927;
          }
          break label1924;
          label1461:
          if (SosoInterface.a().size() == 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SOSO.LBS", 4, "listener is empty.");
            }
            SosoInterface.c();
            return;
          }
          if (m != 0)
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder().append("onLocationChanged()");
              if (localObject7 != null) {
                break label1594;
              }
            }
            label1594:
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + localObject7.jdField_c_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:reqRawData");
              if (localObject4 != null) {
                SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
              }
              if (localTencentLocation != null)
              {
                SosoInterface.a().jdField_c_of_type_JavaLangString = localTencentLocation.jdField_c_of_type_JavaLangString;
                SosoInterface.a().jdField_h_of_type_Boolean = localTencentLocation.jdField_h_of_type_Boolean;
              }
              SosoInterface.c();
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
                break label1710;
              }
            }
            label1710:
            for (paramTencentLocation = "";; paramTencentLocation = " goonLis been truncated:" + localObject7.jdField_c_of_type_JavaLangString)
            {
              QLog.d("SOSO.LBS", 2, paramTencentLocation + " start:" + ((SosoInterface.OnLocationListener)localObject6).jdField_c_of_type_JavaLangString);
              if (localObject4 != null) {
                SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
              }
              SosoInterface.c();
              ((SosoInterface.OnLocationListener)localObject6).jdField_e_of_type_Long = 0L;
              SosoInterface.a((SosoInterface.OnLocationListener)localObject6);
              return;
            }
          }
          if (localObject7 == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "onLocationChanged() goonLis goon after 1000ms:" + localObject7.jdField_c_of_type_JavaLangString);
          }
          if ((localObject4 != null) && (localObject4 != localObject7)) {
            SosoInterface.OnLocationListener.b((SosoInterface.OnLocationListener)localObject4, false);
          }
          if ((SosoInterface.OnLocationListener.b(localObject7)) || (SosoInterface.OnLocationListener.a(localObject7))) {
            break;
          }
          SosoInterface.c();
          ThreadManager.getSubThreadHandler().postDelayed(new zta(this, localObject7), 2000L);
          return;
        }
        localObject6 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject6;
        continue;
        label1851:
        localObject4 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject4;
        break label931;
        label1864:
        break label906;
        label1867:
        break label894;
        label1870:
        localObject4 = paramTencentLocation;
        paramTencentLocation = (TencentLocation)localObject1;
        localObject1 = localObject4;
        break label931;
        label1883:
        i = 0;
        break label785;
        label1889:
        if (localObject6 == null)
        {
          i = -10000;
          break label1240;
          label1902:
          localObject4 = paramTencentLocation;
          paramTencentLocation = (TencentLocation)localObject1;
          localObject1 = localObject4;
          break label931;
        }
        i = 0;
        break label1240;
      }
      label1921:
      break label931;
      label1924:
      paramTencentLocation = (TencentLocation)localObject4;
      label1927:
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
      SosoInterface.OnLocationListener localOnLocationListener;
      synchronized (SosoInterface.jdField_a_of_type_JavaLangObject)
      {
        if (SosoInterface.a().isEmpty()) {
          return;
        }
        i = SosoInterface.a().size() - 1;
        if (i < 0) {
          break label157;
        }
        localOnLocationListener = (SosoInterface.OnLocationListener)SosoInterface.a().get(i);
        if (localOnLocationListener == null) {
          break label161;
        }
        if (localOnLocationListener.jdField_e_of_type_Boolean) {
          ThreadManager.getUIHandler().post(new zsz(this, localOnLocationListener, paramString1, paramInt, paramString2));
        }
      }
      localOnLocationListener.a(paramString1, paramInt, paramString2);
      break label161;
      label157:
      return;
      label161:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsy
 * JD-Core Version:    0.7.0.1
 */