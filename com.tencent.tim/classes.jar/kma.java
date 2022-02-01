import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.2;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.AdMaterialResManager.3;
import com.tencent.biz.pubaccount.readinjoy.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class kma
  extends mfl
{
  private klz a = new kmb(this);
  private ConcurrentHashMap<String, MaterialData> aV = new ConcurrentHashMap();
  private List<MaterialData> gk = new ArrayList();
  private ArrayList<MaterialData> kg = new ArrayList();
  private String prefix = "adMaterial";
  
  public kma(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private Long a(MaterialData paramMaterialData)
  {
    paramMaterialData = this.mEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "id=?", new String[] { String.valueOf(paramMaterialData.id) }, null, null, null, null);
    if ((paramMaterialData != null) && (paramMaterialData.size() == 1)) {
      return Long.valueOf(((MaterialData)paramMaterialData.get(0)).getId());
    }
    return Long.valueOf(-1L);
  }
  
  public static kma a(QQAppInterface paramQQAppInterface)
  {
    return (kma)paramQQAppInterface.getManager(337);
  }
  
  private void a(MaterialData paramMaterialData)
  {
    try
    {
      if (this.aV != null) {
        this.aV.remove(paramMaterialData.id);
      }
      aqhq.delete(paramMaterialData.res_path, false);
      this.mEntityManager.delete(MaterialData.class.getSimpleName(), "id=? ", new String[] { String.valueOf(paramMaterialData.id) });
      return;
    }
    catch (Exception paramMaterialData)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdMaterialResManager", 2, "clearExpireData failed " + QLog.getStackTraceString(paramMaterialData));
    }
  }
  
  public static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString)
  {
    a(paramMaterialData, paramBoolean, paramString, null, "resource_download_key");
  }
  
  public static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramMaterialData, paramBoolean, paramString1, paramString2, "resource_fetch_key");
  }
  
  private static void a(MaterialData paramMaterialData, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", i);
        localJSONObject.put("reason", paramString1);
        localJSONObject.put("os", "Android");
        if ((!paramString3.equals("resource_fetch_key")) && (paramMaterialData != null))
        {
          localJSONObject.put("adId", paramMaterialData.adid);
          localJSONObject.put("adSource", paramMaterialData.ad_source);
          localJSONObject.put("resUrl", paramMaterialData.url);
          localJSONObject.put("resMD5", paramMaterialData.res_md5);
          localJSONObject.put("version", paramMaterialData.res_version);
          localJSONObject.put("type", paramMaterialData.ad_type);
          localJSONObject.put("startTime", paramMaterialData.start_time);
          localJSONObject.put("endTime", paramMaterialData.end_time);
          localJSONObject.put("delivery_effect", paramMaterialData.delivery_effect);
        }
        if (paramString2 != null) {
          localJSONObject.put("content", paramString2);
        }
        annx.b(localQQAppInterface, "sendtdbank|b_pcg_ffc_game_dev_qq_kandian_commercial|ad_resource_statistics_report", paramString3 + "|" + localJSONObject.toString(), true);
        return;
      }
      catch (Exception paramMaterialData)
      {
        return;
      }
      i = 0;
    }
  }
  
  private void aEp()
  {
    Object localObject = aq();
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((MaterialData)((Iterator)localObject).next());
      }
    }
  }
  
  private List<MaterialData> ap()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      Object localObject = this.mApp.getCurrentAccountUin();
      localObject = this.mEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=?", new String[] { localObject, String.valueOf(l), String.valueOf(0) }, null, null, null, null);
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
  
  private List<MaterialData> aq()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      long l = NetConnInfoCenter.getServerTime();
      List localList = this.mEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time<?", new String[] { this.mApp.getCurrentAccountUin(), String.valueOf(l) }, null, null, null, null);
      return localList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
      }
    }
    return localArrayList;
  }
  
  private void b(MaterialData paramMaterialData)
  {
    paramMaterialData.res_path = "";
    paramMaterialData.isReady = false;
    this.mEntityManager.update(paramMaterialData);
  }
  
  public static void b(MaterialData paramMaterialData, boolean paramBoolean, String paramString)
  {
    a(paramMaterialData, paramBoolean, paramString, null, "resource_use_key");
  }
  
  private void bN(ArrayList<MaterialData> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      bO(paramArrayList);
      r(paramArrayList);
      this.gk = ap();
      if (this.gk == null) {
        break label86;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "ad_material need download num =  " + this.gk.size());
      }
      bV(this.gk);
    }
    label86:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AdMaterialResManager", 2, "ad_material are already downloaded ");
  }
  
  private void bO(ArrayList<MaterialData> paramArrayList)
  {
    aEp();
    ArrayList localArrayList = new ArrayList();
    Object localObject = getAll();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    Iterator localIterator1 = ((List)localObject).iterator();
    if (localIterator1.hasNext())
    {
      localObject = (MaterialData)localIterator1.next();
      Iterator localIterator2 = paramArrayList.iterator();
      label72:
      if (localIterator2.hasNext())
      {
        MaterialData localMaterialData = (MaterialData)localIterator2.next();
        if ((!((MaterialData)localObject).id.equals(localMaterialData.id)) || ((((MaterialData)localObject).res_md5.equals(localMaterialData.res_md5)) && (((MaterialData)localObject).res_version == localMaterialData.res_version))) {
          break label233;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "not the same res_version or md5 update material data ,id =  " + ((MaterialData)localObject).id);
        }
        long l = ((MaterialData)localObject).getId();
        localObject = ((MaterialData)localObject).res_path;
        localMaterialData.setId(l);
        localMaterialData.setStatus(1001);
        localMaterialData.res_path = ((String)localObject);
        localArrayList.add(localMaterialData);
        localObject = localMaterialData;
      }
    }
    label233:
    for (;;)
    {
      break label72;
      break;
      bU(localArrayList);
      return;
    }
  }
  
  private void bU(List<MaterialData> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            MaterialData localMaterialData = (MaterialData)paramList.next();
            aqhq.delete(localMaterialData.res_path, false);
            localMaterialData.res_path = "";
            if (this.aV != null) {
              this.aV.put(localMaterialData.id, localMaterialData);
            }
            if ((!this.mEntityManager.update(localMaterialData)) && (QLog.isColorLevel())) {
              QLog.d("AdMaterialResManager", 2, "updateDataByList failed data id =  " + localMaterialData.id);
            }
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "updateDataByList failed " + QLog.getStackTraceString(paramList));
        }
      }
    }
  }
  
  private void c(MaterialData paramMaterialData)
  {
    a(this.prefix, paramMaterialData, 1);
  }
  
  private ConcurrentHashMap<String, MaterialData> d()
  {
    Object localObject2 = new ArrayList();
    try
    {
      localObject1 = n(-1);
      if (localObject1 == null) {
        break label110;
      }
      localObject2 = new ConcurrentHashMap();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MaterialData localMaterialData = (MaterialData)((Iterator)localObject1).next();
        ((ConcurrentHashMap)localObject2).put(localMaterialData.id, localMaterialData);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("AdMaterialResManager", 2, "getMaterialDataList query  failed " + QLog.getStackTraceString(localException));
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
    label110:
    return new ConcurrentHashMap();
  }
  
  private List<MaterialData> getAll()
  {
    return this.mEntityManager.query(MaterialData.class);
  }
  
  private void mj(String paramString)
  {
    ThreadManagerV2.excute(new AdMaterialResManager.3(this, paramString), 64, null, true);
  }
  
  private List<MaterialData> n(int paramInt)
  {
    long l = NetConnInfoCenter.getServerTime();
    String str = this.mApp.getCurrentAccountUin();
    if (paramInt == -1) {
      return this.mEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=?", new String[] { str, String.valueOf(l), String.valueOf(1) }, null, null, null, null);
    }
    return this.mEntityManager.query(MaterialData.class, MaterialData.class.getSimpleName(), true, "uin=? and end_time>? and isReady=? and ad_type=?", new String[] { str, String.valueOf(l), String.valueOf(1), String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private boolean r(ArrayList<MaterialData> paramArrayList)
  {
    for (;;)
    {
      MaterialData localMaterialData;
      try
      {
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        localMaterialData = (MaterialData)paramArrayList.next();
        long l = a(localMaterialData).longValue();
        if (l != -1L)
        {
          localMaterialData.setId(l);
          localMaterialData.setStatus(1001);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("AdMaterialResManager", 4, "[insert new] already had set data adid = " + localMaterialData.adid);
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label170;
        }
      }
      catch (Exception paramArrayList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "[insert new]  failed " + QLog.getStackTraceString(paramArrayList));
        }
        return false;
      }
      QLog.d("AdMaterialResManager", 4, "[insert new] data adid =  " + localMaterialData.adid);
      label170:
      this.mEntityManager.persistOrReplace(localMaterialData);
    }
    return true;
  }
  
  public String O(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    if ((this.aV != null) && (this.aV.get(paramString1) != null))
    {
      paramString1 = (MaterialData)this.aV.get(paramString1);
      if (paramString1 != null)
      {
        if (aqhq.fileExists(paramString1.res_path)) {
          return paramString1.res_path;
        }
        b(paramString1);
      }
    }
    return "";
  }
  
  public void a(Context paramContext, String paramString, BaseResData paramBaseResData) {}
  
  public void a(String paramString, BaseResData paramBaseResData)
  {
    paramBaseResData.isReady = true;
    paramBaseResData.business = paramString;
    if ((paramBaseResData instanceof MaterialData))
    {
      ((MaterialData)paramBaseResData).res_path = U(paramString, paramBaseResData.id);
      if (aqhq.fileExists(((MaterialData)paramBaseResData).res_path)) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "download finish update db material res_path file not exist  id = " + paramBaseResData.id);
      }
      a((MaterialData)paramBaseResData, false, "res_path file not exist");
    }
    label93:
    do
    {
      do
      {
        return;
        a((MaterialData)paramBaseResData, true, "no error");
        paramBaseResData.setStatus(1001);
        if (!this.mEntityManager.update(paramBaseResData)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialResManager", 2, "download finish update db material id = " + paramBaseResData.id);
        }
      } while (this.aV == null);
      this.aV.put(paramBaseResData.id, (MaterialData)paramBaseResData);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("AdMaterialResManager", 2, "download finish update db material failed  id = " + paramBaseResData.id);
  }
  
  public boolean a(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void b(String paramString, BaseResData paramBaseResData) {}
  
  public boolean b(String paramString, BaseResData paramBaseResData)
  {
    return false;
  }
  
  public void bV(List<MaterialData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        c((MaterialData)paramList.next());
      }
    }
  }
  
  public void bt(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_" + paramString2;
    if ((this.aV != null) && (this.aV.get(paramString1) != null))
    {
      paramString2 = (MaterialData)this.aV.get(paramString1);
      aqhq.delete(paramString2.res_path, false);
      b(paramString2);
      this.aV.put(paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("AdMaterialResManager", 2, "deleteDirById success id = " + paramString1);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AdMaterialResManager", 2, "deleteDirById failed id = " + paramString1);
  }
  
  public ArrayList<MaterialData> i(int paramInt)
  {
    this.kg.clear();
    Iterator localIterator = this.aV.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((MaterialData)localEntry.getValue()).ad_type == paramInt) {
        if (aqhq.fileExists(((MaterialData)localEntry.getValue()).res_path)) {
          this.kg.add(localEntry.getValue());
        } else {
          b((MaterialData)localEntry.getValue());
        }
      }
    }
    return this.kg;
  }
  
  public void init()
  {
    if ((this.mApp != null) && (this.a != null))
    {
      this.mApp.addObserver(this.a);
      ThreadManagerV2.excute(new AdMaterialResManager.2(this), 32, null, true);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.mApp.removeObserver(this.a);
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kma
 * JD-Core Version:    0.7.0.1
 */