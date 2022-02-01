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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ttv
  extends ral
  implements tvb
{
  private static String jdField_a_of_type_JavaLangString = "adMaterial";
  private List<MaterialData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CopyOnWriteArrayList<MaterialData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private ttu jdField_a_of_type_Ttu = new ttw(this);
  private ttx jdField_a_of_type_Ttx;
  private volatile boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, MaterialData> b = new ConcurrentHashMap();
  
  public ttv(AppInterface paramAppInterface)
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
        twp.a("ReadInJoySuperMaskAd", "getRootDirectory = " + paramMaterialData);
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
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
      }
    }
    return localArrayList;
  }
  
  public static ttv a(QQAppInterface paramQQAppInterface)
  {
    return (ttv)paramQQAppInterface.getManager(337);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    tvh.a.a();
    tvf.a.a();
  }
  
  private void a(String paramString)
  {
    ThreadManagerV2.excute(new AdMaterialResManager.4(this, paramString), 64, null, true);
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
            twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is empty , replace a new data");
            label103:
            b(localMaterialData1);
            tvh.a.b(localMaterialData1);
          }
        }
        for (;;)
        {
          localHashMap.put(localMaterialData1.id, localMaterialData1);
          break;
          if (!localMaterialData2.isReady)
          {
            twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is not ready , replace a new data");
            break label103;
          }
          if (localMaterialData2.res_version != localMaterialData1.res_version)
          {
            FileUtils.deleteDirectory(a(localMaterialData2));
            twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data is version check fail , replace a new data");
            break label103;
          }
          if (!tuw.a(localMaterialData2))
          {
            twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data file not exist , replace a new data");
            break label103;
          }
          if (!tuw.b(localMaterialData2))
          {
            twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : local data manifest file not exist , replace a new data");
            break label103;
          }
          twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : file exist , not need download : " + localMaterialData1.id);
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
          tvh.a.b(localObject);
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
    Object localObject = new tvo(localJSONObject, new tvp(paramMaterialData.adid, paramMaterialData.ad_source, paramMaterialData.res_version), false, 1);
    boolean bool = tvs.a.a("[PRELOAD]", new tvc[] { localObject });
    localObject = localJSONObject.optString("animFileName");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMaterialData.animFileName = ((String)localObject);
      twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : checkFinalResFile, id = " + paramMaterialData.id + " result = " + bool + " fileName = " + (String)localObject);
    }
    paramMaterialData.superMaskType = localJSONObject.optInt("superMaskType");
    return bool;
  }
  
  private boolean a(MaterialData paramMaterialData, File paramFile)
  {
    paramMaterialData = new tvl(paramMaterialData, paramFile);
    return tvs.a.a("[PRELOAD]", new tvc[] { paramMaterialData });
  }
  
  private void b(bgoe parambgoe, MaterialData paramMaterialData, File paramFile)
  {
    if ((parambgoe == null) || (paramMaterialData == null))
    {
      FileUtils.deleteFile(paramFile);
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(jdField_a_of_type_JavaLangString + "_" + paramMaterialData.id);
    int i = parambgoe.a;
    if (i != 0)
    {
      tvg.a.a(paramMaterialData.toJson(), false, "errorCode = " + i, "", "resource_download_key");
      tvg.a.a(paramMaterialData.adid, "downloadFail", paramMaterialData.res_version);
      FileUtils.deleteFile(paramFile);
      return;
    }
    tvg.a.a(paramMaterialData.adid, "downloadSuccess", paramMaterialData.res_version);
    if ((paramFile == null) || (!paramFile.exists()))
    {
      tvg.a.a(paramMaterialData.adid, "noFile", paramMaterialData.res_version);
      return;
    }
    if (!a(paramMaterialData, paramFile))
    {
      tvg.a.a(paramMaterialData.toJson(), false, "check file md5 failed", "", "resource_download_key");
      tvg.a.a(paramMaterialData.adid, "md5Fail", paramMaterialData.res_version);
      FileUtils.deleteFile(paramFile);
      return;
    }
    paramMaterialData.res_path = a(paramMaterialData.ad_source, paramMaterialData.adid, paramMaterialData.res_version);
    try
    {
      FileUtils.uncompressZip(paramFile.getAbsolutePath(), paramMaterialData.res_path, false);
      tvg.a.a(paramMaterialData.adid, "zipSuccess", paramMaterialData.res_version);
      if (a(paramMaterialData))
      {
        tvg.a.a(paramMaterialData.adid, "AllSuccess", paramMaterialData.res_version);
        tvh.a.a(paramMaterialData);
        e(paramMaterialData);
        tvg.a.a(paramMaterialData.toJson(), true, "no error", "", "resource_download_key");
        FileUtils.deleteFile(paramFile);
        return;
      }
    }
    catch (IOException parambgoe)
    {
      for (;;)
      {
        tvg.a.a(paramMaterialData.adid, "zipFail", paramMaterialData.res_version);
        parambgoe.printStackTrace();
        continue;
        FileUtils.deleteDirectory(a(paramMaterialData));
        tvg.a.a(paramMaterialData.toJson(), false, "res_path file not exist", "", "resource_download_key");
      }
    }
  }
  
  private void b(MaterialData paramMaterialData)
  {
    if (paramMaterialData.end_time <= NetConnInfoCenter.getServerTime()) {
      return;
    }
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()))
    {
      twp.a("ReadInJoySuperMaskAd", "[PRELOAD] netType = wifi");
      a(jdField_a_of_type_JavaLangString, paramMaterialData, 2);
      return;
    }
    if ((bhov.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()) == 4) && (paramMaterialData.enable_4g == 1))
    {
      twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : download by 4G : id = " + paramMaterialData.adid);
      ThreadManager.getSubThreadHandler().postDelayed(new AdMaterialResManager.5(this, paramMaterialData), 10000L);
      return;
    }
    twp.a("ReadInJoySuperMaskAd", "[PRELOAD] netType = " + bhov.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()) + " enable_4g = " + paramMaterialData.enable_4g);
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
        twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : persistOrReplaceToDB, id = " + paramMaterialData.id + " result = " + bool);
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
      twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : removeEntityIfExistsInDB, id = " + paramMaterialData.id + " result = " + bool);
    }
  }
  
  private void d(MaterialData paramMaterialData)
  {
    paramMaterialData.setStatus(1001);
    int i = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.delete(MaterialData.class.getSimpleName(), "id=? ", new String[] { paramMaterialData.id });
    twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : deleteToDB, id = " + paramMaterialData.id + " result = " + i);
  }
  
  private void e(MaterialData paramMaterialData)
  {
    paramMaterialData.isReady = true;
    paramMaterialData.setStatus(1001);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramMaterialData);
    twp.a("ReadInJoySuperMaskAd", "[PRELOAD] : updateToDB , id = " + paramMaterialData.id + "result = " + bool);
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
  
  public void a(bgoe parambgoe, MaterialData paramMaterialData, File paramFile)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManagerV2.executeOnSubThread(new AdMaterialResManager.6(this, parambgoe, paramMaterialData, paramFile));
      return;
    }
    b(parambgoe, paramMaterialData, paramFile);
  }
  
  public void a(MaterialData paramMaterialData)
  {
    if (paramMaterialData != null) {
      tvg.a.a(paramMaterialData.adid, "startDownload", paramMaterialData.res_version);
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
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (this.jdField_a_of_type_Ttu != null)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_Ttu);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Ttx = new ttx(this);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), this.jdField_a_of_type_Ttx);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Ttu != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_Ttu);
    }
    if (this.jdField_a_of_type_Ttx != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Ttx);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttv
 * JD-Core Version:    0.7.0.1
 */