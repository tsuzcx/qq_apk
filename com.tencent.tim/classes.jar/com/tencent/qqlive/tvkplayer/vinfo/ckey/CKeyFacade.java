package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.DeviceInfoUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyBean;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyUtil;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsAppKeyVerify;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsLog;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.VsReporter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class CKeyFacade
{
  private static final String KEYNAME = "tvkmedia.key";
  private static final String SONAME = "ckeygeneratorV2";
  private static final String TAG = "CKeyFacade|ckeygeneratorV2.so";
  static boolean bLoadSucc;
  private static CKeyBeaconReport cKeyBeaconReport;
  private static int flag_11;
  private static int flag_22;
  private static int flag_33;
  private static int flag_44;
  private static String mAppKey;
  private static String mBeaconID;
  private static String mBsGuid;
  private static Context mContext;
  private static String mExtInfo;
  private static String mGuid;
  private static int mHandler = 0;
  private static volatile CKeyFacade mInstance;
  public static String mJarVersion = "V3.0.015.4";
  private static String mOmgID;
  private static String mOpenID;
  private static String mPkgName;
  private static String mPlatform;
  private static String mSdtfrom;
  private static String mSoVersion;
  private static String mUin;
  private static String mVsKey;
  private static String mVuid;
  private boolean isInit = false;
  private boolean isMutiInit = false;
  
  static
  {
    bLoadSucc = false;
    cKeyBeaconReport = null;
    flag_11 = 1;
    flag_22 = 2;
    flag_33 = 4;
    flag_44 = 8;
    mInstance = null;
    mUin = "";
    mOpenID = "";
    mVuid = "";
    mOmgID = "";
    mBsGuid = "";
    mBeaconID = "";
    mGuid = "";
    mContext = null;
    mVsKey = "";
    mPlatform = "";
    mSdtfrom = "";
    mAppKey = "";
    mPkgName = "";
    mExtInfo = "";
    mSoVersion = "";
  }
  
  private static String byteArrayToString(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = "";
      }
    }
  }
  
  public static String ckBuildSignStr(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = new TreeMap(paramMap).entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("&");
      }
      localStringBuilder.append((String)localEntry.getKey()).append("=").append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  public static String ckSign(int paramInt)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    VsReporter.reportSign(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, paramInt);
    return getencSS(paramInt);
  }
  
  public static String ckSignature(String paramString, long paramLong)
  {
    paramString = paramString.split("&");
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length != 2) {
        if (arrayOfString[0].length() > 0) {
          localHashMap.put(arrayOfString[0], "");
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
    }
    return ckSignature_map(localHashMap, paramLong);
  }
  
  public static String ckSignature_map(Map<String, String> paramMap, long paramLong)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    try
    {
      paramMap = new String(getSignature(ckBuildSignStr(paramMap), paramLong));
      return paramMap;
    }
    catch (Throwable paramMap) {}
    return "exception";
  }
  
  public static String ckTaskEncrypt(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    VsReporter.reportTaskEncrypt(mContext, mPlatform, mSdtfrom, mGuid, mBsGuid, mBeaconID, paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    try
    {
      paramString1 = taskEncrypt(paramString1, paramString2, paramString3, paramString4, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString5);
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return null;
  }
  
  private static native void ckeyMoudleInit(String paramString1, String paramString2, String paramString3, Context paramContext);
  
  private static native byte[] genCKey(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int[] paramArrayOfInt, int paramInt2, String paramString7, String paramString8, String paramString9, String paramString10, byte[] paramArrayOfByte);
  
  public static String getAppVer(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getCKey(int paramInt, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    paramArrayOfByte1 = byteArrayToString(paramArrayOfByte1);
    paramArrayOfByte2 = byteArrayToString(paramArrayOfByte2);
    paramArrayOfByte3 = byteArrayToString(paramArrayOfByte3);
    paramArrayOfByte4 = byteArrayToString(paramArrayOfByte4);
    paramArrayOfByte6 = byteArrayToString(paramArrayOfByte6);
    return getCKey(byteArrayToString(paramArrayOfByte5), paramLong, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte6, "");
  }
  
  public static String getCKey(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    for (;;)
    {
      int j;
      int[] arrayOfInt;
      int i;
      try
      {
        paramString6 = paramString6.split(",");
        j = paramString6.length;
        arrayOfInt = new int[j];
        i = 0;
        if (i < j) {
          if (paramString6[i].length() == 0) {
            arrayOfInt[i] = -1;
          } else {
            arrayOfInt[i] = Integer.parseInt(paramString6[i]);
          }
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString1 = getCKey(paramString1, paramLong, paramString2, paramString3, paramString4, paramString5, arrayOfInt, j, paramString7);
      return paramString1;
      i += 1;
    }
  }
  
  public static String getCKey(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, int[] paramArrayOfInt, int paramInt, String paramString6)
  {
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(mContext, "ckeygeneratorV2");
    }
    StarTrailHelper.loadso(mContext);
    localObject1 = "";
    for (;;)
    {
      try
      {
        str1 = new Exception().getStackTrace()[1].getClassName();
        localObject1 = str1;
        localObject3 = new Exception().getStackTrace()[1].getMethodName();
        localObject1 = str1;
        VsLog.info(str1 + "  " + (String)localObject3, new Object[0]);
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        String str1;
        Object localObject3;
        VsAppKeyBean localVsAppKeyBean;
        String str3;
        Object localObject4;
        byte[] arrayOfByte;
        String str2 = "catch";
        Object localObject2 = localObject1;
        localObject1 = str2;
        continue;
        str2 = "0";
        continue;
      }
      try
      {
        localVsAppKeyBean = VsAppKeyUtil.getInstance().getAppKey(paramString4);
        if (localVsAppKeyBean == null)
        {
          VsLog.error("init plz~~", new Object[0]);
          return "";
        }
        mBsGuid = paramString1;
        str3 = CKeyGuard.genGuard(mContext);
        mGuid = "";
        localObject3 = Thread.currentThread().getStackTrace()[2].getMethodName();
        localObject4 = (paramLong + "," + paramString2 + "," + mBeaconID).getBytes();
        arrayOfByte = StarTrailHelper.stGetSign(mContext, paramString1, (String)localObject3, (byte[])localObject4);
      }
      catch (Throwable paramString1)
      {
        paramString2 = "";
        continue;
      }
      try
      {
        if ((mBeaconID == null) || (mBeaconID.isEmpty()))
        {
          localObject3 = cKeyBeaconReport;
          mBeaconID = CKeyBeaconReport.getQIMEI();
        }
      }
      catch (Exception localException)
      {
        mBeaconID = "0";
      }
    }
    localObject4 = DeviceInfoUtil.getQimei36();
    if (localObject4 != null)
    {
      localObject3 = localObject4;
      if (!((String)localObject4).isEmpty())
      {
        paramString3 = new String(genCKey(paramLong, Integer.parseInt(paramString4), paramString3, paramString2, getfd(paramString5), localVsAppKeyBean.getVsKey(), paramString1, mGuid, paramArrayOfInt, paramInt, paramString6, str3, (String)localObject3, mBeaconID, arrayOfByte));
        try
        {
          VsReporter.reportCKey(mContext, mPlatform, mSdtfrom, localVsAppKeyBean.getVsKey(), mGuid, paramString1, mBeaconID, 0, mPkgName, paramString4, paramString5, paramString2, paramLong, paramString3, str1 + "|" + (String)localObject1, mExtInfo, str3);
          return paramString3;
        }
        catch (Throwable paramString1)
        {
          paramString2 = paramString3;
          VsLog.error("getCKey: catch " + paramString1.getMessage(), new Object[0]);
          return paramString2;
        }
      }
    }
  }
  
  private static native String getCKeyVersion();
  
  public static int getHandler()
  {
    return mHandler;
  }
  
  public static String getJarVersion()
  {
    return mJarVersion;
  }
  
  private static native byte[] getSignature(String paramString, long paramLong);
  
  public static String getSoVersion()
  {
    return mSoVersion;
  }
  
  public static String getVersion()
  {
    try
    {
      String str = getCKeyVersion();
      VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "ver succ" });
      return str;
    }
    catch (Throwable localThrowable)
    {
      VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "ver error" });
    }
    return "";
  }
  
  private static native String getencSS(int paramInt);
  
  public static String getfd(String paramString)
  {
    try
    {
      if (paramString.length() <= 2) {
        return "null";
      }
      char[] arrayOfChar = paramString.substring(1).toCharArray();
      int i = 0;
      while (i < paramString.length() - 1)
      {
        arrayOfChar[i] = ((char)(arrayOfChar[i] + '1' + i + i));
        i += 1;
      }
      paramString = String.valueOf(arrayOfChar);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "null";
  }
  
  public static String getfd(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = byteArrayToString(paramArrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder("");
      if (paramArrayOfByte.length() <= 2) {
        return "ffff";
      }
      char[] arrayOfChar = paramArrayOfByte.substring(1).toCharArray();
      int i = 0;
      while (i < paramArrayOfByte.length() - 1)
      {
        localStringBuilder.append((char)(arrayOfChar[i] + '1' + i + i));
        i += 1;
      }
      paramArrayOfByte = localStringBuilder.toString();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return "ffff";
  }
  
  public static String getmPlatform()
  {
    return mPlatform;
  }
  
  public static String getmSdtfrom()
  {
    return mSdtfrom;
  }
  
  public static CKeyFacade instance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new CKeyFacade();
      }
      CKeyFacade localCKeyFacade = mInstance;
      return localCKeyFacade;
    }
    finally {}
  }
  
  private static Boolean parseJson2IntA(String paramString, int[] paramArrayOfInt)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (localJSONObject.has("extern1"))
        {
          paramArrayOfInt[0] = localJSONObject.optInt("extern1", 0);
          j = 0x0 | flag_11;
          paramString = Boolean.valueOf(true);
          int i = j;
          if (localJSONObject.has("extern2"))
          {
            paramArrayOfInt[1] = localJSONObject.optInt("extern2", 0);
            i = j | flag_22;
            paramString = Boolean.valueOf(true);
          }
          j = i;
          if (localJSONObject.has("extern3"))
          {
            paramArrayOfInt[2] = localJSONObject.optInt("extern3", 0);
            j = i | flag_33;
            paramString = Boolean.valueOf(true);
          }
          i = j;
          if (localJSONObject.has("extern4"))
          {
            paramArrayOfInt[3] = localJSONObject.optInt("extern4", 0);
            i = j | flag_44;
            paramString = Boolean.valueOf(true);
          }
          paramArrayOfInt[9] = i;
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return Boolean.valueOf(false);
      }
      int j = 0;
      paramString = localBoolean;
    }
  }
  
  public static void setInterface(String paramString1, String paramString2, BeaconInterface paramBeaconInterface, ModuleUpdateInterface paramModuleUpdateInterface)
  {
    LibLoadUtil.setModuleLoadInterface(paramModuleUpdateInterface);
    cKeyBeaconReport = new CKeyBeaconReport(paramString1, paramString2, paramBeaconInterface);
  }
  
  public static void setSwitchReport(boolean paramBoolean)
  {
    CKeyBeaconReport.setSwitchReport(paramBoolean);
  }
  
  private static native String taskEncrypt(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString5);
  
  public boolean addVsAppkey(Context paramContext, String paramString)
  {
    boolean bool = true;
    int i;
    if (VsAppKeyUtil.getInstance().getCount() > 0)
    {
      i = 1;
      paramContext = VsAppKeyVerify.getInstance().verifyVsAppKey(paramContext, paramString);
      if (paramContext != null) {
        break label38;
      }
      bool = false;
    }
    label38:
    while (i != 0)
    {
      return bool;
      i = 0;
      break;
    }
    initStartrail(paramContext.getPlatform());
    return true;
  }
  
  public String getmExtInfo()
  {
    return mExtInfo;
  }
  
  public String getmOpenID()
  {
    return mOpenID;
  }
  
  public String getmUin()
  {
    return mUin;
  }
  
  public String getmVuid()
  {
    return mVuid;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2)
  {
    VsLog.info("CKeyFacade|ckeygeneratorV2.so", new Object[] { "load ckeygeneratorV2.so init" });
    if (!bLoadSucc) {
      bLoadSucc = LibLoadUtil.loadso(paramContext, "ckeygeneratorV2");
    }
    StarTrailHelper.loadso(mContext);
    if (paramContext == null) {}
    do
    {
      return;
      mContext = paramContext.getApplicationContext();
      DeviceInfoUtil.updateQimei(mContext);
      paramContext = VsAppKeyVerify.getInstance().verifyVsAppKey(mContext, paramString1);
      if (paramContext != null)
      {
        mPlatform = paramContext.getPlatform();
        mPkgName = paramContext.getPkgName();
        mSdtfrom = paramContext.getSdtfrom();
        mVsKey = paramContext.getVsKey();
      }
      new StringBuilder().append("dl_").append(mPlatform).toString();
    } while ((this.isInit) || (this.isMutiInit));
    CKeyGuard.guardInit(mContext);
    mSoVersion = getVersion();
    mBsGuid = paramString2;
    paramContext = new Thread(new CKeyFacade.1(this, paramString2, paramContext));
    paramContext.setName("TVK_guidthread");
    paramContext.start();
    this.isInit = true;
  }
  
  public void initStartrail(String paramString)
  {
    paramString = "dl_" + paramString;
    try
    {
      Object localObject = cKeyBeaconReport;
      mBeaconID = CKeyBeaconReport.getQIMEI();
      mGuid = "";
      localObject = Thread.currentThread().getStackTrace()[2].getMethodName();
      DeviceInfoUtil.getQimei36();
      mHandler = StarTrailHelper.stInitUp(mContext, paramString, mBeaconID, mBsGuid, (String)localObject, getAppVer(mContext));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void setInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    mUin = paramString1;
    mOpenID = paramString2;
    mVuid = paramString3;
    mExtInfo = paramString4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.CKeyFacade
 * JD-Core Version:    0.7.0.1
 */