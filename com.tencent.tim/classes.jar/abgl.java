import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher.1;
import com.tencent.mobileqq.addon.DiyPendantFetcher.2;
import com.tencent.mobileqq.addon.DiyPendantFetcher.3;
import com.tencent.mobileqq.addon.DiyPendantFetcher.4;
import com.tencent.mobileqq.addon.DiyPendantFetcher.5;
import com.tencent.mobileqq.addon.DiyPendantFetcher.6;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class abgl
{
  public static volatile long Nl;
  public static abgl b;
  public static boolean bCl;
  public final int CACHE_SIZE = 64;
  public final CopyOnWriteArrayList<abgl.a> E = new CopyOnWriteArrayList();
  AtomicBoolean cf = new AtomicBoolean(false);
  public ETEngine d = ETEngine.getInstanceForDiyPendant();
  public final Runnable fr = new DiyPendantFetcher.1(this);
  public final LRULinkedHashMap<String, DiyPendantEntity> g = new LRULinkedHashMap(64);
  public final LRULinkedHashMap<Integer, kt> h;
  public final CopyOnWriteArraySet<String> h;
  public final LRULinkedHashMap<String, Bitmap> i;
  public final CopyOnWriteArraySet<String> i;
  
  private abgl()
  {
    this.jdField_h_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(16);
    this.jdField_i_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(10);
    this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  }
  
  private void By(String paramString)
  {
    Object localObject2 = paramString.split("_");
    if (localObject2.length == 3)
    {
      Object localObject1 = localObject2[2];
      localObject2 = localObject2[1];
      if (BaseApplicationImpl.sImageCache.get(paramString) == null)
      {
        localObject1 = new File(aqgm.pr((String)localObject1));
        if (((File)localObject1).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i("DiyPendantFetcher", 2, "decode and put scale bitmap into BaseApplicationImpl.sImageCache, " + ((File)localObject1).getAbsolutePath());
          }
          localObject1 = aqcu.decodeFile(((File)localObject1).getAbsolutePath());
          if (localObject1 != null)
          {
            BaseApplicationImpl.sImageCache.put(paramString, localObject1);
            this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(paramString);
          }
        }
      }
    }
  }
  
  public static abgl a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new abgl();
      }
      return b;
    }
    finally {}
  }
  
  public void Bw(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "notifyPasterDownloadComplete " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(paramString)) {
        By(paramString);
      }
      cBt();
    }
  }
  
  public void Bx(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "notifyFontDownloadComplete, scid =" + paramString);
    }
    kt localkt;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.replace("faceAddon.stickerFont.android.", "");
      localkt = (kt)this.jdField_h_of_type_ComTencentUtilLRULinkedHashMap.get(Integer.valueOf(Integer.parseInt(paramString)));
      if (localkt != null)
      {
        if (localkt.mFontType != 1) {
          break label125;
        }
        if (!this.cf.get()) {
          cBq();
        }
        if ((this.cf.get()) && (this.d.native_loadFont(localkt.mFontPath, Integer.parseInt(paramString), true))) {
          cBt();
        }
      }
    }
    label125:
    while (!new File(localkt.mFontPath).exists()) {
      return;
    }
    localkt.mTypeface = Typeface.createFromFile(localkt.mFontPath);
  }
  
  public Bitmap a(abgk paramabgk, int paramInt)
  {
    if ((paramabgk == null) || (TextUtils.isEmpty(paramabgk.uinAndDiyId))) {
      return null;
    }
    if (this.g.containsKey(paramabgk.uinAndDiyId))
    {
      Object localObject = (DiyPendantEntity)this.g.get(paramabgk.uinAndDiyId);
      if (((DiyPendantEntity)localObject).getStickerInfoList().size() > paramInt)
      {
        localObject = a((DiyPendantSticker)((DiyPendantEntity)localObject).getStickerInfoList().get(paramInt));
        Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(localObject);
        if (localBitmap != null)
        {
          this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject);
          return localBitmap;
        }
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "can not found bitmap cache in BaseApplicationImpl.sImageCache! " + (String)localObject);
        }
        this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "fetchDiyPaster: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
      }
      this.E.add(paramabgk);
      paramabgk = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramabgk instanceof QQAppInterface)) {
        l((QQAppInterface)paramabgk, 500);
      }
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + paramabgk.uinAndDiyId);
      }
      this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramabgk.uinAndDiyId);
    }
  }
  
  public Bitmap a(abgl.a parama, String paramString, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt1 <= 0)) {
      return null;
    }
    String str = paramString + "_" + paramInt1 + "_" + paramInt2 + "_" + paramFloat + "_" + paramInt3 + "_" + paramInt4 + "_" + paramInt5;
    if (this.jdField_i_of_type_ComTencentUtilLRULinkedHashMap.containsKey(str)) {
      return (Bitmap)this.jdField_i_of_type_ComTencentUtilLRULinkedHashMap.get(str);
    }
    synchronized (this.d)
    {
      if (!this.cf.get()) {
        cBq();
      }
      if ((!this.cf.get()) || (TextUtils.isEmpty(paramString)))
      {
        QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail EnigeReady = " + this.cf.get() + " text = " + paramString);
        return null;
      }
    }
    Object localObject = aqgm.pp(String.valueOf(paramInt1));
    if (!this.d.native_isFontLoaded(paramInt1))
    {
      this.E.add(parama);
      if (aqgm.rm(String.valueOf(paramInt1)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "found font res but can not load the font, font id = " + paramInt1);
        }
        ThreadManager.executeOnFileThread(new DiyPendantFetcher.3(this, (String)localObject, paramInt1));
      }
      for (;;)
      {
        QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not exist!");
        return null;
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "can not found font res! font id = " + paramInt1);
        }
        gz(paramInt1, paramInt2);
      }
    }
    parama = new ETFont(paramInt1, (String)localObject, paramFloat);
    parama.setColor(paramInt3);
    try
    {
      localObject = Bitmap.createBitmap(paramInt4, paramInt5, Bitmap.Config.ARGB_8888);
      if (!this.d.native_isPaintableChar(paramString.charAt(0), parama)) {
        break label593;
      }
      for (paramInt1 = this.d.native_spaceMeasureText(paramString, 0, paramString.length(), parama, paramPaint); paramInt1 > paramInt4; paramInt1 = this.d.native_spaceMeasureText(paramString, 0, paramString.length(), parama, paramPaint)) {
        parama.mFontSize -= 1;
      }
      paramInt2 = (paramInt4 - paramInt1) / 2;
    }
    catch (OutOfMemoryError parama)
    {
      QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont Bitmap.createBitmap OutOfMemoryError: " + parama.getMessage());
      return null;
    }
    paramInt1 = 0;
    paramPaint = new Paint.FontMetrics();
    if (this.d.native_getFontMetrics(paramPaint, parama))
    {
      paramFloat = paramPaint.bottom;
      float f = paramPaint.top;
      paramInt1 = (int)((paramInt5 - (paramFloat - f)) / 2.0F);
    }
    if (!this.d.native_drawText(paramString, (Bitmap)localObject, paramInt2, paramInt1, parama))
    {
      QLog.d("DiyPendantFetcher", 1, "fetchTextWithFont fail font not support: " + paramString.charAt(0));
      return null;
    }
    label593:
    if (localObject != null) {
      this.jdField_i_of_type_ComTencentUtilLRULinkedHashMap.put(str, localObject);
    }
    return localObject;
  }
  
  public Typeface a(abgl.a parama, int paramInt1, int paramInt2)
  {
    if ((parama == null) || (paramInt1 <= 0)) {
      return null;
    }
    kt localkt = (kt)this.jdField_h_of_type_ComTencentUtilLRULinkedHashMap.get(Integer.valueOf(paramInt1));
    if ((localkt != null) && (localkt.mTypeface != null)) {
      return localkt.mTypeface;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "can not found typeface in the cache! font id = " + paramInt1);
    }
    this.E.add(parama);
    gz(paramInt1, paramInt2);
    return null;
  }
  
  public DiyPendantEntity a(QQAppInterface paramQQAppInterface, String paramString, acci paramacci)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (this.g.containsKey(paramString))
      {
        paramQQAppInterface = new ArrayList();
        paramQQAppInterface.add(this.g.get(paramString));
        if (paramacci != null) {
          paramacci.onUpdate(1, true, paramQQAppInterface);
        }
        return (DiyPendantEntity)this.g.get(paramString);
      }
      localObject = (DiyPendantEntity)paramQQAppInterface.a().createEntityManager().find(DiyPendantEntity.class, " uinAndDiyId=? ", new String[] { paramString });
      if (localObject == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "query diy pendant from database, uinAndDiyId: " + paramString);
      }
      this.g.put(paramString, localObject);
      paramString = new ArrayList();
      paramString.add(localObject);
      paramQQAppInterface = (QQAppInterface)localObject;
    } while (paramacci == null);
    paramacci.onUpdate(1, true, paramString);
    return localObject;
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "start request diy id " + paramString);
    }
    this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramString);
    Object localObject = new ArrayList();
    ((List)localObject).add(Long.valueOf(Long.parseLong(paramString.split("_")[0])));
    ((abgm)paramQQAppInterface.getBusinessHandler(114)).a((List)localObject, paramacci);
    return null;
  }
  
  public String a(DiyPendantSticker paramDiyPendantSticker)
  {
    return "DiyPendantFetcher_" + paramDiyPendantSticker.type + "_" + paramDiyPendantSticker.stickerId;
  }
  
  public List<DiyPendantSticker> a(abgk paramabgk)
  {
    if ((paramabgk == null) || (TextUtils.isEmpty(paramabgk.uinAndDiyId))) {
      return null;
    }
    if (this.g.containsKey(paramabgk.uinAndDiyId)) {
      return ((DiyPendantEntity)this.g.get(paramabgk.uinAndDiyId)).getStickerInfoList();
    }
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "can not found cache in DiyPendantCache! " + paramabgk.uinAndDiyId);
    }
    this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramabgk.uinAndDiyId);
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "fetchDiyBaseInfo: put DiyPendantDrawable into mNotRefreshAIODrawables and post delay 0.5s to load bubble diy!");
    }
    this.E.add(paramabgk);
    paramabgk = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramabgk instanceof QQAppInterface)) {
      l((QQAppInterface)paramabgk, 500);
    }
    return null;
  }
  
  public void a(DiyPendantEntity paramDiyPendantEntity)
  {
    paramDiyPendantEntity = paramDiyPendantEntity.getStickerInfoList().iterator();
    while (paramDiyPendantEntity.hasNext())
    {
      String str = a((DiyPendantSticker)paramDiyPendantEntity.next());
      if (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(str)) {
        By(str);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, List<DiyPendantEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)paramList.next();
      if (paramBoolean)
      {
        paramQQAppInterface.a().createEntityManager().persistOrReplace(localDiyPendantEntity);
        ExtensionInfo localExtensionInfo = localacff.a(localDiyPendantEntity.uinAndDiyId.split("_")[0]);
        if ((localExtensionInfo != null) && (localExtensionInfo.pendantDiyId != localDiyPendantEntity.diyId))
        {
          localExtensionInfo.pendantDiyId = localDiyPendantEntity.diyId;
          localArrayList.add(localExtensionInfo);
        }
      }
      this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localDiyPendantEntity.uinAndDiyId);
      this.g.put(localDiyPendantEntity.uinAndDiyId, localDiyPendantEntity);
      a(localDiyPendantEntity);
    }
    localacff.iN(localArrayList);
    cBt();
  }
  
  public void bU(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      bV(paramQQAppInterface);
    } while ((this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.E.isEmpty()));
    ThreadManager.post(new DiyPendantFetcher.2(this, paramQQAppInterface), 5, null, false);
  }
  
  public void bV(QQAppInterface paramQQAppInterface)
  {
    if (!bCl)
    {
      bCl = true;
      ThreadManager.post(new DiyPendantFetcher.5(this, paramQQAppInterface), 5, null, false);
    }
  }
  
  public void bW(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("DiyPendantFetcher", 2, "mUnCacheDiyId size is 0!");
      }
    }
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Object localObject1 = new ArrayList(this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet);
      int k = ((ArrayList)localObject1).size();
      Object localObject2 = paramQQAppInterface.a().createEntityManager();
      int j = 0;
      while (j < k)
      {
        DiyPendantEntity localDiyPendantEntity = (DiyPendantEntity)((EntityManager)localObject2).find(DiyPendantEntity.class, (String)((ArrayList)localObject1).get(j));
        if (localDiyPendantEntity != null) {
          localArrayList.add(localDiyPendantEntity);
        }
        j += 1;
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiyPendantEntity)((Iterator)localObject1).next();
        this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(((DiyPendantEntity)localObject2).uinAndDiyId);
      }
    } while (localArrayList.isEmpty());
    a(paramQQAppInterface, false, localArrayList);
  }
  
  void cBq()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      if (this.d.initEngine(16, 1048576))
      {
        this.cf.set(true);
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("DiyPendantFetcher", 2, "DIY Pendant init Font Engine time = " + (l2 - l1) + "ms");
        }
      }
      else
      {
        if (this.d.isEngineInited.compareAndSet(false, true)) {
          lb.aF();
        }
        this.cf.set(false);
        QLog.d("DiyPendantFetcher", 1, "vip font not downloaded, start early download.");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.cf.set(false);
      QLog.e("DiyPendantFetcher", 1, "initETEngine Exception:" + localThrowable.getMessage());
    }
  }
  
  public void cBr()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    VasQuickUpdateManager localVasQuickUpdateManager;
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      cBs();
      if (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) {
        break label222;
      }
      localVasQuickUpdateManager = (VasQuickUpdateManager)((AppRuntime)localObject1).getManager(184);
      localObject2 = null;
      Iterator localIterator = this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      int j = 0;
      if (localIterator.hasNext())
      {
        String[] arrayOfString = ((String)localIterator.next()).split("_");
        if (arrayOfString.length != 3) {
          break label238;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new String[this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size()];
        }
        localObject2 = arrayOfString[2];
        int k = j + 1;
        localObject1[j] = ("faceAddon.sticker." + (String)localObject2 + ".png");
        j = k;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      break;
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("DiyPendantFetcher", 2, "now download from VasQuickUpdateManager list: " + TextUtils.join(",", (Object[])localObject2));
        }
        localVasQuickUpdateManager.downloadGatherItem(4L, localObject2[0], (String[])localObject2, "DiyPendantFetcher");
      }
      label222:
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("DiyPendantFetcher", 2, "all paster has decode!");
      return;
      label238:
      localObject1 = localObject2;
    }
  }
  
  public void cBs()
  {
    if (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.size() > 0)
    {
      Iterator localIterator = this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext()) {
        By((String)localIterator.next());
      }
      cBt();
    }
  }
  
  @TargetApi(11)
  public void cBt()
  {
    ThreadManager.getUIHandler().post(new DiyPendantFetcher.6(this));
  }
  
  public void clearCache()
  {
    this.E.clear();
  }
  
  void gz(int paramInt1, int paramInt2)
  {
    String str = aqgm.pp(String.valueOf(paramInt1));
    if (!this.jdField_h_of_type_ComTencentUtilLRULinkedHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      kt localkt = new kt(paramInt1, str);
      localkt.mFontType = paramInt2;
      this.jdField_h_of_type_ComTencentUtilLRULinkedHashMap.put(Integer.valueOf(paramInt1), localkt);
    }
    ThreadManager.executeOnFileThread(new DiyPendantFetcher.4(this, paramInt1, str));
  }
  
  public void l(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_h_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()) && (this.jdField_i_of_type_JavaUtilConcurrentCopyOnWriteArraySet.isEmpty()));
      if (paramInt <= 0)
      {
        ThreadManager.getUIHandler().removeCallbacks(this.fr);
        bU(paramQQAppInterface);
        return;
      }
    } while (System.currentTimeMillis() <= Nl);
    if (QLog.isColorLevel()) {
      QLog.i("DiyPendantFetcher", 2, "postLoadPendantDiy delay:  " + paramInt);
    }
    ThreadManager.getUIHandler().postDelayed(this.fr, paramInt);
    Nl = System.currentTimeMillis() + paramInt;
  }
  
  public static abstract interface a
  {
    public abstract Object L();
    
    public abstract void invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgl
 * JD-Core Version:    0.7.0.1
 */