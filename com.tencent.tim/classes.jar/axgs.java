import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager.1;
import dov.com.qq.im.ae.play.AEPlayShowMaterialManager.2;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class axgs
  extends axpm
{
  private List<axbq> MC = new LinkedList();
  private anhn a = new anhn();
  private axbr b;
  private String cUn;
  private final Object gp = new Object();
  
  private void F(@NonNull axbu paramaxbu)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "deleteMaterialZipAndDir, AEMaterialMetaData.id=" + paramaxbu.id);
    }
    File localFile = new File(awtn.b.b.cSQ, paramaxbu.id);
    paramaxbu = new File(awtn.b.b.cSR, paramaxbu.id);
    if (localFile.exists()) {
      aqhq.deleteFile(localFile.getPath());
    }
    if (paramaxbu.exists()) {
      aqhq.cn(paramaxbu.getPath());
    }
  }
  
  private void T(@NonNull List<axbq> paramList1, @NonNull List<axbq> paramList2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "diffTwoListAndDeleteOutdatedMaterial");
    }
    paramList1 = h(paramList1);
    Map localMap = h(paramList2);
    Iterator localIterator = paramList1.entrySet().iterator();
    label211:
    label214:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramList1 = (Map.Entry)localIterator.next();
        String str = (String)paramList1.getKey();
        paramList2 = (axbu)paramList1.getValue();
        if (paramList2 == null) {
          continue;
        }
        paramList1 = paramList2;
        if (localMap.containsKey(str))
        {
          paramList1 = (axbu)localMap.get(str);
          if ((paramList1 == null) || ((paramList1.eEy != 4) && (paramList1.eEy != 5) && (paramList1.eEy != 6) && (paramList1.eEy != 7)) || (paramList1.md5.equals(paramList2.md5))) {
            break label211;
          }
        }
      }
      for (paramList1 = paramList2;; paramList1 = null)
      {
        if ((paramList1 == null) || ((paramList1.eEy != 4) && (paramList1.eEy != 5) && (paramList1.eEy != 6) && (paramList1.eEy != 7))) {
          break label214;
        }
        F(paramList1);
        break;
        return;
      }
    }
  }
  
  private List<axbq> a(@NonNull List<axbq> paramList, @NonNull Map<String, axbu> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "reAssemblePsCategory");
    }
    this.cUn = null;
    LinkedList localLinkedList1 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      axbq localaxbq = (axbq)paramList.get(i);
      LinkedList localLinkedList2 = new LinkedList();
      int j = 0;
      Object localObject;
      if (j < localaxbq.Mm.size())
      {
        localObject = (axbu)localaxbq.Mm.get(j);
        if (((axbu)localObject).eEy != 0)
        {
          ((axbu)localObject).usable = g((axbu)localObject);
          localLinkedList2.add(localObject);
          if (((axbu)localObject).eEy == 2) {
            this.cUn = ((axbu)localObject).webUrl;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          if (paramMap.containsKey(((axbu)localObject).id))
          {
            axbu localaxbu = (axbu)paramMap.get(((axbu)localObject).id);
            localaxbu.playShowCoverImg = ((axbu)localObject).playShowCoverImg;
            localaxbu.Kq = localaxbq.cTw;
            localaxbu.playShowDisplayText = ((axbu)localObject).playShowDisplayText;
            if ((TextUtils.isEmpty(localaxbu.cTC)) && (!TextUtils.isEmpty(((axbu)localObject).cTC))) {
              localaxbu.cTC = ((axbu)localObject).cTC;
            }
            localLinkedList2.add(localaxbu);
          }
        }
      }
      if (localLinkedList2.size() > 0)
      {
        localObject = new axbq();
        ((axbq)localObject).categoryName = localaxbq.categoryName;
        ((axbq)localObject).eEw = localaxbq.eEw;
        ((axbq)localObject).cTw = localaxbq.cTw;
        ((axbq)localObject).Mm = localLinkedList2;
        localLinkedList1.add(localObject);
      }
      i += 1;
    }
    return localLinkedList1;
  }
  
  private List<axbq> bB(List<axbq> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getFilteredPsCategoryList");
    }
    return a(paramList, h(new LinkedList(c().hK())));
  }
  
  private List<axbq> bs(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "parsePsCategoryListFromConfig");
    }
    if (TextUtils.isEmpty(paramString)) {
      return new LinkedList();
    }
    GetPlayShowCatMatTreeRsp localGetPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp)GsonUtils.json2Obj(paramString, axbi.e);
    if ((localGetPlayShowCatMatTreeRsp == null) || (localGetPlayShowCatMatTreeRsp.Categories == null) || (localGetPlayShowCatMatTreeRsp.Categories.size() == 0)) {
      return new LinkedList();
    }
    LinkedList localLinkedList1 = new LinkedList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < localGetPlayShowCatMatTreeRsp.Categories.size())
    {
      PSMetaCategory localPSMetaCategory = (PSMetaCategory)localGetPlayShowCatMatTreeRsp.Categories.get(i);
      if ((localPSMetaCategory == null) || (localPSMetaCategory.materials == null) || (localPSMetaCategory.materials.size() == 0)) {}
      LinkedList localLinkedList2;
      label253:
      do
      {
        i += 1;
        break;
        localLinkedList2 = new LinkedList();
        j = 0;
        if (j < localPSMetaCategory.materials.size())
        {
          PSMetaMaterial localPSMetaMaterial = (PSMetaMaterial)localPSMetaCategory.materials.get(j);
          if ((localPSMetaMaterial == null) || (TextUtils.isEmpty(localPSMetaMaterial.id)) || (TextUtils.isEmpty(localPSMetaMaterial.thumbUrl))) {}
          for (;;)
          {
            j += 1;
            break;
            if (localHashMap.containsKey(localPSMetaMaterial.id))
            {
              paramString = (axbu)localHashMap.get(localPSMetaMaterial.id);
              if ((paramString.eEy != 4) && (paramString.eEy != 5) && (paramString.eEy != 6) && (paramString.eEy != 7)) {
                break label479;
              }
              if ((TextUtils.isEmpty(paramString.resurl)) || (TextUtils.isEmpty(paramString.md5))) {
                continue;
              }
            }
            do
            {
              do
              {
                localHashMap.put(localPSMetaMaterial.id, paramString);
                localLinkedList2.add(paramString);
                break;
                paramString = new axbu();
                paramString.id = localPSMetaMaterial.id;
                paramString.name = localPSMetaMaterial.id;
                paramString.resurl = localPSMetaMaterial.packageUrl;
                paramString.md5 = localPSMetaMaterial.packageMd5;
                paramString.eEy = localPSMetaMaterial.type;
                paramString.playShowCoverImg = localPSMetaMaterial.thumbUrl;
                paramString.Kq = localPSMetaCategory.id;
                paramString.playShowDisplayText = localPSMetaMaterial.name;
                Map localMap = localPSMetaMaterial.additionalFields;
                if (localMap != null)
                {
                  paramString.webUrl = ((String)localMap.get("web_url"));
                  paramString.miniAppId = ((String)localMap.get("mini_app_id"));
                  paramString.cTC = ((String)localMap.get("takeSameName"));
                }
                break label253;
                if (paramString.eEy != 2) {
                  break label500;
                }
              } while (!TextUtils.isEmpty(paramString.webUrl));
              break;
            } while ((paramString.eEy != 3) || (TextUtils.isEmpty(paramString.miniAppId)));
          }
        }
      } while (localLinkedList2.size() <= 0);
      label479:
      label500:
      paramString = new axbq();
      paramString.categoryName = localPSMetaCategory.name;
      paramString.cTw = localPSMetaCategory.id;
      if (localPSMetaCategory.onlyFlag) {}
      for (int j = 1;; j = 2)
      {
        paramString.eEw = j;
        paramString.dtV = localPSMetaCategory.defaultFlag;
        paramString.Mm = localLinkedList2;
        localLinkedList1.add(paramString);
        break;
      }
    }
    return localLinkedList1;
  }
  
  private axbr c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getAEMaterialManager");
    }
    if (this.b == null) {
      this.b = ((axbr)axov.a(18));
    }
    return this.b;
  }
  
  private void eJC()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListAsync");
    }
    ThreadManager.excute(new AEPlayShowMaterialManager.1(this), 64, null, true);
  }
  
  private void eJE()
  {
    axiy.i("AEPlayShowMaterialManager", "notifyMaterialListUpdated");
    ThreadManager.getUIHandler().post(new AEPlayShowMaterialManager.2(this));
  }
  
  private boolean g(@NonNull axbu paramaxbu)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + paramaxbu.id);
    }
    switch (paramaxbu.eEy)
    {
    default: 
      return false;
    case 2: 
    case 3: 
      return true;
    }
    c();
    return axbr.b(paramaxbu);
  }
  
  private Map<String, axbu> h(@Nullable List<axbq> paramList)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "buildMaterialDataMap");
    }
    if (paramList == null) {
      return new HashMap();
    }
    HashMap localHashMap = new HashMap();
    paramList = new LinkedList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (axbq)paramList.next();
      if ((localObject != null) && (((axbq)localObject).Mm != null) && (((axbq)localObject).Mm.size() != 0))
      {
        localObject = new LinkedList(((axbq)localObject).Mm).iterator();
        while (((Iterator)localObject).hasNext())
        {
          axbu localaxbu = (axbu)((Iterator)localObject).next();
          if ((!TextUtils.isEmpty(localaxbu.id)) && (!TextUtils.isEmpty(localaxbu.md5))) {
            localHashMap.put(localaxbu.id, localaxbu);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private List<axbq> hO()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal");
    }
    File localFile1 = new File(awtn.d.cSY);
    File localFile2 = new File(awtn.d.cSZ);
    if (!localFile2.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=null, thread=" + Thread.currentThread());
      }
      if (!localFile1.exists())
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
        }
        return new LinkedList();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
      }
      return bB(bs(ayzs.p(localFile1)));
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, updatedConfig=" + localFile2.getPath() + ", thread=" + Thread.currentThread());
    }
    if (!localFile1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
      }
      localList1 = bB(bs(ayzs.p(localFile2)));
      aqhq.moveFile(localFile2.getPath(), localFile1.getPath());
      return localList1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "updatePsCategoryListInternal, defaultConfig=" + localFile1.getPath() + ", thread=" + Thread.currentThread());
    }
    List localList1 = bs(ayzs.p(localFile1));
    List localList2 = bs(ayzs.p(localFile2));
    T(localList1, localList2);
    localList1 = bB(localList2);
    aqhq.deleteFile(localFile1.getPath());
    aqhq.moveFile(localFile2.getPath(), localFile1.getPath());
    return localList1;
  }
  
  public void b(anho paramanho, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "addObserver, observer=" + paramanho + ", eventId=" + paramInt);
    }
    this.a.a(paramanho, new int[] { paramInt });
  }
  
  public void e(anho paramanho)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "removeObserver, observer=" + paramanho);
    }
    this.a.a(paramanho);
  }
  
  public void eIC()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "initIndeed");
    }
    eJC();
  }
  
  public void eJD()
  {
    synchronized (this.gp)
    {
      if (this.MC != null) {
        this.MC.clear();
      }
      return;
    }
  }
  
  public List<axbq> hN()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "getPsCategoryList");
    }
    return new LinkedList(this.MC);
  }
  
  public void refresh()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowMaterialManager", 4, "refresh");
    }
    eJC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgs
 * JD-Core Version:    0.7.0.1
 */