package com.tencent.ttpic.openapi.cache;

import android.graphics.Bitmap;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.cache.CompatibleList;
import com.tencent.ttpic.cache.LoadETCItemManager;
import com.tencent.ttpic.cache.LoadFaceItemManager;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.cache.LoadStickerItemManager;
import com.tencent.ttpic.cache.PreLoader;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.filter.FabbyMvPart;
import com.tencent.ttpic.openapi.filter.FabbyParts;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public final class VideoMemoryManager
{
  private static String IMAGE_MEMORY_BLACE_LIST = "HUAWEI;HUAWEI MT7-CL00;19|HUAWEI;HUAWEI MT7-CL00;23|Samsung;SM-A8000;22|Samsung;SM-A8000;23|Xiaomi;MI 3;19|Xiaomi;Redmi Note 3;21|vivo;vivo X5V;19|vivo;vivo X5Max V;19|Xiaomi;Redmi 3;22|vivo;vivo Y75A;25|samsung;SM-C5000;23|HUAWEI;CAM-TL00;23";
  private static final String TAG = VideoMemoryManager.class.getSimpleName();
  public static final int VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB = 30720;
  public static final int VIDEO_CACHE_MEM_CACHE_REMAIN_SIZE = 10240;
  private static boolean forceLoadFromSdCard;
  private static final VideoMemoryManager mInstance = new VideoMemoryManager();
  private final Map<String, Bitmap> mBeautyFaceCache = new ConcurrentHashMap();
  private final Map<String, Bitmap> mCache = new ConcurrentHashMap();
  private double mCurMaterialSizeInMB;
  private final Map<String, ETC1Util.ETC1Texture> mETCCache = new ConcurrentHashMap();
  private final Map<FaceOffUtil.FEATURE_TYPE, Bitmap> mGrayCache = new ConcurrentHashMap();
  private final Handler mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.VIDEO_MEMORY_MANAGER).getLooper());
  private int mMaxPreloadSizeInKB;
  private int mSampleSize;
  private final Map<String, LoadItemManager> mStickerManagers = new ConcurrentHashMap();
  private final Map<String, Bitmap> mWM260Cache = new ConcurrentHashMap();
  private final Map<String, LoadItemManager> mWM260Managers = new ConcurrentHashMap();
  
  private void addExtraStickerParser(VideoMaterial paramVideoMaterial, List<StickerItem> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)paramList.next();
        if ((!VideoMaterialUtil.isEmptyItem(localStickerItem)) && (!this.mStickerManagers.containsKey(localStickerItem.id))) {
          if (ExtraStickerParserAgent.getInstance().isInExtraParser(localStickerItem.stickerType)) {
            this.mStickerManagers.put(localStickerItem.id, new LoadExtraStickerParserManager(paramVideoMaterial.getDataPath(), localStickerItem));
          } else if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
            this.mStickerManagers.put(localStickerItem.id, new LoadPagItemManager(paramVideoMaterial.getDataPath(), localStickerItem));
          }
        }
      }
    }
  }
  
  public static VideoMemoryManager getInstance()
  {
    return mInstance;
  }
  
  private long getMaterialImageSizeInKB(VideoMaterial paramVideoMaterial)
  {
    long l1 = 0L;
    if (paramVideoMaterial == null) {}
    Object localObject1;
    long l2;
    do
    {
      return l1;
      localObject1 = new ArrayList();
      Object localObject2;
      Object localObject3;
      if (paramVideoMaterial.getItemList() != null)
      {
        localObject2 = paramVideoMaterial.getItemList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (StickerItem)((Iterator)localObject2).next();
          if (((StickerItem)localObject3).type != VideoFilterFactory.POSITION_TYPE.SKYBOX.type) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (paramVideoMaterial.getHeadCropItemList() != null) {
        ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
      }
      if (paramVideoMaterial.getFabbyParts() != null)
      {
        localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
          if (((FabbyMvPart)localObject3).bgItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
          }
          if (((FabbyMvPart)localObject3).fgItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
          }
          if (((FabbyMvPart)localObject3).coverItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
          }
          if (((FabbyMvPart)localObject3).transitionItem != null) {
            ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
          }
        }
      }
      if (paramVideoMaterial.getFaceFeatureItemList() != null)
      {
        localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getStickerItems() != null)) {
            ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
          }
        }
      }
      localObject1 = ((List)localObject1).iterator();
      for (l2 = l1; ((Iterator)localObject1).hasNext(); l2 = VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((StickerItem)localObject2).subFolder) / 1024 + l2) {
        localObject2 = (StickerItem)((Iterator)localObject1).next();
      }
      l1 = l2;
      if (paramVideoMaterial.getFaceOffItemList() != null)
      {
        localObject1 = paramVideoMaterial.getFaceOffItemList().iterator();
        for (;;)
        {
          l1 = l2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (FaceItem)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty(((FaceItem)localObject2).id)) {
            l2 += VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((FaceItem)localObject2).id) / 1024;
          }
        }
      }
      l2 = l1;
      if (paramVideoMaterial.getFaceFeatureItemList() != null)
      {
        localObject1 = paramVideoMaterial.getFaceFeatureItemList().iterator();
        do
        {
          l2 = l1;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (FaceFeatureItem)((Iterator)localObject1).next();
        } while ((localObject2 == null) || (((FaceFeatureItem)localObject2).getFaceOffItemList() == null));
        localObject2 = ((FaceFeatureItem)localObject2).getFaceOffItemList().iterator();
        l2 = l1;
        for (;;)
        {
          l1 = l2;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject3 = (FaceItem)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(((FaceItem)localObject3).id)) {
            l2 += VideoMaterialUtil.getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + ((FaceItem)localObject3).id) / 1024;
          }
        }
      }
      paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList();
      l1 = l2;
    } while (paramVideoMaterial == null);
    paramVideoMaterial = paramVideoMaterial.iterator();
    for (;;)
    {
      l1 = l2;
      if (!paramVideoMaterial.hasNext()) {
        break;
      }
      localObject1 = (MultiViewerItem)paramVideoMaterial.next();
      if (localObject1 != null) {
        l2 += getMaterialImageSizeInKB(((MultiViewerItem)localObject1).videoMaterial);
      }
    }
  }
  
  public static boolean isInBlackList()
  {
    boolean bool = CompatibleList.isFoundProductFeature(IMAGE_MEMORY_BLACE_LIST);
    if (bool) {}
    return bool;
  }
  
  private ArrayList<StickerItem> loadAllItems(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      localArrayList.addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      localArrayList.addAll(paramVideoMaterial.getHeadCropItemList());
    }
    Object localObject;
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (((Iterator)localObject).hasNext())
      {
        FabbyMvPart localFabbyMvPart = (FabbyMvPart)((Iterator)localObject).next();
        if (localFabbyMvPart.bgItem != null) {
          localArrayList.add(localFabbyMvPart.bgItem);
        }
        if (localFabbyMvPart.fgItem != null) {
          localArrayList.add(localFabbyMvPart.fgItem);
        }
        if (localFabbyMvPart.coverItem != null) {
          localArrayList.add(localFabbyMvPart.coverItem);
        }
        if (localFabbyMvPart.transitionItem != null) {
          localArrayList.add(localFabbyMvPart.transitionItem);
        }
      }
    }
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      paramVideoMaterial = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (paramVideoMaterial.hasNext())
      {
        localObject = (FaceFeatureItem)paramVideoMaterial.next();
        if ((localObject != null) && (((FaceFeatureItem)localObject).getStickerItems() != null)) {
          localArrayList.addAll(((FaceFeatureItem)localObject).getStickerItems());
        }
      }
    }
    return localArrayList;
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt)
  {
    loadAllItemsAppend(paramVideoMaterial, paramInt, loadAllItems(paramVideoMaterial));
  }
  
  private void loadAllItemsAppend(VideoMaterial paramVideoMaterial, int paramInt, List<StickerItem> paramList)
  {
    if (paramVideoMaterial == null) {}
    for (;;)
    {
      return;
      Iterator localIterator1;
      Object localObject2;
      Object localObject1;
      if (paramVideoMaterial.getFaceOffItemList() != null)
      {
        localIterator1 = paramVideoMaterial.getFaceOffItemList().iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (FaceItem)localIterator1.next();
          if (!VideoMaterialUtil.isEmptyItem((FaceItem)localObject2))
          {
            if (TextUtils.isEmpty(((FaceItem)localObject2).id)) {}
            for (localObject1 = ((FaceItem)localObject2).faceExchangeImage;; localObject1 = ((FaceItem)localObject2).id)
            {
              this.mStickerManagers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, paramVideoMaterial.getDataPath(), (FaceItem)localObject2, paramInt));
              break;
            }
          }
        }
      }
      if (paramVideoMaterial.getFaceFeatureItemList() != null)
      {
        localIterator1 = paramVideoMaterial.getFaceFeatureItemList().iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (FaceFeatureItem)localIterator1.next();
          if ((localObject2 != null) && (((FaceFeatureItem)localObject2).getFaceOffItemList() != null))
          {
            Iterator localIterator2 = ((FaceFeatureItem)localObject2).getFaceOffItemList().iterator();
            label183:
            FaceItem localFaceItem;
            while (localIterator2.hasNext())
            {
              localFaceItem = (FaceItem)localIterator2.next();
              if (!VideoMaterialUtil.isEmptyItem(localFaceItem)) {
                if (!TextUtils.isEmpty(localFaceItem.id)) {
                  break label269;
                }
              }
            }
            label269:
            for (localObject1 = localFaceItem.faceExchangeImage;; localObject1 = localFaceItem.id)
            {
              this.mStickerManagers.put(localObject1, new LoadFaceItemManager(this.mCache, this.mGrayCache, ((FaceFeatureItem)localObject2).getDataPath(), localFaceItem, paramInt));
              break label183;
              break;
            }
          }
        }
      }
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (StickerItem)paramList.next();
          if ((!VideoMaterialUtil.isEmptyItem((StickerItem)localObject1)) && (!this.mStickerManagers.containsKey(((StickerItem)localObject1).id)) && (((StickerItem)localObject1).type != VideoFilterFactory.POSITION_TYPE.SKYBOX.type)) {
            if (ExtraStickerParserAgent.getInstance().isInExtraParser(((StickerItem)localObject1).stickerType)) {
              this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadExtraStickerParserManager(paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
            } else if (((StickerItem)localObject1).stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type) {
              this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadETCItemManager(this.mETCCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
            } else if (((StickerItem)localObject1).stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type) {
              this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadPagItemManager(paramVideoMaterial.getDataPath(), (StickerItem)localObject1));
            } else {
              this.mStickerManagers.put(((StickerItem)localObject1).id, new LoadStickerItemManager(this.mCache, paramVideoMaterial.getDataPath(), (StickerItem)localObject1, LoadItemManager.LOAD_TYPE.LOAD_ALL, paramInt));
            }
          }
        }
      }
    }
  }
  
  private void loadImportMaterial(VideoMaterial paramVideoMaterial, int paramInt)
  {
    paramVideoMaterial = paramVideoMaterial.getMultiViewerItemList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      MultiViewerItem localMultiViewerItem = (MultiViewerItem)paramVideoMaterial.next();
      if (localMultiViewerItem != null) {
        loadAllItemsAppend(localMultiViewerItem.videoMaterial, paramInt);
      }
    }
  }
  
  public void clear()
  {
    ??? = this.mStickerManagers.values().iterator();
    while (((Iterator)???).hasNext()) {
      ((LoadItemManager)((Iterator)???).next()).clear();
    }
    this.mStickerManagers.clear();
    synchronized (PreLoader.LOCK_IMAGE_PRE_LOADER)
    {
      Iterator localIterator1 = this.mCache.values().iterator();
      if (localIterator1.hasNext()) {
        BitmapUtils.recycle((Bitmap)localIterator1.next());
      }
    }
    Iterator localIterator2 = this.mGrayCache.values().iterator();
    while (localIterator2.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator2.next());
    }
    this.mCache.clear();
    this.mGrayCache.clear();
    this.mCurMaterialSizeInMB = 0.0D;
  }
  
  public void clearBeautyCache()
  {
    Iterator localIterator = this.mBeautyFaceCache.values().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    this.mBeautyFaceCache.clear();
  }
  
  public void clearWM260()
  {
    Iterator localIterator = this.mWM260Managers.values().iterator();
    while (localIterator.hasNext()) {
      ((LoadItemManager)localIterator.next()).clear();
    }
    this.mWM260Managers.clear();
    localIterator = this.mWM260Cache.values().iterator();
    while (localIterator.hasNext()) {
      BitmapUtils.recycle((Bitmap)localIterator.next());
    }
    this.mWM260Cache.clear();
  }
  
  public Bitmap getBeautyCacheBitmap(String paramString)
  {
    return (Bitmap)this.mBeautyFaceCache.get(paramString);
  }
  
  public double getMaterialSizeInMB()
  {
    return this.mCurMaterialSizeInMB;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public void initInGLThread(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadExtraStickerParserManager))) {
      ((LoadExtraStickerParserManager)paramString).initInGLThread(paramInt);
    }
  }
  
  public boolean isExtraStickerBitmap(String paramString)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadExtraStickerParserManager))) {
      return ((LoadExtraStickerParserManager)paramString).isBitmap();
    }
    return false;
  }
  
  public boolean isForceLoadFromSdCard()
  {
    return forceLoadFromSdCard;
  }
  
  public void loadAllImages(VideoMaterial paramVideoMaterial)
  {
    clear();
    ArrayList localArrayList = loadAllItems(paramVideoMaterial);
    addExtraStickerParser(paramVideoMaterial, localArrayList);
    this.mHandler.post(new VideoMemoryManager.1(this, paramVideoMaterial, localArrayList));
  }
  
  public void loadBeautyCacheBitmap(String paramString1, String paramString2, Set<String> paramSet, boolean paramBoolean)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if ((!this.mBeautyFaceCache.containsKey(str)) || (!BitmapUtils.isLegal((Bitmap)this.mBeautyFaceCache.get(str)))) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new VideoMemoryManager.3(this, paramString1, paramString2, str, paramBoolean));
      }
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadETCAlphaTexture(paramInt);
    }
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadETCRGBTexture(paramInt);
    }
    return null;
  }
  
  public int loadExtraStickerTxt(String paramString, int paramInt1, int paramInt2)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadImage(paramInt2, paramInt1);
    }
    return -1;
  }
  
  public Bitmap loadImage(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    return (Bitmap)this.mGrayCache.get(paramFEATURE_TYPE);
  }
  
  public Bitmap loadImage(String paramString, int paramInt)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      return paramString.loadImage(paramInt);
    }
    return null;
  }
  
  public Bitmap loadImage(String paramString1, String paramString2)
  {
    paramString1 = (LoadItemManager)this.mStickerManagers.get(paramString1);
    if (paramString1 != null) {
      return paramString1.loadImage(paramString2);
    }
    return null;
  }
  
  public Bitmap loadWM260Image(String paramString1, String paramString2)
  {
    paramString1 = (LoadItemManager)this.mWM260Managers.get(paramString1);
    if (paramString1 != null) {
      return paramString1.loadImage(paramString2);
    }
    return null;
  }
  
  public void loadWM260Material(VideoMaterial paramVideoMaterial)
  {
    clearWM260();
    this.mHandler.post(new VideoMemoryManager.2(this, paramVideoMaterial));
  }
  
  public void recycleBitmap(String paramString, Bitmap paramBitmap)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if ((paramString != null) && ((paramString instanceof LoadStickerItemManager))) {
      ((LoadStickerItemManager)paramString).recycleBitmap(paramBitmap);
    }
  }
  
  public void reset(String paramString)
  {
    paramString = (LoadItemManager)this.mStickerManagers.get(paramString);
    if (paramString != null) {
      paramString.reset();
    }
  }
  
  public void setForceLoadFromSdCard(boolean paramBoolean)
  {
    forceLoadFromSdCard = paramBoolean;
  }
  
  public void setMaxPreloadMemorySizeInKB(int paramInt)
  {
    this.mMaxPreloadSizeInKB = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager
 * JD-Core Version:    0.7.0.1
 */