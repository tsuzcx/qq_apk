package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.CPU;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Memory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Screen;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Storage;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import csb;
import csc;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.AppRuntime;
import org.xml.sax.InputSource;

public class DeviceProfileManager
{
  private static DeviceProfileManager.AccountDpcManager jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager;
  private static volatile DeviceProfileManager jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
  public static ConfigurationService.ReqGetConfig a;
  public static final String a;
  public static boolean a = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "featureValue" };
  private static Field[] jdField_a_of_type_ArrayOfJavaLangReflectField;
  public static final int b = 1;
  public static final String b = "dpcConfig";
  public static final int c = 2;
  public static final String c = "dpcConfig_account";
  public static final int d = 3;
  public static final String d = "last_update_time";
  public static final int e = 4;
  public static final String e = "account_last_update_time";
  public static final String f = "key_versioncode";
  public static final String g = "server_version";
  public static final String h = "key_type";
  public static final String i = "ab_rand";
  private static final String j = ",";
  public int a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceProfileManager.class.getSimpleName();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig = null;
  }
  
  private DeviceProfileManager()
  {
    c();
  }
  
  private DeviceProfileManager.DPCConfigInfo a(String paramString)
  {
    HashMap localHashMap;
    if (DeviceProfileManager.AccountDpcManager.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "getFeatureValue() accountDpcManager is null");
        }
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getFeatureValue() accountDpcNames=" + paramString);
      }
      localHashMap = jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager.jdField_a_of_type_JavaUtilHashMap;
      paramString = DeviceProfileManager.AccountDpcManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager, paramString);
    }
    for (;;)
    {
      return (DeviceProfileManager.DPCConfigInfo)localHashMap.get(paramString);
      localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    }
  }
  
  public static DeviceProfileManager a()
  {
    jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager = (DeviceProfileManager.AccountDpcManager)BaseApplicationImpl.a.a().getManager(53);
    if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager = new DeviceProfileManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
    }
    finally {}
  }
  
  public static ConfigurationService.ReqGetConfig a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "test mode is enable");
      }
      a(jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig);
      return jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig;
    }
    Object localObject1 = new ConfigurationService.OS();
    ((ConfigurationService.OS)localObject1).setHasFlag(true);
    ((ConfigurationService.OS)localObject1).type.set(2);
    ((ConfigurationService.OS)localObject1).kernel.set(DeviceInfoUtil.l());
    ((ConfigurationService.OS)localObject1).sdk.set(String.valueOf(DeviceInfoUtil.a()));
    ((ConfigurationService.OS)localObject1).version.set(DeviceInfoUtil.e());
    ((ConfigurationService.OS)localObject1).rom.set(DeviceInfoUtil.i());
    ConfigurationService.CPU localCPU = new ConfigurationService.CPU();
    localCPU.setHasFlag(true);
    localCPU.model.set(DeviceInfoUtil.f());
    localCPU.cores.set(DeviceInfoUtil.b());
    localCPU.frequency.set((int)DeviceInfoUtil.a());
    ConfigurationService.Memory localMemory = new ConfigurationService.Memory();
    localMemory.setHasFlag(true);
    localMemory.total.set(DeviceInfoUtil.c());
    localMemory.process.set(DeviceInfoUtil.e());
    ConfigurationService.Storage localStorage = new ConfigurationService.Storage();
    localStorage.setHasFlag(true);
    localStorage.builtin.set(DeviceInfoUtil.b());
    Object localObject2 = DeviceInfoUtil.b();
    localStorage.external.set(localObject2[0] * 1048576L + localObject2[1] * 1024L * 1024L);
    localObject2 = new ConfigurationService.Screen();
    ((ConfigurationService.Screen)localObject2).setHasFlag(true);
    ((ConfigurationService.Screen)localObject2).model.set("");
    ((ConfigurationService.Screen)localObject2).width.set((int)DeviceInfoUtil.f());
    ((ConfigurationService.Screen)localObject2).height.set((int)DeviceInfoUtil.g());
    ((ConfigurationService.Screen)localObject2).dpi.set(DeviceInfoUtil.e());
    ((ConfigurationService.Screen)localObject2).multi_touch.set(DeviceInfoUtil.c());
    ConfigurationService.Camera localCamera = new ConfigurationService.Camera();
    localCamera.setHasFlag(true);
    localCamera.primary.set(0L);
    localCamera.secondary.set(0L);
    localCamera.flash.set(false);
    Object localObject3 = new ConfigurationService.ConfigSeq();
    ((ConfigurationService.ConfigSeq)localObject3).setHasFlag(true);
    ((ConfigurationService.ConfigSeq)localObject3).type.set(4);
    int k = 0;
    if (paramBoolean) {
      k = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig_account").getInt(DeviceProfileManager.AccountDpcManager.a((QQAppInterface)paramAppInterface, "server_version"), 0);
    }
    ((ConfigurationService.ConfigSeq)localObject3).version.set(k);
    paramAppInterface = new ArrayList();
    paramAppInterface.add(localObject3);
    localObject3 = new ConfigurationService.DeviceInfo();
    ((ConfigurationService.DeviceInfo)localObject3).setHasFlag(true);
    ((ConfigurationService.DeviceInfo)localObject3).brand.set(DeviceInfoUtil.g());
    ((ConfigurationService.DeviceInfo)localObject3).model.set(DeviceInfoUtil.d());
    ((ConfigurationService.DeviceInfo)localObject3).os = ((ConfigurationService.OS)localObject1);
    ((ConfigurationService.DeviceInfo)localObject3).cpu = localCPU;
    ((ConfigurationService.DeviceInfo)localObject3).memory = localMemory;
    ((ConfigurationService.DeviceInfo)localObject3).storage = localStorage;
    ((ConfigurationService.DeviceInfo)localObject3).screen = ((ConfigurationService.Screen)localObject2);
    ((ConfigurationService.DeviceInfo)localObject3).camera = localCamera;
    localObject1 = new ConfigurationService.ReqGetConfig();
    ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject3);
    ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll(paramAppInterface);
    a((ConfigurationService.ReqGetConfig)localObject1);
    return localObject1;
  }
  
  private void a(long paramLong)
  {
    if (a() != 4) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        int k = a();
        if (k != 4) {}
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "waitDPCServerData() is waiting threadID=" + Thread.currentThread().getId());
          }
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.wait(paramLong);
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "waitDpcServerData failed", localInterruptedException);
            }
          }
        }
        return;
      }
    }
  }
  
  private static void a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    if (QLog.isColorLevel())
    {
      ConfigurationService.DeviceInfo localDeviceInfo = paramReqGetConfig.device_info;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("config.version = " + ((ConfigurationService.ConfigSeq)paramReqGetConfig.seq_list.get(0)).version.get() + "\n");
      localStringBuilder.append("buidldReqConfig{");
      localStringBuilder.append(" brand= ");
      localStringBuilder.append(localDeviceInfo.brand.get());
      localStringBuilder.append(" ,model= ");
      localStringBuilder.append(localDeviceInfo.model.get());
      localStringBuilder.append(" ,os.type= ");
      localStringBuilder.append(localDeviceInfo.os.type.get());
      localStringBuilder.append(" ,os.kernel= ");
      localStringBuilder.append(localDeviceInfo.os.kernel.get());
      localStringBuilder.append(" ,os.sdk= ");
      localStringBuilder.append(localDeviceInfo.os.sdk.get());
      localStringBuilder.append(" ,os.version= ");
      localStringBuilder.append(localDeviceInfo.os.version.get());
      localStringBuilder.append(" ,os.rom= ");
      localStringBuilder.append(localDeviceInfo.os.rom.get());
      localStringBuilder.append(" ,cpu.model= ");
      localStringBuilder.append(localDeviceInfo.cpu.model.get());
      localStringBuilder.append(" ,cpu.cores= ");
      localStringBuilder.append(localDeviceInfo.cpu.cores.get());
      localStringBuilder.append(" ,cpu.frequency= ");
      localStringBuilder.append(localDeviceInfo.cpu.frequency.get());
      localStringBuilder.append(" ,memory.total= ");
      localStringBuilder.append(localDeviceInfo.memory.total.get());
      localStringBuilder.append(" ,memory.process= ");
      localStringBuilder.append(localDeviceInfo.memory.process.get());
      localStringBuilder.append(" ,storage.builtin= ");
      localStringBuilder.append(localDeviceInfo.storage.builtin.get());
      localStringBuilder.append(" ,storage.external= ");
      localStringBuilder.append(localDeviceInfo.storage.external.get());
      localStringBuilder.append(" ,screen.model= ");
      localStringBuilder.append(localDeviceInfo.screen.model.get());
      localStringBuilder.append(" ,screen.width= ");
      localStringBuilder.append(localDeviceInfo.screen.width.get());
      localStringBuilder.append(" ,screen.height= ");
      localStringBuilder.append(localDeviceInfo.screen.height.get());
      localStringBuilder.append(" ,screen.dpi= ");
      localStringBuilder.append(localDeviceInfo.screen.dpi.get());
      localStringBuilder.append(" ,screen.multi_touch= ");
      localStringBuilder.append(localDeviceInfo.screen.multi_touch.get());
      localStringBuilder.append(" ,camera.primary= ");
      localStringBuilder.append(localDeviceInfo.camera.primary.get());
      localStringBuilder.append(" ,camera.secondary= ");
      localStringBuilder.append(localDeviceInfo.camera.secondary.get());
      localStringBuilder.append(" ,camera.flash= ");
      localStringBuilder.append(localDeviceInfo.camera.flash.get());
      localStringBuilder.append(" }");
      QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public static DeviceProfileManager b()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager == null) {
        jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager = new DeviceProfileManager();
      }
      return jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
    }
    finally {}
  }
  
  private void b()
  {
    Object localObject1 = DeviceProfileManager.DpcNames.values();
    int m = localObject1.length;
    int k = 0;
    while (k < m)
    {
      Object localObject2 = localObject1[k];
      this.b.put(localObject2.name(), new DeviceProfileManager.DPCConfigInfo());
      k += 1;
    }
    localObject1 = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject1).featureValue = "1";
    this.b.put(DeviceProfileManager.DpcNames.magicface_support.name(), localObject1);
    new DeviceProfileManager.DPCConfigInfo().featureValue = "1";
    this.b.put(DeviceProfileManager.DpcNames.aio_eggs.name(), localObject1);
  }
  
  private static boolean b(DeviceProfileManager.DPCConfigInfo paramDPCConfigInfo, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramDPCConfigInfo == null)) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = paramString.toString().trim().split(",");
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    if (jdField_a_of_type_ArrayOfJavaLangReflectField == null)
    {
      jdField_a_of_type_ArrayOfJavaLangReflectField = new Field[jdField_a_of_type_ArrayOfJavaLangString.length];
      k = 0;
      for (;;)
      {
        if (k < jdField_a_of_type_ArrayOfJavaLangReflectField.length) {
          try
          {
            jdField_a_of_type_ArrayOfJavaLangReflectField[k] = paramDPCConfigInfo.getClass().getField(jdField_a_of_type_ArrayOfJavaLangString[k]);
            jdField_a_of_type_ArrayOfJavaLangReflectField[k].setAccessible(true);
            k += 1;
          }
          catch (NoSuchFieldException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              jdField_a_of_type_ArrayOfJavaLangReflectField[k] = null;
            }
          }
        }
      }
    }
    int m = Math.min(jdField_a_of_type_ArrayOfJavaLangReflectField.length, arrayOfString.length);
    int k = 0;
    boolean bool1 = false;
    boolean bool2;
    while (k < m)
    {
      paramString = arrayOfString[k];
      bool2 = bool1;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          bool2 = bool1;
        }
      }
      else
      {
        k += 1;
        bool1 = bool2;
        continue;
      }
      if ((paramString.indexOf('{', 0) != 0) || (paramString.lastIndexOf('}') != paramString.length() - 1)) {
        break label285;
      }
      paramString = paramString.substring(1, paramString.length() - 1);
    }
    label282:
    label285:
    for (;;)
    {
      try
      {
        if ((jdField_a_of_type_ArrayOfJavaLangReflectField[k] == null) || (paramString.equals((String)jdField_a_of_type_ArrayOfJavaLangReflectField[k].get(paramDPCConfigInfo)))) {
          break label282;
        }
        jdField_a_of_type_ArrayOfJavaLangReflectField[k].set(paramDPCConfigInfo, paramString);
        bool1 = true;
        bool2 = bool1;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        bool2 = bool1;
      }
      break;
      return bool1;
    }
  }
  
  @TargetApi(9)
  private void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "DeviceProfileManager init DPC content");
    }
    b();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig");
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("ab_rand", -1);
    Object localObject;
    int k;
    label116:
    DeviceProfileManager.DpcNames localDpcNames;
    String str;
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_Int = new Random().nextInt(10000);
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("ab_rand", this.jdField_a_of_type_Int);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      DeviceProfileManager.DpcNames[] arrayOfDpcNames = DeviceProfileManager.DpcNames.values();
      int m = arrayOfDpcNames.length;
      k = 0;
      if (k >= m) {
        return;
      }
      localDpcNames = arrayOfDpcNames[k];
      str = localSharedPreferences.getString(localDpcNames.name(), "");
      if (!"".equals(str)) {
        break label257;
      }
      localObject = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.b.get(localDpcNames.name())).clone();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(localDpcNames.name(), localObject);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "init loop mFeatureMapLV2 MAP: " + localDpcNames.name() + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
      }
      k += 1;
      break label116;
      ((SharedPreferences.Editor)localObject).apply();
      break;
      label257:
      localObject = new DeviceProfileManager.DPCConfigInfo();
      b((DeviceProfileManager.DPCConfigInfo)localObject, str);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 658	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo;
    //   7: astore_2
    //   8: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +47 -> 58
    //   14: aload_2
    //   15: ifnull +43 -> 58
    //   18: getstatic 57	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: iconst_2
    //   22: new 116	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 660
    //   32: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 649
    //   42: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_2
    //   46: invokevirtual 650	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:toString	()Ljava/lang/String;
    //   49: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 128	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_2
    //   59: ifnull +20 -> 79
    //   62: aload_2
    //   63: getfield 535	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   66: ifnull +13 -> 79
    //   69: aload_2
    //   70: getfield 535	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   73: invokevirtual 551	java/lang/String:length	()I
    //   76: ifne +11 -> 87
    //   79: ldc_w 284
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: areturn
    //   87: aload_2
    //   88: getfield 535	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   91: astore_1
    //   92: goto -9 -> 83
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	DeviceProfileManager
    //   0	100	1	paramString	String
    //   7	81	2	localDPCConfigInfo	DeviceProfileManager.DPCConfigInfo
    // Exception table:
    //   from	to	target	type
    //   2	14	95	finally
    //   18	58	95	finally
    //   62	79	95	finally
    //   87	92	95	finally
  }
  
  public String a(String paramString, long paramLong)
  {
    a(paramLong);
    return a(paramString);
  }
  
  /* Error */
  public String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 665	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: aload_2
    //   10: astore_1
    //   11: aload 4
    //   13: ifnull +18 -> 31
    //   16: ldc_w 284
    //   19: aload 4
    //   21: invokevirtual 596	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifeq +9 -> 35
    //   29: aload_2
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: aload 4
    //   37: astore_1
    //   38: goto -7 -> 31
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	DeviceProfileManager
    //   0	46	1	paramString1	String
    //   0	46	2	paramString2	String
    //   24	2	3	bool	boolean
    //   7	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	9	41	finally
    //   16	25	41	finally
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mFeatureMapLV2 start loop: \n");
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("key=" + localEntry.getKey() + ", value=" + localEntry.getValue().toString() + "\n");
    }
    localStringBuilder.append("mFeatureMapLV2 end loop: \n");
    localStringBuilder.append("mFeatureAccountMapLV2 start loop: \n");
    localIterator = jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("key=" + localEntry.getKey() + ", value=" + localEntry.getValue().toString() + "\n");
    }
    localStringBuilder.append("mFeatureAccountMapLV2 end loop: \n");
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    if (paramInt == 4) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.notifyAll();
        return;
      }
    }
  }
  
  public boolean a(ConfigurationService.RespGetConfig paramRespGetConfig, String paramString)
  {
    try
    {
      ThreadManager.b().post(new csb(this, paramRespGetConfig, paramString));
      return true;
    }
    finally
    {
      paramRespGetConfig = finally;
      throw paramRespGetConfig;
    }
  }
  
  public boolean a(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (DeviceProfileManager.AccountDpcManager.jdField_a_of_type_JavaUtilHashSet.contains(paramString))
        {
          if (jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "isFeatureSupported() accountDpcManager is null");
            }
            bool = false;
            return bool;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "isFeatureSupported() accountDpcNames=" + paramString);
          }
          localObject = jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager.jdField_a_of_type_JavaUtilHashMap;
          paramString = DeviceProfileManager.AccountDpcManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$AccountDpcManager, paramString);
          localObject = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject).get(paramString);
          if ((QLog.isColorLevel()) && (localObject != null)) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "isFeatureSupported: " + paramString + "=" + ((DeviceProfileManager.DPCConfigInfo)localObject).toString());
          }
          if ((localObject == null) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue == null)) {
            break label238;
          }
          if (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.length() == 0) {
            break label238;
          }
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilHashMap;
          continue;
        }
        if ((((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("0")) || (((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("2"))) {
          break label243;
        }
        bool = ((DeviceProfileManager.DPCConfigInfo)localObject).featureValue.equals("1");
        if (bool)
        {
          bool = true;
          continue;
        }
        bool = false;
        continue;
        bool = false;
      }
      finally {}
      label238:
      continue;
      label243:
      boolean bool = false;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    a(paramLong);
    return a(paramString);
  }
  
  public boolean a(String paramString, HashMap paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceProfileManager parseDCPXML:\n" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    paramHashMap = new csc(paramHashMap);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes("utf-8"))), paramHashMap);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseDCPXML: " + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager
 * JD-Core Version:    0.7.0.1
 */