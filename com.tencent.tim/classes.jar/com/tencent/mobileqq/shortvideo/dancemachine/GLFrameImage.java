package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GLFrameImage
  extends GLImageView
{
  public static final int ANIMATION_MODE_RESTART = 1;
  public static final int ANIMATION_MODE_REVERSE = 0;
  public static final int LOAD_ONE_ALL = 0;
  public static final int LOAD_ONE_USED = 1;
  private static HashMap<String, GLImage> mFrameImages = new HashMap();
  private ArrayList<String> mAnimationFrames = new ArrayList();
  private int mCurrentFrameIndex;
  private int mFrameAnimationMode = 1;
  private float mFrameDuration;
  private boolean mHasAnimationStarted;
  private boolean mHasInitedImage = false;
  protected boolean mIsBoyFilterPrivateRes = false;
  private int mLoadTextureMode = 0;
  private boolean mNeedTemporaryRelease = true;
  private boolean mReversedPlay = false;
  private long mStartMsTime;
  
  public GLFrameImage(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
  }
  
  public static void clearTextureCache()
  {
    Iterator localIterator = mFrameImages.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (GLImage)mFrameImages.get(localObject);
      if (localObject != null) {
        ((GLImage)localObject).release();
      }
    }
    mFrameImages.clear();
    DanceLog.printFrameQueue("GLFrameImage", "clearTextureCache");
  }
  
  public static GLImage getImageByPath(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    GLImage localGLImage2 = (GLImage)mFrameImages.get(paramString);
    GLImage localGLImage1 = localGLImage2;
    if (localGLImage2 == null)
    {
      localGLImage1 = new GLImage(paramBoolean1, paramBoolean2);
      localGLImage1.loadTextureSync(paramString);
      mFrameImages.put(paramString, localGLImage1);
    }
    DanceLog.printFrameQueue("GLFrameImage", "getImageByPath");
    return localGLImage1;
  }
  
  public static void oncePreloadBoyFilterPrivateResource()
  {
    DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource[begin]");
    Map localMap = ResourceManager.getInstance().getAllBoyPosture();
    Object localObject1 = localMap.keySet();
    if (((Set)localObject1).size() <= 0) {
      return;
    }
    Iterator localIterator1 = ((Set)localObject1).iterator();
    while (localIterator1.hasNext())
    {
      localObject1 = (ResourceManager.Posture)localMap.get((String)localIterator1.next());
      if ((((ResourceManager.Posture)localObject1).danceCartoon != null) && (((ResourceManager.Posture)localObject1).danceCartoon.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        HashMap localHashMap = new HashMap();
        Iterator localIterator2 = ((ResourceManager.Posture)localObject1).danceCartoon.iterator();
        Object localObject3 = null;
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          Object localObject2 = localObject3;
          if (localObject3 == null)
          {
            localObject2 = localObject3;
            if (localArrayList.size() > 0) {
              localObject2 = (Bitmap)localArrayList.get(0);
            }
          }
          localObject3 = FileUtils.loadBitmapFromNative(str, false, (Bitmap)localObject2);
          localObject1 = localObject2;
          Object localObject4 = localObject3;
          if (localObject3 == null)
          {
            if (localObject2 == null) {
              break label257;
            }
            localArrayList.remove(localObject2);
            ((Bitmap)localObject2).recycle();
            localObject4 = FileUtils.loadBitmapFromNative(str, false);
            localObject1 = null;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (localObject4 == null) {
              break;
            }
            localObject2 = new GLImage(true, true);
            ((GLImage)localObject2).loadTextureSync((Bitmap)localObject4, false);
            localHashMap.put(str, localObject2);
            if (localObject1 != null) {
              break label271;
            }
            localArrayList.add(localObject4);
            localObject3 = localObject1;
            break;
            label257:
            DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource error");
            localObject1 = localObject2;
            localObject4 = localObject3;
          }
          label271:
          ((Bitmap)localObject4).recycle();
          localObject3 = localObject1;
        }
        if (localObject3 != null)
        {
          ((Bitmap)localObject3).recycle();
          localArrayList.remove(localObject3);
        }
        localObject1 = localArrayList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Bitmap)((Iterator)localObject1).next()).recycle();
        }
        localArrayList.clear();
        TrAsyncTextureLoad.getInstance().notifyGLThreadUpdateTextureCache(localHashMap);
      }
    }
    DanceLog.printFrameQueue("GLFrameImage", "oncePreloadBoyFilterPrivateResource[end]");
  }
  
  private static void printTextureCache()
  {
    DanceLog.printFrameQueue("GLFrameImage", "printTextureCache[Begin]......................");
    Object localObject = mFrameImages.keySet();
    DanceLog.printFrameQueue("GLFrameImage", "printTextureCache size=" + ((Set)localObject).size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      GLImage localGLImage = (GLImage)mFrameImages.get(str);
      if (localGLImage != null) {
        DanceLog.printFrameQueue("GLFrameImage", "printTextureCache path=" + str + " texture=" + localGLImage.getTexture() + " enableRelease=" + localGLImage.isEnableTemporaryRelease() + " isBoy=" + localGLImage.isBoyFilterTexture());
      } else {
        DanceLog.printFrameQueue("GLFrameImage", "printTextureCache path=" + str + " Released[noValue]");
      }
    }
    DanceLog.printFrameQueue("GLFrameImage", "printTextureCache[End]......................");
  }
  
  private static void reloadReleaseDanceStageTexture()
  {
    DanceLog.printFrameQueue("GLFrameImage", "reloadReleaseDanceStageTexture[begin]");
    Set localSet = mFrameImages.keySet();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((GLImage)mFrameImages.get(str) == null)
      {
        GLImage localGLImage = new GLImage(true);
        localGLImage.loadTextureSync(str);
        mFrameImages.put(str, localGLImage);
      }
    }
    DanceLog.printFrameQueue("GLFrameImage", "reloadReleaseDanceStageTexture[end] loadedSize=" + localSet.size());
  }
  
  public static void reloadTextureCache()
  {
    DanceLog.printFrameQueue("GLFrameImage", "reloadTextureCache[begin]");
    TrAsyncTextureLoad.getInstance().processInterrupt();
    printTextureCache();
    temporaryReleaseTextureCacheParam(false);
    reloadReleaseDanceStageTexture();
    printTextureCache();
    DanceLog.printFrameQueue("GLFrameImage", "reloadTextureCache[end]");
  }
  
  public static void temporaryReleaseTextureCache()
  {
    temporaryReleaseTextureCacheParam(true);
  }
  
  private static void temporaryReleaseTextureCacheParam(boolean paramBoolean)
  {
    Object localObject1 = new ArrayList(50);
    Object localObject2 = mFrameImages.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      GLImage localGLImage = (GLImage)mFrameImages.get(str);
      if (localGLImage != null)
      {
        if (localGLImage.isEnableTemporaryRelease()) {
          if (localGLImage.isBoyFilterTexture())
          {
            localGLImage.release();
            mFrameImages.put(str, null);
            ((ArrayList)localObject1).add(str);
          }
          else if (paramBoolean)
          {
            localGLImage.release();
            mFrameImages.put(str, null);
          }
        }
      }
      else {
        DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache[Error] image=null key=" + str);
      }
    }
    DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache[clear boyFilter] size=" + ((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      mFrameImages.remove(localObject2);
    }
    DanceLog.printFrameQueue("GLFrameImage", "temporaryReleaseTextureCache boyFilterName=" + ResourceManager.getInstance().getLittleBoyFilterRootPath());
    printTextureCache();
  }
  
  public static void updateGLFrameImageCache(HashMap<String, GLImage> paramHashMap)
  {
    if (paramHashMap.size() > 0)
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GLImage localGLImage1 = (GLImage)paramHashMap.get(str);
        GLImage localGLImage2 = (GLImage)mFrameImages.get(str);
        if (localGLImage2 == null)
        {
          mFrameImages.put(str, localGLImage1);
        }
        else
        {
          DanceLog.printFrameQueue("GLFrameImage", "updateGLFrameImageCache[Error]newImage=" + localGLImage1 + " oldImage=" + localGLImage2 + str);
          if (localGLImage1 != null) {
            localGLImage1.release();
          }
        }
      }
      paramHashMap.clear();
    }
  }
  
  public void clearStatus()
  {
    super.clearStatus();
    this.mHasAnimationStarted = false;
    this.mReversedPlay = false;
    this.mCurrentFrameIndex = 0;
    this.mStartMsTime = 0L;
    this.mAnimationFrames.clear();
    this.mLoadTextureMode = 0;
    this.mHasInitedImage = false;
    this.mFrameDuration = 0.0F;
    this.mFrameAnimationMode = 1;
  }
  
  public int getAnimationCurrentIndex()
  {
    if (this.mHasAnimationStarted)
    {
      this.mCurrentFrameIndex = ((int)((float)(SystemClock.uptimeMillis() - this.mStartMsTime) / this.mFrameDuration));
      if (this.mFrameAnimationMode != 1) {
        break label65;
      }
      if (this.mCurrentFrameIndex >= this.mAnimationFrames.size())
      {
        this.mStartMsTime = SystemClock.uptimeMillis();
        this.mCurrentFrameIndex = 0;
      }
    }
    for (;;)
    {
      return this.mCurrentFrameIndex;
      label65:
      if (this.mFrameAnimationMode == 0) {
        if (this.mReversedPlay)
        {
          this.mCurrentFrameIndex = (this.mAnimationFrames.size() - 2 - this.mCurrentFrameIndex);
          if (this.mCurrentFrameIndex <= 0)
          {
            this.mReversedPlay = false;
            this.mStartMsTime = SystemClock.uptimeMillis();
            this.mCurrentFrameIndex = 0;
          }
        }
        else if (this.mCurrentFrameIndex >= this.mAnimationFrames.size())
        {
          this.mStartMsTime = SystemClock.uptimeMillis();
          this.mCurrentFrameIndex = (this.mAnimationFrames.size() - 2);
          if (this.mCurrentFrameIndex > 0)
          {
            this.mReversedPlay = true;
          }
          else
          {
            this.mReversedPlay = false;
            this.mCurrentFrameIndex = 0;
          }
        }
      }
    }
  }
  
  public GLImage getImageByIndex(int paramInt)
  {
    String str = (String)this.mAnimationFrames.get(paramInt);
    if (((this.mLoadTextureMode == 1) || (this.mLoadTextureMode == 0)) && ((GLImage)mFrameImages.get(str) == null))
    {
      GLImage localGLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
      localGLImage.loadTextureSync(str);
      mFrameImages.put(str, localGLImage);
    }
    DanceLog.printFrameQueue("GLFrameImage", "getImageByIndex");
    return (GLImage)mFrameImages.get(str);
  }
  
  public GLImage getImageSize()
  {
    if (this.mAnimationFrames.size() > 0)
    {
      String str = (String)this.mAnimationFrames.get(0);
      return (GLImage)mFrameImages.get(str);
    }
    DanceLog.printFrameQueue("GLFrameImage", "getImageSize");
    return null;
  }
  
  public void initAnimationFrame()
  {
    if (!this.mHasInitedImage)
    {
      Object localObject1;
      Object localObject2;
      if (this.mLoadTextureMode == 0)
      {
        localObject1 = this.mAnimationFrames.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!((String)localObject2).equals("")) && ((GLImage)mFrameImages.get(localObject2) == null))
          {
            GLImage localGLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
            localGLImage.loadTextureSync((String)localObject2);
            mFrameImages.put(localObject2, localGLImage);
          }
        }
      }
      if (this.mLoadTextureMode == 1)
      {
        localObject1 = (String)this.mAnimationFrames.get(0);
        if ((localObject1 != null) && (!((String)localObject1).equals("")) && ((GLImage)mFrameImages.get(localObject1) == null))
        {
          localObject2 = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
          ((GLImage)localObject2).loadTextureSync((String)localObject1);
          mFrameImages.put(localObject1, localObject2);
        }
      }
      this.mHasInitedImage = true;
    }
    DanceLog.printFrameQueue("GLFrameImage", "initAnimationFrame");
  }
  
  public void setAnimationFrames(List<String> paramList)
  {
    this.mAnimationFrames.clear();
    this.mAnimationFrames.addAll(paramList);
  }
  
  public void setAnimationPlayMode(int paramInt)
  {
    this.mFrameAnimationMode = paramInt;
  }
  
  public final void setCurrentImage(int paramInt)
  {
    String str = (String)this.mAnimationFrames.get(paramInt);
    GLImage localGLImage;
    if (this.mLoadTextureMode == 0)
    {
      localGLImage = (GLImage)mFrameImages.get(str);
      if (localGLImage == null) {
        if ((str != null) && (!str.equals("")))
        {
          localGLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
          localGLImage.loadTextureSync(str);
          mFrameImages.put(str, localGLImage);
          this.mCurrentTexture = localGLImage.getTexture();
        }
      }
    }
    for (;;)
    {
      DanceLog.printFrameQueue("GLFrameImage", "setCurrentImage");
      return;
      this.mCurrentTexture = localGLImage.getTexture();
      continue;
      if (this.mLoadTextureMode == 1)
      {
        localGLImage = (GLImage)mFrameImages.get(str);
        if (localGLImage == null)
        {
          if ((str != null) && (!str.equals("")))
          {
            localGLImage = new GLImage(this.mNeedTemporaryRelease, this.mIsBoyFilterPrivateRes);
            localGLImage.loadTextureSync(str);
            mFrameImages.put(str, localGLImage);
            this.mCurrentTexture = localGLImage.getTexture();
          }
        }
        else {
          this.mCurrentTexture = localGLImage.getTexture();
        }
      }
    }
  }
  
  public void setFrameDuration(float paramFloat)
  {
    this.mFrameDuration = paramFloat;
  }
  
  public void setLoadTextureMode(int paramInt)
  {
    this.mLoadTextureMode = paramInt;
  }
  
  public void setTemporaryRelease(boolean paramBoolean)
  {
    this.mNeedTemporaryRelease = paramBoolean;
  }
  
  public void startFrameAnimation()
  {
    if (!this.mHasAnimationStarted)
    {
      this.mStartMsTime = SystemClock.uptimeMillis();
      this.mCurrentFrameIndex = 0;
      this.mHasAnimationStarted = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLFrameImage
 * JD-Core Version:    0.7.0.1
 */