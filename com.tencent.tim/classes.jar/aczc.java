import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoAttribute;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class aczc
{
  private static final HashMap<String, aczc.a> jq = new HashMap();
  private static Map<aczc.b, SosoInterface.a> jy = new ConcurrentHashMap(8, 0.75F);
  private static Map<SosoInterface.a, aczc.b> jz = new ConcurrentHashMap(8, 0.75F);
  
  static
  {
    cPm();
  }
  
  private static aczc.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (aczc.a)jq.get(paramString);
  }
  
  private static SosoInterface.SosoLbsInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      return null;
      localObject = a(paramString);
    } while ((localObject == null) || (paramSosoLbsInfo == null));
    if (((aczc.a)localObject).bKy)
    {
      paramString = new SosoInterface.SosoLbsInfo();
      paramString.cW = paramSosoLbsInfo.cW;
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, ((aczc.a)localObject).bKv);
      }
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
        paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
      }
      localObject = new ArrayList();
      if (paramSosoLbsInfo.mCells != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.mCells);
      }
      paramString.mCells = ((ArrayList)localObject);
      localObject = new ArrayList();
      if (paramSosoLbsInfo.tZ != null) {
        ((ArrayList)localObject).addAll(paramSosoLbsInfo.tZ);
      }
      paramString.tZ = ((ArrayList)localObject);
      paramString.RI = paramSosoLbsInfo.RI;
      paramString.mVersion = paramSosoLbsInfo.mVersion;
      paramString.brm = paramSosoLbsInfo.brm;
      return paramString;
    }
    paramString = new SosoInterface.SosoLbsInfo();
    paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(((aczc.a)localObject).cAC, ((aczc.a)localObject).bKv);
    return paramString;
  }
  
  public static SosoInterface.SosoLbsInfo a(String paramString)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business id: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return localObject;
      paramString = a(paramString);
      if (paramString != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("SOSO.LBS.LbsManagerService", 0, "getCachedLbsInfo business info is null.");
    return null;
    if (paramString.bKy) {}
    for (paramString = SosoInterface.a(paramString.bKv);; paramString = SosoInterface.a(paramString.cAC, paramString.bKv))
    {
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      localObject = paramString;
      if (paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) {
        break;
      }
      QLog.e("SOSO.LBS.LbsManagerService", 0, "LBS:" + paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cd + " mLon_02:" + paramString.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.ce);
      return paramString;
    }
  }
  
  private static SosoInterface.a a(aczc.b paramb)
  {
    boolean bool1 = false;
    aczc.a locala = a(paramb.businessId);
    if (locala == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SOSO.LBS.LbsManagerService", 0, "makeSososOnLocationListener business info is null, business id: " + paramb.businessId);
      }
      return null;
    }
    int i = locala.Bn();
    int j = locala.cAC;
    boolean bool2 = locala.bKw;
    boolean bool3 = locala.bKx;
    if (!locala.bKy) {
      bool1 = true;
    }
    return new aczd(j, bool1, bool3, i, paramb.observerOnUiThread, bool2, paramb.businessId, paramb);
  }
  
  public static void a(aczc.b paramb)
  {
    if (paramb == null) {
      return;
    }
    label129:
    label134:
    for (;;)
    {
      synchronized (jy)
      {
        if (jy.containsKey(paramb)) {
          break label129;
        }
        locala = a(paramb);
        if (locala == null) {
          break label134;
        }
        jy.put(paramb, locala);
        jz.put(locala, paramb);
        break label134;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder().append("startLocation sosoLocationListener is null : ");
          if (locala == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool + " business id: " + paramb.businessId);
          }
        }
        else
        {
          if (locala == null) {
            break;
          }
          SosoInterface.a(locala);
          return;
        }
      }
      boolean bool = false;
      continue;
      SosoInterface.a locala = null;
    }
  }
  
  public static boolean adf()
  {
    return SosoInterface.adf();
  }
  
  public static void b(aczc.b paramb)
  {
    if (paramb == null) {
      return;
    }
    for (;;)
    {
      synchronized (jy)
      {
        if (!jy.containsKey(paramb)) {
          break label118;
        }
        locala = (SosoInterface.a)jy.remove(paramb);
        jz.remove(locala);
        if (QLog.isColorLevel())
        {
          paramb = new StringBuilder().append("removeListener business id is: ").append(paramb.businessId).append(" sosoLocationListener is null: ");
          if (locala == null)
          {
            bool = true;
            QLog.i("SOSO.LBS.LbsManagerService", 0, bool);
          }
        }
        else
        {
          if (locala == null) {
            break;
          }
          SosoInterface.c(locala);
          return;
        }
      }
      boolean bool = false;
      continue;
      label118:
      SosoInterface.a locala = null;
    }
  }
  
  private static void cPm()
  {
    aczc.a locala = new aczc.a("official_location", true, 5, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("QQMapActivity", true, 5, 1, true, true, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("readinjoy_anti_cheating", true, 2, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("vas_red_point", false, 2, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_address_select", true, 5, 0, false, true, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_for_report", true, 3, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_weather", true, 4, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_live", true, 5, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_say", true, 5, 0, false, true, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_upload_pic_video", true, 5, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_photo_recommend", true, 3, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_little_video_enter", true, 3, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_request_server", true, 2, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_h5", false, 3, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qzone_other", true, 5, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("readinjoy_feed_ad_distance", true, 4, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("gdt_tangram", true, 1, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("nearby_readinjoy", true, 4, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("troop_handler", true, 2, 0, false, true, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("troop_member_distance", true, 2, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("webview", true, 3, 4, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qq_weather", false, 3, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qq_story_water_mark", true, 4, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("readinjoy_weather", false, 3, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("LBSService.Point", true, 5, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("Login.Guide", true, 2, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("recommend_troop", true, 2, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("vfuchong_bus_card", false, 3, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("readinjoy_position", false, 3, 3, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("qqcircle", true, 4, 0, false, false, false);
    jq.put(locala.businessId, locala);
    locala = new aczc.a("extend_friend", true, 1, 0, false, true, false);
    jq.put(locala.businessId, locala);
  }
  
  public static String getCity()
  {
    return SosoInterface.getCity();
  }
  
  public static String getCityCode()
  {
    return SosoInterface.getCityCode();
  }
  
  public static void onDestroy()
  {
    synchronized (jy)
    {
      jy.clear();
      jz.clear();
      return;
    }
  }
  
  static class a
  {
    public boolean bKv;
    public boolean bKw;
    public boolean bKx;
    public boolean bKy;
    public String businessId;
    public int cAB;
    public int cAC;
    
    public a(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.businessId = paramString;
      this.bKv = paramBoolean1;
      this.cAB = paramInt1;
      this.cAC = paramInt2;
      this.bKw = paramBoolean2;
      this.bKx = paramBoolean3;
      this.bKy = paramBoolean4;
    }
    
    public int Bn()
    {
      if (this.cAB == 5) {
        return 0;
      }
      if (this.cAB == 4) {
        return 60000;
      }
      if (this.cAB == 3) {
        return 180000;
      }
      if (this.cAB == 2) {
        return 600000;
      }
      return 1800000;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessId: ").append(this.businessId).append(",").append("reqLonAndLat: ").append(this.bKv).append(",").append("realTimeRequirement: ").append(this.cAB).append(",").append("requestDataLevel: ").append(this.cAC).append(",").append("reqGoon: ").append(this.bKw).append(",").append("canUseGps: ").append(this.bKx);
      return localStringBuilder.toString();
    }
  }
  
  public static abstract class b
  {
    public String businessId;
    public boolean observerOnUiThread;
    
    public b(String paramString)
    {
      this.businessId = paramString;
    }
    
    public b(String paramString, boolean paramBoolean)
    {
      this.businessId = paramString;
      this.observerOnUiThread = paramBoolean;
    }
    
    public void onConsecutiveFailure(int paramInt1, int paramInt2, boolean paramBoolean) {}
    
    public abstract void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
    
    public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aczc
 * JD-Core Version:    0.7.0.1
 */