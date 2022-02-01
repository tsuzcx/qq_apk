import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.1;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.2;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.3;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher.4;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

public class adxn
{
  public static volatile long Nl;
  public static boolean bCl;
  public static adxn c;
  public final int CACHE_SIZE = 64;
  public final CopyOnWriteArrayList<adyk> E = new CopyOnWriteArrayList();
  public final ConcurrentHashMap<Integer, HashMap<String, adye>> eO = new ConcurrentHashMap();
  public final Runnable fr = new BubbleDiyFetcher.1(this);
  public final CopyOnWriteArraySet<String> h = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<String> i = new CopyOnWriteArraySet();
  public final CopyOnWriteArraySet<String> j = new CopyOnWriteArraySet();
  public final Map<String, String> jM = Collections.synchronizedMap(new LRULinkedHashMap(32));
  public final Map<String, HashMap<String, String>> jN = Collections.synchronizedMap(new LRULinkedHashMap(64));
  public final Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public static adxn a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new adxn();
      }
      return c;
    }
    finally {}
  }
  
  public void Bw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "notifyPasterDownloadComplete " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Hc(paramString);
      cBt();
    }
  }
  
  public void By(String paramString)
  {
    File localFile = ((BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(44)).B();
    Object localObject1 = paramString.split("_");
    String str2;
    Object localObject4;
    Object localObject2;
    if (localObject1.length == 4)
    {
      String str1 = localObject1[3];
      str2 = localObject1[1];
      localObject4 = localObject1[2];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("BubbleDiyFetcher_" + str1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localFile = new File(localFile, str1 + ".png");
          localObject1 = localObject2;
          if (localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.i("BubbleDiyFetcher", 2, "decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + localFile.getAbsolutePath());
            }
            localObject2 = aqcu.decodeFile(localFile.getAbsolutePath());
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              BaseApplicationImpl.sImageCache.put("BubbleDiyFetcher_" + str1, localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {}
      }
    }
    try
    {
      localObject2 = (HashMap)this.eO.get(Integer.valueOf(Integer.parseInt(str2)));
      if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
      {
        localObject2 = (adye)((HashMap)localObject2).get(localObject4);
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.kK[2], localObject2.kK[3], true);
        BaseApplicationImpl.sImageCache.put(paramString, localObject1);
        this.i.remove(paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BubbleDiyFetcher", 2, "", localException);
        }
        Object localObject3 = null;
      }
    }
  }
  
  public void Hc(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.endsWith(paramString)) {
          By(str);
        }
      }
    }
  }
  
  public void Hd(String paramString)
  {
    Object localObject1 = (BubbleManager)BaseApplicationImpl.getApplication().getRuntime().getManager(44);
    Object localObject2 = paramString.split("_");
    Object localObject5;
    Object localObject4;
    if (localObject2.length == 4)
    {
      localObject5 = localObject2[1];
      localObject4 = localObject2[2];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject1 = new File(((BubbleManager)localObject1).A(), String.valueOf(localObject5)).getAbsolutePath();
        Object localObject6 = (String)localObject1 + File.separatorChar + "chartlet" + File.separatorChar + "chartlet.png";
        localObject2 = (Bitmap)BaseApplicationImpl.sImageCache.get("BubbleDiyFetcher_" + localObject5 + "_" + "chartlet");
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject6 = new File((String)localObject6);
          localObject1 = localObject2;
          if (((File)localObject6).exists())
          {
            if (QLog.isColorLevel()) {
              QLog.i("BubbleDiyFetcher", 2, "createStaticBitmapCache: decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + ((File)localObject6).getAbsolutePath());
            }
            localObject2 = aqcu.decodeFile(((File)localObject6).getAbsolutePath());
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              BaseApplicationImpl.sImageCache.put("BubbleDiyFetcher_" + localObject5 + "_" + "chartlet", localObject2);
              localObject1 = localObject2;
            }
          }
        }
        if (localObject1 == null) {}
      }
    }
    try
    {
      localObject2 = (HashMap)this.eO.get(Integer.valueOf(Integer.parseInt(localObject5)));
      if ((localObject2 != null) && (((HashMap)localObject2).containsKey(localObject4)))
      {
        localObject2 = (adye)((HashMap)localObject2).get(localObject4);
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject1, localObject2.kK[2], localObject2.kK[3], true);
        BaseApplicationImpl.sImageCache.put(paramString, localObject1);
        this.j.remove(paramString);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BubbleDiyFetcher", 1, "createStaticBitmapCache error!", localException);
        Object localObject3 = null;
      }
    }
  }
  
  public Bitmap a(adyk paramadyk, adye.a parama)
  {
    if ((paramadyk == null) || (parama == null)) {
      return null;
    }
    paramadyk = "BubbleDiyFetcher_" + parama.bubbleId + "_" + parama.bvU.toUpperCase() + "_" + "chartlet";
    parama = (Bitmap)BaseApplicationImpl.sImageCache.get(paramadyk);
    if (parama != null)
    {
      this.j.remove(paramadyk);
      return parama;
    }
    this.j.add(paramadyk);
    paramadyk = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramadyk instanceof QQAppInterface)) {
      t((QQAppInterface)paramadyk, 500);
    }
    return null;
  }
  
  public String a(adyk paramadyk, String paramString)
  {
    Object localObject;
    if ((paramadyk == null) || (TextUtils.isEmpty(paramString))) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jM.get(paramString);
      localObject = str;
    } while (str != null);
    this.h.add(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "fetchDiyText: put VipBubbleDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
    }
    this.E.add(paramadyk);
    paramadyk = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramadyk instanceof QQAppInterface)) {
      t((QQAppInterface)paramadyk, 500);
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, acci paramacci)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("BubbleDiyFetcher", 2, String.format("uinAndDiyId %s, text cache is %b, diy paster cache is %b", new Object[] { paramString, Boolean.valueOf(this.jM.containsKey(paramString)), Boolean.valueOf(this.jN.containsKey(paramString)) }));
        }
        if ((!this.jM.containsKey(paramString)) || (!this.jN.containsKey(paramString))) {
          break;
        }
        paramQQAppInterface = new BubbleDiyEntity();
        paramQQAppInterface.uinAndDiyId = paramString;
        paramQQAppInterface.diyText = ((String)this.jM.get(paramQQAppInterface.uinAndDiyId));
        BubbleDiyEntity.parsePasterMap(paramQQAppInterface, (HashMap)this.jN.get(paramString));
        paramString = new ArrayList();
        paramString.add(paramQQAppInterface);
      } while (paramacci == null);
      paramacci.onUpdate(1, true, paramString);
      return;
      localObject = (BubbleDiyEntity)paramQQAppInterface.a().createEntityManager().find(BubbleDiyEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "query bubbleDiy from database, uinAndDiyId: " + paramString);
      }
      this.jM.put(paramString, ((BubbleDiyEntity)localObject).diyText);
      this.jN.put(paramString, ((BubbleDiyEntity)localObject).convertToPasterMap());
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(localObject);
    } while (paramacci == null);
    paramacci.onUpdate(1, true, paramQQAppInterface);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "start request diy id " + paramString);
    }
    this.h.add(paramString);
    Object localObject = new ArrayList();
    ((List)localObject).add(paramString);
    ((adxo)paramQQAppInterface.getBusinessHandler(70)).b((List)localObject, paramacci);
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<BubbleDiyEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)paramList.next();
      if (paramBoolean) {
        paramQQAppInterface.a().createEntityManager().persistOrReplace(localBubbleDiyEntity);
      }
      this.h.remove(localBubbleDiyEntity.uinAndDiyId);
      this.jM.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.diyText);
      this.jN.put(localBubbleDiyEntity.uinAndDiyId, localBubbleDiyEntity.convertToPasterMap());
      if (!TextUtils.isEmpty(localBubbleDiyEntity.topLeftId)) {
        Hc(localBubbleDiyEntity.topLeftId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.topRightId)) {
        Hc(localBubbleDiyEntity.topRightId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomLeftId)) {
        Hc(localBubbleDiyEntity.bottomLeftId);
      }
      if (!TextUtils.isEmpty(localBubbleDiyEntity.bottomRightId)) {
        Hc(localBubbleDiyEntity.bottomRightId);
      }
    }
    cBt();
  }
  
  public Bitmap b(adyk paramadyk, adye.a parama)
  {
    if ((paramadyk == null) || (parama == null) || (TextUtils.isEmpty(paramadyk.bwm))) {
      return null;
    }
    if (this.jN.containsKey(paramadyk.bwm))
    {
      Object localObject = (HashMap)this.jN.get(paramadyk.bwm);
      if ((localObject != null) && (((HashMap)localObject).containsKey(parama.bvU.toUpperCase())))
      {
        localObject = (String)((HashMap)localObject).get(parama.bvU.toUpperCase());
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "diy id " + paramadyk.bwm + " has no pasterId for align: " + parama.bvU.toUpperCase());
          }
          return null;
        }
      }
      else
      {
        return null;
      }
      parama = "BubbleDiyFetcher_" + parama.bubbleId + "_" + parama.bvU.toUpperCase() + "_" + (String)localObject;
      localObject = (Bitmap)BaseApplicationImpl.sImageCache.get(parama);
      if (localObject != null)
      {
        this.i.remove(parama);
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! " + parama);
      }
      this.i.add(parama);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "fetchDiyPaster: put VipBubbleDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.E.add(paramadyk);
      paramadyk = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramadyk instanceof QQAppInterface)) {
        t((QQAppInterface)paramadyk, 500);
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "can not found cache in diyPasterCache! " + paramadyk.bwm);
      }
      this.h.add(paramadyk.bwm);
    }
  }
  
  public void bV(QQAppInterface paramQQAppInterface)
  {
    if (!bCl)
    {
      bCl = true;
      ThreadManager.post(new BubbleDiyFetcher.2(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void bW(QQAppInterface paramQQAppInterface)
  {
    if (this.h.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "mUnCacheDiyId size is 0!");
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList(this.h);
      int m = ((ArrayList)localObject1).size();
      Object localObject2 = paramQQAppInterface.a().createEntityManager();
      int k = 0;
      while (k < m)
      {
        BubbleDiyEntity localBubbleDiyEntity = (BubbleDiyEntity)((EntityManager)localObject2).find(BubbleDiyEntity.class, (String)((ArrayList)localObject1).get(k));
        if (localBubbleDiyEntity != null) {
          localArrayList.add(localBubbleDiyEntity);
        }
        k += 1;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (BubbleDiyEntity)((Iterator)localObject1).next();
        this.h.remove(((BubbleDiyEntity)localObject2).uinAndDiyId);
      }
    } while (localArrayList.isEmpty());
    a(paramQQAppInterface, false, localArrayList);
  }
  
  public void cBr()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    VasQuickUpdateManager localVasQuickUpdateManager;
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      cBs();
      if (this.i.isEmpty()) {
        break label231;
      }
      localVasQuickUpdateManager = (VasQuickUpdateManager)((AppRuntime)localObject1).getManager(184);
      localObject2 = null;
      ArrayList localArrayList = new ArrayList(this.i);
      Iterator localIterator = localArrayList.iterator();
      int k = 0;
      if (localIterator.hasNext())
      {
        String[] arrayOfString = ((String)localIterator.next()).split("_");
        if (arrayOfString.length != 4) {
          break label247;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new String[localArrayList.size()];
        }
        localObject2 = arrayOfString[3];
        int m = k + 1;
        localObject1[k] = ("bubble.paster." + (String)localObject2 + ".png");
        k = m;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("BubbleDiyFetcher", 2, "now download from VasQuickUpdateManager list: " + TextUtils.join(",", (Object[])localObject2));
        }
        localVasQuickUpdateManager.downloadGatherItem(2L, localObject2[0], (String[])localObject2, "0");
      }
      label231:
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("BubbleDiyFetcher", 2, "all paster has decode!");
      return;
      label247:
      localObject1 = localObject2;
    }
  }
  
  public void cBs()
  {
    if (this.i.size() > 0)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext()) {
        By((String)localIterator.next());
      }
      cBt();
    }
  }
  
  @TargetApi(11)
  public void cBt()
  {
    HashSet localHashSet = new HashSet(this.E.size());
    Iterator localIterator = this.E.iterator();
    while (localIterator.hasNext())
    {
      adyk localadyk = (adyk)localIterator.next();
      if ((localadyk != null) && (localadyk.getCallback() != null) && (lm(localadyk.bwm))) {
        localHashSet.add(localadyk.bwm);
      }
    }
    if (localHashSet.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BubbleDiyFetcher", 2, "refreshDrawableOnUiThread: " + TextUtils.join(",", localHashSet));
      }
      this.mUIHandler.post(new BubbleDiyFetcher.3(this, localHashSet));
    }
  }
  
  @TargetApi(11)
  public void cI(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      bV(paramQQAppInterface);
    } while ((this.h.isEmpty()) && (this.i.isEmpty()) && (this.E.isEmpty()) && (this.j.isEmpty()));
    ThreadManager.post(new BubbleDiyFetcher.4(this, paramQQAppInterface), 5, null, false);
  }
  
  public void clearCache()
  {
    this.E.clear();
  }
  
  public boolean lm(String paramString)
  {
    Iterator localIterator;
    if ((!TextUtils.isEmpty(paramString)) && (this.jM.containsKey(paramString)) && (this.jN.containsKey(paramString)))
    {
      paramString = (HashMap)this.jN.get(paramString);
      localIterator = this.i.iterator();
    }
    while (localIterator.hasNext())
    {
      String[] arrayOfString = ((String)localIterator.next()).split("_");
      if ((arrayOfString.length == 4) && (paramString.containsValue(arrayOfString[3])))
      {
        return false;
        return false;
      }
    }
    return true;
  }
  
  public void t(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.h.isEmpty()) && (this.i.isEmpty()) && (this.j.isEmpty()));
      if (paramInt <= 0)
      {
        this.mUIHandler.removeCallbacks(this.fr);
        cI(paramQQAppInterface);
        return;
      }
    } while (System.currentTimeMillis() <= Nl);
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "postLoadBubbleDiyTexts delay:  " + paramInt);
    }
    this.mUIHandler.postDelayed(this.fr, paramInt);
    Nl = System.currentTimeMillis() + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxn
 * JD-Core Version:    0.7.0.1
 */