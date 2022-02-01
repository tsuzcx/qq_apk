package com.tencent.ttpic.thread;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.AsyncTask;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.StarEffectFilter;
import com.tencent.ttpic.openapi.facedetect.FaceDetector;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import com.tencent.ttpic.openapi.util.RetrieveDataManager.DATA_TYPE;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.openapi.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FrameUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TargetApi(18)
public class FaceGestureDetGLThread
{
  private static final long BRIGHTNESS_DURATION = 2000L;
  private static final String TAG = FaceGestureDetGLThread.class.getSimpleName();
  private ExecutorService SINGLE_THREAD_EXECUTOR = Executors.newSingleThreadExecutor();
  private int[] autoContrastCurve = new int[256];
  private double averageFaceL = 60.0D;
  private int[] brightnessAdjustmentCurve = new int[256];
  private byte[] brightnessAdjustmentData;
  private int curLevel;
  private int[] his;
  private int[] hisAutoContrast = new int[256];
  private Pair<Integer, int[]> histogram = null;
  private int inputHeight;
  private int inputWidth;
  private int[] lastAutoContrastCurve = new int[256];
  private final Object mBodyDetLock = new Object();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame;
  private VideoPreviewFaceOutlineDetector mFaceDetector = new VideoPreviewFaceOutlineDetector();
  private boolean mInitReady;
  private long mLastBrightnessTime = -1L;
  private OnFaceDetListener mListener;
  private BaseFilter mRotateFilter = new BaseFilter(BaseFilter.getFragmentShader(0));
  private Frame mRotateFrame;
  private StarEffectFilter mStarEffectFilter = new StarEffectFilter();
  private int[][][][] matrixCbs;
  private int[][][][] matrixCrs;
  private int[][] matrixRL;
  private GLSegSharedData sharedData;
  private float[] whitenBalanceRGBGain = { 1.0F, 1.0F, 1.0F };
  
  public FaceGestureDetGLThread(EGLContext paramEGLContext)
  {
    this(paramEGLContext, false);
  }
  
  public FaceGestureDetGLThread(EGLContext paramEGLContext, boolean paramBoolean)
  {
    this.mCopyFilter.apply();
    this.mStarEffectFilter.initial();
    this.sharedData = new GLSegSharedData();
    this.mCopyFrame = new Frame();
    this.mRotateFilter.apply();
    this.mRotateFrame = new Frame();
    AlgoUtils.resetBrightnessAdjustmentCurve(this.brightnessAdjustmentCurve);
    if (this.mFaceDetector.init() != 0)
    {
      this.mInitReady = false;
      return;
    }
    this.mInitReady = true;
  }
  
  private void createBrightnessCurve(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte)
  {
    double d2 = 0.0D;
    double d1 = 0.0D;
    double[] arrayOfDouble1 = new double[3];
    double[] arrayOfDouble2 = new double[3];
    double[] arrayOfDouble3 = new double[3];
    while (paramInt1 <= paramInt2)
    {
      paramInt6 = paramInt3;
      while (paramInt6 <= paramInt4)
      {
        int j = (paramInt6 * paramInt5 + paramInt1) * 4;
        double d4 = d1;
        double d3 = d2;
        if (j >= 0)
        {
          d4 = d1;
          d3 = d2;
          if (j + 2 < paramArrayOfByte.length)
          {
            int k = paramArrayOfByte[j];
            int i = paramArrayOfByte[(j + 1)];
            j = paramArrayOfByte[(j + 2)];
            k = this.lastAutoContrastCurve[(k & 0xFF)];
            i = this.lastAutoContrastCurve[(i & 0xFF)];
            j = this.lastAutoContrastCurve[(j & 0xFF)];
            arrayOfDouble1[0] = k;
            arrayOfDouble1[1] = i;
            arrayOfDouble1[2] = j;
            AlgoUtils.sRGB2XYZ(arrayOfDouble1, arrayOfDouble2);
            AlgoUtils.XYZ2Lab(arrayOfDouble2, arrayOfDouble3);
            d3 = d2 + arrayOfDouble3[0];
            d4 = d1 + 1.0D;
          }
        }
        paramInt6 += 1;
        d1 = d4;
        d2 = d3;
      }
      paramInt1 += 1;
    }
    if (d1 != 0.0D)
    {
      this.averageFaceL = (d2 / d1);
      if ((this.averageFaceL >= 60.0D) && (this.averageFaceL <= 75.0D)) {
        resetBrightnessAdjustmentCurve();
      }
    }
    else
    {
      return;
    }
    if (this.averageFaceL < 60.0D) {}
    for (paramInt1 = (int)(1.0D * (60.0D - this.averageFaceL) + 128.0D);; paramInt1 = (int)(0.8D * (75.0D - this.averageFaceL) + 128.0D))
    {
      paramArrayOfByte = this.brightnessAdjustmentCurve;
      AlgoUtils.getPreparedSpline(new int[] { 0, 128, 255 }, new int[] { 0, paramInt1, 255 }, paramArrayOfByte);
      return;
    }
  }
  
  private double getInterpolateValue(double paramDouble, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, List<Double> paramList1, List<Double> paramList2, List<Double> paramList3)
  {
    int i = paramArrayOfDouble1.length - 1;
    if (paramDouble == paramArrayOfDouble1[i]) {
      return paramArrayOfDouble2[i];
    }
    i = 0;
    int j = paramList3.size() - 1;
    while (i <= j)
    {
      int k = (int)Math.floor(0.5D * (i + j));
      d1 = paramArrayOfDouble1[k];
      if (d1 < paramDouble) {
        i = k + 1;
      } else if (d1 > paramDouble) {
        j = k - 1;
      } else {
        return paramArrayOfDouble2[k];
      }
    }
    i = Math.max(0, j);
    paramDouble -= paramArrayOfDouble1[i];
    double d1 = paramDouble * paramDouble;
    double d2 = paramArrayOfDouble2[i];
    double d3 = ((Double)paramList1.get(i)).doubleValue();
    double d4 = ((Double)paramList2.get(i)).doubleValue();
    return ((Double)paramList3.get(i)).doubleValue() * paramDouble * d1 + (d2 + d3 * paramDouble + d4 * d1);
  }
  
  private float[] getRGBGain(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = (int)(FaceDetector.FACE_DETECT_WIDTH / 90.0F);
    int i1 = paramInt1 / n / 5 * 5;
    int i2 = paramInt2 / n / 5 * 5;
    if ((this.matrixRL == null) || (this.matrixRL.length != i1) || (this.matrixRL[0].length != i2)) {
      this.matrixRL = ((int[][])Array.newInstance(Integer.TYPE, new int[] { i1, i2 }));
    }
    if ((this.matrixCrs == null) || (this.matrixCrs[0][0].length != i1 / 5) || (this.matrixCrs[0][0][0].length != i2 / 5))
    {
      paramInt2 = i1 / 5;
      i = i2 / 5;
      this.matrixCrs = ((int[][][][])Array.newInstance(Integer.TYPE, new int[] { 5, 5, paramInt2, i }));
    }
    if ((this.matrixCbs == null) || (this.matrixCbs[0][0].length != i1 / 5) || (this.matrixCbs[0][0][0].length != i2 / 5))
    {
      paramInt2 = i1 / 5;
      i = i2 / 5;
      this.matrixCbs = ((int[][][][])Array.newInstance(Integer.TYPE, new int[] { 5, 5, paramInt2, i }));
    }
    paramInt2 = 0;
    int m;
    int i3;
    while (paramInt2 < i1)
    {
      i = 0;
      while (i < i2)
      {
        j = (i * n * paramInt1 + paramInt2 * n) * 4;
        if ((j >= 0) && (j + 2 < paramArrayOfByte.length))
        {
          m = paramArrayOfByte[j] & 0xFF;
          i3 = paramArrayOfByte[(j + 1)] & 0xFF;
          int i4 = paramArrayOfByte[(j + 2)] & 0xFF;
          j = (int)(m * 0.299D + i3 * 0.587D + i4 * 0.114D);
          k = (int)(m * -0.169D + i3 * -0.331D + i4 * 0.5D + 128.0D);
          d1 = m;
          d2 = i3;
          m = (int)(i4 * -0.081D + (d1 * 0.5D + d2 * -0.419D) + 128.0D);
          i3 = i1 / 5;
          i4 = i2 / 5;
          this.matrixRL[paramInt2][i] = j;
          this.matrixCrs[(paramInt2 / i3)][(i / i4)][(paramInt2 % i3)][(i % i4)] = k;
          this.matrixCbs[(paramInt2 / i3)][(i / i4)][(paramInt2 % i3)][(i % i4)] = m;
        }
        i += 1;
      }
      paramInt2 += 1;
    }
    double d4 = 0.0D;
    double d3 = 0.0D;
    double d2 = 0.0D;
    double d1 = 0.0D;
    paramInt2 = 0;
    while (paramInt2 < 5)
    {
      i = 0;
      double d5 = d1;
      d1 = d3;
      for (d3 = d5; i < 5; d3 = d5 + d3)
      {
        long l2 = 0L;
        long l1 = 0L;
        j = 0;
        while (j < i1 / 5)
        {
          k = 0;
          while (k < i2 / 5)
          {
            l2 += this.matrixCrs[paramInt2][i][j][k];
            l1 += this.matrixCbs[paramInt2][i][j][k];
            k += 1;
          }
          j += 1;
        }
        double d7 = l2 / (i1 / 5 * i2 / 5);
        double d8 = l1 / (i1 / 5 * i2 / 5);
        l2 = 0L;
        l1 = 0L;
        j = 0;
        while (j < i1 / 5)
        {
          k = 0;
          while (k < i2 / 5)
          {
            l2 = (l2 + Math.abs(this.matrixCrs[paramInt2][i][j][k] - d7));
            l1 = (l1 + Math.abs(this.matrixCbs[paramInt2][i][j][k] - d8));
            k += 1;
          }
          j += 1;
        }
        d5 = l2 / (i1 / 5 * i2 / 5);
        double d6 = l1 / (i1 / 5 * i2 / 5);
        d4 += d8 / 5 / 5;
        d7 = d7 / 5 / 5;
        d6 = d6 / 5 / 5;
        d5 = d5 / 5 / 5;
        d2 = d6 + d2;
        d1 = d7 + d1;
        i += 1;
      }
      paramInt2 += 1;
      d5 = d1;
      d1 = d3;
      d3 = d5;
    }
    paramInt2 = 0;
    while (paramInt2 < 5)
    {
      i = 0;
      while (i < 5)
      {
        j = 0;
        while (j < i1 / 5)
        {
          k = 0;
          while (k < i2 / 5)
          {
            i3 = i1 / 5;
            m = i2 / 5;
            i3 = i3 * paramInt2 + j;
            m = m * i + k;
            if ((this.matrixCbs[paramInt2][i][j][k] - (d4 + d2) >= 1.5D * d2) || (this.matrixCrs[paramInt2][i][j][k] - (1.5D * d3 + d1) >= 1.5D * d1)) {
              this.matrixRL[i3][m] = 0;
            }
            if (this.matrixRL[i3][m] >= 250) {
              this.matrixRL[i3][m] = 0;
            }
            k += 1;
          }
          j += 1;
        }
        i += 1;
      }
      paramInt2 += 1;
    }
    Object localObject = new int[256];
    paramInt2 = 0;
    int i = 0;
    while (i < i1)
    {
      j = 0;
      while (j < i2)
      {
        k = paramInt2;
        if (this.matrixRL[i][j] != 0)
        {
          k = this.matrixRL[i][j];
          localObject[k] += 1;
          k = paramInt2 + 1;
        }
        j += 1;
        paramInt2 = k;
      }
      i += 1;
    }
    int k = 0;
    int j = 0;
    i = 250;
    if (i != 0)
    {
      k += localObject[i] * i;
      j += localObject[i];
      if (j <= paramInt2 / 10) {}
    }
    for (paramInt2 = k / j;; paramInt2 = 0)
    {
      if (i == 0)
      {
        return new float[] { 1.0F, 1.0F, 1.0F };
        i -= 1;
        break;
      }
      localObject = new float[3];
      long[] arrayOfLong = new long[3];
      k = 0;
      while (k < i1)
      {
        m = 0;
        while (m < i2)
        {
          if (this.matrixRL[k][m] >= i)
          {
            i3 = (m * n * paramInt1 + k * n) * 4;
            arrayOfLong[0] += (paramArrayOfByte[i3] & 0xFF);
            arrayOfLong[1] += (paramArrayOfByte[(i3 + 1)] & 0xFF);
            arrayOfLong[2] += (paramArrayOfByte[(i3 + 2)] & 0xFF);
          }
          m += 1;
        }
        k += 1;
      }
      localObject[0] = (paramInt2 / (float)(arrayOfLong[0] / j));
      localObject[1] = (paramInt2 / (float)(arrayOfLong[1] / j));
      localObject[2] = (paramInt2 / (float)(arrayOfLong[2] / j));
      float f6 = localObject[0] - 1.0F;
      float f5 = localObject[1] - 1.0F;
      float f4 = localObject[2] - 1.0F;
      float f3;
      float f2;
      float f1;
      if ((Math.abs(f6) <= 0.05D) && (Math.abs(f5) <= 0.05D))
      {
        f3 = f5;
        f2 = f6;
        f1 = f4;
        if (Math.abs(f4) <= 0.05D) {}
      }
      else
      {
        f1 = Math.max(Math.max(Math.abs(f6), Math.abs(f5)), Math.abs(f4));
        f2 = f6 / f1 * 0.05F;
        f3 = f5 / f1 * 0.05F;
        f1 = f4 / f1 * 0.05F;
      }
      localObject[0] = (f2 + 1.0F);
      localObject[1] = (f3 + 1.0F);
      localObject[2] = (1.0F + f1);
      return localObject;
      i = 0;
    }
  }
  
  private void resetBrightnessAdjustmentCurve()
  {
    try
    {
      this.brightnessAdjustmentCurve = new int[256];
      int i = 0;
      while (i < 256)
      {
        this.brightnessAdjustmentCurve[i] = i;
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  private void switchBrightnessAdjustment(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return;
      if ((this.brightnessAdjustmentData == null) || (this.brightnessAdjustmentData.length != paramArrayOfByte.length)) {
        this.brightnessAdjustmentData = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.brightnessAdjustmentData, 0, paramArrayOfByte.length);
      System.arraycopy(this.autoContrastCurve, 0, this.lastAutoContrastCurve, 0, this.autoContrastCurve.length);
    } while ((this.SINGLE_THREAD_EXECUTOR.isShutdown()) || (this.SINGLE_THREAD_EXECUTOR.isTerminated()));
    this.SINGLE_THREAD_EXECUTOR.execute(new FaceGestureDetGLThread.3(this, paramInt1, paramInt2));
  }
  
  public void destroy()
  {
    if (this.sharedData != null) {
      this.sharedData.clear();
    }
    if (this.mCopyFrame != null) {
      this.mCopyFrame.clear();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.ClearGLSL();
    }
    if (this.mRotateFilter != null) {
      this.mRotateFilter.ClearGLSL();
    }
    if (this.mRotateFrame != null) {
      this.mRotateFrame.clear();
    }
    if (this.mStarEffectFilter != null) {
      this.mStarEffectFilter.clear();
    }
    if (this.SINGLE_THREAD_EXECUTOR != null) {
      this.SINGLE_THREAD_EXECUTOR.shutdownNow();
    }
  }
  
  public VideoPreviewFaceOutlineDetector getDetector()
  {
    return this.mFaceDetector;
  }
  
  public String getHistogramInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("averageL: " + (int)this.averageFaceL + "\n");
    return localStringBuffer.toString();
  }
  
  public int getLastFaceDetectedPhoneRotation()
  {
    if (this.mFaceDetector != null) {
      return this.mFaceDetector.getLastFaceDetectedPhoneRotation();
    }
    return 0;
  }
  
  public boolean isInitReady()
  {
    return this.mInitReady;
  }
  
  public void onPreviewStartPreImmediately()
  {
    this.mLastBrightnessTime = -1L;
    resetBrightnessAdjustmentCurve();
  }
  
  public void postFaceDetectorDestroy()
  {
    this.mFaceDetector.destroy();
    RetrieveDataManager.getInstance().clear();
  }
  
  public SegmentDataPipe postFaceGestureDet(Frame paramFrame, double paramDouble, boolean paramBoolean1, int paramInt, StarParam paramStarParam, boolean paramBoolean2, boolean paramBoolean3)
  {
    AEProfiler.getInstance().start("PTFaceDetect-detect", true);
    if (this.mListener == null) {
      return null;
    }
    Frame localFrame = FrameUtil.rotateCorrect(paramFrame, paramFrame.width, paramFrame.height, paramInt, this.mRotateFilter, this.mRotateFrame);
    GLES20.glFinish();
    paramFrame = this.sharedData.getFreeTexturePileMakeBusy();
    if (paramFrame == null) {
      return null;
    }
    paramFrame.mTimestamp = System.currentTimeMillis();
    if ((this.inputWidth != localFrame.width) || (this.inputHeight != localFrame.height)) {
      RetrieveDataManager.getInstance().clear();
    }
    this.inputWidth = localFrame.width;
    this.inputHeight = localFrame.height;
    j = (int)(localFrame.width * paramDouble);
    k = (int)(localFrame.height * paramDouble);
    if (localFrame.height > 2560) {
      LogUtils.d("GetHistogram", "faceDetectFrame [" + localFrame.width + "x" + localFrame.height + "] faceDetectScale = " + paramDouble);
    }
    paramFrame.mTexFrame = localFrame;
    arrayOfByte = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, localFrame.getTextureId(), j, k);
    try
    {
      if ((paramFrame.mData == null) || (paramFrame.mData.length != arrayOfByte.length)) {
        paramFrame.mData = new byte[arrayOfByte.length];
      }
      System.arraycopy(arrayOfByte, 0, paramFrame.mData, 0, arrayOfByte.length);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        long l2;
        CountDownLatch localCountDownLatch2;
        do
        {
          for (;;)
          {
            CountDownLatch localCountDownLatch1;
            long l1;
            localCountDownLatch1.await();
            localCountDownLatch2.await();
            paramFrame.histogram = this.histogram;
            try
            {
              paramStarParam = this.brightnessAdjustmentCurve;
              paramFrame.curve = AlgoUtils.mergeCurve(this.autoContrastCurve, paramStarParam);
              paramFrame.faceAverageL = this.averageFaceL;
              paramFrame.makeDataReady();
              this.sharedData.makeBrotherTextureFree(paramFrame);
              l1 = AEProfiler.getInstance().end("PTFaceDetect-detect", true);
              AEProfiler.getInstance().add(1, "PTFaceDetect-detect", l1);
              return paramFrame;
            }
            finally {}
            localOutOfMemoryError = localOutOfMemoryError;
            localOutOfMemoryError.printStackTrace();
            continue;
            this.mFaceDetector.doTrackByRGBA(paramFrame.mData, j, k, paramInt);
          }
        } while (l2 - this.mLastBrightnessTime < 2000L);
        int i = 1;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceGestureDetGLThread.2(this, arrayOfByte, j, k, localCountDownLatch2));
        this.mLastBrightnessTime = l2;
      }
      catch (InterruptedException paramStarParam)
      {
        for (;;)
        {
          paramStarParam.printStackTrace();
        }
      }
    }
    localCountDownLatch1 = new CountDownLatch(1);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceGestureDetGLThread.1(this, arrayOfByte, j, k, localCountDownLatch1));
    this.mFaceDetector.init();
    this.mFaceDetector.autoChangeFaceRefine(j, k, paramInt);
    this.mFaceDetector.setNeedFaceKit(paramBoolean2);
    this.mFaceDetector.setFaceKitVerticesArray(paramFrame.faceKitVerticesArray);
    this.mFaceDetector.setFace3DVerticesArray(paramFrame.face3DVerticesArray);
    this.mFaceDetector.setFace3DRotationArray(paramFrame.face3DRotationArray);
    this.mFaceDetector.setFeatureIndicesArray(paramFrame.featureIndicesArray);
    this.mFaceDetector.setFacePiont2DCenter(paramFrame.facePiont2DCenter);
    if (paramBoolean1)
    {
      this.mFaceDetector.doDectectTrackByRGBA(paramFrame.mData, j, k);
      l1 = this.mFaceDetector.getFaceTrackTime();
      this.mFaceDetector.updateAllFaceExpression(paramBoolean3);
      l2 = System.currentTimeMillis();
      localCountDownLatch2 = new CountDownLatch(1);
      i = 0;
      if (this.mLastBrightnessTime > 0L) {
        break label755;
      }
      this.mLastBrightnessTime = (l2 - 2000L + 2000L);
      if (i == 0) {
        localCountDownLatch2.countDown();
      }
      paramFrame.faceInfos = this.mFaceDetector.getAllFaceInfos();
      paramFrame.allFacePoints = this.mFaceDetector.getAllFaces();
      paramFrame.allIrisPoints = this.mFaceDetector.getAllIris();
      paramFrame.allFaceAngles = this.mFaceDetector.getAllFaceAngles();
      paramFrame.allPointsVis = this.mFaceDetector.getAllPointsVis();
      paramFrame.mTriggeredExpressionType = this.mFaceDetector.getTriggeredExpression();
      paramFrame.expressions = this.mFaceDetector.getExpressions();
      paramFrame.faceStatus = this.mFaceDetector.getFaceStatus3Ds();
      paramFrame.recordFaceInfo = this.mFaceDetector.getRecordFaceInfo();
      paramFrame.faceActionCounter = this.mFaceDetector.getFaceActionCounter();
      paramFrame.rgbGain = this.whitenBalanceRGBGain;
      paramFrame.detectTimes = new HashMap();
      paramFrame.detectTimes.put("sdk_face_detect_time", Long.valueOf(l1));
      processStar(paramFrame, localFrame, paramStarParam, paramInt);
    }
  }
  
  public void processStar(SegmentDataPipe paramSegmentDataPipe, Frame paramFrame, StarParam paramStarParam, int paramInt)
  {
    if ((paramFrame.width == 0) || (!VideoMaterialUtil.needRenderStar(paramStarParam)))
    {
      paramSegmentDataPipe.starPoints = new ArrayList();
      paramSegmentDataPipe.starMaskFrame = null;
      return;
    }
    if (paramStarParam.starType == 0)
    {
      paramSegmentDataPipe.starMaskFrame = this.mStarEffectFilter.getMaskFrame(paramFrame, paramStarParam, paramInt);
      paramSegmentDataPipe.starPoints = new ArrayList();
      return;
    }
    paramSegmentDataPipe.starPoints = this.mStarEffectFilter.getStarPoints(paramFrame, paramStarParam, paramInt);
    paramSegmentDataPipe.starMaskFrame = null;
  }
  
  public void setAgeDetectable(boolean paramBoolean)
  {
    if (this.mFaceDetector != null) {
      this.mFaceDetector.setDetectAge(paramBoolean);
    }
  }
  
  public void setMaxFaceCount(int paramInt)
  {
    if (this.mFaceDetector != null) {
      this.mFaceDetector.setMaxFaceCount(paramInt);
    }
  }
  
  public void setOnFaceDetListener(OnFaceDetListener paramOnFaceDetListener)
  {
    this.mListener = paramOnFaceDetListener;
  }
  
  public void tryFaceDetectorInit()
  {
    LogUtils.e("debug", "tryFaceDetectorInit");
    if (this.mInitReady) {
      return;
    }
    if (this.mFaceDetector.init() != 0) {}
    for (this.mInitReady = false;; this.mInitReady = true)
    {
      LogUtils.e("debug", "mInitReady = " + this.mInitReady);
      return;
    }
  }
  
  public static abstract interface OnFaceDetListener
  {
    public abstract void onDataReady(SegmentDataPipe paramSegmentDataPipe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.thread.FaceGestureDetGLThread
 * JD-Core Version:    0.7.0.1
 */