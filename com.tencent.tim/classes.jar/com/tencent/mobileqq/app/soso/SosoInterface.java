package com.tencent.mobileqq.app.soso;

import aczb;
import acze;
import aczf;
import aczg;
import aczh;
import aczi;
import aczj;
import aczk;
import aczl;
import aczm;
import afem;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import anpc;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import txi;

public class SosoInterface
{
  public static long RG;
  private static long RH;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private static TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static long[] af;
  private static boolean bKA;
  private static boolean bKB;
  public static volatile boolean bKz;
  private static final AtomicInteger bh;
  public static volatile String brj;
  public static int cAD = 2000;
  private static int cAE;
  private static int cAF;
  private static int cAG;
  private static int cAH;
  private static final a d;
  private static SosoLbsInfo f;
  private static long lastUpdateTime;
  private static final Object lock = new Object();
  private static long sTime;
  private static Handler subHandler;
  private static final ArrayList<a> tY;
  
  static
  {
    brj = "";
    tY = new ArrayList();
    subHandler = new Handler(ThreadManager.getSubThreadLooper(), new acze());
    bh = new AtomicInteger(0);
    af = new long[] { 0L, 0L, 0L, 0L, 0L };
    bKA = true;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    aczf localaczf = new aczf();
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(localaczf, localIntentFilter);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new aczg();
      d = new aczh(0, false, false, 0L, false, false, "reqRawData");
      bKB = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private static void Kq(int paramInt)
  {
    u().edit().putInt("last_location_err_code", paramInt).commit();
  }
  
  public static SosoLbsInfo a(int paramInt, boolean paramBoolean)
  {
    if ((f == null) || (f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(paramInt, paramBoolean);
    return localSosoLbsInfo;
  }
  
  public static SosoLbsInfo a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SosoLbsInfo localSosoLbsInfo = null;
    boolean bool = true;
    if ((paramLong <= 5000L) || (paramInt == 4))
    {
      localObject = localSosoLbsInfo;
      if (QLog.isColorLevel())
      {
        QLog.i("SOSO.LBS", 2, "getCanUsedLbsInfoCache maxCacheInterval is: " + paramLong + " directly return.");
        localObject = localSosoLbsInfo;
      }
    }
    EIPCResult localEIPCResult;
    do
    {
      do
      {
        do
        {
          long l;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return localObject;
                      if (!isMainProcess()) {
                        break;
                      }
                      l = SystemClock.elapsedRealtime();
                      localObject = localSosoLbsInfo;
                    } while (paramLong <= 0L);
                    localObject = localSosoLbsInfo;
                  } while (paramBoolean1);
                  if (!paramBoolean2) {
                    break;
                  }
                  localObject = localSosoLbsInfo;
                } while (af[paramInt] <= 0L);
                localObject = localSosoLbsInfo;
              } while (l >= af[paramInt] + paramLong);
              return a(paramInt, true);
              localObject = localSosoLbsInfo;
            } while (RG <= 0L);
            localObject = localSosoLbsInfo;
          } while (l >= RG + paramLong);
          localObject = localSosoLbsInfo;
        } while (f == null);
        return a(true);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("max_cache_interval", paramLong);
        ((Bundle)localObject).putBoolean("goon", paramBoolean1);
        ((Bundle)localObject).putInt("level", paramInt);
        ((Bundle)localObject).putBoolean("req_location", paramBoolean2);
        localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "get_lbs_info", (Bundle)localObject);
        if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
          break;
        }
        localEIPCResult.data.setClassLoader(SosoInterface.class.getClassLoader());
        localSosoLbsInfo = (SosoLbsInfo)localEIPCResult.data.getParcelable("soso_lbs_info");
        localObject = localSosoLbsInfo;
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is ok ,info is null: ");
      if (localSosoLbsInfo == null) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        QLog.i("SOSO.LBS", 2, paramBoolean1);
        return localSosoLbsInfo;
      }
      localObject = localSosoLbsInfo;
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is not ok. code: ");
    if (localEIPCResult == null) {}
    for (paramInt = -1;; paramInt = localEIPCResult.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      return null;
    }
  }
  
  public static SosoLbsInfo a(boolean paramBoolean)
  {
    if (f == null) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.cW = f.cW;
    if (f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, paramBoolean);
    }
    if (f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
    }
    ArrayList localArrayList = new ArrayList();
    if (f.mCells != null) {
      localArrayList.addAll(f.mCells);
    }
    localSosoLbsInfo.mCells = localArrayList;
    localArrayList = new ArrayList();
    if (f.tZ != null) {
      localArrayList.addAll(f.tZ);
    }
    localSosoLbsInfo.tZ = localArrayList;
    localSosoLbsInfo.RI = f.RI;
    localSosoLbsInfo.mVersion = f.mVersion;
    localSosoLbsInfo.brm = f.brm;
    return localSosoLbsInfo;
  }
  
  private static void a(int paramInt, TencentLocation paramTencentLocation, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    if (f == null)
    {
      f = new SosoLbsInfo();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoLocation();
    }
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.ce = paramTencentLocation.getLongitude();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cd = paramTencentLocation.getLatitude();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.brn = paramTencentLocation.getVerifyKey();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cAN = paramTencentLocation.getFakeReason();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.RJ = paramTencentLocation.getTime();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.speed = paramTencentLocation.getSpeed();
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.bro = paramTencentLocation.getSourceProvider();
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      RH = SystemClock.elapsedRealtime();
      if (RH - lastUpdateTime > 3000L)
      {
        fk(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
        lastUpdateTime = RH;
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - lastUpdateTime));
        }
      }
      if (!isMainProcess())
      {
        paramTencentLocation = new Bundle();
        paramTencentLocation.putInt("level", paramInt);
        paramTencentLocation.putBoolean("req_location", true);
        paramTencentLocation.putParcelable("soso_lbs_info", f);
        paramTencentLocation = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", paramTencentLocation);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("update location ipc result code: ");
          if (paramTencentLocation != null) {
            break label690;
          }
        }
      }
      break;
    }
    label690:
    for (paramInt = -1;; paramInt = paramTencentLocation.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      aczb.a(f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramString);
      return;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.yi = paramTencentLocation.getPoiList();
      af[4] = SystemClock.elapsedRealtime();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.nation = paramTencentLocation.getNation();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.province = paramTencentLocation.getProvince();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city = paramTencentLocation.getCity();
      localObject = paramTencentLocation.getCityCode();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase("unknown"))) {
        f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode = ((String)localObject);
      }
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.district = paramTencentLocation.getDistrict();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.town = paramTencentLocation.getTown();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.village = paramTencentLocation.getVillage();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.street = paramTencentLocation.getStreet();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.Qw = paramTencentLocation.getStreetNo();
      af[3] = SystemClock.elapsedRealtime();
      u().edit().putString("adcode", f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode);
      u().edit().putString("city", f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city).commit();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.name = paramTencentLocation.getName();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.address = paramTencentLocation.getAddress();
      af[1] = SystemClock.elapsedRealtime();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.altitude = paramTencentLocation.getAltitude();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.accuracy = paramTencentLocation.getAccuracy();
      af[0] = SystemClock.elapsedRealtime();
      break;
    }
  }
  
  public static void a(a parama)
  {
    int j = 1;
    if (parama == null) {
      return;
    }
    for (;;)
    {
      boolean bool;
      label57:
      try
      {
        if (a.access$1500(parama)) {
          a.access$1502(parama, false);
        }
        bool = aqiw.isNetSupport(BaseApplicationImpl.getContext());
        if ((!adg()) || ("official_location".equals(parama.tag))) {
          break label151;
        }
        i = 1;
      }
      finally {}
      if (TextUtils.isEmpty(brj)) {
        brj = getOaid();
      }
      SosoLbsInfo localSosoLbsInfo;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool);
        }
        localSosoLbsInfo = a(parama.level, true);
        if (parama.uiThread)
        {
          a(parama, i, localSosoLbsInfo);
          break;
          label151:
          i = 0;
        }
      }
      while (bool)
      {
        if (!bKA)
        {
          i = -10001;
          break label57;
        }
        if (i != 0)
        {
          j = -10003;
          i = j;
          if (!QLog.isColorLevel()) {
            break label57;
          }
          QLog.i("SOSO.LBS", 2, "发现启动时定位业务：" + parama.tag);
          i = j;
          break label57;
          parama.onLocationFinish(i, localSosoLbsInfo);
          break;
          if (jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null) {}
          ThreadManager.getSubThreadHandler().post(new SosoInterface.6(parama));
          break;
        }
        i = 0;
        break label57;
      }
      int i = j;
    }
  }
  
  private static void a(a parama, int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (parama == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new SosoInterface.5(parama, paramInt, paramSosoLbsInfo));
  }
  
  private static void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt1 == -4) || (paramInt1 == -17)))
    {
      break label28;
      break label28;
    }
    label28:
    while (((paramBoolean1) || (!HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) && (!paramBoolean1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt1));
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localHashMap.put("param_caller", paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("param_reason", paramString2);
    }
    localHashMap.put("param_useCache", Boolean.toString(paramBoolean4));
    localHashMap.put("param_askGps", Boolean.toString(paramBoolean3));
    localHashMap.put("param_costTime", Long.toString(paramLong));
    localHashMap.put("param_level", String.valueOf(paramInt2));
    String str = afem.getCurrentUin();
    if (paramBoolean4) {
      if (paramBoolean2)
      {
        paramString2 = "actSosoLocationCache";
        label191:
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, paramString2, paramBoolean1, paramLong, 0L, localHashMap, "");
        paramString2 = MagnifierSDK.a().a();
        if (!paramBoolean2) {
          break label410;
        }
      }
    }
    for (;;)
    {
      paramString2.onGPSScan("requestSoso", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean3), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (!adg()) {
        break;
      }
      paramString2 = new HashMap();
      if ((paramString1 == null) || (paramString1.length() <= 0)) {
        break;
      }
      paramString2.put("param_caller", paramString1);
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(str, "actLocationEarly", paramBoolean1, paramLong, 0L, paramString2, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SOSO.LBS", 2, "location too early: " + paramString1);
      return;
      paramString2 = "actSosoRawDataCache";
      break label191;
      if (paramBoolean2)
      {
        paramString2 = "actSosoLocation";
        break label191;
      }
      paramString2 = "actSosoRawData";
      break label191;
      label410:
      paramInt2 = -1;
    }
  }
  
  public static boolean adf()
  {
    return u().getInt("last_location_err_code", -1) == 0;
  }
  
  public static boolean adg()
  {
    if (!bKB) {
      return false;
    }
    if (isMainProcess()) {}
    for (long l = Conversation.FL; (l > 0L) && (SystemClock.elapsedRealtime() - l < 60000L); l = fg()) {
      return true;
    }
    bKB = false;
    return false;
  }
  
  /* Error */
  @Deprecated
  public static void aj(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 768	com/tencent/mobileqq/app/ThreadManager:getSubThread	()Ljava/lang/Thread;
    //   3: invokestatic 773	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 773	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 778	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 781	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 783	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 214	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 785
    //   35: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 787	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 773	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 791	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 12
    //   57: ldc 70
    //   59: astore 11
    //   61: aload 11
    //   63: astore 10
    //   65: aload 12
    //   67: ifnull +95 -> 162
    //   70: aload 11
    //   72: astore 10
    //   74: aload 12
    //   76: arraylength
    //   77: iconst_4
    //   78: if_icmplt +84 -> 162
    //   81: aload 12
    //   83: iconst_3
    //   84: aaload
    //   85: astore 10
    //   87: new 214	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   94: aload 10
    //   96: invokevirtual 796	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   99: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 798
    //   105: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 10
    //   110: invokevirtual 801	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   113: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 11
    //   121: aload 11
    //   123: astore 10
    //   125: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +34 -> 162
    //   131: ldc 212
    //   133: iconst_2
    //   134: new 214	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 803
    //   144: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 11
    //   149: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 234	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 11
    //   160: astore 10
    //   162: lload_0
    //   163: lconst_0
    //   164: lcmp
    //   165: ifle +139 -> 304
    //   168: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   171: getstatic 247	com/tencent/mobileqq/app/soso/SosoInterface:RG	J
    //   174: lload_0
    //   175: ladd
    //   176: lcmp
    //   177: ifge +127 -> 304
    //   180: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +29 -> 212
    //   186: ldc 212
    //   188: iconst_2
    //   189: new 214	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 805
    //   199: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: new 632	java/util/HashMap
    //   215: dup
    //   216: invokespecial 633	java/util/HashMap:<init>	()V
    //   219: astore 11
    //   221: aload_2
    //   222: ifnull +20 -> 242
    //   225: aload_2
    //   226: invokevirtual 647	java/lang/String:length	()I
    //   229: ifle +13 -> 242
    //   232: aload 11
    //   234: ldc_w 649
    //   237: aload_2
    //   238: invokevirtual 644	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: aload 10
    //   244: invokestatic 478	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +14 -> 261
    //   250: aload 11
    //   252: ldc_w 807
    //   255: aload 10
    //   257: invokevirtual 644	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload 11
    //   263: ldc_w 653
    //   266: getstatic 811	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   269: invokevirtual 814	java/lang/Boolean:booleanValue	()Z
    //   272: invokestatic 658	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   275: invokevirtual 644	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: invokestatic 676	afem:getCurrentUin	()Ljava/lang/String;
    //   282: astore_2
    //   283: invokestatic 124	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   286: invokestatic 683	anpc:a	(Landroid/content/Context;)Lanpc;
    //   289: aload_2
    //   290: ldc_w 718
    //   293: iconst_1
    //   294: lconst_0
    //   295: lconst_0
    //   296: aload 11
    //   298: ldc 70
    //   300: invokevirtual 687	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   303: return
    //   304: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +39 -> 346
    //   310: ldc 212
    //   312: iconst_2
    //   313: new 214	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 816
    //   323: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 818
    //   333: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: lload_0
    //   337: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: getstatic 144	com/tencent/mobileqq/app/soso/SosoInterface:d	Lcom/tencent/mobileqq/app/soso/SosoInterface$a;
    //   349: aload_2
    //   350: putfield 571	com/tencent/mobileqq/app/soso/SosoInterface$a:tag	Ljava/lang/String;
    //   353: getstatic 144	com/tencent/mobileqq/app/soso/SosoInterface:d	Lcom/tencent/mobileqq/app/soso/SosoInterface$a;
    //   356: invokestatic 820	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lcom/tencent/mobileqq/app/soso/SosoInterface$a;)V
    //   359: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   362: lstore_0
    //   363: iconst_0
    //   364: istore 9
    //   366: iconst_0
    //   367: istore 8
    //   369: iload 8
    //   371: istore 7
    //   373: getstatic 68	com/tencent/mobileqq/app/soso/SosoInterface:lock	Ljava/lang/Object;
    //   376: astore 11
    //   378: iload 8
    //   380: istore 7
    //   382: aload 11
    //   384: monitorenter
    //   385: iload 9
    //   387: istore 8
    //   389: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   392: lstore_3
    //   393: iload 9
    //   395: istore 8
    //   397: getstatic 247	com/tencent/mobileqq/app/soso/SosoInterface:RG	J
    //   400: lstore 5
    //   402: lload_3
    //   403: lload 5
    //   405: ldc2_w 821
    //   408: ladd
    //   409: lcmp
    //   410: ifge +67 -> 477
    //   413: iconst_1
    //   414: istore 7
    //   416: aload 11
    //   418: monitorexit
    //   419: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -119 -> 303
    //   425: ldc 212
    //   427: iconst_2
    //   428: new 214	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 824
    //   438: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_2
    //   442: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 826
    //   448: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: iload 7
    //   453: invokevirtual 322	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   456: ldc_w 828
    //   459: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokestatic 243	android/os/SystemClock:elapsedRealtime	()J
    //   465: lload_0
    //   466: lsub
    //   467: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 430	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    //   477: iload 9
    //   479: istore 8
    //   481: getstatic 68	com/tencent/mobileqq/app/soso/SosoInterface:lock	Ljava/lang/Object;
    //   484: ldc2_w 829
    //   487: invokevirtual 834	java/lang/Object:wait	(J)V
    //   490: iconst_0
    //   491: istore 7
    //   493: goto -77 -> 416
    //   496: iload 7
    //   498: istore 8
    //   500: aload 11
    //   502: monitorexit
    //   503: aload 10
    //   505: athrow
    //   506: astore 10
    //   508: goto -89 -> 419
    //   511: astore 10
    //   513: goto -17 -> 496
    //   516: astore 10
    //   518: iload 8
    //   520: istore 7
    //   522: goto -26 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	paramLong	long
    //   0	525	2	paramString	String
    //   392	11	3	l1	long
    //   400	4	5	l2	long
    //   371	150	7	bool1	boolean
    //   367	152	8	bool2	boolean
    //   364	114	9	bool3	boolean
    //   63	441	10	localObject1	Object
    //   506	1	10	localInterruptedException	java.lang.InterruptedException
    //   511	1	10	localObject2	Object
    //   516	1	10	localObject3	Object
    //   59	442	11	localObject4	Object
    //   55	27	12	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   373	378	506	java/lang/InterruptedException
    //   382	385	506	java/lang/InterruptedException
    //   503	506	506	java/lang/InterruptedException
    //   416	419	511	finally
    //   389	393	516	finally
    //   397	402	516	finally
    //   481	490	516	finally
    //   500	503	516	finally
  }
  
  @Deprecated
  public static SosoLbsInfo b()
  {
    return a(true);
  }
  
  private static void b(a parama)
  {
    if (parama == null) {
      return;
    }
    synchronized (lock)
    {
      if (!tY.contains(parama)) {
        tY.add(parama);
      }
      return;
    }
  }
  
  @Deprecated
  public static SosoLbsInfo c()
  {
    if ((f == null) || (f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoLbsInfo localSosoLbsInfo = new SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(4, true);
    return localSosoLbsInfo;
  }
  
  public static void c(a parama)
  {
    synchronized (lock)
    {
      tY.remove(parama);
      a.access$1502(parama, true);
      a.access$1602(parama, false);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + parama.tag + " removed.");
      }
      if (tY.size() == 0)
      {
        ThreadManager.getSubThreadHandler().post(new SosoInterface.8());
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  private static void cPn()
  {
    bh.set(0);
    if ((jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener != null) && (jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null))
    {
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
    cAE = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "stopLocation() stop LBS");
    }
  }
  
  private static void cPo()
  {
    for (;;)
    {
      int i;
      a locala;
      synchronized (lock)
      {
        if (tY.isEmpty()) {
          return;
        }
        i = tY.size() - 1;
        if (i < 0) {
          break label107;
        }
        locala = (a)tY.get(i);
        if (locala == null) {
          break label116;
        }
        if (locala.reqLocation)
        {
          SosoLbsInfo localSosoLbsInfo1 = a(locala.level, true);
          if (!locala.uiThread) {
            break label96;
          }
          a(locala, -10000, localSosoLbsInfo1);
        }
      }
      SosoLbsInfo localSosoLbsInfo2 = a(true);
      continue;
      label96:
      locala.onLocationFinish(-10000, localSosoLbsInfo2);
      break label116;
      label107:
      tY.clear();
      return;
      label116:
      i -= 1;
    }
  }
  
  public static void f(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return;
    }
    if (f == null)
    {
      f = new SosoLbsInfo();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoLocation();
    }
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.speed = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.speed;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.ce = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.ce;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cd = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cd;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.brn = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.brn;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cAN = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cAN;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.RJ = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.RJ;
    f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.bro = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.bro;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    for (;;)
    {
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.altitude = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.altitude;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.accuracy = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.accuracy;
      af[0] = SystemClock.elapsedRealtime();
      return;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.nation = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.nation;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.province = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.province;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city;
      String str = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode;
      if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
        f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode = str;
      }
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.district = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.district;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.town = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.town;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.village = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.village;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.street = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.street;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.Qw = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.Qw;
      af[3] = SystemClock.elapsedRealtime();
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.name = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.name;
      f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.address = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.address;
      af[1] = SystemClock.elapsedRealtime();
    }
  }
  
  private static long fg()
  {
    return u().getLong("normal_enter_conversation_time", 0L);
  }
  
  public static void fk(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2204);
    localNewIntent.putExtra("longitude", paramString1);
    localNewIntent.putExtra("latitude", paramString2);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public static String getCity()
  {
    SosoLbsInfo localSosoLbsInfo = c();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city))) {
      return localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.city;
    }
    return u().getString("city", "");
  }
  
  public static String getCityCode()
  {
    SosoLbsInfo localSosoLbsInfo = c();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode))) {
      return localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cityCode;
    }
    return u().getString("adcode", "");
  }
  
  /* Error */
  private static String getOaid()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 947	com/tencent/mobileqq/app/soso/SosoInterface:bKz	Z
    //   6: ifeq +12 -> 18
    //   9: getstatic 72	com/tencent/mobileqq/app/soso/SosoInterface:brj	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: iconst_1
    //   19: putstatic 947	com/tencent/mobileqq/app/soso/SosoInterface:bKz	Z
    //   22: invokestatic 602	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   25: new 949	com/tencent/mobileqq/app/soso/SosoInterface$7
    //   28: dup
    //   29: invokespecial 950	com/tencent/mobileqq/app/soso/SosoInterface$7:<init>	()V
    //   32: invokevirtual 612	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: getstatic 72	com/tencent/mobileqq/app/soso/SosoInterface:brj	Ljava/lang/String;
    //   39: astore_0
    //   40: goto -27 -> 13
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	28	0	str	String
    //   43	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	43	finally
    //   18	40	43	finally
  }
  
  public static void i(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      if (f == null)
      {
        f = new SosoLbsInfo();
        f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoLocation();
      }
      for (;;)
      {
        try
        {
          f.cW = paramArrayOfByte;
          localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
          d2 = 0.0D;
          d1 = d2;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          Object localObject1;
          SosoAttribute localSosoAttribute;
          ArrayList localArrayList1;
          int j;
          int i;
          Object localObject3;
          ArrayList localArrayList2;
          Object localObject2;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("location");
          d1 = d2;
          d2 = ((JSONObject)localObject1).getDouble("latitude");
          d1 = d2;
          d3 = ((JSONObject)localObject1).getDouble("longitude");
          d1 = d3;
        }
        catch (JSONException localJSONException2)
        {
          d3 = 0.0D;
          d2 = d1;
          d1 = d3;
          continue;
          bool = false;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("attribute");
          localSosoAttribute = new SosoAttribute(((JSONObject)localObject1).getString("imei"), ((JSONObject)localObject1).getString("imsi"), ((JSONObject)localObject1).getString("phonenum"), ((JSONObject)localObject1).getString("qq"), ((JSONObject)localObject1).getBoolean("roaming"));
          localArrayList1 = new ArrayList();
          localObject1 = localJSONObject.getJSONArray("cells");
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            int k = ((JSONObject)localObject3).getInt("mcc");
            int m = ((JSONObject)localObject3).getInt("mnc");
            int n = ((JSONObject)localObject3).getInt("lac");
            int i1 = ((JSONObject)localObject3).getInt("cellid");
            int i2 = ((JSONObject)localObject3).getInt("rss");
            if (i != 0) {
              break label666;
            }
            bool = true;
            localArrayList1.add(new SosoCell(k, m, n, i1, i2, bool));
            i += 1;
            continue;
          }
        }
        catch (JSONException localJSONException1)
        {
          localSosoAttribute = new SosoAttribute("", "", "", "", false);
          continue;
          localArrayList2 = new ArrayList();
          localObject2 = localJSONObject.getJSONArray("wifis");
          i = 0;
          j = ((JSONArray)localObject2).length();
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localArrayList2.add(new SosoWifi(((JSONObject)localObject3).getString("mac"), ((JSONObject)localObject3).getInt("rssi")));
            i += 1;
            continue;
          }
          localObject2 = "";
          try
          {
            localObject3 = localJSONObject.getString("version");
            localObject2 = localObject3;
            l = localJSONObject.getLong("source");
          }
          catch (JSONException localJSONException3)
          {
            long l = 0L;
            Object localObject4 = localObject2;
            continue;
            i = paramString.code;
            continue;
          }
          if (d2 != 0.0D) {
            f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cf = d2;
          }
          if (d1 != 0.0D) {
            f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.cg = d1;
          }
          f.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = localSosoAttribute;
          f.mCells = localArrayList1;
          f.tZ = localArrayList2;
          f.RI = l;
          f.mVersion = ((String)localObject3);
          f.brm = paramString;
          RG = SystemClock.elapsedRealtime();
          if (isMainProcess()) {
            break;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("provider", paramString);
          ((Bundle)localObject2).putByteArray("raw_data", paramArrayOfByte);
          ((Bundle)localObject2).putBoolean("req_location", false);
          paramString = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", (Bundle)localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          paramArrayOfByte = new StringBuilder().append("update raw data, ipc result code: ");
          if (paramString == null)
          {
            i = -1;
            QLog.i("SOSO.LBS", 2, i);
            return;
          }
        }
      }
    }
  }
  
  public static void io(long paramLong)
  {
    u().edit().putLong("normal_enter_conversation_time", paramLong).commit();
  }
  
  private static boolean isMainProcess()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public static boolean kM(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS", 2, "saveSosoInterfaceConfig: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    u().edit().putString("config", paramString).commit();
    return true;
  }
  
  public static void onDestroy()
  {
    ThreadManager.getSubThreadHandler().post(new SosoInterface.9());
    synchronized (lock)
    {
      tY.clear();
      return;
    }
  }
  
  private static SharedPreferences u()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sosoConfig", 4);
  }
  
  public static final class SosoAttribute
    implements Parcelable
  {
    public static final Parcelable.Creator<SosoAttribute> CREATOR = new aczi();
    public String QT;
    public String Tn;
    public boolean bKC;
    public String brk;
    public String brl;
    
    public SosoAttribute(Parcel paramParcel)
    {
      this.Tn = paramParcel.readString();
      this.brk = paramParcel.readString();
      this.QT = paramParcel.readString();
      this.brl = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bKC = bool;
        return;
      }
    }
    
    public SosoAttribute(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
    {
      this.Tn = paramString1;
      this.brk = paramString2;
      this.QT = paramString3;
      this.brl = paramString4;
      this.bKC = paramBoolean;
    }
    
    public SosoAttribute a()
    {
      return new SosoAttribute(this.Tn, this.brk, this.QT, this.brl, this.bKC);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.Tn);
      paramParcel.writeString(this.brk);
      paramParcel.writeString(this.QT);
      paramParcel.writeString(this.brl);
      if (this.bKC) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
  
  public static final class SosoCell
    implements Parcelable, Comparable<SosoCell>
  {
    public static final Parcelable.Creator<SosoCell> CREATOR = new aczj();
    public boolean bKD;
    public int cAI;
    public int cAJ;
    public int cAK;
    public int cAL;
    public int cAM;
    
    public SosoCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
    {
      this.cAI = paramInt1;
      this.cAJ = paramInt2;
      this.cAK = paramInt3;
      this.cAL = paramInt4;
      this.cAM = paramInt5;
      this.bKD = paramBoolean;
    }
    
    public SosoCell(Parcel paramParcel)
    {
      this.cAI = paramParcel.readInt();
      this.cAJ = paramParcel.readInt();
      this.cAK = paramParcel.readInt();
      this.cAL = paramParcel.readInt();
      this.cAM = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bKD = bool;
        return;
      }
    }
    
    public int a(SosoCell paramSosoCell)
    {
      return this.cAL - paramSosoCell.cAL;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.cAI);
      paramParcel.writeInt(this.cAJ);
      paramParcel.writeInt(this.cAK);
      paramParcel.writeInt(this.cAL);
      paramParcel.writeInt(this.cAM);
      if (this.bKD) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeByte((byte)paramInt);
        return;
      }
    }
  }
  
  public static class SosoLbsInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<SosoLbsInfo> CREATOR = new aczk();
    public long RI;
    public SosoInterface.SosoAttribute a;
    public SosoInterface.SosoLocation a;
    public String brm;
    public byte[] cW;
    public ArrayList<SosoInterface.SosoCell> mCells = new ArrayList();
    public String mVersion;
    public ArrayList<SosoInterface.SosoWifi> tZ = new ArrayList();
    
    public SosoLbsInfo() {}
    
    public SosoLbsInfo(Parcel paramParcel)
    {
      this.cW = paramParcel.createByteArray();
      this.mVersion = paramParcel.readString();
      this.RI = paramParcel.readLong();
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = ((SosoInterface.SosoAttribute)paramParcel.readParcelable(SosoInterface.SosoAttribute.class.getClassLoader()));
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = ((SosoInterface.SosoLocation)paramParcel.readParcelable(SosoInterface.SosoLocation.class.getClassLoader()));
      this.brm = paramParcel.readString();
      this.mCells = paramParcel.createTypedArrayList(SosoInterface.SosoCell.CREATOR);
      this.tZ = paramParcel.createTypedArrayList(SosoInterface.SosoWifi.CREATOR);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeByteArray(this.cW);
      paramParcel.writeString(this.mVersion);
      paramParcel.writeLong(this.RI);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute, paramInt);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramInt);
      paramParcel.writeString(this.brm);
      paramParcel.writeTypedList(this.mCells);
      paramParcel.writeTypedList(this.tZ);
    }
  }
  
  public static final class SosoLocation
    implements Parcelable
  {
    public static final Parcelable.Creator<SosoLocation> CREATOR = new aczl();
    public String Qw;
    public long RJ;
    public float accuracy;
    public String address;
    public double altitude;
    public String brn;
    public String bro;
    public int cAN;
    public double cd;
    public double ce;
    public double cf;
    public double cg;
    public String city;
    public String cityCode;
    public String district;
    public String name;
    public String nation;
    public String province;
    public float speed;
    public String street;
    public String town;
    public String village;
    public List<TencentPoi> yi;
    
    public SosoLocation() {}
    
    public SosoLocation(Parcel paramParcel)
    {
      this.cd = paramParcel.readDouble();
      this.ce = paramParcel.readDouble();
      this.cf = paramParcel.readDouble();
      this.cg = paramParcel.readDouble();
      this.altitude = paramParcel.readDouble();
      this.accuracy = paramParcel.readFloat();
      this.cAN = paramParcel.readInt();
      this.RJ = paramParcel.readLong();
      this.speed = paramParcel.readFloat();
      this.name = paramParcel.readString();
      this.address = paramParcel.readString();
      this.nation = paramParcel.readString();
      this.province = paramParcel.readString();
      this.city = paramParcel.readString();
      this.cityCode = paramParcel.readString();
      this.district = paramParcel.readString();
      this.town = paramParcel.readString();
      this.village = paramParcel.readString();
      this.street = paramParcel.readString();
      this.Qw = paramParcel.readString();
      this.brn = paramParcel.readString();
      this.bro = paramParcel.readString();
    }
    
    public SosoLocation a(int paramInt, boolean paramBoolean)
    {
      SosoLocation localSosoLocation = new SosoLocation();
      if (paramBoolean)
      {
        localSosoLocation.cd = this.cd;
        localSosoLocation.ce = this.ce;
        localSosoLocation.cf = this.cf;
        localSosoLocation.cg = this.cg;
      }
      localSosoLocation.speed = this.speed;
      localSosoLocation.altitude = this.altitude;
      localSosoLocation.accuracy = this.accuracy;
      localSosoLocation.brn = this.brn;
      localSosoLocation.cAN = this.cAN;
      localSosoLocation.RJ = this.RJ;
      localSosoLocation.bro = this.bro;
      if ((paramInt == 1) || (paramInt == 3) || (paramInt == 4))
      {
        localSosoLocation.name = this.name;
        localSosoLocation.address = this.address;
      }
      if ((paramInt == 3) || (paramInt == 4))
      {
        localSosoLocation.nation = this.nation;
        localSosoLocation.province = this.province;
        localSosoLocation.city = this.city;
        localSosoLocation.cityCode = this.cityCode;
        localSosoLocation.district = this.district;
        localSosoLocation.town = this.town;
        localSosoLocation.village = this.village;
        localSosoLocation.street = this.street;
        localSosoLocation.Qw = this.Qw;
      }
      if (paramInt == 4)
      {
        LinkedList localLinkedList = new LinkedList();
        if ((this.yi != null) && (this.yi.size() > 0)) {
          localLinkedList.addAll(this.yi);
        }
        localSosoLocation.yi = localLinkedList;
      }
      return localSosoLocation;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeDouble(this.cd);
      paramParcel.writeDouble(this.ce);
      paramParcel.writeDouble(this.cf);
      paramParcel.writeDouble(this.cg);
      paramParcel.writeDouble(this.altitude);
      paramParcel.writeFloat(this.accuracy);
      paramParcel.writeInt(this.cAN);
      paramParcel.writeLong(this.RJ);
      paramParcel.writeFloat(this.speed);
      paramParcel.writeString(this.name);
      paramParcel.writeString(this.address);
      paramParcel.writeString(this.nation);
      paramParcel.writeString(this.province);
      paramParcel.writeString(this.city);
      paramParcel.writeString(this.cityCode);
      paramParcel.writeString(this.district);
      paramParcel.writeString(this.town);
      paramParcel.writeString(this.village);
      paramParcel.writeString(this.street);
      paramParcel.writeString(this.Qw);
      paramParcel.writeString(this.brn);
      paramParcel.writeString(this.bro);
    }
  }
  
  public static final class SosoWifi
    implements Parcelable
  {
    public static final Parcelable.Creator<SosoWifi> CREATOR = new aczm();
    public long RK;
    public String brp;
    public int mRssi;
    
    public SosoWifi(Parcel paramParcel)
    {
      this.mRssi = paramParcel.readInt();
      this.RK = paramParcel.readLong();
      this.brp = paramParcel.readString();
    }
    
    public SosoWifi(String paramString, int paramInt)
    {
      this.mRssi = paramInt;
      this.brp = paramString;
      this.RK = ag(paramString);
    }
    
    public static long ag(String paramString)
    {
      try
      {
        paramString = paramString.split(":");
        if (paramString.length == 6)
        {
          int j = 40;
          int i = 0;
          long l1 = 0L;
          while (i < paramString.length)
          {
            long l2 = Long.parseLong(paramString[i], 16);
            long l3 = l2;
            if (j > 0) {
              l3 = l2 << j;
            }
            l1 += l3;
            j -= 8;
            i += 1;
          }
          return l1;
        }
      }
      catch (Exception paramString)
      {
        return 0L;
      }
      return 0L;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mRssi);
      paramParcel.writeLong(this.RK);
      paramParcel.writeString(this.brp);
    }
  }
  
  public static abstract class a
  {
    public boolean askGPS;
    protected String callerRoute;
    protected long geoCacheInterval;
    protected long globalCacheInterval;
    public boolean goonListener;
    private boolean isRemoved;
    public int level;
    protected long levelCacheInterval;
    public long maxCacheInterval;
    protected int maxFailCount = 3;
    public boolean reqLocation;
    private boolean requesting;
    public long sTime;
    public String tag;
    public boolean uiThread;
    
    public a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
    {
      if ((paramInt == 0) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4))
      {
        this.tag = paramString;
        this.level = paramInt;
        this.askGPS = paramBoolean2;
        this.reqLocation = paramBoolean1;
        this.goonListener = paramBoolean4;
        this.uiThread = paramBoolean3;
        this.maxCacheInterval = paramLong;
        this.sTime = SystemClock.elapsedRealtime();
        return;
      }
      throw new AndroidRuntimeException("invalid level=" + paramInt);
    }
    
    public void onConsecutiveFailure(int paramInt1, int paramInt2) {}
    
    public abstract void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo);
    
    public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */