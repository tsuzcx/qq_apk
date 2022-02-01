package com.tmsdk;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.token.global.k;
import com.tencent.token.utils.j;
import com.tencent.token.utils.l;
import com.tmsdk.base.AbsTMSBaseConfig;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.common.util.ReleaseSetting;
import com.tmsdk.common.util.TmsLog;

public class TMSDKContext
{
  private static final int BUILD_NO = 6001;
  public static final int ELANG_CHS = 1;
  public static final int ELANG_ENG = 2;
  public static final int ELANG_NONE = 0;
  private static final int EP_QQMobileToken = 115;
  private static final boolean IS_IPLIST = true;
  private static final String LC = "C1D4CD9B6187E99C";
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
  static AbsTMSConfig sAbsTMSConfig;
  
  public static void SaveStringData(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SaveStringData, modelId:[");
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
    TMSDKBaseContext.SaveStringData(paramInt, (String)localObject);
  }
  
  public static void c_c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("c_c, arg:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    TmsLog.d("TMSDKContext", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init, aContext:[");
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
        public int getBuildNo()
        {
          return j.a;
        }
        
        public String getChannel()
        {
          String str = l.m();
          if ("0000".equals(str)) {
            return "1001";
          }
          return str;
        }
        
        public String getDeviceId1()
        {
          return l.b(this.val$aContext);
        }
        
        public String getDeviceId2()
        {
          return l.c(this.val$aContext);
        }
        
        public String getDeviceId3()
        {
          return TMSDKContext.sAbsTMSConfig.getDeviceId3();
        }
        
        public String getDeviceId4()
        {
          return k.b();
        }
        
        public String getLC()
        {
          return "C1D4CD9B6187E99C";
        }
        
        public String getOpenIdTicket()
        {
          return k.c();
        }
        
        public int getProductId()
        {
          return 115;
        }
        
        public String getTCPServerAdd()
        {
          String str2 = TMSDKContext.sAbsTMSConfig.getServerAddress();
          String str1 = str2;
          if (TextUtils.isEmpty(str2)) {
            str1 = "mazu.3g.qq.com";
          }
          return str1;
        }
        
        public String getTccSoName()
        {
          return "Tcc-1.0.1";
        }
        
        public String getVersion()
        {
          return j.b;
        }
        
        public boolean isAllowAndroidID()
        {
          return ReleaseSetting.isAllowAndroidID();
        }
        
        public boolean isAllowImei()
        {
          if (TextUtils.isEmpty(getDeviceId1())) {
            return true;
          }
          return ReleaseSetting.isAllowImei();
        }
        
        public boolean isAllowImsi()
        {
          return ReleaseSetting.isAllowImsi();
        }
        
        public boolean isAllowMac()
        {
          return ReleaseSetting.isAllowMac();
        }
        
        public boolean isAllowOther()
        {
          return ReleaseSetting.isAllowOther();
        }
        
        public boolean isCheckLicence()
        {
          return ReleaseSetting.isCheckLicence();
        }
        
        public boolean isJavaTCC()
        {
          return ReleaseSetting.isJavaTCC();
        }
        
        public boolean isUseIPList()
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveActionData, modelId:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("])");
    TmsLog.d("TMSDKContext", localStringBuilder.toString());
    TMSDKBaseContext.saveActionData(paramInt);
  }
  
  public static void sendShark(int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ISharkCallBackOut paramISharkCallBackOut)
  {
    TMSDKBaseContext.sendShark(paramInt, paramJceStruct1, paramJceStruct2, 0, paramISharkCallBackOut);
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAutoConnectionSwitch, aContext[");
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