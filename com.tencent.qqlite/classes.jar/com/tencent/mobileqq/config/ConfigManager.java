package com.tencent.mobileqq.config;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.BaseConf;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import ddc;
import ddd;
import dde;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import protocol.KQQConfig.GetResourceRespInfoV2;

public class ConfigManager
  implements CommandListener, IHttpCommunicatorListener
{
  public static final byte a = 1;
  public static final int a = 1;
  public static final String a = "CONFIG_MSG";
  public static final byte[] a;
  public static final byte b = 2;
  private static final int b = 30;
  public static final String b = "CONFIG_TITLE";
  private static int c = 1;
  public static final String c = "http://activeqq.3g.qq.com/activeQQ/upgrade.jsp";
  public static final String d = "http://kiss.3g.qq.com/activeQQ/mq/5?g_t=2&";
  public static final String e = "http://kiss.3g.qq.com/activeQQ/mq/4?";
  public static final String f = "qq_config.dat";
  private static final String h = "http://conf.3g.qq.com/newConf/n";
  private static final String i = "POST";
  public Command a;
  public ddd a;
  private File jdField_a_of_type_JavaIoFile;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public Command b;
  String g;
  private String j;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { -16, 68, 31, 95, -12, 45, -91, -113, -36, -9, -108, -102, -70, 98, -44, 17 };
  }
  
  public ConfigManager(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_Ddd = new ddd(this);
    String str = paramContext.getFilesDir().getAbsolutePath() + "/" + paramString;
    File localFile = new File(str);
    if (localFile != null) {}
    try
    {
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    this.g = (paramContext.getFilesDir().getAbsolutePath() + "/" + paramString + "/" + "qq_config.dat");
    if (QLog.isDevelopLevel()) {
      QLog.i("SPLASH_ConfigServlet", 4, "savePointFilePath == " + this.g);
    }
    this.jdField_a_of_type_JavaIoFile = new File(str, "qq_config.dat");
    try
    {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {
        this.jdField_a_of_type_JavaIoFile.createNewFile();
      }
      this.jdField_a_of_type_JavaUtilTimer = ThreadManager.a();
      this.j = paramString;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static final int a()
  {
    int k = c;
    c = k + 1;
    return k;
  }
  
  public static ResourcePluginInfo a(EntityManager paramEntityManager, boolean paramBoolean, GetResourceRespInfoV2 paramGetResourceRespInfoV2)
  {
    ResourcePluginInfo localResourcePluginInfo = new ResourcePluginInfo();
    localResourcePluginInfo.strPkgName = paramGetResourceRespInfoV2.strPkgName;
    localResourcePluginInfo.strResName = paramGetResourceRespInfoV2.strResName;
    Object localObject;
    if (paramBoolean) {
      localObject = paramGetResourceRespInfoV2.strResURL_big;
    }
    for (;;)
    {
      localResourcePluginInfo.strResURL = ((String)localObject);
      localResourcePluginInfo.uiCurVer = paramGetResourceRespInfoV2.uiNewVer;
      localResourcePluginInfo.sLanType = paramGetResourceRespInfoV2.sLanType;
      localResourcePluginInfo.sResSubType = paramGetResourceRespInfoV2.sResSubType;
      localObject = ConfigParser.a(paramGetResourceRespInfoV2.strResConf);
      localResourcePluginInfo.strGotoUrl = ((String)((HashMap)localObject).get("pluginEntranceUrl"));
      localObject = (String)((HashMap)localObject).get("newswitch");
      if (localObject != null) {}
      try
      {
        if ((byte)Integer.parseInt((String)localObject) == 0) {}
        for (localResourcePluginInfo.isNew = 1;; localResourcePluginInfo.isNew = 0)
        {
          localResourcePluginInfo.sPriority = paramGetResourceRespInfoV2.sPriority;
          localResourcePluginInfo.strResDesc = paramGetResourceRespInfoV2.strResDesc;
          localResourcePluginInfo.cCanChangeState = paramGetResourceRespInfoV2.cCanChangeState;
          localResourcePluginInfo.cDefaultState = paramGetResourceRespInfoV2.cDefaultState;
          localResourcePluginInfo.uiResId = paramGetResourceRespInfoV2.uiResId;
          if (localResourcePluginInfo.cDefaultState != 0) {
            break label217;
          }
          localResourcePluginInfo.cLocalState = 1;
          localResourcePluginInfo.iPluginType = paramGetResourceRespInfoV2.iPluginType;
          ResourcePluginInfo.persistOrReplace(paramEntityManager, localResourcePluginInfo);
          return localResourcePluginInfo;
          localObject = paramGetResourceRespInfoV2.strResURL_small;
          break;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label217:
          if (localResourcePluginInfo.cDefaultState == 1) {
            localResourcePluginInfo.cLocalState = 0;
          }
        }
      }
    }
  }
  
  static String a(String paramString, int paramInt)
  {
    if ((paramInt <= 0) || (paramString.indexOf("g_q=") != -1)) {
      return paramString;
    }
    if (paramString.indexOf('?') > 0)
    {
      if (paramString.endsWith("g_q=")) {
        return paramString + paramInt;
      }
      return paramString + "&g_q=" + paramInt;
    }
    return paramString + "?g_q=" + paramInt;
  }
  
  static String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer().append(paramString1.trim());
    String str = Config.b();
    if ((str == null) || (str.length() == 0) || (str.equals("00"))) {}
    for (;;)
    {
      if (paramString2 != null)
      {
        paramString1 = paramString2.trim();
        if (paramString1.length() > 0)
        {
          if (paramString1.charAt(0) != '&') {
            localStringBuffer.append('&');
          }
          localStringBuffer.append(paramString1);
        }
      }
      return localStringBuffer.toString();
      if (paramString1.indexOf('?') > 0)
      {
        if (paramString1.endsWith("sid=")) {
          localStringBuffer.append(str);
        } else {
          localStringBuffer.append('&').append("sid=").append(str);
        }
      }
      else {
        localStringBuffer.append('?').append("sid=").append(str);
      }
    }
  }
  
  private void a(BaseConf paramBaseConf, DataInputStream paramDataInputStream)
  {
    paramBaseConf.a(paramDataInputStream);
  }
  
  public static void a(String paramString1, String paramString2, CommandListener paramCommandListener, Command[] paramArrayOfCommand, boolean paramBoolean) {}
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   9: ifnull +327 -> 336
    //   12: aload_0
    //   13: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   16: invokevirtual 119	java/io/File:exists	()Z
    //   19: ifeq +317 -> 336
    //   22: aload_0
    //   23: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   26: invokevirtual 323	java/io/File:canRead	()Z
    //   29: ifeq +307 -> 336
    //   32: aload_0
    //   33: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   36: invokevirtual 326	java/io/File:length	()J
    //   39: lconst_0
    //   40: lcmp
    //   41: ifle +295 -> 336
    //   44: new 328	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   52: invokespecial 331	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: aload 5
    //   58: astore 4
    //   60: aload_3
    //   61: ifnull +124 -> 185
    //   64: aload 5
    //   66: astore 4
    //   68: aload_3
    //   69: invokevirtual 334	java/io/FileInputStream:available	()I
    //   72: ifle +113 -> 185
    //   75: new 336	java/io/DataInputStream
    //   78: dup
    //   79: aload_3
    //   80: invokespecial 339	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore 5
    //   85: iconst_0
    //   86: istore_1
    //   87: aload 5
    //   89: astore 4
    //   91: iload_1
    //   92: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   95: arraylength
    //   96: if_icmpge +85 -> 181
    //   99: aload 5
    //   101: astore 4
    //   103: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   106: iload_1
    //   107: aaload
    //   108: astore 6
    //   110: aload 5
    //   112: astore 4
    //   114: aload_0
    //   115: aload 6
    //   117: aload 5
    //   119: invokespecial 344	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataInputStream;)V
    //   122: aload 5
    //   124: astore 4
    //   126: aload 6
    //   128: getfield 347	com/tencent/mobileqq/config/struct/BaseConf:a_	B
    //   131: iconst_1
    //   132: if_icmpeq +15 -> 147
    //   135: aload 5
    //   137: astore 4
    //   139: aload 6
    //   141: getfield 347	com/tencent/mobileqq/config/struct/BaseConf:a_	B
    //   144: ifne +24 -> 168
    //   147: aload 5
    //   149: astore 4
    //   151: aload 6
    //   153: invokevirtual 349	com/tencent/mobileqq/config/struct/BaseConf:a	()Z
    //   156: ifeq +12 -> 168
    //   159: aload 5
    //   161: astore 4
    //   163: aload 6
    //   165: invokevirtual 351	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   168: iload_1
    //   169: iconst_1
    //   170: iadd
    //   171: istore_1
    //   172: goto -85 -> 87
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_3
    //   178: goto -122 -> 56
    //   181: aload 5
    //   183: astore 4
    //   185: aload_3
    //   186: ifnull +7 -> 193
    //   189: aload_3
    //   190: invokevirtual 354	java/io/FileInputStream:close	()V
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 355	java/io/DataInputStream:close	()V
    //   203: iconst_0
    //   204: istore_1
    //   205: iload_1
    //   206: ifeq +119 -> 325
    //   209: iload_2
    //   210: istore_1
    //   211: iload_1
    //   212: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   215: arraylength
    //   216: if_icmpge +109 -> 325
    //   219: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   222: iload_1
    //   223: aaload
    //   224: invokevirtual 351	com/tencent/mobileqq/config/struct/BaseConf:a	()V
    //   227: iload_1
    //   228: iconst_1
    //   229: iadd
    //   230: istore_1
    //   231: goto -20 -> 211
    //   234: astore_3
    //   235: iconst_0
    //   236: istore_1
    //   237: goto -32 -> 205
    //   240: astore 6
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 5
    //   247: astore 4
    //   249: aload 6
    //   251: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   254: aload_3
    //   255: ifnull +7 -> 262
    //   258: aload_3
    //   259: invokevirtual 354	java/io/FileInputStream:close	()V
    //   262: aload 5
    //   264: ifnull +8 -> 272
    //   267: aload 5
    //   269: invokevirtual 355	java/io/DataInputStream:close	()V
    //   272: iconst_1
    //   273: istore_1
    //   274: goto -69 -> 205
    //   277: astore_3
    //   278: iconst_1
    //   279: istore_1
    //   280: goto -75 -> 205
    //   283: astore 5
    //   285: aconst_null
    //   286: astore 4
    //   288: aload_3
    //   289: ifnull +7 -> 296
    //   292: aload_3
    //   293: invokevirtual 354	java/io/FileInputStream:close	()V
    //   296: aload 4
    //   298: ifnull +8 -> 306
    //   301: aload 4
    //   303: invokevirtual 355	java/io/DataInputStream:close	()V
    //   306: aload 5
    //   308: athrow
    //   309: astore_3
    //   310: goto -117 -> 193
    //   313: astore_3
    //   314: goto -52 -> 262
    //   317: astore_3
    //   318: goto -22 -> 296
    //   321: astore_3
    //   322: goto -16 -> 306
    //   325: return
    //   326: astore 5
    //   328: goto -40 -> 288
    //   331: astore 6
    //   333: goto -88 -> 245
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -282 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	ConfigManager
    //   86	194	1	k	int
    //   4	206	2	m	int
    //   55	25	3	localFileInputStream	java.io.FileInputStream
    //   175	1	3	localException1	Exception
    //   177	13	3	localObject1	Object
    //   234	25	3	localException2	Exception
    //   277	16	3	localException3	Exception
    //   309	1	3	localException4	Exception
    //   313	1	3	localException5	Exception
    //   317	1	3	localException6	Exception
    //   321	1	3	localException7	Exception
    //   337	1	3	localObject2	Object
    //   58	244	4	localDataInputStream1	DataInputStream
    //   1	267	5	localDataInputStream2	DataInputStream
    //   283	24	5	localObject3	Object
    //   326	1	5	localObject4	Object
    //   108	56	6	localBaseConf	BaseConf
    //   240	10	6	localException8	Exception
    //   331	1	6	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   44	56	175	java/lang/Exception
    //   198	203	234	java/lang/Exception
    //   68	85	240	java/lang/Exception
    //   267	272	277	java/lang/Exception
    //   68	85	283	finally
    //   189	193	309	java/lang/Exception
    //   258	262	313	java/lang/Exception
    //   292	296	317	java/lang/Exception
    //   301	306	321	java/lang/Exception
    //   91	99	326	finally
    //   103	110	326	finally
    //   114	122	326	finally
    //   126	135	326	finally
    //   139	147	326	finally
    //   151	159	326	finally
    //   163	168	326	finally
    //   249	254	326	finally
    //   91	99	331	java/lang/Exception
    //   103	110	331	java/lang/Exception
    //   114	122	331	java/lang/Exception
    //   126	135	331	java/lang/Exception
    //   139	147	331	java/lang/Exception
    //   151	159	331	java/lang/Exception
    //   163	168	331	java/lang/Exception
  }
  
  public void a(Command paramCommand, ConfigDialog paramConfigDialog) {}
  
  public void a(BaseConf paramBaseConf, DataOutputStream paramDataOutputStream)
  {
    paramBaseConf.a(paramDataOutputStream);
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg arg1, HttpMsg paramHttpMsg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShanPing", 2, "config-huibao--decode------------");
    }
    paramHttpMsg2 = paramHttpMsg2.a();
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        if (this.jdField_a_of_type_Boolean) {
          return;
        }
        ConfigParser.a(paramHttpMsg2, new dde(), this.j);
        b();
        d();
        return;
      }
      return;
    }
    catch (RuntimeException ???) {}
  }
  
  public void a(String paramString) {}
  
  public void a(BaseConf[] paramArrayOfBaseConf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashLogo", 2, "fight..confighParse..getConfig");
    }
    this.jdField_a_of_type_Boolean = false;
    paramArrayOfBaseConf = new HttpMsg("http://conf.3g.qq.com/newConf/n", ConfigParser.a(paramArrayOfBaseConf), this, true);
    paramArrayOfBaseConf.c("POST");
    paramArrayOfBaseConf.b(5);
    HttpCommunicator localHttpCommunicator = Config.a();
    if (localHttpCommunicator != null) {
      localHttpCommunicator.a(paramArrayOfBaseConf);
    }
    this.jdField_a_of_type_JavaUtilTimer.schedule(new ddc(this), 1000L);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaIoFile != null) && (this.jdField_a_of_type_JavaIoFile.exists()))
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        this.jdField_a_of_type_JavaIoFile = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    d();
  }
  
  public boolean b()
  {
    boolean bool = true;
    switch (this.jdField_a_of_type_Ddd.a)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: new 99	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 124	com/tencent/mobileqq/config/ConfigManager:g	Ljava/lang/String;
    //   14: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: putfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   20: aload_0
    //   21: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   24: invokevirtual 119	java/io/File:exists	()Z
    //   27: ifne +11 -> 38
    //   30: aload_0
    //   31: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   34: invokevirtual 144	java/io/File:createNewFile	()Z
    //   37: pop
    //   38: aload_0
    //   39: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   42: ifnull +85 -> 127
    //   45: aload_0
    //   46: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   49: invokevirtual 119	java/io/File:exists	()Z
    //   52: ifeq +75 -> 127
    //   55: new 431	java/io/FileOutputStream
    //   58: dup
    //   59: aload_0
    //   60: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   63: invokespecial 432	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: astore_2
    //   67: new 434	java/io/DataOutputStream
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 437	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   75: astore_3
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_1
    //   79: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   82: arraylength
    //   83: if_icmpge +28 -> 111
    //   86: aload_0
    //   87: getstatic 342	com/tencent/mobileqq/config/Config:a	[Lcom/tencent/mobileqq/config/struct/BaseConf;
    //   90: iload_1
    //   91: aaload
    //   92: aload_3
    //   93: invokevirtual 439	com/tencent/mobileqq/config/ConfigManager:a	(Lcom/tencent/mobileqq/config/struct/BaseConf;Ljava/io/DataOutputStream;)V
    //   96: iload_1
    //   97: iconst_1
    //   98: iadd
    //   99: istore_1
    //   100: goto -22 -> 78
    //   103: astore_2
    //   104: aload_2
    //   105: invokevirtual 156	java/lang/Exception:printStackTrace	()V
    //   108: goto -70 -> 38
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 441	java/io/DataOutputStream:close	()V
    //   127: return
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 441	java/io/DataOutputStream:close	()V
    //   147: aload_0
    //   148: getfield 141	com/tencent/mobileqq/config/ConfigManager:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   151: invokevirtual 427	java/io/File:delete	()Z
    //   154: pop
    //   155: return
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_2
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 440	java/io/FileOutputStream:close	()V
    //   167: aload 4
    //   169: ifnull +8 -> 177
    //   172: aload 4
    //   174: invokevirtual 441	java/io/DataOutputStream:close	()V
    //   177: aload_3
    //   178: athrow
    //   179: astore_2
    //   180: goto -61 -> 119
    //   183: astore_2
    //   184: return
    //   185: astore_3
    //   186: goto -47 -> 139
    //   189: astore_2
    //   190: goto -43 -> 147
    //   193: astore_2
    //   194: goto -27 -> 167
    //   197: astore_2
    //   198: goto -21 -> 177
    //   201: astore_3
    //   202: goto -43 -> 159
    //   205: astore 5
    //   207: aload_3
    //   208: astore 4
    //   210: aload 5
    //   212: astore_3
    //   213: goto -54 -> 159
    //   216: astore_3
    //   217: aconst_null
    //   218: astore 4
    //   220: aload_2
    //   221: astore_3
    //   222: aload 4
    //   224: astore_2
    //   225: goto -94 -> 131
    //   228: astore 4
    //   230: aload_2
    //   231: astore 4
    //   233: aload_3
    //   234: astore_2
    //   235: aload 4
    //   237: astore_3
    //   238: goto -107 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	ConfigManager
    //   77	23	1	k	int
    //   66	6	2	localFileOutputStream	java.io.FileOutputStream
    //   103	13	2	localException1	Exception
    //   128	1	2	localException2	Exception
    //   130	34	2	localObject1	Object
    //   179	1	2	localException3	Exception
    //   183	1	2	localException4	Exception
    //   189	1	2	localException5	Exception
    //   193	1	2	localException6	Exception
    //   197	24	2	localException7	Exception
    //   224	11	2	localObject2	Object
    //   4	132	3	localDataOutputStream	DataOutputStream
    //   156	22	3	localObject3	Object
    //   185	1	3	localException8	Exception
    //   201	7	3	localObject4	Object
    //   212	1	3	localObject5	Object
    //   216	1	3	localException9	Exception
    //   221	17	3	localObject6	Object
    //   1	222	4	localObject7	Object
    //   228	1	4	localException10	Exception
    //   231	5	4	localObject8	Object
    //   205	6	5	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   20	38	103	java/lang/Exception
    //   55	67	128	java/lang/Exception
    //   55	67	156	finally
    //   115	119	179	java/lang/Exception
    //   123	127	183	java/lang/Exception
    //   135	139	185	java/lang/Exception
    //   143	147	189	java/lang/Exception
    //   163	167	193	java/lang/Exception
    //   172	177	197	java/lang/Exception
    //   67	76	201	finally
    //   78	96	205	finally
    //   67	76	216	java/lang/Exception
    //   78	96	228	java/lang/Exception
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    Object localObject = Config.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ConfigListener)((Iterator)localObject).next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.ConfigManager
 * JD-Core Version:    0.7.0.1
 */