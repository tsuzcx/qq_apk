import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.remoteCheck.QCircleGetRainBowRequest;
import com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginInfo;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

public class vwj
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static vwj jdField_a_of_type_Vwj;
  private static Object b = new Object();
  public long a;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private String jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getDir("qcircleplugin", 0).getPath();
  
  private QCirclePluginInfo a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    QCirclePluginInfo localQCirclePluginInfo1;
    if ((paramQCirclePluginInfo.version <= 0) || (TextUtils.isEmpty(paramQCirclePluginInfo.zipFileUrl)) || (TextUtils.isEmpty(paramQCirclePluginInfo.managerFileUrl)) || (paramQCirclePluginInfo.zipFileLength <= 0L) || (paramQCirclePluginInfo.managerFilelength <= 0L)) {
      localQCirclePluginInfo1 = null;
    }
    QCirclePluginInfo localQCirclePluginInfo2;
    do
    {
      do
      {
        return localQCirclePluginInfo1;
        localQCirclePluginInfo2 = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, paramQCirclePluginInfo.version + "");
        localQCirclePluginInfo1 = paramQCirclePluginInfo;
      } while (localQCirclePluginInfo2 == null);
      if (localQCirclePluginInfo2.isInvalid) {
        return null;
      }
      localQCirclePluginInfo1 = paramQCirclePluginInfo;
    } while (!localQCirclePluginInfo2.isReady);
    return localQCirclePluginInfo2;
  }
  
  /* Error */
  private EntityManager a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	vwj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 103	vwj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: invokestatic 107	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: invokevirtual 111	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnonnull +11 -> 37
    //   29: ldc 113
    //   31: iconst_1
    //   32: ldc 115
    //   34: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_1
    //   38: instanceof 123
    //   41: ifne +16 -> 57
    //   44: ldc 113
    //   46: iconst_1
    //   47: ldc 125
    //   49: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aconst_null
    //   53: astore_1
    //   54: goto -40 -> 14
    //   57: aload_1
    //   58: invokevirtual 130	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   61: ifnonnull +16 -> 77
    //   64: ldc 113
    //   66: iconst_1
    //   67: ldc 132
    //   69: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -60 -> 14
    //   77: aload_0
    //   78: aload_1
    //   79: checkcast 123	com/tencent/mobileqq/app/QQAppInterface
    //   82: invokevirtual 136	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   85: invokevirtual 141	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: putfield 103	vwj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   91: aload_0
    //   92: getfield 103	vwj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   95: astore_1
    //   96: goto -82 -> 14
    //   99: astore_1
    //   100: ldc 113
    //   102: iconst_1
    //   103: new 73	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   110: ldc 143
    //   112: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: aconst_null
    //   126: astore_1
    //   127: goto -113 -> 14
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	vwj
    //   13	83	1	localObject1	Object
    //   99	17	1	localException	java.lang.Exception
    //   126	1	1	localObject2	Object
    //   130	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   77	96	99	java/lang/Exception
    //   2	14	130	finally
    //   18	25	130	finally
    //   29	37	130	finally
    //   37	52	130	finally
    //   57	72	130	finally
    //   77	96	130	finally
    //   100	125	130	finally
  }
  
  public static vwj a()
  {
    if (jdField_a_of_type_Vwj == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Vwj == null) {
        jdField_a_of_type_Vwj = new vwj();
      }
      return jdField_a_of_type_Vwj;
    }
  }
  
  private void a(QCirclePluginInfo paramQCirclePluginInfo)
  {
    ??? = this.jdField_a_of_type_JavaLangString + "/" + paramQCirclePluginInfo.version + "/qcirle-plugin.zip";
    File localFile = new File((String)???);
    if ((!localFile.exists()) || (localFile.length() != paramQCirclePluginInfo.zipFileLength))
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1L).setPluginVersion(paramQCirclePluginInfo.version));
      vwg.a().a(paramQCirclePluginInfo.zipFileUrl, (String)???, new vwl(this, paramQCirclePluginInfo, (String)???));
      ??? = this.jdField_a_of_type_JavaLangString + "/" + paramQCirclePluginInfo.version + "/qcirle-pluginmanager.apk";
      localFile = new File((String)???);
      if ((localFile.exists()) && (localFile.length() == paramQCirclePluginInfo.managerFilelength)) {
        break label264;
      }
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2L).setPluginVersion(paramQCirclePluginInfo.version));
      vwg.a().a(paramQCirclePluginInfo.managerFileUrl, (String)???, new vwm(this, paramQCirclePluginInfo, (String)???));
    }
    label264:
    do
    {
      return;
      paramQCirclePluginInfo.pluginZipPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(1003L).setPluginVersion(paramQCirclePluginInfo.version));
      break;
      paramQCirclePluginInfo.pluginManagerPath = ((String)???);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_download").setRetCode(2003L).setPluginVersion(paramQCirclePluginInfo.version));
    } while ((TextUtils.isEmpty(paramQCirclePluginInfo.pluginManagerPath)) || (TextUtils.isEmpty(paramQCirclePluginInfo.pluginZipPath)));
    paramQCirclePluginInfo.isReady = true;
    synchronized (b)
    {
      a().delete(QCirclePluginInfo.class.getSimpleName(), null, null);
      paramQCirclePluginInfo.setStatus(1000);
      a().persistOrReplace(paramQCirclePluginInfo);
      return;
    }
  }
  
  private void a(QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    if (paramGetRainbowTableConfigRsp.update.get() == 1)
    {
      if (!TextUtils.isEmpty(paramGetRainbowTableConfigRsp.data.get())) {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramGetRainbowTableConfigRsp.data.get());
          int i = localJSONObject.getInt("version");
          paramGetRainbowTableConfigRsp = paramGetRainbowTableConfigRsp.cookie.get();
          String str1 = localJSONObject.getString("zipFileUrl");
          String str2 = localJSONObject.getString("managerFileUrl");
          long l1 = localJSONObject.getLong("zipFileLength");
          long l2 = localJSONObject.getLong("managerFilelength");
          QLog.e("QCirclePluginManager", 1, " version= " + i + " cookie= " + paramGetRainbowTableConfigRsp + " zipFileUrl= " + str1 + " managerFileUrl= " + str2 + "  zipFileLength =" + l1 + " managerFilelength =" + l2);
          paramGetRainbowTableConfigRsp = a(new QCirclePluginInfo(i, paramGetRainbowTableConfigRsp, str1, str2, l1, l2, BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
          if (paramGetRainbowTableConfigRsp == null)
          {
            QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(2L));
            return;
          }
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(0L).setPluginVersion(paramGetRainbowTableConfigRsp.version));
          a(paramGetRainbowTableConfigRsp);
          return;
        }
        catch (JSONException paramGetRainbowTableConfigRsp)
        {
          QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(3L));
          QLog.e("QCirclePluginManager", 1, paramGetRainbowTableConfigRsp, new Object[0]);
          paramGetRainbowTableConfigRsp.printStackTrace();
          return;
        }
      }
      QLog.e("QCirclePluginManager", 1, "data =" + paramGetRainbowTableConfigRsp.data);
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(4L));
      return;
    }
    paramGetRainbowTableConfigRsp = a(false);
    if ((paramGetRainbowTableConfigRsp != null) && (!paramGetRainbowTableConfigRsp.isReady)) {
      a(paramGetRainbowTableConfigRsp);
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(1L));
    QLog.e("QCirclePluginManager", 1, "update = 0");
  }
  
  public QCirclePluginInfo a(boolean paramBoolean)
  {
    Object localObject = a().query(QCirclePluginInfo.class);
    QCirclePluginInfo localQCirclePluginInfo;
    label233:
    long l2;
    long l1;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localQCirclePluginInfo = (QCirclePluginInfo)localIterator.next();
          if ((localQCirclePluginInfo != null) && ((!paramBoolean) || (localQCirclePluginInfo.isReady)) && (!localQCirclePluginInfo.isInvalid) && (localQCirclePluginInfo.mUin == BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()) && (localQCirclePluginInfo.qua.equals(QUA.getQUA3())))
          {
            if (paramBoolean) {
              QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(0L).setPluginVersion(localQCirclePluginInfo.version));
            }
            return localQCirclePluginInfo;
          }
          if ("qCirclePluginInfo= " + localQCirclePluginInfo + localQCirclePluginInfo != null)
          {
            localObject = "version=" + localQCirclePluginInfo.version + "isReady=" + localQCirclePluginInfo.isReady + "isInvalid=" + localQCirclePluginInfo.isInvalid;
            QLog.e("QCirclePluginManager", 1, (String)localObject);
            if (!paramBoolean) {
              continue;
            }
            if (localQCirclePluginInfo != null) {
              break label292;
            }
            l2 = 1L;
            l1 = -1L;
          }
        }
      }
    }
    for (;;)
    {
      QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_get").setRetCode(l2).setPluginVersion(l1));
      break;
      localObject = "";
      break label233;
      label292:
      if (localQCirclePluginInfo.isInvalid)
      {
        l2 = 2L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (!localQCirclePluginInfo.isReady)
      {
        l2 = 3L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (localQCirclePluginInfo.mUin != BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())
      {
        l2 = 4L;
        l1 = localQCirclePluginInfo.version;
      }
      else if (!localQCirclePluginInfo.qua.equals(QUA.getQUA3()))
      {
        l2 = 5L;
        l1 = localQCirclePluginInfo.version;
        continue;
        QLog.e("QCirclePluginManager", 1, "size = 0");
        return null;
        return null;
      }
      else
      {
        l1 = -1L;
        l2 = 0L;
      }
    }
  }
  
  public void a()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < QzoneConfig.getQQCirclePluginIntervalTime())
    {
      QLog.e("QCirclePluginManager", 1, "time =" + QzoneConfig.getQQCirclePluginIntervalTime());
      localObject = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, "4");
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    String str = "";
    QCirclePluginInfo localQCirclePluginInfo = a(true);
    Object localObject = str;
    if (localQCirclePluginInfo != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(localQCirclePluginInfo.cookie)) {
        localObject = localQCirclePluginInfo.cookie;
      }
    }
    QLog.e("QCirclePluginManager", 1, "cookie=" + (String)localObject);
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_req").setRetCode(0L));
    localObject = new QCircleGetRainBowRequest((String)localObject, QUA.getQUA3(), "PUBLIC", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "8.4.10");
    VSNetworkHelper.getInstance().sendRequest((VSBaseRequest)localObject, new vwk(this, (QCircleGetRainBowRequest)localObject));
  }
  
  public void a(int paramInt)
  {
    QLog.e("QCirclePluginManager", 1, "setQCirclePluginInvalid=" + paramInt);
    QCirclePluginInfo localQCirclePluginInfo = (QCirclePluginInfo)a().find(QCirclePluginInfo.class, paramInt + "");
    if (localQCirclePluginInfo != null)
    {
      QLog.e("QCirclePluginManager", 1, "setQCirclePluginInvalid success" + paramInt);
      localQCirclePluginInfo.isInvalid = true;
      synchronized (b)
      {
        a().update(localQCirclePluginInfo);
        QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_set_plugin_invalid").setRetCode(0L).setPluginVersion(paramInt));
        return;
      }
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_set_plugin_invalid").setRetCode(1L).setPluginVersion(paramInt));
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("9b16ced79b", vvq.a().a());
    localEditor.commit();
    c();
  }
  
  public void c()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("QCirclePluginVersion", 4).edit();
    localEditor.putString("version", vvq.a().b());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwj
 * JD-Core Version:    0.7.0.1
 */