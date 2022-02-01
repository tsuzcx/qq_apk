import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGlobalConfigManager.1;
import com.tencent.mobileqq.ar.ARGlobalConfigManager.2;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.manager.Manager;

public class adas
  implements Manager
{
  protected volatile ARCommonConfigInfo a;
  volatile ARScanStarFaceConfigInfo a;
  private QQAppInterface mApp;
  SharedPreferences pref;
  private final Vector<WeakReference<adfh>> z = new Vector();
  
  public adas(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "ARGlobalConfigManager constructor");
    }
    this.mApp = paramQQAppInterface;
    this.pref = paramQQAppInterface.getApp().getSharedPreferences("ar_global_config" + paramQQAppInterface.getAccount(), 0);
    ThreadManager.post(new ARGlobalConfigManager.1(this), 8, null, true);
  }
  
  public int Br()
  {
    return this.pref.getInt("ar_global_app_version", 0);
  }
  
  public int Bs()
  {
    return this.pref.getInt("ar_global_key_config_version", 0);
  }
  
  public int Bt()
  {
    return this.pref.getInt("ar_scan_star_face_config_version", 0);
  }
  
  public void Kt(int paramInt)
  {
    this.pref.edit().putInt("ar_global_key_config_version", paramInt).commit();
  }
  
  public void Ku(int paramInt)
  {
    this.pref.edit().putInt("ar_scan_star_face_config_version", paramInt).commit();
  }
  
  public ARScanAR a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARGlobalConfigManager", 2, "getQQArEntryTypeInfo");
    }
    a();
    a();
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "config is null");
      }
      localObject = null;
    }
    ARScanAR localARScanAR;
    do
    {
      return localObject;
      localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.arControllers.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localARScanAR = (ARScanAR)((Iterator)localObject).next();
      } while (localARScanAR.cDS != 1);
      localObject = localARScanAR;
    } while (!QLog.isColorLevel());
    QLog.d("AREngine_ARGlobalConfigManager", 2, "config is found");
    return localARScanAR;
    return null;
  }
  
  /* Error */
  public ARCommonConfigInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 127	adas:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   6: ifnonnull +29 -> 35
    //   9: aload_0
    //   10: monitorenter
    //   11: ldc 34
    //   13: iconst_2
    //   14: ldc 160
    //   16: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 42	adas:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 164	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:loadConfigFromFile	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   30: putfield 127	adas:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc 34
    //   37: iconst_2
    //   38: ldc 166
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 127	adas:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   50: aastore
    //   51: invokestatic 172	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 127	adas:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	adas
    //   61	4	1	localARCommonConfigInfo	ARCommonConfigInfo
    //   66	4	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	35	66	finally
    //   67	69	66	finally
    //   2	11	71	finally
    //   35	62	71	finally
    //   69	71	71	finally
  }
  
  public ARCommonConfigInfo a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    }
    if (paramBoolean) {
      a();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
      ThreadManager.postImmediately(new ARGlobalConfigManager.2(this), null, false);
    }
  }
  
  /* Error */
  public ARScanStarFaceConfigInfo a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   6: ifnonnull +29 -> 35
    //   9: aload_0
    //   10: monitorenter
    //   11: ldc 34
    //   13: iconst_2
    //   14: ldc 184
    //   16: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 42	adas:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   24: invokevirtual 61	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   27: invokestatic 189	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   30: putfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   33: aload_0
    //   34: monitorexit
    //   35: ldc 34
    //   37: iconst_2
    //   38: ldc 191
    //   40: iconst_1
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   50: aastore
    //   51: invokestatic 172	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   54: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	adas
    //   61	4	1	localARScanStarFaceConfigInfo	ARScanStarFaceConfigInfo
    //   66	4	1	localObject1	Object
    //   71	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	35	66	finally
    //   67	69	66	finally
    //   2	11	71	finally
    //   35	62	71	finally
    //   69	71	71	finally
  }
  
  public void a(adfh paramadfh)
  {
    if (paramadfh != null) {
      this.z.add(new WeakReference(paramadfh));
    }
  }
  
  public boolean adn()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      int i = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
      int j = Br();
      if (j == 0) {
        break label88;
      }
      if (i != j) {
        return false;
      }
      QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion version code is  " + i + "local version type is " + j);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        QLog.d("AREngine_ARGlobalConfigManager", 1, "AppVersionEqualsLocalVersion error happen");
      }
    }
    return true;
    label88:
    return false;
  }
  
  public boolean ado()
  {
    ARScanAR localARScanAR = a();
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (localARScanAR == null) {
      return false;
    }
    if ((localARScanAR.aRBegin <= l) && (l <= localARScanAR.aREnd)) {
      return true;
    }
    QLog.d("AREngine_ARGlobalConfigManager", 1, "isShowArPort | getQQArEntryTypeInfo out of date !");
    return false;
  }
  
  public void cPA()
  {
    int i = 0;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    try
    {
      int j = localBaseApplicationImpl.getPackageManager().getPackageInfo(localBaseApplicationImpl.getPackageName(), 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
    this.pref.edit().putInt("ar_global_app_version", i).commit();
  }
  
  public void cPB()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "clearArConfigInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
      Kt(0);
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "after delete ARConfig, we should remove serverVersionCode");
      }
      ARCommonConfigInfo.deleteConfigFile(this.mApp.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public void cPC()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AREngine_ARGlobalConfigManager", 2, "clearScanStarFaceConfigInfo");
      }
      this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
      ARScanStarFaceConfigInfo.deleteConfigFile(this.mApp.getCurrentAccountUin());
      return;
    }
    finally {}
  }
  
  public boolean kO(String paramString)
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARGlobalConfigManager", 2, "updateArConfigInfo | config = " + paramString);
        }
        boolean bool1 = bool2;
        Object localObject1;
        if (ARCommonConfigInfo.saveArConfigToFile(paramString, this.mApp.getCurrentAccountUin()))
        {
          ArrayList localArrayList = new ArrayList();
          localObject3 = new ArrayList();
          localObject1 = localArrayList;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
          {
            localObject1 = localArrayList;
            if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = ARCommonConfigInfo.parseArConfig(paramString);
          SharedPreferencesProxyManager.getInstance().getProxy("qrcode", 0).edit().putInt("ar_guide_b_showed_c" + this.mApp.getCurrentAccountUin(), 0).commit();
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARGlobalConfigManager", 2, "parseArconfigxml fail");
            }
            cPB();
            bool1 = bool2;
          }
        }
        else
        {
          return bool1;
        }
        paramString = (String)localObject3;
        if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null)
        {
          paramString = (String)localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList != null) {
            paramString = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.nativeSoResList;
          }
        }
        Object localObject3 = new ades(this.mApp);
        ((ades)localObject3).a((ArrayList)localObject1, paramString, "arsdk2");
        ((ades)localObject3).a((ArrayList)localObject1, paramString, "arcloud");
        paramString = this.z;
        int i = 0;
        try
        {
          if (i < this.z.size())
          {
            localObject1 = (WeakReference)this.z.get(i);
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
            {
              localObject1 = this.z;
              int j = i - 1;
              ((Vector)localObject1).remove(i);
              i = j;
            }
            else
            {
              ((adfh)((WeakReference)localObject1).get()).a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo);
            }
          }
          else
          {
            bool1 = true;
            continue;
          }
        }
        finally {}
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean kP(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +29 -> 36
    //   10: ldc 34
    //   12: iconst_2
    //   13: new 50	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 344
    //   23: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: iload_3
    //   37: istore_2
    //   38: aload_1
    //   39: aload_0
    //   40: getfield 42	adas:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 273	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   46: invokestatic 347	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:aG	(Ljava/lang/String;Ljava/lang/String;)Z
    //   49: ifeq +39 -> 88
    //   52: aload_0
    //   53: aload_1
    //   54: invokestatic 350	com/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   57: putfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   60: aload_0
    //   61: getfield 182	adas:jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARScanStarFaceConfigInfo;
    //   64: ifnonnull +28 -> 92
    //   67: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +12 -> 82
    //   73: ldc 34
    //   75: iconst_2
    //   76: ldc_w 352
    //   79: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_0
    //   83: invokevirtual 354	adas:cPC	()V
    //   86: iload_3
    //   87: istore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_2
    //   91: ireturn
    //   92: iconst_1
    //   93: istore_2
    //   94: goto -6 -> 88
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	adas
    //   0	102	1	paramString	String
    //   37	57	2	bool1	boolean
    //   1	86	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	36	97	finally
    //   38	82	97	finally
    //   82	86	97	finally
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adas
 * JD-Core Version:    0.7.0.1
 */