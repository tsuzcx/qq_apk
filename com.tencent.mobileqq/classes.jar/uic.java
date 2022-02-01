import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.3;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.4;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.5;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager.6;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class uic
  extends rmr
  implements ujb
{
  private static String jdField_a_of_type_JavaLangString = "adMaterial";
  private uib jdField_a_of_type_Uib = new uid(this);
  private uie jdField_a_of_type_Uie;
  
  public uic(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private String a(MaterialData paramMaterialData)
  {
    int i = paramMaterialData.res_version;
    String str1 = paramMaterialData.res_path;
    String str2 = File.separator + i;
    paramMaterialData = str1;
    if (str1 != null)
    {
      paramMaterialData = str1;
      if (str1.endsWith(str2))
      {
        paramMaterialData = str1.substring(0, str1.length() - str2.length());
        ukq.a("ReadInJoySuperMaskAd", "getRootDirectory = " + paramMaterialData);
      }
    }
    return paramMaterialData;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    String str2 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".readInjoy/resource/");
    String str1 = str2;
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      str1 = str2 + jdField_a_of_type_JavaLangString + "/";
    }
    return str1 + paramString1 + "_" + paramString2 + "/" + paramInt;
  }
  
  private List<MaterialData> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      Object localObject = "uin=? and end_time>? and isReady=?";
      String[] arrayOfString = new String[3];
      arrayOfString[0] = str;
      arrayOfString[1] = String.valueOf(l);
      arrayOfString[2] = String.valueOf(0);
      if (paramBoolean)
      {
        localObject = "uin=? and end_time>? and isReady=? and enable_4g=?";
        arrayOfString = new String[4];
        arrayOfString[0] = str;
        arrayOfString[1] = String.valueOf(l);
        arrayOfString[2] = String.valueOf(0);
        arrayOfString[3] = String.valueOf(1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, (String)localObject, arrayOfString, null, null, null, null);
      return localObject;
    }
    catch (Exception localException)
    {
      c("getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
    }
    return localArrayList;
  }
  
  public static uic a(QQAppInterface paramQQAppInterface)
  {
    return (uic)paramQQAppInterface.getManager(QQManagerFactory.READINJOY_AD_MATERIAL_MANAGER);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ujh.a.a();
    ujf.a.a();
  }
  
  private void a(ArrayList<MaterialData> paramArrayList)
  {
    long l = NetConnInfoCenter.getServerTime();
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    HashMap localHashMap = a();
    int i = 0;
    MaterialData localMaterialData1;
    while (i < paramArrayList.size())
    {
      localMaterialData1 = (MaterialData)paramArrayList.get(i);
      if (localMaterialData1 == null)
      {
        i += 1;
      }
      else
      {
        localMaterialData1.setStatus(1000);
        MaterialData localMaterialData2;
        if (localHashMap.containsKey(localMaterialData1.id))
        {
          localMaterialData2 = (MaterialData)localHashMap.get(localMaterialData1.id);
          if (localMaterialData2 == null)
          {
            ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is empty , replace a new data");
            label102:
            b(localMaterialData1);
            ujh.a.b(localMaterialData1);
          }
        }
        for (;;)
        {
          localHashMap.put(localMaterialData1.id, localMaterialData1);
          break;
          if (!localMaterialData2.isReady)
          {
            ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is not ready , replace a new data");
            break label102;
          }
          if (localMaterialData2.res_version != localMaterialData1.res_version)
          {
            FileUtils.deleteDirectory(a(localMaterialData2));
            ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is version check fail , replace a new data");
            break label102;
          }
          if (!uja.a(localMaterialData2))
          {
            ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data file not exist , replace a new data");
            break label102;
          }
          if (!uja.b(localMaterialData2))
          {
            ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data manifest file not exist , replace a new data");
            break label102;
          }
          ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : file exist , not need download : " + localMaterialData1.id);
          break;
          b(localMaterialData1);
        }
      }
    }
    paramArrayList = localHashMap.entrySet().iterator();
    while (paramArrayList.hasNext())
    {
      localMaterialData1 = (MaterialData)((Map.Entry)paramArrayList.next()).getValue();
      if ((localMaterialData1 != null) && (!localMaterialData1.isReady) && (localMaterialData1.end_time >= l)) {
        b(localMaterialData1);
      }
    }
    a(localHashMap, l);
  }
  
  private void a(HashMap<String, MaterialData> paramHashMap, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramHashMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      MaterialData localMaterialData = (MaterialData)((Map.Entry)((Iterator)localObject).next()).getValue();
      if ((localMaterialData != null) && (localMaterialData.end_time < paramLong)) {
        localArrayList.add(localMaterialData.id);
      }
    }
    if (localArrayList.size() > 0)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        localObject = (MaterialData)paramHashMap.get(localArrayList.get(i));
        if (localObject != null)
        {
          QLog.d("ReadInJoySuperMaskAd", 1, "[PRELOAD] : file over time , need clear : " + ((MaterialData)localObject).id + " endTime = " + ((MaterialData)localObject).end_time);
          ujh.a.b(localObject);
          d((MaterialData)localObject);
          FileUtils.deleteDirectory(a((MaterialData)localObject));
        }
        i += 1;
      }
    }
  }
  
  private boolean a(MaterialData paramMaterialData)
  {
    if (paramMaterialData == null) {
      return false;
    }
    JSONObject localJSONObject = paramMaterialData.toJson();
    Object localObject = new ujp(localJSONObject, new ujq(paramMaterialData.adid, paramMaterialData.ad_source, paramMaterialData.res_version), false, 1);
    boolean bool = ujt.a.a("[PRELOAD]", new ujc[] { localObject });
    localObject = localJSONObject.optString("animFileName");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMaterialData.animFileName = ((String)localObject);
      ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : checkFinalResFile, id = " + paramMaterialData.id + " result = " + bool + " fileName = " + (String)localObject);
    }
    paramMaterialData.superMaskType = localJSONObject.optInt("superMaskType");
    return bool;
  }
  
  private boolean a(MaterialData paramMaterialData, File paramFile)
  {
    paramMaterialData = new ujm(paramMaterialData, paramFile);
    return ujt.a.a("[PRELOAD]", new ujc[] { paramMaterialData });
  }
  
  private void b(bhyo parambhyo, MaterialData paramMaterialData, File paramFile)
  {
    if ((parambhyo == null) || (paramMaterialData == null))
    {
      FileUtils.deleteFile(paramFile);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(jdField_a_of_type_JavaLangString + "_" + paramMaterialData.id);
    int i = parambhyo.a;
    if (i != 0)
    {
      ujg.a.a(paramMaterialData.toJson(), false, "errorCode = " + i, "", "resource_download_key");
      ujg.a.a(paramMaterialData.adid, "downloadFail", paramMaterialData.res_version);
      FileUtils.deleteFile(paramFile);
      return;
    }
    ujg.a.a(paramMaterialData.adid, "downloadSuccess", paramMaterialData.res_version);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      ujg.a.a(paramMaterialData.adid, "noFile", paramMaterialData.res_version);
      return;
    }
    if (!a(paramMaterialData, paramFile))
    {
      ujg.a.a(paramMaterialData.toJson(), false, "check file md5 failed", "", "resource_download_key");
      ujg.a.a(paramMaterialData.adid, "md5Fail", paramMaterialData.res_version);
      FileUtils.deleteFile(paramFile);
      return;
    }
    paramMaterialData.res_path = a(paramMaterialData.ad_source, paramMaterialData.adid, paramMaterialData.res_version);
    try
    {
      FileUtils.uncompressZip(paramFile.getAbsolutePath(), paramMaterialData.res_path, false);
      ujg.a.a(paramMaterialData.adid, "zipSuccess", paramMaterialData.res_version);
      if (a(paramMaterialData))
      {
        ujg.a.a(paramMaterialData.adid, "AllSuccess", paramMaterialData.res_version);
        ujh.a.a(paramMaterialData);
        e(paramMaterialData);
        ujg.a.a(paramMaterialData.toJson(), true, "no error", "", "resource_download_key");
        FileUtils.deleteFile(paramFile);
        return;
      }
    }
    catch (IOException parambhyo)
    {
      for (;;)
      {
        ujg.a.a(paramMaterialData.adid, "zipFail", paramMaterialData.res_version);
        parambhyo.printStackTrace();
        continue;
        FileUtils.deleteDirectory(a(paramMaterialData));
        ujg.a.a(paramMaterialData.toJson(), false, "res_path file not exist", "", "resource_download_key");
      }
    }
  }
  
  private void b(MaterialData paramMaterialData)
  {
    if (paramMaterialData.end_time <= NetConnInfoCenter.getServerTime()) {}
    while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()))
    {
      ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] netType = wifi");
      a(jdField_a_of_type_JavaLangString, paramMaterialData, 2);
      return;
    }
    if ((bizo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()) == 4) && (paramMaterialData.enable_4g == 1))
    {
      ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : download by 4G : id = " + paramMaterialData.adid);
      ThreadManager.getSubThreadHandler().postDelayed(new AdMaterialResManager.5(this, paramMaterialData), 10000L);
      return;
    }
    ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] netType = " + bizo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()) + " enable_4g = " + paramMaterialData.enable_4g);
  }
  
  private void b(String paramString)
  {
    ThreadManagerV2.excute(new AdMaterialResManager.4(this, paramString), 64, null, true);
  }
  
  private boolean b(MaterialData paramMaterialData)
  {
    boolean bool = false;
    if (paramMaterialData.getStatus() == 1000)
    {
      c(paramMaterialData);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramMaterialData);
      if (paramMaterialData.getStatus() != 1001) {}
    }
    for (bool = true;; bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData)) {
      do
      {
        ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : persistOrReplaceToDB, id = " + paramMaterialData.id + " result = " + bool);
        return bool;
      } while ((paramMaterialData.getStatus() != 1001) && (paramMaterialData.getStatus() != 1002));
    }
  }
  
  private void c(MaterialData paramMaterialData)
  {
    Entity localEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(MaterialData.class, "id = ?", new String[] { paramMaterialData.id });
    if (localEntity != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(localEntity);
      ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : removeEntityIfExistsInDB, id = " + paramMaterialData.id + " result = " + bool);
    }
  }
  
  private static void c(String paramString)
  {
    QLog.d("AdMaterialResManager", 2, paramString);
  }
  
  private void d(MaterialData paramMaterialData)
  {
    paramMaterialData.setStatus(1001);
    int i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(MaterialData.class.getSimpleName(), "id=? ", new String[] { paramMaterialData.id });
    ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : deleteToDB, id = " + paramMaterialData.id + " result = " + i);
  }
  
  private void e(MaterialData paramMaterialData)
  {
    paramMaterialData.isReady = true;
    paramMaterialData.setStatus(1001);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData);
    ukq.a("ReadInJoySuperMaskAd", "[PRELOAD] : updateToDB , id = " + paramMaterialData.id + "result = " + bool);
  }
  
  public MaterialData a(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "id=?", new String[] { paramString }, null, null, null, null);
    paramString = localObject1;
    if (localObject2 != null)
    {
      paramString = localObject1;
      if (((List)localObject2).size() > 0)
      {
        localObject2 = (Entity)((List)localObject2).get(0);
        paramString = localObject1;
        if ((localObject2 instanceof MaterialData)) {
          paramString = (MaterialData)localObject2;
        }
      }
    }
    return paramString;
  }
  
  public HashMap<String, MaterialData> a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(MaterialData.class);
    HashMap localHashMap = new HashMap();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        Entity localEntity = (Entity)localList.get(i);
        if ((localEntity instanceof MaterialData)) {
          localHashMap.put(((MaterialData)localEntity).id, (MaterialData)localEntity);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(bhyo parambhyo, MaterialData paramMaterialData, File paramFile)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.6(this, parambhyo, paramMaterialData, paramFile));
      return;
    }
    b(parambhyo, paramMaterialData, paramFile);
  }
  
  public void a(MaterialData paramMaterialData)
  {
    if (paramMaterialData != null) {
      ujg.a.a(paramMaterialData.adid, "startDownload", paramMaterialData.res_version);
    }
  }
  
  public void a(String paramString, BaseResData paramBaseResData) {}
  
  public void b()
  {
    ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.2(this));
  }
  
  public void b(String paramString, BaseResData paramBaseResData) {}
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void c()
  {
    ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.3(this));
  }
  
  public boolean c(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_Uib != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Uib);
    }
    this.jdField_a_of_type_Uie = new uie(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_Uie);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Uib != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Uib);
    }
    if (this.jdField_a_of_type_Uie != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Uie);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uic
 * JD-Core Version:    0.7.0.1
 */