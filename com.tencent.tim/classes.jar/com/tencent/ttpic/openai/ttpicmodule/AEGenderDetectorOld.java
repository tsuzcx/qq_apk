package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import android.util.Log;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AEGenderDetectorOld
{
  private static final String TAG = "GenderDetector";
  private static boolean isInitial = false;
  private static ThreadLocal<AEGenderDetectorOld> sInstance;
  private final int DETECT_FRAME_NUMS = 4;
  private int DISTANCE_MAX_TWO_POINTS = 100;
  private final int SLEFT_EYE_INDEX = 43;
  private final int SRIGHT_EYE_INDEX = 53;
  private boolean isClear = false;
  private boolean isDetectorContinue = true;
  private boolean isReset = false;
  private HashMap<Integer, Long> mFaceCodeIDMap;
  private int mFaceCount = 0;
  private List<FaceInfo> mFaceInfos = new ArrayList();
  private GenderDetectOldImpl mGenderDetectOldImpl;
  private HashMap<Long, Integer> mGenderDetectorCount;
  private int[] mGenderOld;
  private HashMap<Long, Integer> mGenderOldMap;
  private int[] mGenderSum;
  private HashMap<Long, Integer> mGenderSumMap;
  private boolean mIsDetectingGender = false;
  private boolean mNeedDetectGender = true;
  private List<TraceFaceItem> mTraceFcaeList;
  private long sFaceIndexCount = 0L;
  
  private void addFaceEye2Detect(int paramInt, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    if ((paramFaceInfo != null) && (paramFaceInfo.rect != null) && (paramFaceInfo.rect.length > 0))
    {
      PointF localPointF1 = new PointF(paramFaceInfo.rect[0], paramFaceInfo.rect[1]);
      PointF localPointF2 = new PointF(paramFaceInfo.rect[2], paramFaceInfo.rect[3]);
      this.mGenderDetectOldImpl.setEyeLocationByIndex(paramInt, (int)localPointF1.x, (int)localPointF1.y, (int)localPointF2.x, (int)localPointF2.y, paramBoolean, paramFaceInfo.faceId);
    }
  }
  
  private TraceFaceItem creatTraceFaceItem(FaceInfo paramFaceInfo)
  {
    long l = this.sFaceIndexCount;
    this.sFaceIndexCount = (1L + l);
    return new TraceFaceItem(l, paramFaceInfo);
  }
  
  private double distance2Lines(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3, PointF paramPointF4)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null) || (paramPointF3 == null) || (paramPointF4 == null)) {
      return this.DISTANCE_MAX_TWO_POINTS;
    }
    return (distance2Points(paramPointF1, paramPointF3) + distance2Points(paramPointF2, paramPointF4)) / 2.0D;
  }
  
  private double distance2Points(PointF paramPointF1, PointF paramPointF2)
  {
    Log.i("GenderDetector", "DIS:(" + paramPointF1.x + "," + paramPointF1.y + ")->(" + paramPointF2.x + "," + paramPointF2.y + ")");
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  private long getFaceIDByFaceInfo(FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.mFaceCodeIDMap == null)) {
      return -1L;
    }
    paramFaceInfo = (Long)this.mFaceCodeIDMap.get(Integer.valueOf(paramFaceInfo.hashCode()));
    if (paramFaceInfo == null) {
      return -2L;
    }
    return paramFaceInfo.longValue();
  }
  
  public static AEGenderDetectorOld getInstance()
  {
    if (sInstance == null) {
      sInstance = new AEGenderDetectorOld.1();
    }
    return (AEGenderDetectorOld)sInstance.get();
  }
  
  private boolean isOutImage(FaceInfo paramFaceInfo, int paramInt)
  {
    return (paramFaceInfo == null) || (((PointF)paramFaceInfo.points.get(43)).x < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).x > paramInt - 5) || (((PointF)paramFaceInfo.points.get(43)).y < 5.0F) || (((PointF)paramFaceInfo.points.get(53)).y < 5.0F) || (paramFaceInfo.angles[0] < -0.75D);
  }
  
  private void realDectect(Bitmap paramBitmap, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mIsDetectingGender = true;
    if (this.mGenderDetectOldImpl == null) {
      this.mGenderDetectOldImpl = new GenderDetectOldImpl(null);
    }
    this.mGenderDetectOldImpl.setData(paramBitmap);
    this.mGenderDetectOldImpl.setImgWH(paramInt1, paramInt2);
    paramInt2 = 0;
    boolean bool1 = false;
    if (paramInt2 < paramList.size())
    {
      paramBitmap = (FaceInfo)paramList.get(paramInt2);
      paramBitmap.gender = GenderType.DEFAULT.value;
      boolean bool3 = isOutImage(paramBitmap, paramInt1);
      long l = paramBitmap.faceId;
      int i;
      if ((this.mGenderDetectorCount != null) && (this.mGenderDetectorCount.get(Long.valueOf(l)) != null))
      {
        i = ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue();
        label136:
        bool2 = bool1;
        if (i < 4)
        {
          if (!bool3)
          {
            if (this.mGenderDetectorCount != null) {
              this.mGenderDetectorCount.put(Long.valueOf(l), Integer.valueOf(i + 1));
            }
            bool1 = true;
          }
          if (bool3) {
            break label218;
          }
        }
      }
      label218:
      for (boolean bool2 = true;; bool2 = false)
      {
        addFaceEye2Detect(paramInt2, paramBitmap, bool2);
        bool2 = bool1;
        paramInt2 += 1;
        bool1 = bool2;
        break;
        i = 0;
        break label136;
      }
    }
    this.mIsDetectingGender = bool1;
    if (bool1) {
      this.mGenderDetectOldImpl.detect();
    }
  }
  
  private void resetTraceFaceItems()
  {
    if (this.mFaceCodeIDMap != null) {
      this.mFaceCodeIDMap.clear();
    }
    if (this.mTraceFcaeList != null) {
      this.mTraceFcaeList.clear();
    }
  }
  
  private void touchGendersByFaceIDS()
  {
    if (this.mFaceCount <= 0) {}
    Object localObject2;
    HashMap localHashMap;
    do
    {
      return;
      localObject2 = null;
      localHashMap = null;
      if (!this.isDetectorContinue) {
        break;
      }
      localObject2 = this.mGenderDetectOldImpl.getGenderMap();
    } while (localObject2 == null);
    Iterator localIterator = this.mFaceInfos.iterator();
    FaceInfo localFaceInfo;
    long l;
    do
    {
      localObject1 = localHashMap;
      if (!localIterator.hasNext()) {
        break;
      }
      localFaceInfo = (FaceInfo)localIterator.next();
      l = localFaceInfo.faceId;
    } while (l < 0L);
    if (this.mGenderSumMap == null) {
      this.mGenderSumMap = new HashMap();
    }
    Object localObject1 = (GenderParams)((Map)localObject2).get(Long.valueOf(l));
    int i;
    label129:
    label161:
    label212:
    label234:
    int j;
    if (localObject1 != null)
    {
      i = ((GenderParams)localObject1).genderType;
      localFaceInfo.curGender = i;
      if (localObject1 != null) {
        break label333;
      }
      localObject1 = new GenderParams();
      ((GenderParams)localObject1).genderType = GenderType.DEFAULT.value;
      if ((localObject1 == null) || (this.mGenderDetectorCount.get(Long.valueOf(l)) == null)) {
        break label368;
      }
      if (!this.mGenderSumMap.containsKey(Long.valueOf(l))) {
        break label415;
      }
      i = ((Integer)this.mGenderSumMap.get(Long.valueOf(l))).intValue();
      if (i < 0) {
        break label423;
      }
      if (((GenderParams)localObject1).genderType <= 0) {
        break label420;
      }
      i += ((GenderParams)localObject1).genderType - 1;
      if (((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() == 4)
      {
        if (i >= 0) {
          break label456;
        }
        j = GenderType.DEFAULT.value;
        label266:
        localFaceInfo.gender = j;
      }
      this.mGenderSumMap.put(Long.valueOf(l), Integer.valueOf(i));
      if (localHashMap != null) {
        break label736;
      }
      localHashMap = new HashMap();
    }
    label333:
    label598:
    label733:
    label736:
    for (;;)
    {
      localHashMap.put(Long.valueOf(l), Integer.valueOf(localFaceInfo.gender));
      break;
      i = GenderType.DEFAULT.value;
      break label129;
      if (((GenderParams)localObject1).genderType == GenderType.DEFAULT.value)
      {
        if (this.mGenderOldMap != null) {
          break label370;
        }
        i = GenderType.DEFAULT.value;
      }
      for (;;)
      {
        ((GenderParams)localObject1).genderType = i;
        break label161;
        label368:
        break;
        label370:
        if (this.mGenderOldMap.containsKey(Long.valueOf(l))) {
          i = ((Integer)this.mGenderOldMap.get(Long.valueOf(l))).intValue();
        } else {
          i = GenderType.DEFAULT.value;
        }
      }
      i = -1;
      break label212;
      break label234;
      i = ((GenderParams)localObject1).genderType;
      i = (((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() + 1) * (i - 1);
      break label234;
      if (i > ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() / 2)
      {
        j = GenderType.MALE.value;
        break label266;
      }
      j = GenderType.FEMALE.value;
      break label266;
      localObject1 = localObject2;
      if (this.mGenderSumMap != null)
      {
        localObject1 = localObject2;
        if (this.mGenderSumMap.size() > 0)
        {
          localObject1 = this.mFaceInfos.iterator();
          localHashMap = null;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FaceInfo)((Iterator)localObject1).next();
            l = ((FaceInfo)localObject2).faceId;
            if (this.mGenderSumMap.containsKey(Long.valueOf(l)))
            {
              i = ((Integer)this.mGenderSumMap.get(Long.valueOf(l))).intValue();
              if (i >= 0) {
                break label665;
              }
              i = GenderType.DEFAULT.value;
              label609:
              ((FaceInfo)localObject2).gender = i;
              ((FaceInfo)localObject2).curGender = ((FaceInfo)localObject2).gender;
              if (localHashMap != null) {
                break label733;
              }
              localHashMap = new HashMap();
            }
          }
        }
      }
      for (;;)
      {
        localHashMap.put(Long.valueOf(l), Integer.valueOf(((FaceInfo)localObject2).gender));
        break;
        i = -1;
        break label598;
        if (i > ((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() / 2)
        {
          i = GenderType.MALE.value;
          break label609;
        }
        i = GenderType.FEMALE.value;
        break label609;
        localObject1 = localHashMap;
        if (this.mGenderOldMap != null) {
          this.mGenderOldMap.clear();
        }
        this.mGenderOldMap = ((HashMap)localObject1);
        return;
      }
    }
  }
  
  public void destroy()
  {
    if (this.mGenderDetectOldImpl != null) {
      this.mGenderDetectOldImpl.clear();
    }
    sInstance = null;
    this.mIsDetectingGender = false;
    this.mGenderSum = null;
    this.mGenderOld = null;
    if (this.mGenderSumMap != null) {
      this.mGenderSumMap.clear();
    }
    if (this.mGenderOldMap != null) {
      this.mGenderOldMap.clear();
    }
    if (this.mGenderDetectorCount != null) {
      this.mGenderDetectorCount.clear();
    }
  }
  
  public void detectGender(Bitmap paramBitmap, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    this.mFaceInfos = paramList;
    if (!isInitial) {
      return;
    }
    this.DISTANCE_MAX_TWO_POINTS = (paramInt1 * 3 / 4);
    if (!this.mNeedDetectGender)
    {
      this.mGenderDetectorCount = null;
      this.mGenderSum = null;
      this.mGenderOld = null;
      if (this.mGenderSumMap != null) {
        this.mGenderSumMap.clear();
      }
      if (this.mGenderOldMap != null) {
        this.mGenderOldMap.clear();
      }
      if (this.mGenderDetectOldImpl != null) {
        this.mGenderDetectOldImpl.reset();
      }
      this.mFaceCount = 0;
      return;
    }
    if ((paramList != null) && (paramList.size() != this.mFaceCount))
    {
      if (this.mGenderDetectorCount == null) {
        this.mGenderDetectorCount = new HashMap();
      }
      this.mGenderDetectorCount.clear();
      this.isDetectorContinue = true;
      this.mFaceCount = paramList.size();
      this.mGenderSum = new int[this.mFaceCount];
      if (this.mGenderSumMap == null) {
        this.mGenderSumMap = new HashMap();
      }
      this.mGenderSumMap.clear();
    }
    if ((paramBitmap == null) || (paramList == null) || (paramList.size() <= 0))
    {
      reset();
      return;
    }
    this.isDetectorContinue = false;
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        long l = ((FaceInfo)paramList.get(i)).faceId;
        if ((this.mGenderDetectorCount == null) || (this.mGenderDetectorCount.size() == 0) || (this.mGenderDetectorCount.get(Long.valueOf(l)) == null) || (((Integer)this.mGenderDetectorCount.get(Long.valueOf(l))).intValue() < 4)) {
          this.isDetectorContinue = true;
        }
      }
      else
      {
        if ((!this.isDetectorContinue) || (this.mFaceCount <= 0)) {
          break;
        }
        realDectect(paramBitmap, paramInt1, paramInt2, paramList);
        return;
      }
      i += 1;
    }
  }
  
  public List<FaceInfo> detectGenderAndUpdateFaceInfo(Bitmap paramBitmap, int paramInt1, int paramInt2, List<FaceInfo> paramList)
  {
    if (!isInitial) {
      return null;
    }
    detectGender(paramBitmap, paramInt1, paramInt2, paramList);
    return getGender();
  }
  
  public List<FaceInfo> getGender()
  {
    if ((!isInitial) || (this.mGenderDetectOldImpl == null) || (this.mFaceInfos == null) || (this.mFaceInfos.size() < 1)) {
      return this.mFaceInfos;
    }
    touchGendersByFaceIDS();
    return this.mFaceInfos;
  }
  
  public boolean init()
  {
    if (isInitial) {
      return true;
    }
    isInitial = FeatureManager.Features.RAPID_NET_GENDER_DETECT.init();
    if (!isInitial)
    {
      LogUtils.e("GenderDetector", "GenderDetector init is failed!");
      Log.e("GenderDetector", "GenderDetector init is failed!");
    }
    for (;;)
    {
      return isInitial;
      LogUtils.e("GenderDetector", "GenderDetector init is successful!");
      Log.i("GenderDetector", "GenderDetector init is successful!");
    }
  }
  
  public boolean isDetectGender()
  {
    return this.mNeedDetectGender;
  }
  
  public void reset()
  {
    this.mGenderOld = null;
    if (this.mGenderOldMap != null) {
      this.mGenderOldMap.clear();
    }
    if (this.mGenderDetectorCount != null) {
      this.mGenderDetectorCount.clear();
    }
    if (this.mGenderDetectOldImpl != null) {
      this.mGenderDetectOldImpl.reset();
    }
    resetTraceFaceItems();
  }
  
  public void setNeedDetectGender(boolean paramBoolean)
  {
    this.mNeedDetectGender = paramBoolean;
  }
  
  public void updateFacesTrack(List<FaceInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (this.mTraceFcaeList != null) {
        this.mTraceFcaeList.clear();
      }
      this.mTraceFcaeList = null;
    }
    int j;
    int k;
    int i;
    for (;;)
    {
      return;
      if (this.mTraceFcaeList == null) {
        this.mTraceFcaeList = new ArrayList();
      }
      j = paramList.size();
      k = this.mTraceFcaeList.size();
      if (j != k) {
        break;
      }
      i = 0;
      while (i < j)
      {
        ((TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
        i += 1;
      }
    }
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label208:
    FaceInfo localFaceInfo;
    if (k > j)
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Log.i("GenderDetector", "人脸变少了：mTraceFcaeList=" + this.mTraceFcaeList.size() + "-->Faces=" + paramList.size());
      Iterator localIterator1 = paramList.iterator();
      if (localIterator1.hasNext())
      {
        localFaceInfo = (FaceInfo)localIterator1.next();
        double d1 = this.DISTANCE_MAX_TWO_POINTS;
        Iterator localIterator2 = this.mTraceFcaeList.iterator();
        paramList = null;
        label249:
        while (localIterator2.hasNext())
        {
          TraceFaceItem localTraceFaceItem = (TraceFaceItem)localIterator2.next();
          if (!localArrayList2.contains(localTraceFaceItem))
          {
            double d2 = localTraceFaceItem.distanceTwoFaces(localFaceInfo);
            if (d2 >= d1) {
              break label472;
            }
            d1 = d2;
            paramList = localTraceFaceItem;
          }
        }
      }
    }
    label393:
    label444:
    label472:
    for (;;)
    {
      break label249;
      if (paramList != null)
      {
        paramList.updatePoints(localFaceInfo);
        localArrayList1.add(paramList);
        localArrayList2.add(paramList);
        Log.i("GenderDetector", "匹配上一帧人脸，ID：" + paramList.idFace);
        break label208;
      }
      Log.i("GenderDetector", "人脸丢失，ID");
      break label208;
      this.mTraceFcaeList.clear();
      this.mTraceFcaeList = localArrayList1;
      return;
      i = 0;
      if (i < j)
      {
        if (i >= k) {
          break label444;
        }
        ((TraceFaceItem)this.mTraceFcaeList.get(i)).updatePoints((FaceInfo)paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break label393;
        break;
        this.mTraceFcaeList.add(creatTraceFaceItem((FaceInfo)paramList.get(i)));
      }
    }
  }
  
  class GenderDetectOldImpl
  {
    private Bitmap detectData;
    int faceCount = 0;
    long[] faceIDs;
    private List<AEGenderDetectorOld.GenderParams> gender;
    int heightData = 0;
    boolean[] isInOutImageArr;
    int[] recth;
    int[] rectw;
    int[] rectx;
    int[] recty;
    int widthData = 0;
    
    private GenderDetectOldImpl() {}
    
    private List<AEGenderDetectorOld.GenderParams> getGender()
    {
      return this.gender;
    }
    
    private Map<Long, AEGenderDetectorOld.GenderParams> getGenderMap()
    {
      if (this.gender == null) {
        return null;
      }
      HashMap localHashMap = new HashMap();
      Iterator localIterator = new ArrayList(this.gender).iterator();
      while (localIterator.hasNext())
      {
        AEGenderDetectorOld.GenderParams localGenderParams = (AEGenderDetectorOld.GenderParams)localIterator.next();
        if (localGenderParams != null) {
          localHashMap.put(Long.valueOf(localGenderParams.faceID), localGenderParams);
        }
      }
      return localHashMap;
    }
    
    private int[] initArraySize(int[] paramArrayOfInt, int paramInt)
    {
      int[] arrayOfInt;
      if (paramArrayOfInt != null)
      {
        arrayOfInt = paramArrayOfInt;
        if (paramArrayOfInt.length >= paramInt) {}
      }
      else
      {
        Log.i("GenderDetector", "int[]initArraySize:" + paramInt);
        arrayOfInt = new int[paramInt];
        if (paramArrayOfInt != null) {
          System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
        }
      }
      return arrayOfInt;
    }
    
    private long[] initArraySize(long[] paramArrayOfLong, int paramInt)
    {
      long[] arrayOfLong;
      if (paramArrayOfLong != null)
      {
        arrayOfLong = paramArrayOfLong;
        if (paramArrayOfLong.length >= paramInt) {}
      }
      else
      {
        Log.i("GenderDetector", "long[]initArraySize:" + paramInt);
        arrayOfLong = new long[paramInt];
        if (paramArrayOfLong != null) {
          System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 0, paramArrayOfLong.length);
        }
      }
      return arrayOfLong;
    }
    
    private boolean[] initArraySize(boolean[] paramArrayOfBoolean, int paramInt)
    {
      boolean[] arrayOfBoolean;
      if (paramArrayOfBoolean != null)
      {
        arrayOfBoolean = paramArrayOfBoolean;
        if (paramArrayOfBoolean.length >= paramInt) {}
      }
      else
      {
        Log.i("GenderDetector", "boolean[]initArraySize:" + paramInt);
        arrayOfBoolean = new boolean[paramInt];
        if (paramArrayOfBoolean != null) {
          System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, paramArrayOfBoolean.length);
        }
      }
      return arrayOfBoolean;
    }
    
    private void initCoorArray(int paramInt)
    {
      this.rectx = initArraySize(this.rectx, paramInt);
      this.recty = initArraySize(this.recty, paramInt);
      this.rectw = initArraySize(this.rectw, paramInt);
      this.recth = initArraySize(this.recth, paramInt);
      this.faceIDs = initArraySize(this.faceIDs, paramInt);
      this.isInOutImageArr = initArraySize(this.isInOutImageArr, paramInt);
    }
    
    private void setCoorValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong)
    {
      initCoorArray(this.faceCount);
      this.rectx[paramInt1] = paramInt2;
      this.recty[paramInt1] = paramInt3;
      this.rectw[paramInt1] = paramInt4;
      this.recth[paramInt1] = paramInt5;
      this.faceIDs[paramInt1] = paramLong;
      this.isInOutImageArr[paramInt1] = paramBoolean;
    }
    
    public void clear()
    {
      if (AEGenderDetectorOld.this.mIsDetectingGender) {
        AEGenderDetectorOld.access$302(AEGenderDetectorOld.this, true);
      }
      do
      {
        return;
        BitmapUtils.recycle(this.detectData);
        this.isInOutImageArr = null;
        this.rectx = null;
        this.recty = null;
        this.rectw = null;
        this.recth = null;
      } while (this.gender == null);
      this.gender.clear();
      AEGenderDetectorOld.access$302(AEGenderDetectorOld.this, false);
    }
    
    public void detect()
    {
      if (!AEGenderDetectorOld.isInitial) {}
      label564:
      do
      {
        return;
        AEGenderDetectorOld.access$202(AEGenderDetectorOld.this, true);
        int k = this.faceCount;
        int i;
        if ((this.gender == null) || (k > this.gender.size()))
        {
          if (this.gender == null) {
            this.gender = new ArrayList();
          }
          i = k - this.gender.size();
          while (i > 0)
          {
            this.gender.add(new AEGenderDetectorOld.GenderParams(AEGenderDetectorOld.this));
            i -= 1;
          }
        }
        int j = 0;
        Object localObject;
        if (j < k)
        {
          if ((isEmptyArray()) || (isOutOfRange(j)) || (this.isInOutImageArr[j] == 0) || (this.rectx[j] == 0) || (this.recty[j] == 0) || (this.rectw[j] == 0) || (this.recth[j] == 0)) {
            break label564;
          }
          localObject = FeatureManager.Features.RAPID_NET_GENDER_DETECT.retrieveGenderInfo(this.detectData, this.rectx[j], this.recty[j], this.rectw[j], this.recth[j]);
          if (localObject != null) {}
        }
        for (;;)
        {
          j += 1;
          break;
          i = Float.valueOf(localObject[0]).intValue();
          if (j >= this.gender.size())
          {
            if (k >= this.gender.size()) {
              break label789;
            }
            i = this.gender.size();
            while ((i > k) && (i > 0))
            {
              this.gender.remove(i - 1);
              i -= 1;
            }
          }
          if (this.gender.get(j) == null) {
            this.gender.set(j, new AEGenderDetectorOld.GenderParams(AEGenderDetectorOld.this));
          }
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).isInImage = true;
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectXY(this.rectx[j], this.recty[j]);
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectWH(this.rectw[j], this.recth[j]);
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
          this.rectx[j] = 0;
          this.recty[j] = 0;
          this.rectw[j] = 0;
          this.recth[j] = 0;
          localObject = (AEGenderDetectorOld.GenderParams)this.gender.get(j);
          if (i == 0) {
            i = GenderType.FEMALE.value;
          }
          for (;;)
          {
            ((AEGenderDetectorOld.GenderParams)localObject).genderType = i;
            Log.i("TAG", "gender is 1:" + ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType);
            break;
            if (i == 1) {
              i = GenderType.MALE.value;
            } else {
              i = ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType;
            }
          }
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).isInImage = false;
          if (this.gender.get(j) == null) {
            this.gender.set(j, new AEGenderDetectorOld.GenderParams(AEGenderDetectorOld.this));
          }
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectXY(this.rectx[j], this.recty[j]);
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).setRectWH(this.rectw[j], this.recth[j]);
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType = GenderType.DEFAULT.value;
          ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).faceID = this.faceIDs[j];
          this.rectx[j] = 0;
          this.recty[j] = 0;
          this.rectw[j] = 0;
          this.recth[j] = 0;
          Log.i("TAG", "gender is 2:" + ((AEGenderDetectorOld.GenderParams)this.gender.get(j)).genderType);
        }
        AEGenderDetectorOld.access$202(AEGenderDetectorOld.this, false);
        if (AEGenderDetectorOld.this.isClear) {
          clear();
        }
      } while (!AEGenderDetectorOld.this.isReset);
      label789:
      reset();
    }
    
    public boolean isEmptyArray()
    {
      return (this.isInOutImageArr == null) || (this.rectx == null) || (this.recty == null) || (this.rectw == null) || (this.recth == null);
    }
    
    public boolean isOutOfRange(int paramInt)
    {
      return (this.isInOutImageArr.length <= paramInt) || (this.rectx.length <= paramInt) || (this.recty.length <= paramInt) || (this.rectw.length <= paramInt) || (this.recth.length <= paramInt);
    }
    
    public void reset()
    {
      if (AEGenderDetectorOld.this.mIsDetectingGender) {
        AEGenderDetectorOld.access$402(AEGenderDetectorOld.this, true);
      }
      while (this.gender == null) {
        return;
      }
      this.gender.clear();
      AEGenderDetectorOld.access$402(AEGenderDetectorOld.this, false);
    }
    
    public void setData(Bitmap paramBitmap)
    {
      this.detectData = paramBitmap.copy(Bitmap.Config.ARGB_8888, false);
    }
    
    public void setEyeLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong)
    {
      this.faceCount = (paramInt1 + 1);
      setCoorValue(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramLong);
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
  }
  
  class GenderParams
  {
    long faceID;
    int genderType = 0;
    boolean isInImage = true;
    PointF rectWH;
    PointF rectXY;
    
    GenderParams() {}
    
    public void setRectWH(int paramInt1, int paramInt2)
    {
      if (this.rectWH == null) {
        this.rectWH = new PointF();
      }
      this.rectWH.set(paramInt1, paramInt2);
    }
    
    public void setRectXY(int paramInt1, int paramInt2)
    {
      if (this.rectXY == null) {
        this.rectXY = new PointF();
      }
      this.rectXY.set(paramInt1, paramInt2);
    }
    
    public String toString()
    {
      if ((this.rectXY == null) || (this.rectWH == null)) {
        return "NULL";
      }
      return "(" + this.rectXY.x + "," + this.rectXY.y + "),(" + this.rectWH.x + "," + this.rectWH.y + "),gender:" + this.genderType + ",isInImage:" + this.isInImage;
    }
  }
  
  class TraceFaceItem
  {
    private final int SFACE_CENTER_POINT = 64;
    private PointF centerPoint;
    private FaceInfo curFace;
    private long idFace;
    
    public TraceFaceItem(long paramLong, FaceInfo paramFaceInfo)
    {
      this.idFace = paramLong;
      updatePoints(paramFaceInfo);
    }
    
    public double distanceTwoFaces(FaceInfo paramFaceInfo)
    {
      if ((paramFaceInfo != null) && (paramFaceInfo.points != null) && (paramFaceInfo.points.size() > 64)) {
        return AEGenderDetectorOld.this.distance2Points(this.centerPoint, (PointF)paramFaceInfo.points.get(64));
      }
      return AEGenderDetectorOld.this.DISTANCE_MAX_TWO_POINTS;
    }
    
    public FaceInfo getFaceInfo()
    {
      return this.curFace;
    }
    
    public void updatePoints(FaceInfo paramFaceInfo)
    {
      if ((paramFaceInfo == null) || (paramFaceInfo.points == null) || (paramFaceInfo.points.size() <= 53))
      {
        if ((AEGenderDetectorOld.this.mFaceCodeIDMap != null) && (this.curFace != null)) {
          AEGenderDetectorOld.this.mFaceCodeIDMap.remove(Integer.valueOf(this.curFace.hashCode()));
        }
        this.curFace = null;
        return;
      }
      if (AEGenderDetectorOld.this.mFaceCodeIDMap == null) {
        AEGenderDetectorOld.access$602(AEGenderDetectorOld.this, new HashMap());
      }
      if (this.curFace != null) {
        AEGenderDetectorOld.this.mFaceCodeIDMap.remove(Integer.valueOf(this.curFace.hashCode()));
      }
      this.curFace = paramFaceInfo;
      AEGenderDetectorOld.this.mFaceCodeIDMap.put(Integer.valueOf(this.curFace.hashCode()), Long.valueOf(this.idFace));
      this.centerPoint = ((PointF)paramFaceInfo.points.get(64));
      this.centerPoint = new PointF(this.centerPoint.x, this.centerPoint.y);
      paramFaceInfo.faceId = this.idFace;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetectorOld
 * JD-Core Version:    0.7.0.1
 */