import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class afhc
  extends affx<CameraEmotionData>
{
  private boolean bYb;
  private boolean bYc;
  
  public afhc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void I(List<accj.a> paramList1, List<accj.a> paramList2)
  {
    int k = 0;
    if (paramList2.size() < paramList1.size())
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.remove((accj.a)paramList2.next());
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramList2 = ez();
        if (paramList2 != null) {
          for (int i = 1;; i = j)
          {
            j = i;
            if (k >= paramList2.size()) {
              break;
            }
            int m = ((CameraEmotionData)paramList2.get(k)).emoId;
            j = i;
            if (i < m) {
              j = m;
            }
            k += 1;
          }
        }
        int j = 1;
        paramList2 = new ArrayList();
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (accj.a)localIterator.next();
          j += 1;
          localObject = a((accj.a)localObject, j);
          ((CameraEmotionData)localObject).RomaingType = "normal";
          b((CustomEmotionBase)localObject, 1);
          paramList2.add(localObject);
        }
        S(paramList2, 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needAdd = " + bool + "| remoteImgList.size = " + paramList1.size());
      }
      return;
    }
  }
  
  private CameraEmotionData a(accj.a parama, int paramInt)
  {
    if ((parama == null) || (this.app == null)) {
      return null;
    }
    CameraEmotionData localCameraEmotionData = new CameraEmotionData();
    localCameraEmotionData.uin = this.app.getCurrentAccountUin();
    localCameraEmotionData.emoId = (paramInt + 1);
    localCameraEmotionData.resid = parama.bnT;
    localCameraEmotionData.strContext = parama.content;
    localCameraEmotionData.templateId = parama.templateId;
    if (aqmr.isEmpty(parama.md5)) {}
    for (localCameraEmotionData.md5 = afgu.kz(parama.bnT);; localCameraEmotionData.md5 = parama.md5)
    {
      localCameraEmotionData.url = parama.url;
      return localCameraEmotionData;
    }
  }
  
  private void e(List<String> paramList, List<CameraEmotionData> paramList1, boolean paramBoolean)
  {
    Object localObject = as("needDel");
    if (localObject == null) {
      localObject = new ArrayList();
    }
    for (;;)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        if (((List)localObject).size() > 0)
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext()) {
            if (!paramList.contains(((CameraEmotionData)localIterator.next()).resid)) {
              localIterator.remove();
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, locNeedDelList.size = " + ((List)localObject).size());
        }
      }
      if (paramBoolean) {
        ((List)localObject).addAll(paramList1);
      }
      if (((List)localObject).size() > 0)
      {
        paramList = ((List)localObject).iterator();
        while (paramList.hasNext()) {
          b((CameraEmotionData)paramList.next(), 4);
        }
        S((List)localObject, 4);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "updateLocalDBFromServer, needDelete = " + paramBoolean + "| localNotInServerList.size = " + paramList1.size());
      }
      return;
    }
  }
  
  public int CV()
  {
    if (this.zz == null) {
      return 0;
    }
    Iterator localIterator = this.zz.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if ("needDel".equals(((CameraEmotionData)localIterator.next()).RomaingType)) {
        break label59;
      }
      i += 1;
    }
    label59:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  protected void S(List<CameraEmotionData> paramList, int paramInt)
  {
    super.S(paramList, paramInt);
    if (this.app != null) {
      yhf.a(this.app).ciq();
    }
  }
  
  public afmi a(CameraEmotionData paramCameraEmotionData)
  {
    aflv localaflv = new aflv();
    localaflv.type = 11;
    localaflv.path = a(paramCameraEmotionData);
    localaflv.bDY = paramCameraEmotionData.strContext;
    localaflv.templateId = paramCameraEmotionData.templateId;
    localaflv.url = paramCameraEmotionData.url;
    localaflv.emoId = paramCameraEmotionData.emoId;
    localaflv.eId = paramCameraEmotionData.resid;
    localaflv.bDZ = paramCameraEmotionData.RomaingType;
    localaflv.thumbPath = paramCameraEmotionData.thumbPath;
    localaflv.bnT = paramCameraEmotionData.resid;
    return localaflv;
  }
  
  public String a(CameraEmotionData paramCameraEmotionData)
  {
    if ((paramCameraEmotionData == null) || (this.app == null)) {
      return "";
    }
    if (!TextUtils.isEmpty(paramCameraEmotionData.emoPath)) {
      return paramCameraEmotionData.emoPath;
    }
    String str2 = paramCameraEmotionData.md5;
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (TextUtils.isEmpty(paramCameraEmotionData.resid)) {
        return "";
      }
      str1 = afgu.kz(paramCameraEmotionData.resid);
    }
    return afgu.aV(str1, this.app.getCurrentUin());
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, int paramInt)
  {
    super.a(paramCameraEmotionData, paramInt);
    if (this.app != null)
    {
      paramCameraEmotionData = yhf.a(this.app);
      if (paramCameraEmotionData != null) {
        paramCameraEmotionData.ciq();
      }
    }
  }
  
  public void c(List<accj.a> paramList, List<String> paramList1, List<String> paramList2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    Object localObject1;
    int i;
    ArrayList localArrayList;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateLocalDBFromServer, start remoteImgList.size = ").append(paramList.size()).append("| deleteSize =");
      if (paramList2 == null)
      {
        i = 0;
        QLog.d("CameraEmotionRoamingDBManager", 2, i);
      }
    }
    else
    {
      localObject1 = new ArrayList();
      localArrayList = new ArrayList();
      localObject2 = ez();
      if (localObject2 == null) {
        break label243;
      }
      localObject2 = ((List)localObject2).iterator();
    }
    for (;;)
    {
      bool2 = bool1;
      if (!((Iterator)localObject2).hasNext()) {
        break label243;
      }
      CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject2).next();
      if ((!localCameraEmotionData.RomaingType.equals("needDel")) && (!localCameraEmotionData.RomaingType.equals("failed")) && (!localCameraEmotionData.RomaingType.equals("needUpload")))
      {
        i = paramList1.indexOf(localCameraEmotionData.resid);
        if (i < 0)
        {
          bool1 = true;
          ((List)localObject1).add(localCameraEmotionData);
          continue;
          i = paramList2.size();
          break;
        }
        localArrayList.add(paramList.get(i));
      }
    }
    label243:
    e(paramList2, (List)localObject1, bool2);
    I(paramList, localArrayList);
    trimCache();
  }
  
  public void cZs()
  {
    if (!this.bYc)
    {
      this.bYc = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("sucFlag", "0");
      localHashMap.put("retCode", String.valueOf(15));
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, localHashMap, null);
    }
  }
  
  public List<afmi> eA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPanel.");
    }
    List localList = ez();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          CameraEmotionData localCameraEmotionData = (CameraEmotionData)localList.get(i);
          if ("needDel".equals(localCameraEmotionData.RomaingType)) {
            QLog.d("CameraEmotionRoamingDBManager", 1, "data need delete, do not need display -> resId:" + localCameraEmotionData.resid);
          } else {
            localArrayList.add(a(localCameraEmotionData));
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPanel, display size:" + localArrayList.size());
      }
      return localArrayList;
      i -= 1;
    }
  }
  
  protected List<afmi> eB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = ez();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    for (;;)
    {
      int i;
      try
      {
        i = localList.size() - 1;
        if (i >= 0)
        {
          CameraEmotionData localCameraEmotionData = (CameraEmotionData)localList.get(i);
          if (!"normal".equals(localCameraEmotionData.RomaingType))
          {
            QLog.d("CameraEmotionRoamingDBManager", 1, "data need hidden, do not need display -> resId:" + localCameraEmotionData.resid);
          }
          else
          {
            aflv localaflv = new aflv();
            localaflv.type = 11;
            localaflv.path = a(localCameraEmotionData);
            localaflv.bDY = localCameraEmotionData.strContext;
            localaflv.templateId = localCameraEmotionData.templateId;
            localaflv.url = localCameraEmotionData.url;
            localaflv.emoId = localCameraEmotionData.emoId;
            localaflv.eId = localCameraEmotionData.resid;
            localaflv.bDZ = localCameraEmotionData.RomaingType;
            localaflv.thumbPath = localCameraEmotionData.thumbPath;
            localaflv.bnT = localCameraEmotionData.resid;
            localArrayList.add(localaflv);
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmotionRoamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + localArrayList.size());
      }
      return localArrayList;
      i -= 1;
    }
  }
  
  public List<CameraEmotionData> ez()
  {
    Object localObject3;
    Object localObject4;
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.zz.size() <= 0) {
        break label119;
      }
      localObject3 = this.zz.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (CameraEmotionData)((Iterator)localObject3).next();
        if (localObject4 != null) {
          localArrayList.add(localObject4);
        }
      }
      localObject3 = localObject1;
    }
    finally {}
    if (QLog.isColorLevel())
    {
      QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from cache: data size = " + localObject1.size());
      localObject3 = localObject1;
    }
    for (;;)
    {
      return localObject3;
      label119:
      localObject3 = localObject1;
      if (this.app != null)
      {
        localObject3 = this.app.a().createEntityManager();
        Object localObject2;
        int i;
        if (localObject3 != null)
        {
          localObject2 = ((EntityManager)localObject3).query(h(), false, null, null, null, null, null, null);
          localObject3 = new ArrayList();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject4 = ((List)localObject2).iterator();
            i = 0;
            if (!((Iterator)localObject4).hasNext()) {
              break label413;
            }
            CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject4).next();
            if (TextUtils.isEmpty(localCameraEmotionData.RomaingType))
            {
              localCameraEmotionData.RomaingType = "init";
              ((List)localObject3).add(localCameraEmotionData);
              i = 1;
            }
            for (;;)
            {
              b(localCameraEmotionData, 1);
              break;
              if (localCameraEmotionData.RomaingType.equals("needUpload"))
              {
                localCameraEmotionData.RomaingType = "failed";
                ((List)localObject3).add(localCameraEmotionData);
                cZs();
                i = 1;
              }
            }
          }
        }
        label413:
        for (;;)
        {
          trimCache();
          if (i != 0) {
            S((List)localObject3, 2);
          }
          if (QLog.isColorLevel()) {
            if (localObject2 != null)
            {
              QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from db : data size = " + ((List)localObject2).size());
              this.bYb = true;
            }
            else
            {
              localObject2 = new ArrayList();
              QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from db : data size = null");
              if (this.bYb) {
                anpc.a(BaseApplication.getContext()).collectPerformance("", "CameraEmoDBError", true, 0L, 0L, null, "");
              }
            }
          }
          break;
          i = 0;
          continue;
          break;
        }
        localObject3 = localObject2;
      }
    }
  }
  
  public Class h()
  {
    return CameraEmotionData.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    afgz.a().a.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhc
 * JD-Core Version:    0.7.0.1
 */