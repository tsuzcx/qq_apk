package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.CPU;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Camera;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Memory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.OS;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
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
import fbm;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public class DeviceProfileManager
{
  private static volatile DeviceProfileManager jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager;
  public static ConfigurationService.ReqGetConfig a;
  public static final String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public static boolean a = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "featureValue" };
  public static final String b = "last_update_time";
  private static final String c = ",";
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Field[] jdField_a_of_type_ArrayOfJavaLangReflectField;
  private HashMap b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceProfileManager.class.getSimpleName();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$ReqGetConfig = null;
  }
  
  private DeviceProfileManager()
  {
    b();
  }
  
  public static DeviceProfileManager a()
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
  
  public static ConfigurationService.ReqGetConfig a()
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
    ConfigurationService.Screen localScreen = new ConfigurationService.Screen();
    localScreen.setHasFlag(true);
    localScreen.model.set("");
    localScreen.width.set((int)DeviceInfoUtil.f());
    localScreen.height.set((int)DeviceInfoUtil.g());
    localScreen.dpi.set(DeviceInfoUtil.e());
    localScreen.multi_touch.set(DeviceInfoUtil.c());
    ConfigurationService.Camera localCamera = new ConfigurationService.Camera();
    localCamera.setHasFlag(true);
    localCamera.primary.set(0L);
    localCamera.secondary.set(0L);
    localCamera.flash.set(false);
    Object localObject3 = new ConfigurationService.ConfigSeq();
    ((ConfigurationService.ConfigSeq)localObject3).setHasFlag(true);
    ((ConfigurationService.ConfigSeq)localObject3).type.set(4);
    ((ConfigurationService.ConfigSeq)localObject3).version.set(0);
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(localObject3);
    localObject3 = new ConfigurationService.DeviceInfo();
    ((ConfigurationService.DeviceInfo)localObject3).setHasFlag(true);
    ((ConfigurationService.DeviceInfo)localObject3).brand.set(DeviceInfoUtil.g());
    ((ConfigurationService.DeviceInfo)localObject3).model.set(DeviceInfoUtil.d());
    ((ConfigurationService.DeviceInfo)localObject3).os = ((ConfigurationService.OS)localObject1);
    ((ConfigurationService.DeviceInfo)localObject3).cpu = localCPU;
    ((ConfigurationService.DeviceInfo)localObject3).memory = localMemory;
    ((ConfigurationService.DeviceInfo)localObject3).storage = localStorage;
    ((ConfigurationService.DeviceInfo)localObject3).screen = localScreen;
    ((ConfigurationService.DeviceInfo)localObject3).camera = localCamera;
    localObject1 = new ConfigurationService.ReqGetConfig();
    ((ConfigurationService.ReqGetConfig)localObject1).device_info = ((ConfigurationService.DeviceInfo)localObject3);
    ((ConfigurationService.ReqGetConfig)localObject1).seq_list.addAll((Collection)localObject2);
    a((ConfigurationService.ReqGetConfig)localObject1);
    return localObject1;
  }
  
  private void a()
  {
    Object localObject1 = DeviceProfileManager.DpcNames.values();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      this.b.put(localObject2.name(), new DeviceProfileManager.DPCConfigInfo());
      i += 1;
    }
    localObject1 = new DeviceProfileManager.DPCConfigInfo();
    ((DeviceProfileManager.DPCConfigInfo)localObject1).featureValue = "1";
    this.b.put(DeviceProfileManager.DpcNames.magicface_support.name(), localObject1);
  }
  
  private void a(DeviceProfileManager.DPCConfigInfo paramDPCConfigInfo, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramDPCConfigInfo == null)) {}
    String[] arrayOfString;
    do
    {
      return;
      arrayOfString = paramString.toString().trim().split(",");
    } while ((arrayOfString == null) || (arrayOfString.length == 0));
    if (this.jdField_a_of_type_ArrayOfJavaLangReflectField == null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangReflectField = new Field[jdField_a_of_type_ArrayOfJavaLangString.length];
      i = 0;
      for (;;)
      {
        if (i < this.jdField_a_of_type_ArrayOfJavaLangReflectField.length) {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaLangReflectField[i] = paramDPCConfigInfo.getClass().getField(jdField_a_of_type_ArrayOfJavaLangString[i]);
            this.jdField_a_of_type_ArrayOfJavaLangReflectField[i].setAccessible(true);
            i += 1;
          }
          catch (NoSuchFieldException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
              this.jdField_a_of_type_ArrayOfJavaLangReflectField[i] = null;
            }
          }
        }
      }
    }
    int j = Math.min(this.jdField_a_of_type_ArrayOfJavaLangReflectField.length, arrayOfString.length);
    int i = 0;
    label135:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if ((str != null) && (str.length() != 0)) {
        break label167;
      }
    }
    for (;;)
    {
      i += 1;
      break label135;
      break;
      label167:
      paramString = str;
      if (str.indexOf('{', 0) == 0)
      {
        paramString = str;
        if (str.lastIndexOf('}') == str.length() - 1) {
          paramString = str.substring(1, str.length() - 1);
        }
      }
      try
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangReflectField[i] != null) {
          this.jdField_a_of_type_ArrayOfJavaLangReflectField[i].set(paramDPCConfigInfo, paramString);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static void a(ConfigurationService.ReqGetConfig paramReqGetConfig)
  {
    if (QLog.isColorLevel())
    {
      paramReqGetConfig = paramReqGetConfig.device_info;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buidldReqConfig{");
      localStringBuilder.append(" brand= ");
      localStringBuilder.append(paramReqGetConfig.brand.get());
      localStringBuilder.append(" ,model= ");
      localStringBuilder.append(paramReqGetConfig.model.get());
      localStringBuilder.append(" ,os.type= ");
      localStringBuilder.append(paramReqGetConfig.os.type.get());
      localStringBuilder.append(" ,os.kernel= ");
      localStringBuilder.append(paramReqGetConfig.os.kernel.get());
      localStringBuilder.append(" ,os.sdk= ");
      localStringBuilder.append(paramReqGetConfig.os.sdk.get());
      localStringBuilder.append(" ,os.version= ");
      localStringBuilder.append(paramReqGetConfig.os.version.get());
      localStringBuilder.append(" ,os.rom= ");
      localStringBuilder.append(paramReqGetConfig.os.rom.get());
      localStringBuilder.append(" ,cpu.model= ");
      localStringBuilder.append(paramReqGetConfig.cpu.model.get());
      localStringBuilder.append(" ,cpu.cores= ");
      localStringBuilder.append(paramReqGetConfig.cpu.cores.get());
      localStringBuilder.append(" ,cpu.frequency= ");
      localStringBuilder.append(paramReqGetConfig.cpu.frequency.get());
      localStringBuilder.append(" ,memory.total= ");
      localStringBuilder.append(paramReqGetConfig.memory.total.get());
      localStringBuilder.append(" ,memory.process= ");
      localStringBuilder.append(paramReqGetConfig.memory.process.get());
      localStringBuilder.append(" ,storage.builtin= ");
      localStringBuilder.append(paramReqGetConfig.storage.builtin.get());
      localStringBuilder.append(" ,storage.external= ");
      localStringBuilder.append(paramReqGetConfig.storage.external.get());
      localStringBuilder.append(" ,screen.model= ");
      localStringBuilder.append(paramReqGetConfig.screen.model.get());
      localStringBuilder.append(" ,screen.width= ");
      localStringBuilder.append(paramReqGetConfig.screen.width.get());
      localStringBuilder.append(" ,screen.height= ");
      localStringBuilder.append(paramReqGetConfig.screen.height.get());
      localStringBuilder.append(" ,screen.dpi= ");
      localStringBuilder.append(paramReqGetConfig.screen.dpi.get());
      localStringBuilder.append(" ,screen.multi_touch= ");
      localStringBuilder.append(paramReqGetConfig.screen.multi_touch.get());
      localStringBuilder.append(" ,camera.primary= ");
      localStringBuilder.append(paramReqGetConfig.camera.primary.get());
      localStringBuilder.append(" ,camera.secondary= ");
      localStringBuilder.append(paramReqGetConfig.camera.secondary.get());
      localStringBuilder.append(" ,camera.flash= ");
      localStringBuilder.append(paramReqGetConfig.camera.flash.get());
      localStringBuilder.append(" }");
      QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
    }
  }
  
  private void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "DeviceProfileManager init DPC content");
    }
    a();
    SharedPreferences localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig");
    DeviceProfileManager.DpcNames[] arrayOfDpcNames = DeviceProfileManager.DpcNames.values();
    int j = arrayOfDpcNames.length;
    int i = 0;
    if (i < j)
    {
      DeviceProfileManager.DpcNames localDpcNames = arrayOfDpcNames[i];
      String str = localSharedPreferences.getString(localDpcNames.name(), "");
      DeviceProfileManager.DPCConfigInfo localDPCConfigInfo;
      if ("".equals(str)) {
        localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)this.b.get(localDpcNames.name())).clone();
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(localDpcNames.name(), localDPCConfigInfo);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "init loop mFeatureMapLV2 MAP: " + localDpcNames.name() + "=" + localDPCConfigInfo.toString());
        }
        i += 1;
        break;
        localDPCConfigInfo = new DeviceProfileManager.DPCConfigInfo();
        a(localDPCConfigInfo, str);
      }
    }
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 512	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 327	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo
    //   13: astore_2
    //   14: invokestatic 481	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   17: ifeq +47 -> 64
    //   20: aload_2
    //   21: ifnull +43 -> 64
    //   24: getstatic 30	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: iconst_4
    //   28: new 405	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 406	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 524
    //   38: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc_w 520
    //   48: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 521	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:toString	()Ljava/lang/String;
    //   55: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 478	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 485	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: ifnull +20 -> 85
    //   68: aload_2
    //   69: getfield 336	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   72: ifnull +13 -> 85
    //   75: aload_2
    //   76: getfield 336	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   79: invokevirtual 350	java/lang/String:length	()I
    //   82: ifne +10 -> 92
    //   85: ldc 202
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: areturn
    //   92: aload_2
    //   93: getfield 336	com/tencent/mobileqq/app/DeviceProfileManager$DPCConfigInfo:featureValue	Ljava/lang/String;
    //   96: astore_1
    //   97: goto -9 -> 88
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	DeviceProfileManager
    //   0	105	1	paramString	String
    //   13	80	2	localDPCConfigInfo	DeviceProfileManager.DPCConfigInfo
    // Exception table:
    //   from	to	target	type
    //   2	20	100	finally
    //   24	64	100	finally
    //   68	85	100	finally
    //   92	97	100	finally
  }
  
  /* Error */
  public boolean a(com.tencent.mobileqq.pb.PBRepeatField paramPBRepeatField)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5: invokevirtual 526	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_2
    //   18: ireturn
    //   19: invokestatic 531	com/tencent/mobileqq/app/ThreadManager:b	()Landroid/os/Handler;
    //   22: new 533	fbl
    //   25: dup
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 536	fbl:<init>	(Lcom/tencent/mobileqq/app/DeviceProfileManager;Lcom/tencent/mobileqq/pb/PBRepeatField;)V
    //   31: invokevirtual 542	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: iconst_1
    //   36: istore_2
    //   37: goto -22 -> 15
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	DeviceProfileManager
    //   0	45	1	paramPBRepeatField	com.tencent.mobileqq.pb.PBRepeatField
    //   8	29	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	40	finally
    //   19	35	40	finally
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "DeviceProfileManager parseDCPXML:\n" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    fbm localfbm = new fbm(null);
    try
    {
      SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new ByteArrayInputStream(paramString.getBytes("utf-8"))), localfbm);
      return true;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "pareseDCPXML: " + paramString.getMessage());
      }
      paramString.printStackTrace();
      fbm.jdField_a_of_type_JavaUtilHashMap = null;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if ((QLog.isDevelopLevel()) && (localDPCConfigInfo != null)) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "isFeatureSupported: " + paramString + "=" + localDPCConfigInfo.toString());
        }
        boolean bool;
        if ((localDPCConfigInfo != null) && (localDPCConfigInfo.featureValue != null))
        {
          int i = localDPCConfigInfo.featureValue.length();
          if (i != 0) {}
        }
        else
        {
          bool = false;
          return bool;
        }
        if ((!localDPCConfigInfo.featureValue.equals("0")) && (!localDPCConfigInfo.featureValue.equals("2")))
        {
          bool = localDPCConfigInfo.featureValue.equals("1");
          if (bool) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceProfileManager
 * JD-Core Version:    0.7.0.1
 */