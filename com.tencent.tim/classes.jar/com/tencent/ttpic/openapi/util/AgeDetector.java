package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.AgeType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ytFaceAttr.YTFaceAttr;
import com.tencent.ytFaceAttr.YTFaceAttr.FaceAttr;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class AgeDetector
{
  public static final AgeRang[] AGE_RANGS = { new AgeRang(0, 5), new AgeRang(6, 15), new AgeRang(16, 35), new AgeRang(36, 1000) };
  private static final String TAG = "AgeDetector";
  private static boolean isInitial = false;
  private static ThreadLocal<AgeDetector> sInstance;
  private final int DETECT_FRAME_NUMS = 5;
  private int DISTANCE_MAX_TWO_POINTS = 100;
  private final int LEFT_MOUTH_INDEX = 65;
  private final int NOSE_INDEX = 64;
  private final int RIGHT_MOUTH_INDEX = 66;
  private final int SLEFT_EYE_INDEX = 43;
  private final int SRIGHT_EYE_INDEX = 53;
  private Bitmap bitmap = null;
  private boolean isClear = false;
  private boolean isDetectorContinue = true;
  private boolean isReset = false;
  private DetectAgeRunnable mDetectAgeRunnable;
  private Handler mDetectorAgeHandler;
  private int mFaceCount = 0;
  private List<FaceInfo> mFaceInfos = new ArrayList();
  private int mInitCheckCount = 0;
  private boolean mIsDetectingAge = false;
  private boolean mNeedDetectAge = false;
  private boolean mSyncDetectAge = false;
  
  private void addFaceKeyPoint2Detect(int paramInt, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 0))
    {
      int i = (int)((PointF)paramFaceInfo.points.get(43)).x;
      int j = (int)((PointF)paramFaceInfo.points.get(43)).y;
      int k = (int)((PointF)paramFaceInfo.points.get(53)).x;
      int m = (int)((PointF)paramFaceInfo.points.get(53)).y;
      int n = (int)((PointF)paramFaceInfo.points.get(64)).x;
      int i1 = (int)((PointF)paramFaceInfo.points.get(64)).y;
      int i2 = (int)((PointF)paramFaceInfo.points.get(65)).x;
      int i3 = (int)((PointF)paramFaceInfo.points.get(65)).y;
      int i4 = (int)((PointF)paramFaceInfo.points.get(66)).x;
      int i5 = (int)((PointF)paramFaceInfo.points.get(66)).y;
      this.mDetectAgeRunnable.setKeyPointLocationByIndex(paramInt, i, j, k, m, n, i1, i2, i3, i4, i5, paramBoolean, paramFaceInfo.faceId);
    }
  }
  
  public static AgeDetector getInstance()
  {
    if (sInstance == null) {
      sInstance = new AgeDetector.1();
    }
    return (AgeDetector)sInstance.get();
  }
  
  public static int getRangeIndex(int paramInt)
  {
    int i = 0;
    while (i < AGE_RANGS.length)
    {
      if (AGE_RANGS[i].isMatch(paramInt)) {
        return i;
      }
      i += 1;
    }
    return AGE_RANGS.length - 1;
  }
  
  private void initThreadHandle()
  {
    if (this.mDetectorAgeHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("AgeDetectThread");
      localHandlerThread.start();
      this.mDetectorAgeHandler = new Handler(localHandlerThread.getLooper());
    }
    this.mDetectorAgeHandler.post(new AgeDetector.2(this));
  }
  
  private boolean isOutImage(FaceInfo paramFaceInfo, int paramInt)
  {
    return (paramFaceInfo == null) || (((PointF)paramFaceInfo.points.get(43)).x < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).x > paramInt - 5) || (((PointF)paramFaceInfo.points.get(43)).y < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).y < 5.0F) || (paramFaceInfo.angles[0] < -0.75D);
  }
  
  private void realDectect(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    updateDetectStatus(true);
    if (this.mDetectorAgeHandler == null) {
      initThreadHandle();
    }
    if (this.mDetectAgeRunnable == null) {
      this.mDetectAgeRunnable = new DetectAgeRunnable(null);
    }
    this.mDetectAgeRunnable.setData(paramArrayOfByte);
    this.mDetectAgeRunnable.setImgWH(paramInt1, paramInt2);
    paramInt2 = 0;
    boolean bool1 = false;
    if (paramInt2 < paramList.size())
    {
      paramArrayOfByte = (FaceInfo)paramList.get(paramInt2);
      paramArrayOfByte.age = AgeType.DEFAULT.value;
      boolean bool2 = isOutImage(paramArrayOfByte, paramInt1);
      if (!bool2) {
        bool1 = true;
      }
      if (!bool2) {}
      for (bool2 = true;; bool2 = false)
      {
        addFaceKeyPoint2Detect(paramInt2, paramArrayOfByte, bool2);
        paramInt2 += 1;
        break;
      }
    }
    updateDetectStatus(bool1);
    if (bool1)
    {
      this.mDetectorAgeHandler.removeCallbacks(this.mDetectAgeRunnable);
      this.mDetectorAgeHandler.post(this.mDetectAgeRunnable);
    }
  }
  
  public void destroy()
  {
    if (this.mDetectorAgeHandler != null)
    {
      this.mDetectorAgeHandler.getLooper().quit();
      this.mDetectorAgeHandler = null;
    }
    if (this.mDetectAgeRunnable != null) {
      this.mDetectAgeRunnable.clear();
    }
    sInstance = null;
    updateDetectStatus(false);
  }
  
  public void detectAge(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mFaceInfos = paramList;
    if (!isInitial)
    {
      if (this.mSyncDetectAge)
      {
        if (this.mDetectorAgeHandler == null)
        {
          HandlerThread localHandlerThread = new HandlerThread("AgeDetectThread");
          localHandlerThread.start();
          this.mDetectorAgeHandler = new Handler(localHandlerThread.getLooper());
        }
        getInstance().init();
      }
    }
    else
    {
      this.DISTANCE_MAX_TWO_POINTS = (paramInt1 * 3 / 4);
      if (this.mNeedDetectAge) {
        break label143;
      }
      if (this.mDetectorAgeHandler != null) {
        this.mDetectorAgeHandler.removeCallbacks(this.mDetectAgeRunnable);
      }
      if (this.mDetectAgeRunnable != null) {
        this.mDetectAgeRunnable.reset();
      }
      this.mFaceCount = 0;
    }
    label143:
    do
    {
      return;
      if (this.mInitCheckCount % 30 == 0) {
        initThreadHandle();
      }
      this.mInitCheckCount += 1;
      return;
      if ((paramList != null) && (paramList.size() != this.mFaceCount)) {
        this.mFaceCount = paramList.size();
      }
      if ((paramArrayOfByte == null) || (paramList == null) || (paramList.size() <= 0))
      {
        reset();
        return;
      }
    } while ((this.mIsDetectingAge) || (this.mFaceCount <= 0));
    realDectect(paramArrayOfByte, paramInt1, paramInt2, paramList);
  }
  
  public void detectAgeAndUpdateFaceInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    detectAge(paramArrayOfByte, paramInt1, paramInt2, paramList);
    getAge();
  }
  
  public List<FaceInfo> getAge()
  {
    if ((!isInitial) || (this.mDetectAgeRunnable == null) || (this.mFaceInfos == null) || (this.mFaceInfos.size() < 1)) {
      return this.mFaceInfos;
    }
    if (this.mSyncDetectAge) {
      try
      {
        for (;;)
        {
          boolean bool = this.mIsDetectingAge;
          if (!bool) {
            break;
          }
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Log.e("AgeDetector", localInterruptedException.getMessage());
          }
        }
      }
      finally {}
    }
    Iterator localIterator = this.mFaceInfos.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      if (localFaceInfo != null) {
        localFaceInfo.age = this.mDetectAgeRunnable.getAgeByFaceID(localFaceInfo.faceId);
      }
    }
    return this.mFaceInfos;
  }
  
  public void init()
  {
    if ((isInitial) || (!FeatureManager.Features.AGE_DETECT.init()))
    {
      LogUtils.e("AgeDetector", "AgeDetector not need init:!" + isInitial + ",ready:" + FeatureManager.Features.AGE_DETECT.isFunctionReady());
      return;
    }
    LogUtils.i("AgeDetector", "AgeDetector has inited.");
    isInitial = true;
  }
  
  public boolean isDetectAge()
  {
    return this.mNeedDetectAge;
  }
  
  public void reset()
  {
    if (this.mDetectorAgeHandler != null) {
      this.mDetectorAgeHandler.removeCallbacks(this.mDetectAgeRunnable);
    }
    if (this.mDetectAgeRunnable != null) {
      this.mDetectAgeRunnable.reset();
    }
  }
  
  public void setNeedDetectAge(boolean paramBoolean)
  {
    this.mNeedDetectAge = paramBoolean;
  }
  
  public void setSyncDetectAge(boolean paramBoolean)
  {
    this.mSyncDetectAge = paramBoolean;
  }
  
  public void updateDetectStatus(boolean paramBoolean)
  {
    try
    {
      this.mIsDetectingAge = paramBoolean;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  class AgeDetectInfo
    extends AgeDetector.AgeParams
  {
    float[] points;
    
    public AgeDetectInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, boolean paramBoolean, long paramLong)
    {
      super();
      this.ageType = AgeType.DEFAULT.value;
      this.faceID = paramLong;
      this.isInImage = paramBoolean;
      this.points = new float[] { paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10 };
    }
  }
  
  class AgeParams
  {
    int ageType = AgeType.DEFAULT.value;
    long faceID;
    boolean isInImage = true;
    
    AgeParams() {}
  }
  
  public static class AgeRang
  {
    int endAge;
    int starAge;
    
    public AgeRang(int paramInt1, int paramInt2)
    {
      this.starAge = paramInt1;
      this.endAge = paramInt2;
    }
    
    public boolean isMatch(int paramInt)
    {
      return (paramInt >= this.starAge) && (paramInt <= this.endAge);
    }
  }
  
  class AgeResultInfo
  {
    static final int MAX_DETECT_TIMES = 5;
    int ageResult = AgeType.DEFAULT.value;
    int[] agesDetected = new int[5];
    int detectTimes = 0;
    long faceID = -1L;
    
    public AgeResultInfo(long paramLong)
    {
      this.faceID = paramLong;
      this.detectTimes = 0;
    }
    
    private int calculateAge()
    {
      int j = 0;
      int[] arrayOfInt1 = new int[AgeDetector.AGE_RANGS.length];
      int i = 0;
      while (i < arrayOfInt1.length)
      {
        arrayOfInt1[i] = 0;
        i += 1;
      }
      int[] arrayOfInt2 = this.agesDetected;
      int n = arrayOfInt2.length;
      int k = 0;
      i = 0;
      int m;
      if (k < n)
      {
        m = AgeDetector.getRangeIndex(arrayOfInt2[k]);
        arrayOfInt1[m] += 1;
        if (arrayOfInt1[m] <= i) {
          break label120;
        }
        j = arrayOfInt1[m];
        i = m;
      }
      for (;;)
      {
        m = k + 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        return calculateAvg(AgeDetector.AGE_RANGS[j]) / i;
        label120:
        m = i;
        i = j;
        j = m;
      }
    }
    
    private int calculateAvg(AgeDetector.AgeRang paramAgeRang)
    {
      int i = 0;
      int k;
      if (paramAgeRang == null)
      {
        k = AgeType.DEFAULT.value;
        return k;
      }
      int[] arrayOfInt = this.agesDetected;
      int m = arrayOfInt.length;
      int j = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        int n = arrayOfInt[j];
        k = i;
        if (paramAgeRang.isMatch(n)) {
          k = i + n;
        }
        j += 1;
        i = k;
      }
    }
    
    public int getAge()
    {
      return this.ageResult;
    }
    
    public int getDetectTimes()
    {
      return this.detectTimes;
    }
    
    public boolean needDetectAge()
    {
      return this.detectTimes < 5;
    }
    
    public void setAgeResult(int paramInt)
    {
      this.ageResult = paramInt;
    }
    
    public void updateAge(int paramInt)
    {
      if (this.detectTimes < 5)
      {
        int[] arrayOfInt = this.agesDetected;
        int i = this.detectTimes;
        this.detectTimes = (i + 1);
        arrayOfInt[i] = paramInt;
        if (this.detectTimes == 5) {
          this.ageResult = calculateAge();
        }
      }
    }
  }
  
  class DetectAgeRunnable
    implements Runnable
  {
    private byte[] detectData;
    private Vector<AgeDetector.AgeDetectInfo> detectInfos;
    YTFaceAttr.FaceAttr faceAttr;
    int faceCount = 0;
    int heightData = 0;
    private ConcurrentHashMap<Long, AgeDetector.AgeResultInfo> mValueHashMap;
    int widthData = 0;
    YTFaceAttr ytFaceAttr1;
    
    private DetectAgeRunnable() {}
    
    public void clear()
    {
      if (AgeDetector.this.mIsDetectingAge) {
        AgeDetector.access$202(AgeDetector.this, true);
      }
      do
      {
        return;
        this.detectData = null;
      } while (this.mValueHashMap == null);
      this.mValueHashMap.clear();
      AgeDetector.access$202(AgeDetector.this, false);
    }
    
    public int getAgeByFaceID(long paramLong)
    {
      if ((this.mValueHashMap != null) && (this.mValueHashMap.get(Long.valueOf(paramLong)) != null)) {
        return ((AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(paramLong))).ageResult;
      }
      return AgeType.DEFAULT.value;
    }
    
    public void reset()
    {
      if (AgeDetector.this.mIsDetectingAge) {
        AgeDetector.access$302(AgeDetector.this, true);
      }
      while (this.mValueHashMap == null) {
        return;
      }
      this.mValueHashMap.clear();
      AgeDetector.access$302(AgeDetector.this, false);
    }
    
    public void run()
    {
      if ((!AgeDetector.isInitial) || (this.detectInfos == null)) {}
      label356:
      do
      {
        return;
        AgeDetector.this.updateDetectStatus(true);
        if (this.detectData.length != 0)
        {
          AgeDetector.access$502(AgeDetector.this, Bitmap.createBitmap(this.widthData, this.heightData, Bitmap.Config.ARGB_8888));
          AgeDetector.this.bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.detectData));
        }
        Iterator localIterator = this.detectInfos.iterator();
        while (localIterator.hasNext())
        {
          AgeDetector.AgeDetectInfo localAgeDetectInfo = (AgeDetector.AgeDetectInfo)localIterator.next();
          if (this.mValueHashMap == null) {
            this.mValueHashMap = new ConcurrentHashMap();
          }
          AgeDetector.AgeResultInfo localAgeResultInfo2 = (AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(localAgeDetectInfo.faceID));
          if ((localAgeDetectInfo != null) && (localAgeDetectInfo.isInImage) && ((localAgeResultInfo2 == null) || (localAgeResultInfo2.needDetectAge())))
          {
            if (this.ytFaceAttr1 == null) {
              this.ytFaceAttr1 = new YTFaceAttr();
            }
            if (this.faceAttr == null) {
              this.faceAttr = new YTFaceAttr.FaceAttr();
            }
            this.faceAttr.ageRes = AgeType.DEFAULT.value;
            AgeDetector.AgeResultInfo localAgeResultInfo1;
            if (this.ytFaceAttr1.predictFaceAttrBitmap(AgeDetector.this.bitmap, localAgeDetectInfo.points, 0, this.faceAttr) == 0)
            {
              localAgeDetectInfo.ageType = this.faceAttr.ageRes;
              localAgeResultInfo1 = localAgeResultInfo2;
              if (localAgeResultInfo2 == null) {
                localAgeResultInfo1 = new AgeDetector.AgeResultInfo(AgeDetector.this, localAgeDetectInfo.faceID);
              }
              if (!AgeDetector.this.mSyncDetectAge) {
                break label356;
              }
              localAgeResultInfo1.setAgeResult(localAgeDetectInfo.ageType);
            }
            for (;;)
            {
              this.mValueHashMap.put(Long.valueOf(localAgeDetectInfo.faceID), localAgeResultInfo1);
              Log.i("AgeDetector", "faceID:" + localAgeDetectInfo.faceID + ",detected age:" + localAgeDetectInfo.ageType);
              localAgeDetectInfo.points = null;
              break;
              localAgeResultInfo1.updateAge(localAgeDetectInfo.ageType);
            }
          }
        }
        this.detectInfos.clear();
        AgeDetector.this.updateDetectStatus(false);
        if (AgeDetector.this.isClear) {
          clear();
        }
      } while (!AgeDetector.this.isReset);
      reset();
    }
    
    public void setData(byte[] paramArrayOfByte)
    {
      if ((this.detectData == null) || (this.detectData.length < paramArrayOfByte.length)) {
        this.detectData = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.detectData, 0, paramArrayOfByte.length);
    }
    
    public void setFaceCount(int paramInt)
    {
      this.faceCount = paramInt;
    }
    
    public void setImgWH(int paramInt1, int paramInt2)
    {
      this.widthData = paramInt1;
      this.heightData = paramInt2;
    }
    
    public void setKeyPointLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, boolean paramBoolean, long paramLong)
    {
      if ((this.mValueHashMap != null) && (this.mValueHashMap.get(Long.valueOf(paramLong)) != null) && (!((AgeDetector.AgeResultInfo)this.mValueHashMap.get(Long.valueOf(paramLong))).needDetectAge())) {
        return;
      }
      this.faceCount = (paramInt1 + 1);
      if (this.detectInfos == null) {
        this.detectInfos = new Vector();
      }
      AgeDetector.AgeDetectInfo localAgeDetectInfo = new AgeDetector.AgeDetectInfo(AgeDetector.this, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramBoolean, paramLong);
      this.detectInfos.add(localAgeDetectInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.AgeDetector
 * JD-Core Version:    0.7.0.1
 */