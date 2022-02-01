package com.tencent.ttpic.util.youtu;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.EmotionInfo;
import com.tencent.ttpic.openapi.PTEmotionAttr;
import com.tencent.ttpic.util.SoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmotionDetector
{
  public static final int SLEFT_EYE_INDEX = 43;
  public static final int SRIGHT_EYE_INDEX = 53;
  private static final String TAG = EmotionDetector.class.getSimpleName();
  private static boolean isInitial = false;
  private static int sMaxFaceCount = 1;
  private float[] mDistanceSquare;
  private int[] mFaceIndex;
  private int mMinIndex = -1;
  private SmileDetector mSmileDetector;
  
  private void addFaceArr(int paramInt1, int paramInt2, float paramFloat)
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null) || (paramInt2 >= this.mFaceIndex.length)) {}
    do
    {
      return;
      this.mFaceIndex[paramInt1] = paramInt2;
      this.mDistanceSquare[paramInt1] = paramFloat;
    } while ((this.mMinIndex != -1) && (paramFloat >= this.mDistanceSquare[this.mMinIndex]));
    this.mMinIndex = paramInt2;
  }
  
  private void addFaceEye2Detect(int paramInt, EmotionInfo paramEmotionInfo)
  {
    if (paramEmotionInfo != null)
    {
      PointF localPointF1 = paramEmotionInfo.leftEye;
      PointF localPointF2 = paramEmotionInfo.rightEye;
      this.mSmileDetector.setEyeLocationByIndex(paramInt, (int)localPointF1.x, (int)localPointF1.y, (int)localPointF2.x, (int)localPointF2.y);
      this.mSmileDetector.setFaceDirection(paramInt, paramEmotionInfo.angles[0], paramEmotionInfo.angles[1], paramEmotionInfo.angles[1]);
    }
  }
  
  public static int detectSmile(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (isInitial) {
      return detectSmileByBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return -1;
  }
  
  public static int detectSmile(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (isInitial) {
      return detectSmileByRGBA(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    return -1;
  }
  
  @SoInfo(libName="expression_ttpic")
  private static native int detectSmileByBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  @SoInfo(libName="expression_ttpic")
  private static native int detectSmileByRGBA(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private float distanceSquare2Point(PointF paramPointF1, PointF paramPointF2)
  {
    float f1 = paramPointF2.x - paramPointF1.x;
    float f2 = paramPointF2.y - paramPointF1.y;
    return f1 * f1 + f2 * f2;
  }
  
  private void initFaceArray()
  {
    if ((this.mFaceIndex == null) || (this.mFaceIndex.length < sMaxFaceCount))
    {
      this.mFaceIndex = new int[sMaxFaceCount];
      this.mDistanceSquare = new float[sMaxFaceCount];
    }
    int i = 0;
    while (i < this.mFaceIndex.length)
    {
      this.mFaceIndex[i] = 0;
      this.mDistanceSquare[i] = 0.0F;
      i += 1;
    }
    this.mMinIndex = -1;
  }
  
  private boolean isOutImage(EmotionInfo paramEmotionInfo, int paramInt)
  {
    boolean bool = false;
    if ((paramEmotionInfo == null) || (paramEmotionInfo.leftEye.x < 5.0F) || (paramEmotionInfo.rightEye.x > paramInt - 5) || (paramEmotionInfo.leftEye.y < 5.0F) || (paramEmotionInfo.rightEye.y < 5.0F) || (paramEmotionInfo.angles[0] < -0.75D)) {
      bool = true;
    }
    return bool;
  }
  
  @SoInfo(libName="expression_ttpic")
  private static native int nClassNativeInit();
  
  public static int nativeInit()
  {
    return nClassNativeInit();
  }
  
  private void updateFaceArr(int paramInt, float paramFloat)
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null)) {}
    do
    {
      return;
      if (this.mMinIndex == -1) {
        break;
      }
    } while (this.mDistanceSquare[this.mMinIndex] >= paramFloat);
    this.mFaceIndex[this.mMinIndex] = paramInt;
    this.mDistanceSquare[this.mMinIndex] = paramFloat;
    updateMinFace();
    return;
    this.mFaceIndex[0] = paramInt;
    this.mMinIndex = 0;
  }
  
  private void updateMinFace()
  {
    if ((this.mFaceIndex == null) || (this.mDistanceSquare == null) || (this.mMinIndex < 0) || (this.mMinIndex >= this.mDistanceSquare.length)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mFaceIndex.length)
      {
        if (this.mDistanceSquare[i] < this.mDistanceSquare[this.mMinIndex]) {
          this.mMinIndex = i;
        }
        i += 1;
      }
    }
  }
  
  public void destroy()
  {
    if (this.mSmileDetector != null) {
      this.mSmileDetector.clear();
    }
  }
  
  public Object detectSmile(byte[] paramArrayOfByte, int paramInt1, int paramInt2, List<EmotionInfo> paramList, boolean paramBoolean)
  {
    int m = 0;
    int i = 0;
    PTEmotionAttr localPTEmotionAttr = new PTEmotionAttr();
    if ((!isInitial) || (paramArrayOfByte == null) || (paramList == null) || (paramList.size() <= 0)) {
      return localPTEmotionAttr;
    }
    if (this.mSmileDetector == null) {
      this.mSmileDetector = new SmileDetector(null);
    }
    this.mSmileDetector.setData(paramArrayOfByte);
    this.mSmileDetector.setImgWH(paramInt1, paramInt2);
    paramInt2 = paramList.size();
    int k;
    if ((paramBoolean) || (paramInt2 <= sMaxFaceCount))
    {
      paramInt2 = 0;
      k = paramInt2;
      if (i < paramList.size())
      {
        paramArrayOfByte = (EmotionInfo)paramList.get(i);
        if (isOutImage(paramArrayOfByte, paramInt1)) {}
        for (;;)
        {
          i += 1;
          break;
          addFaceEye2Detect(i, paramArrayOfByte);
          paramInt2 = 1;
        }
      }
    }
    else
    {
      initFaceArray();
      paramInt2 = 0;
      i = 0;
      k = paramInt2;
      int j = i;
      if (i < sMaxFaceCount)
      {
        k = paramInt2;
        j = i;
        if (paramInt2 < paramList.size())
        {
          if (isOutImage((EmotionInfo)paramList.get(paramInt2), paramInt1)) {}
          do
          {
            paramInt2 += 1;
            break;
            addFaceArr(i, paramInt2, distanceSquare2Point(((EmotionInfo)paramList.get(paramInt2)).leftFace, ((EmotionInfo)paramList.get(paramInt2)).rightFace));
            j = i + 1;
            i = j;
          } while (paramInt2 < paramList.size());
          k = paramInt2;
        }
      }
      if ((j >= sMaxFaceCount) && (k < paramList.size()))
      {
        if (isOutImage((EmotionInfo)paramList.get(k), paramInt1)) {}
        for (;;)
        {
          k += 1;
          break;
          updateFaceArr(k, distanceSquare2Point(((EmotionInfo)paramList.get(k)).leftFace, ((EmotionInfo)paramList.get(k)).rightFace));
        }
      }
      paramInt1 = 0;
      paramInt2 = m;
      for (;;)
      {
        k = paramInt1;
        if (paramInt2 >= j) {
          break;
        }
        addFaceEye2Detect(paramInt2, (EmotionInfo)paramList.get(this.mFaceIndex[paramInt2]));
        paramInt2 += 1;
        paramInt1 = 1;
      }
    }
    if (k != 0)
    {
      localPTEmotionAttr.setValue(this.mSmileDetector.detectSmile(paramBoolean));
      if (paramBoolean)
      {
        localPTEmotionAttr.setSmileValues(this.mSmileDetector.getSmileValues());
        localPTEmotionAttr.setIsSmiles(this.mSmileDetector.getIsSmiles());
        localPTEmotionAttr.setCurrentFrameSmile(this.mSmileDetector.isCurrentFrameSmile());
      }
      localPTEmotionAttr.setSmile(this.mSmileDetector.isSmile());
    }
    return localPTEmotionAttr;
  }
  
  public int getSmileValue()
  {
    if (this.mSmileDetector == null) {
      return 0;
    }
    return this.mSmileDetector.getSmileValue();
  }
  
  public boolean init()
  {
    isInitial = true;
    return true;
  }
  
  public boolean isSmile()
  {
    if (this.mSmileDetector != null) {
      return this.mSmileDetector.isSmile();
    }
    return false;
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    sMaxFaceCount = paramInt;
  }
  
  class SmileDetector
  {
    final int MAX_UPDATE_TIME = 2000;
    final float[] PITCH_LINES = { -0.2F, -0.3F, -0.4F, -0.47F, -0.55F, -0.6F, -0.65F, -0.7F, -0.74F, -0.77F, -0.785F };
    final int[] PITCH_SMILE_GAP = { -3, -5, -8, -13, -17, -22, -28, -35, -43, -48, -54 };
    final int SMILE_THRESHOLD = 40;
    long dectecFrame = 0L;
    private byte[] detectData;
    int faceCount = 0;
    int heightData = 0;
    List<Boolean> isSmiles = new ArrayList();
    long lastDetectTime = 0L;
    int[] leftEyeX;
    int[] leftEyeY;
    float[] pitchs;
    int[] rightEyeX;
    int[] rightEyeY;
    float[] rolls;
    int[] smileValueQueen = { 0, 0, 0, 0, 0 };
    List<Integer> smileValues = new ArrayList();
    int sumSmile = 0;
    int widthData = 0;
    float[] yaws;
    
    private SmileDetector() {}
    
    private int calculatePitchGap(float paramFloat)
    {
      int k = 0;
      int i = this.PITCH_LINES.length - 1;
      for (;;)
      {
        int j = k;
        if (i >= 0)
        {
          if (paramFloat < this.PITCH_LINES[i]) {
            j = this.PITCH_SMILE_GAP[i];
          }
        }
        else {
          return j;
        }
        i -= 1;
      }
    }
    
    private int calculateSmileValue()
    {
      if (this.dectecFrame > this.smileValueQueen.length) {}
      for (int i = this.smileValueQueen.length; i > 0; i = (int)this.dectecFrame) {
        return this.sumSmile / i;
      }
      return 0;
    }
    
    private boolean checkTimeOut()
    {
      return System.currentTimeMillis() - this.lastDetectTime > 2000L;
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
        LogUtils.i(EmotionDetector.TAG, "initArraySize:" + paramInt);
        arrayOfInt = new int[paramInt];
        if (paramArrayOfInt != null) {
          System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramArrayOfInt.length);
        }
      }
      return arrayOfInt;
    }
    
    private void initCoorArray(int paramInt)
    {
      this.leftEyeX = initArraySize(this.leftEyeX, paramInt);
      this.leftEyeY = initArraySize(this.leftEyeY, paramInt);
      this.rightEyeX = initArraySize(this.rightEyeX, paramInt);
      this.rightEyeY = initArraySize(this.rightEyeY, paramInt);
    }
    
    private void initDirections(int paramInt)
    {
      this.pitchs = initFloatArray(this.pitchs, paramInt);
      this.yaws = initFloatArray(this.yaws, paramInt);
      this.rolls = initFloatArray(this.rolls, paramInt);
    }
    
    private float[] initFloatArray(float[] paramArrayOfFloat, int paramInt)
    {
      float[] arrayOfFloat;
      if (paramArrayOfFloat != null)
      {
        arrayOfFloat = paramArrayOfFloat;
        if (paramArrayOfFloat.length >= paramInt) {}
      }
      else
      {
        LogUtils.i(EmotionDetector.TAG, "initArraySize:" + paramInt);
        arrayOfFloat = new float[paramInt];
        if (paramArrayOfFloat != null) {
          System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, paramArrayOfFloat.length);
        }
      }
      return arrayOfFloat;
    }
    
    private void resetArray()
    {
      int i = 0;
      while (i < this.smileValueQueen.length)
      {
        this.smileValueQueen[i] = 0;
        i += 1;
      }
      this.sumSmile = 0;
      this.dectecFrame = 0L;
    }
    
    private void setCoorValue(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      initCoorArray(this.faceCount);
      this.leftEyeX[paramInt1] = paramInt2;
      this.leftEyeY[paramInt1] = paramInt3;
      this.rightEyeX[paramInt1] = paramInt4;
      this.rightEyeY[paramInt1] = paramInt5;
    }
    
    private void setFaceDirection(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      initDirections(this.faceCount);
      this.pitchs[paramInt] = paramFloat1;
      this.yaws[paramInt] = paramFloat2;
      this.rolls[paramInt] = paramFloat3;
    }
    
    private void updateSmileValue(int paramInt)
    {
      int i = (int)(this.dectecFrame % this.smileValueQueen.length);
      this.sumSmile -= this.smileValueQueen[i];
      this.sumSmile += paramInt;
      this.smileValueQueen[i] = paramInt;
      this.dectecFrame += 1L;
    }
    
    private void updateTime()
    {
      long l = System.currentTimeMillis();
      if (l - this.lastDetectTime > 2000L) {
        resetArray();
      }
      this.lastDetectTime = l;
    }
    
    private boolean voteSmile()
    {
      int i = this.smileValueQueen.length / 2 + 1;
      int[] arrayOfInt = this.smileValueQueen;
      int m = arrayOfInt.length;
      int j = 0;
      for (;;)
      {
        int k = i;
        if (j < m)
        {
          k = i;
          if (arrayOfInt[j] > 40)
          {
            i -= 1;
            k = i;
            if (i <= 0) {
              k = i;
            }
          }
        }
        else
        {
          if (k > 0) {
            break;
          }
          return true;
        }
        j += 1;
        i = k;
      }
      return false;
    }
    
    public void clear()
    {
      this.detectData = null;
    }
    
    public int detectSmile(boolean paramBoolean)
    {
      if (!EmotionDetector.isInitial) {
        return 0;
      }
      if (paramBoolean)
      {
        this.smileValues.clear();
        this.isSmiles.clear();
      }
      updateTime();
      int m = 0;
      int i = 0;
      int j;
      if (m < this.faceCount)
      {
        int k = EmotionDetector.detectSmileByRGBA(this.detectData, this.widthData, this.heightData, this.leftEyeX[m], this.leftEyeY[m], this.rightEyeX[m], this.rightEyeY[m]);
        if (this.pitchs[m] < -0.2D)
        {
          j = calculatePitchGap(this.pitchs[m]);
          label120:
          j = k + j;
          k = j;
          if (j > 100) {
            k = 100;
          }
          j = k;
          if (k < 0) {
            j = 0;
          }
          if ((j <= 40) || (paramBoolean)) {
            break label181;
          }
        }
      }
      for (;;)
      {
        updateSmileValue(j);
        if (checkTimeOut()) {
          resetArray();
        }
        return j;
        j = 0;
        break label120;
        label181:
        this.smileValues.add(Integer.valueOf(j));
        List localList = this.isSmiles;
        boolean bool;
        if (j > 40)
        {
          bool = true;
          label210:
          localList.add(Boolean.valueOf(bool));
          if (j <= i) {
            break label245;
          }
        }
        for (;;)
        {
          m += 1;
          i = j;
          break;
          bool = false;
          break label210;
          label245:
          j = i;
        }
        j = i;
      }
    }
    
    public List<Boolean> getIsSmiles()
    {
      return this.isSmiles;
    }
    
    public int getSmileValue()
    {
      if (checkTimeOut()) {
        resetArray();
      }
      return calculateSmileValue();
    }
    
    public List<Integer> getSmileValues()
    {
      return this.smileValues;
    }
    
    public boolean isCurrentFrameSmile()
    {
      if (this.isSmiles != null)
      {
        Iterator localIterator = this.isSmiles.iterator();
        while (localIterator.hasNext()) {
          if (((Boolean)localIterator.next()).booleanValue()) {
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean isSmile()
    {
      if (checkTimeOut()) {
        resetArray();
      }
      return voteSmile();
    }
    
    public void setData(byte[] paramArrayOfByte)
    {
      if ((this.detectData == null) || (this.detectData.length < paramArrayOfByte.length)) {
        this.detectData = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.detectData, 0, paramArrayOfByte.length);
    }
    
    public void setEyeLocationByIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.faceCount = (paramInt1 + 1);
      setCoorValue(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.EmotionDetector
 * JD-Core Version:    0.7.0.1
 */