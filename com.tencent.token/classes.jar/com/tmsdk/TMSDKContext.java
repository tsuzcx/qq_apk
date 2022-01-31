package com.tmsdk;

import android.content.Context;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.ISharkCallBackOut;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.common.util.TmsLog;

public class TMSDKContext
{
  private static final int BUILD_NO = 6001;
  public static final int ELANG_CHS = 1;
  public static final int ELANG_ENG = 2;
  public static final int ELANG_NONE = 0;
  private static final int EP_QQMobileToken = 115;
  private static final boolean IS_IPLIST = true;
  private static final String LC = "QQTOKEN20190910";
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
  
  public static void SaveStringData(int paramInt, String paramString)
  {
    TmsLog.d("TMSDKContext", "SaveStringData, modelId:[" + paramInt + "]msg:[" + paramString + "]");
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = " ";
    }
    TMSDKBaseContext.SaveStringData(paramInt, str);
  }
  
  public static void c_c(int paramInt)
  {
    TmsLog.d("TMSDKContext", "c_c, arg:[" + paramInt + "]");
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
  
  /* Error */
  public static boolean init(Context paramContext, AbsTMSConfig paramAbsTMSConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 47
    //   5: new 67	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   12: ldc 121
    //   14: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: ldc 126
    //   23: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc 81
    //   32: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 91	com/tmsdk/common/util/TmsLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: ifnonnull +17 -> 59
    //   45: ldc 47
    //   47: ldc 128
    //   49: invokestatic 131	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore_2
    //   54: ldc 2
    //   56: monitorexit
    //   57: iload_2
    //   58: ireturn
    //   59: aload_1
    //   60: ifnull +23 -> 83
    //   63: aload_1
    //   64: putstatic 59	com/tmsdk/TMSDKContext:sAbsTMSConfig	Lcom/tmsdk/AbsTMSConfig;
    //   67: aload_0
    //   68: new 133	com/tmsdk/TMSDKContext$2
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 136	com/tmsdk/TMSDKContext$2:<init>	(Landroid/content/Context;)V
    //   76: invokestatic 139	com/tmsdk/base/TMSDKBaseContext:init	(Landroid/content/Context;Lcom/tmsdk/base/AbsTMSBaseConfig;)Z
    //   79: istore_2
    //   80: goto -26 -> 54
    //   83: new 141	com/tmsdk/TMSDKContext$1
    //   86: dup
    //   87: invokespecial 142	com/tmsdk/TMSDKContext$1:<init>	()V
    //   90: putstatic 59	com/tmsdk/TMSDKContext:sAbsTMSConfig	Lcom/tmsdk/AbsTMSConfig;
    //   93: goto -26 -> 67
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_0
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramContext	Context
    //   0	102	1	paramAbsTMSConfig	AbsTMSConfig
    //   53	27	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	41	96	finally
    //   45	52	96	finally
    //   63	67	96	finally
    //   67	80	96	finally
    //   83	93	96	finally
  }
  
  public static boolean isInitialized()
  {
    return TMSDKBaseContext.isInitialized();
  }
  
  public static void saveActionData(int paramInt)
  {
    TmsLog.d("TMSDKContext", "saveActionData, modelId:[" + paramInt + "])");
    TMSDKBaseContext.saveActionData(paramInt);
  }
  
  public static void sendShark(int paramInt, JceStruct paramJceStruct1, JceStruct paramJceStruct2, ISharkCallBackOut paramISharkCallBackOut)
  {
    TMSDKBaseContext.sendShark(paramInt, paramJceStruct1, paramJceStruct2, 0, paramISharkCallBackOut);
  }
  
  public static void setAutoConnectionSwitch(Context paramContext, boolean paramBoolean)
  {
    TmsLog.d("TMSDKContext", "setAutoConnectionSwitch, aContext[" + paramContext + "]aAutoConnection:[" + paramBoolean + "]");
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