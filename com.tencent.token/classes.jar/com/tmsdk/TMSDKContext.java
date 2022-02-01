package com.tmsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.aaw;
import com.tencent.token.aay;
import com.tencent.token.ael;
import com.tencent.token.agn;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.xr;
import com.tencent.token.yc;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.common.util.ReleaseSetting;
import com.tmsdk.common.util.TmsLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TMSDKContext
{
  private static final int BUILD_NO = 6001;
  public static final int ELANG_CHS = 1;
  public static final int ELANG_ENG = 2;
  public static final int ELANG_NONE = 0;
  private static final int EP_QQMobileToken = 115;
  private static final boolean IS_IPLIST = true;
  public static final String LC = "C1D4CD9B6187E99C";
  private static final String LIB_TMS_COMMON = "Tcc-1.0.1";
  private static final int PRODUCT_ID = 115;
  private static final String SDK_VERSION = "2.0.0";
  private static final String SDK_VERSION_INFO = "2.0.0 20190827163200";
  public static final int S_ERR_FILE_OP = -201;
  public static final int S_ERR_FROM_SERVER = -101;
  public static final int S_ERR_TIMEOUT = -102;
  public static final int S_ERR_UNKNOWN = -999;
  public static final int S_EXIST_NEWER_DB = -208;
  public static final int S_NOTEXIST_NEWER_DB = -209;
  public static final int S_OK = 0;
  static final String TAG_LOG = "TMSDKContext";
  private static final String TCP_SERVER = "mazu.3g.qq.com";
  private static final String TCP_SERVER_TEST = "mazutest.3g.qq.com";
  static AbsTMSConfig sAbsTMSConfig = null;
  static final List<Pair<Integer, String>> waitingList = Collections.synchronizedList(new ArrayList());
  
  public static void SaveStringData(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder("SaveStringData, modelId:[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]msg:[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    TmsLog.d("TMSDKContext", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = " ";
    }
    if (!isInitialized())
    {
      waitingList.add(new Pair(Integer.valueOf(paramInt), localObject));
      return;
    }
    TMSDKBaseContext.SaveStringData(paramInt, (String)localObject);
    checkFlushWaitingList();
  }
  
  public static void c_c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("c_c, arg:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    TmsLog.d("TMSDKContext", localStringBuilder.toString());
  }
  
  static void checkFlushWaitingList()
  {
    if (waitingList.size() > 0) {
      synchronized (waitingList)
      {
        Iterator localIterator = waitingList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if (localPair.second == null) {
            TMSDKBaseContext.saveActionData(((Integer)localPair.first).intValue());
          } else {
            TMSDKBaseContext.SaveStringData(((Integer)localPair.first).intValue(), (String)localPair.second);
          }
        }
        return;
      }
    }
  }
  
  public static boolean checkLicence()
  {
    return TMSDKBaseContext.checkLicence();
  }
  
  public static Context getApplicationContext()
  {
    return TMSDKBaseContext.getApplicationContext();
  }
  
  public static int getProductId()
  {
    return 115;
  }
  
  public static String getSDKVersionInfo()
  {
    return "2.0.0 20190827163200";
  }
  
  public static boolean init(Context paramContext, AbsTMSConfig paramAbsTMSConfig)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("init, aContext:[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("]aConfig:[");
      localStringBuilder.append(paramAbsTMSConfig);
      localStringBuilder.append("]");
      TmsLog.d("TMSDKContext", localStringBuilder.toString());
      if (paramContext == null)
      {
        TmsLog.w("TMSDKContext", "aContext is null");
        return false;
      }
      if (paramAbsTMSConfig != null) {
        sAbsTMSConfig = paramAbsTMSConfig;
      } else {
        sAbsTMSConfig = new AbsTMSConfig() {};
      }
      boolean bool = TMSDKBaseContext.init(paramContext, new AbsTMSBaseConfig()
      {
        public final int getBuildNo()
        {
          return xr.d();
        }
        
        public final String getChannel()
        {
          String str = aay.k();
          if ("0000".equals(str)) {
            return "999001";
          }
          return str;
        }
        
        public final String getDeviceId1()
        {
          return aay.l();
        }
        
        public final String getDeviceId2()
        {
          return aay.c(this.val$aContext);
        }
        
        public final String getDeviceId3()
        {
          return TMSDKContext.sAbsTMSConfig.getDeviceId3();
        }
        
        public final String getDeviceId4()
        {
          
          if (!yc.a) {
            return "";
          }
          long l = System.currentTimeMillis();
          Object localObject2 = agn.a(RqdApplication.n());
          Object localObject1 = "";
          if (((ael)localObject2).a() == 0)
          {
            localObject2 = ((ael)localObject2).c();
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = "";
            }
          }
          localObject2 = new StringBuilder("getOAID : ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("  time=");
          ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
          return localObject1;
        }
        
        public final String getLC()
        {
          return "C1D4CD9B6187E99C";
        }
        
        public final String getOpenIdTicket()
        {
          return yc.b();
        }
        
        public final int getProductId()
        {
          return 115;
        }
        
        public final String getTCPServerAdd()
        {
          String str2 = TMSDKContext.sAbsTMSConfig.getServerAddress();
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = "mazu.3g.qq.com";
          }
          return str1;
        }
        
        public final String getTccSoName()
        {
          return "Tcc-1.0.1";
        }
        
        public final String getVersion()
        {
          return aaw.b;
        }
        
        public final boolean isAllowAndroidID()
        {
          return ReleaseSetting.isAllowAndroidID();
        }
        
        public final boolean isAllowImei()
        {
          if (TextUtils.isEmpty(getDeviceId1())) {
            return true;
          }
          return ReleaseSetting.isAllowImei();
        }
        
        public final boolean isAllowImsi()
        {
          return ReleaseSetting.isAllowImsi();
        }
        
        public final boolean isAllowMac()
        {
          return ReleaseSetting.isAllowMac();
        }
        
        public final boolean isAllowOther()
        {
          return ReleaseSetting.isAllowOther();
        }
        
        public final boolean isCheckLicence()
        {
          return ReleaseSetting.isCheckLicence();
        }
        
        public final boolean isJavaTCC()
        {
          return ReleaseSetting.isJavaTCC();
        }
        
        public final boolean isUseIPList()
        {
          return TMSDKContext.sAbsTMSConfig.isUseIPList();
        }
      });
      return bool;
    }
    finally {}
  }
  
  public static boolean isInitialized()
  {
    return TMSDKBaseContext.isInitialized();
  }
  
  public static void saveActionData(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("saveActionData, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("])");
    TmsLog.d("TMSDKContext", localStringBuilder.toString());
    if (!isInitialized())
    {
      waitingList.add(new Pair(Integer.valueOf(paramInt), null));
      return;
    }
    TMSDKBaseContext.saveActionData(paramInt);
    checkFlushWaitingList();
  }
  
  public static void sendShark(int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ISharkCallBackOut paramISharkCallBackOut)
  {
    TMSDKBaseContext.sendShark(paramInt, paramJceStruct1, paramJceStruct2, 0, paramISharkCallBackOut);
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("setAutoConnectionSwitch, aContext[");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("]aAutoConnection:[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    TmsLog.d("TMSDKContext", localStringBuilder.toString());
    TMSDKBaseContext.setAutoConnectionSwitch(paramContext, paramBoolean);
  }
  
  public static void setCurrentLang(int paramInt)
  {
    TMSDKBaseContext.setCurrentLang(paramInt);
  }
  
  public static void setTMSDKLogEnable(boolean paramBoolean)
  {
    TmsLog.setLogEnable(paramBoolean);
    TMSDKBaseContext.setLogEnable(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.TMSDKContext
 * JD-Core Version:    0.7.0.1
 */