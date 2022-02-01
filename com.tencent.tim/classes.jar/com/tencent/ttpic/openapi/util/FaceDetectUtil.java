package com.tencent.ttpic.openapi.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.faceBeauty.AndroidFaceDetect;
import com.tencent.faceBeauty.FaceDetect;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.facedetect.TTFaceOriginDataModel;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTFaceAttr.Builder;
import com.tencent.ttpic.openapi.PTFaceAttr.PTExpression;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.facedetect.FaceParams;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.model.FaceActionCounter;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.ttpic.util.youtu.TTpicBitmapFaceDetect;
import com.tencent.view.RendererUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceDetectUtil
{
  public static final int CF_FACE_POINTS = 131;
  public static final List<PointF> EMPTY_LIST = new ArrayList();
  public static final int ILLEGAL_BIG_FACE = 2;
  public static final int ILLEGAL_SMALL_FACE = 1;
  public static final int LEGAL_NORMAL_FACE = 0;
  public static final int MIN_EYE_WIDTH = 20;
  public static final String TAG = FaceDetectUtil.class.getSimpleName();
  
  public static List<PointF> array2List(PointF[] paramArrayOfPointF)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfPointF == null) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfPointF.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfPointF[i]);
        i += 1;
      }
    }
  }
  
  private static boolean canUseTTPicDetect()
  {
    return FeatureManager.Features.FACE_DETECT.isPicFaceDetReady();
  }
  
  public static int checkLegalFace(FaceParam paramFaceParam, int paramInt)
  {
    if (paramFaceParam == null) {}
    int i;
    do
    {
      return 1;
      i = distance(paramFaceParam.mLeftEyeCenter, paramFaceParam.mRightEyeCenter);
    } while (i < 20);
    if (i > paramInt) {
      return 2;
    }
    return 0;
  }
  
  public static PTFaceAttr detectFace(Bitmap paramBitmap, double paramDouble)
  {
    int i = RendererUtils.createTexture(paramBitmap);
    paramBitmap = new Frame(0, i, paramBitmap.getWidth(), paramBitmap.getHeight());
    PTFaceDetector localPTFaceDetector = new PTFaceDetector();
    localPTFaceDetector.init(true);
    PTFaceAttr localPTFaceAttr = localPTFaceDetector.detectFrame(paramBitmap, System.currentTimeMillis(), 0, false, paramDouble, 0.0F, true, false, null);
    paramBitmap.clear();
    RendererUtils.clearTexture(i);
    localPTFaceDetector.destroy();
    return localPTFaceAttr;
  }
  
  public static List<FaceParam> detectFacesByBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramBitmap == null) {
      return localArrayList;
    }
    TTpicBitmapFaceDetect localTTpicBitmapFaceDetect = new TTpicBitmapFaceDetect();
    localTTpicBitmapFaceDetect.needDetectFaceFeatures(paramBoolean);
    localTTpicBitmapFaceDetect.detectFace(paramBitmap);
    if (localTTpicBitmapFaceDetect.detectedFace())
    {
      int i = 0;
      while (i < localTTpicBitmapFaceDetect.getFaceCount())
      {
        localArrayList.add(localTTpicBitmapFaceDetect.getFaceParams(i));
        i += 1;
      }
    }
    if ((localTTpicBitmapFaceDetect instanceof TTpicBitmapFaceDetect)) {
      localTTpicBitmapFaceDetect.destroy();
    }
    return localArrayList;
  }
  
  private static int distance(Point paramPoint1, Point paramPoint2)
  {
    return (int)Math.sqrt(Math.abs(paramPoint1.x - paramPoint2.x) * Math.abs(paramPoint1.x - paramPoint2.x) + Math.abs(paramPoint1.y - paramPoint2.y) * Math.abs(paramPoint1.y - paramPoint2.y));
  }
  
  private static List<List<PointF>> doFaceDetect(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = detectFacesByBitmap(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), true);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(facePointf83to90(outline2Points(((FaceParam)((Iterator)localObject).next()).mFaceOutline)));
    }
    return localArrayList;
  }
  
  public static List<List<PointF>> doFaceDetect(Bitmap paramBitmap)
  {
    Object localObject = detectFacesByBitmap(paramBitmap, true);
    paramBitmap = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBitmap.add(facePointf83to90(outline2Points(((FaceParam)((Iterator)localObject).next()).mFaceOutline)));
    }
    return paramBitmap;
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, int paramInt)
  {
    return doPicFaceDetect(paramBitmap, true, true, paramInt);
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, boolean paramBoolean)
  {
    return doPicFaceDetect(paramBitmap, paramBoolean, true, -1);
  }
  
  public static List<FaceParams> doPicFaceDetect(Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Object localObject;
    if (canUseTTPicDetect())
    {
      localObject = new TTpicBitmapFaceDetect();
      ((FaceDetect)localObject).needDetectFaceFeatures(paramBoolean1);
      ((FaceDetect)localObject).needDetectFaceGender(paramBoolean2);
      ((FaceDetect)localObject).detectFace(paramBitmap);
      if (((FaceDetect)localObject).detectedFace()) {
        localArrayList.addAll(pickAvailableFaces((FaceDetect)localObject, paramInt));
      }
      if (!(localObject instanceof TTpicBitmapFaceDetect)) {
        break label108;
      }
      ((TTpicBitmapFaceDetect)localObject).destroy();
    }
    for (;;)
    {
      return localArrayList;
      localObject = new AndroidFaceDetect();
      break;
      label108:
      ((FaceDetect)localObject).release();
    }
  }
  
  public static List<FaceParam> doPicFaceDetectbyManual(Bitmap paramBitmap, Point paramPoint1, Point paramPoint2)
  {
    return doPicFaceDetectbyManual(paramBitmap, null, paramPoint1, paramPoint2);
  }
  
  public static List<FaceParam> doPicFaceDetectbyManual(Bitmap paramBitmap, Rect paramRect, Point paramPoint1, Point paramPoint2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    TTpicBitmapFaceDetect localTTpicBitmapFaceDetect = new TTpicBitmapFaceDetect();
    localTTpicBitmapFaceDetect.needDetectFaceFeatures(true);
    localTTpicBitmapFaceDetect.needDetectFaceGender(true);
    localTTpicBitmapFaceDetect.detectFaceByManual(paramBitmap, paramRect, paramPoint1, paramPoint2);
    int i = 0;
    while (i < localTTpicBitmapFaceDetect.getFaceCount())
    {
      localArrayList.add(localTTpicBitmapFaceDetect.getFaceParams(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> facePointf83to90(List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() < 83)) {
      return paramList;
    }
    while (paramList.size() < 90) {
      paramList.add(new PointF());
    }
    while (paramList.size() > 90) {
      paramList.remove(paramList.size() - 1);
    }
    PointF localPointF = (PointF)paramList.get(83);
    float f = ((PointF)paramList.get(55)).x;
    localPointF.x = ((((PointF)paramList.get(63)).x - ((PointF)paramList.get(55)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(83);
    f = ((PointF)paramList.get(55)).y;
    localPointF.y = ((((PointF)paramList.get(63)).y - ((PointF)paramList.get(55)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).x;
    localPointF.x = ((((PointF)paramList.get(31)).x - ((PointF)paramList.get(23)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(84);
    f = ((PointF)paramList.get(23)).y;
    localPointF.y = ((((PointF)paramList.get(31)).y - ((PointF)paramList.get(23)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).x;
    localPointF.x = ((((PointF)paramList.get(77)).x - ((PointF)paramList.get(59)).x) / 2.0F + f);
    localPointF = (PointF)paramList.get(85);
    f = ((PointF)paramList.get(59)).y;
    localPointF.y = ((((PointF)paramList.get(77)).y - ((PointF)paramList.get(59)).y) / 2.0F + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).x;
    localPointF.x = (((PointF)paramList.get(35)).x - ((PointF)paramList.get(6)).x + f);
    localPointF = (PointF)paramList.get(86);
    f = ((PointF)paramList.get(35)).y;
    localPointF.y = (((PointF)paramList.get(35)).y - ((PointF)paramList.get(6)).y + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).x;
    localPointF.x = ((((PointF)paramList.get(64)).x - ((PointF)paramList.get(9)).x) * 1.4F + f);
    localPointF = (PointF)paramList.get(87);
    f = ((PointF)paramList.get(64)).y;
    localPointF.y = ((((PointF)paramList.get(64)).y - ((PointF)paramList.get(9)).y) * 1.4F + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).x;
    localPointF.x = (((PointF)paramList.get(45)).x - ((PointF)paramList.get(12)).x + f);
    localPointF = (PointF)paramList.get(88);
    f = ((PointF)paramList.get(45)).y;
    localPointF.y = (((PointF)paramList.get(45)).y - ((PointF)paramList.get(12)).y + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).x;
    localPointF.x = (((PointF)paramList.get(83)).x - ((PointF)paramList.get(59)).x + f);
    localPointF = (PointF)paramList.get(89);
    f = ((PointF)paramList.get(83)).y;
    localPointF.y = (((PointF)paramList.get(83)).y - ((PointF)paramList.get(59)).y + f);
    return paramList;
  }
  
  public static PointF[] flatArray2Points(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null) {
      return null;
    }
    PointF[] arrayOfPointF = new PointF[paramArrayOfFloat.length / 2];
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      arrayOfPointF[i] = new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]);
      i += 1;
    }
    return arrayOfPointF;
  }
  
  public static PTFaceAttr genFaceAttr(List<TTFaceOriginDataModel> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TTFaceOriginDataModel)((Iterator)localObject1).next();
      localObject3 = new FaceInfo();
      localObject4 = new float['¼'];
      int i = 0;
      while (i < 67)
      {
        localObject4[(i * 2)] = localObject2.facePoint[(i + 21)][0];
        localObject4[(i * 2 + 1)] = localObject2.facePoint[(i + 21)][1];
        i += 1;
      }
      i = 67;
      while (i < 88)
      {
        localObject4[(i * 2)] = localObject2.facePoint[(i - 67)][0];
        localObject4[(i * 2 + 1)] = localObject2.facePoint[(i - 67)][1];
        i += 1;
      }
      i = 88;
      while (i < 94)
      {
        localObject4[(i * 2)] = localObject2.facePoint[i][0];
        localObject4[(i * 2 + 1)] = localObject2.facePoint[i][1];
        i += 1;
      }
      ((FaceInfo)localObject3).points = YoutuPointsUtil.transformYTPointsToPtuPoints((float[])localObject4);
      ((FaceInfo)localObject3).irisPoints = YoutuPointsUtil.getIrisPoints((float[])localObject4);
      ((FaceInfo)localObject3).pointsVis = YoutuPointsUtil.transformYTPointsVisToPtuPoints(((TTFaceOriginDataModel)localObject2).facePointVisible);
      ((FaceInfo)localObject3).pointsVis = YoutuPointsUtil.smoothYTPointsVisPoints(((FaceInfo)localObject3).pointsVis);
      ((FaceInfo)localObject3).angles[0] = ((float)(((TTFaceOriginDataModel)localObject2).pitch * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject3).angles[1] = ((float)(((TTFaceOriginDataModel)localObject2).yaw * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject3).angles[2] = ((float)(((TTFaceOriginDataModel)localObject2).roll * 3.141592653589793D / 180.0D) * -1.0F);
      ((FaceInfo)localObject3).pitch = ((TTFaceOriginDataModel)localObject2).pitch;
      ((FaceInfo)localObject3).yaw = ((TTFaceOriginDataModel)localObject2).yaw;
      ((FaceInfo)localObject3).roll = ((TTFaceOriginDataModel)localObject2).roll;
      ((FaceInfo)localObject3).scale = 0.0F;
      ((FaceInfo)localObject3).tx = 0.0F;
      ((FaceInfo)localObject3).ty = 0.0F;
      ((FaceInfo)localObject3).denseFaceModel = null;
      ((FaceInfo)localObject3).transform = null;
      ((FaceInfo)localObject3).expressionWeights = null;
      ((FaceInfo)localObject3).gender = GenderType.FEMALE.value;
      localArrayList.add(localObject3);
    }
    Object localObject7 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashSet();
    Object localObject4 = new HashMap();
    Pair localPair = Pair.create(Integer.valueOf(255), null);
    ((Set)localObject3).add(Integer.valueOf(1));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      FaceInfo localFaceInfo = (FaceInfo)localIterator.next();
      ((List)localObject7).add(localFaceInfo.points);
      ((List)localObject6).add(localFaceInfo.irisPoints);
      ((List)localObject1).add(localFaceInfo.pointsVis);
      ((List)localObject5).add(localFaceInfo.angles);
      FaceStatus localFaceStatus = new FaceStatus();
      localFaceStatus.pitch = localFaceInfo.pitch;
      localFaceStatus.yaw = localFaceInfo.yaw;
      localFaceStatus.roll = localFaceInfo.roll;
      localFaceStatus.tx = localFaceInfo.tx;
      localFaceStatus.ty = localFaceInfo.ty;
      localFaceStatus.scale = localFaceInfo.scale;
      localFaceStatus.denseFaceModel = localFaceInfo.denseFaceModel;
      localFaceStatus.transform = localFaceInfo.transform;
      localFaceStatus.expressionWeights = localFaceInfo.expressionWeights;
      localFaceStatus.eyeRollWeights = localFaceInfo.eyeRollWeights;
      localFaceStatus.gender = localFaceInfo.gender;
      localFaceStatus.age = localFaceInfo.age;
      localFaceStatus.faceID = localFaceInfo.faceId;
      localFaceStatus.eyeEulerAngle = localFaceInfo.eyeEulerAngle;
      ((List)localObject2).add(localFaceStatus);
    }
    localObject7 = AlgoUtils.rotatePointsForList((List)localObject7, paramInt1, paramInt2, paramInt3);
    localObject6 = AlgoUtils.rotatePointsForList((List)localObject6, paramInt1, paramInt2, paramInt3);
    localObject5 = AlgoUtils.rotateAngles((List)localObject5, -paramInt3);
    if (paramList.size() > 0)
    {
      ((Set)localObject3).add(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value));
      ((Map)localObject4).put(Integer.valueOf(PTFaceAttr.PTExpression.FACE_DETECT.value), new FaceActionCounter(1, System.currentTimeMillis()));
    }
    return new PTFaceAttr(new PTFaceAttr.Builder().facePoints((List)localObject7).irisPoints((List)localObject6).faceAngles((List)localObject5).pointsVis((List)localObject1).faceInfoList(localArrayList).histogram(localPair).faceStatusList((List)localObject2).faceActionCounter((Map)localObject4).triggeredExpression((Set)localObject3).faceDetectScale(1.0D).timeStamp(System.currentTimeMillis()).rotation(0).faceDetector(null));
  }
  
  public static void getAngleFromFaceParams(List<FaceParams> paramList, HashMap<FaceParam, float[]> paramHashMap)
  {
    if (paramHashMap == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        paramHashMap.put(((FaceParams)paramList.get(i)).getFaceParam(), ((FaceParams)paramList.get(i)).getFaceAngles());
        i += 1;
      }
    }
  }
  
  public static List<FaceParam> getFaceParamFromFaceParams(List<FaceParams> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add(((FaceParams)paramList.get(i)).getFaceParam());
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<List<PointF>> getPointsByFaceParamsList(List<FaceParam> paramList)
  {
    paramList = paramList.iterator();
    ArrayList localArrayList = new ArrayList();
    while (paramList.hasNext()) {
      localArrayList.add(facePointf83to90(outline2Points(((FaceParam)paramList.next()).mFaceOutline)));
    }
    return localArrayList;
  }
  
  /* Error */
  public static List<FaceParam> newEnhanceDetect4Server(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore_1
    //   6: aload_0
    //   7: ifnull +13 -> 20
    //   10: aload_0
    //   11: invokevirtual 213	android/graphics/Bitmap:isRecycled	()Z
    //   14: ifeq +8 -> 22
    //   17: aload 4
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: new 130	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect
    //   25: dup
    //   26: invokespecial 131	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:<init>	()V
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: aload_2
    //   33: iconst_1
    //   34: invokevirtual 134	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceFeatures	(Z)V
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: iconst_1
    //   41: invokevirtual 245	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:needDetectFaceGender	(Z)V
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: aload_0
    //   48: invokevirtual 137	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectFace	(Landroid/graphics/Bitmap;)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_2
    //   54: invokevirtual 140	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:detectedFace	()Z
    //   57: ifeq +72 -> 129
    //   60: aload_2
    //   61: astore_1
    //   62: getstatic 30	com/tencent/ttpic/openapi/util/FaceDetectUtil:TAG	Ljava/lang/String;
    //   65: new 524	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 527
    //   75: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 93	android/graphics/Bitmap:getWidth	()I
    //   82: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: ldc_w 536
    //   88: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 96	android/graphics/Bitmap:getHeight	()I
    //   95: invokevirtual 534	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc_w 538
    //   101: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 541	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 547	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_2
    //   111: astore_1
    //   112: aload_2
    //   113: getfield 550	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:mFaceParams	Ljava/util/List;
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: aload_2
    //   120: ifnull -100 -> 20
    //   123: aload_2
    //   124: invokevirtual 148	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   127: aload_0
    //   128: areturn
    //   129: aload 4
    //   131: astore_1
    //   132: aload_2
    //   133: ifnull -113 -> 20
    //   136: aload_2
    //   137: invokevirtual 148	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_3
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: getstatic 30	com/tencent/ttpic/openapi/util/FaceDetectUtil:TAG	Ljava/lang/String;
    //   150: new 524	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 525	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 552
    //   160: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_3
    //   164: invokevirtual 555	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 541	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 558	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 4
    //   178: astore_1
    //   179: aload_0
    //   180: ifnull -160 -> 20
    //   183: aload_0
    //   184: invokevirtual 148	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 148	com/tencent/ttpic/util/youtu/TTpicBitmapFaceDetect:destroy	()V
    //   200: aload_0
    //   201: athrow
    //   202: astore_0
    //   203: goto -11 -> 192
    //   206: astore_3
    //   207: aload_2
    //   208: astore_0
    //   209: goto -64 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramBitmap	Bitmap
    //   5	192	1	localObject1	Object
    //   29	179	2	localTTpicBitmapFaceDetect	TTpicBitmapFaceDetect
    //   142	22	3	localException1	java.lang.Exception
    //   206	1	3	localException2	java.lang.Exception
    //   1	176	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	30	142	java/lang/Exception
    //   22	30	189	finally
    //   32	37	202	finally
    //   39	44	202	finally
    //   46	51	202	finally
    //   53	60	202	finally
    //   62	110	202	finally
    //   112	117	202	finally
    //   147	176	202	finally
    //   32	37	206	java/lang/Exception
    //   39	44	206	java/lang/Exception
    //   46	51	206	java/lang/Exception
    //   53	60	206	java/lang/Exception
    //   62	110	206	java/lang/Exception
    //   112	117	206	java/lang/Exception
  }
  
  public static List<PointF> outline2Points(int[][] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int[] arrayOfInt = paramArrayOfInt[i];
      localArrayList.add(new PointF(arrayOfInt[0], arrayOfInt[1]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<TTFaceOriginDataModel> parseOrigFaceDataModelJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return GsonUtils.json2ObjList(paramString, TTFaceOriginDataModel.class);
  }
  
  private static List<FaceParams> pickAvailableFaces(FaceDetect paramFaceDetect, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    FaceParams localFaceParams;
    if (i < paramFaceDetect.getFaceCount())
    {
      localFaceParams = new FaceParams();
      localFaceParams.setFaceParam(paramFaceDetect.getFaceParams(i));
      if ((paramInt != -1) || (checkLegalFace(localFaceParams.getFaceParam(), paramInt) != 1))
      {
        if (!(paramFaceDetect instanceof TTpicBitmapFaceDetect)) {
          break label91;
        }
        localFaceParams.setFaceAngles(((TTpicBitmapFaceDetect)paramFaceDetect).getFaceAngles(i));
      }
      for (;;)
      {
        localArrayList.add(localFaceParams);
        i += 1;
        break;
        label91:
        localFaceParams.setFaceAngles(new float[] { 0.0F, 0.0F, 0.0F });
      }
    }
    if ((localArrayList.isEmpty()) && (paramFaceDetect.getFaceCount() != 0))
    {
      localFaceParams = new FaceParams();
      localFaceParams.setFaceParam((FaceParam)paramFaceDetect.mFaceParams.get(0));
      if (!(paramFaceDetect instanceof TTpicBitmapFaceDetect)) {
        break label188;
      }
      localFaceParams.setFaceAngles(((TTpicBitmapFaceDetect)paramFaceDetect).getFaceAngles(0));
    }
    for (;;)
    {
      localArrayList.add(localFaceParams);
      return localArrayList;
      label188:
      localFaceParams.setFaceAngles(new float[] { 0.0F, 0.0F, 0.0F });
    }
  }
  
  public static PointF[] ulsee2Orig(PointF[] paramArrayOfPointF)
  {
    if (paramArrayOfPointF == null) {
      return null;
    }
    return new PointF[] { paramArrayOfPointF[0], AlgoUtils.middlePoint(paramArrayOfPointF[1], paramArrayOfPointF[2]), paramArrayOfPointF[3], AlgoUtils.middlePoint(paramArrayOfPointF[4], paramArrayOfPointF[5]), paramArrayOfPointF[6], paramArrayOfPointF[8], paramArrayOfPointF[10], paramArrayOfPointF[12], paramArrayOfPointF[14], paramArrayOfPointF[16], paramArrayOfPointF[18], paramArrayOfPointF[20], paramArrayOfPointF[22], paramArrayOfPointF[24], paramArrayOfPointF[26], AlgoUtils.middlePoint(paramArrayOfPointF[27], paramArrayOfPointF[28]), paramArrayOfPointF[29], AlgoUtils.middlePoint(paramArrayOfPointF[30], paramArrayOfPointF[31]), paramArrayOfPointF[32], paramArrayOfPointF[33], paramArrayOfPointF[64], paramArrayOfPointF[65], paramArrayOfPointF[66], paramArrayOfPointF[67], paramArrayOfPointF[36], paramArrayOfPointF[35], paramArrayOfPointF[34], paramArrayOfPointF[42], paramArrayOfPointF[71], paramArrayOfPointF[70], paramArrayOfPointF[69], paramArrayOfPointF[68], paramArrayOfPointF[39], paramArrayOfPointF[40], paramArrayOfPointF[41], paramArrayOfPointF[52], paramArrayOfPointF[57], paramArrayOfPointF[73], paramArrayOfPointF[56], paramArrayOfPointF[55], paramArrayOfPointF[54], paramArrayOfPointF[72], paramArrayOfPointF[53], paramArrayOfPointF[74], paramArrayOfPointF[104], paramArrayOfPointF[61], paramArrayOfPointF[62], paramArrayOfPointF[76], paramArrayOfPointF[63], paramArrayOfPointF[58], paramArrayOfPointF[59], paramArrayOfPointF[75], paramArrayOfPointF[60], paramArrayOfPointF[77], paramArrayOfPointF[105], paramArrayOfPointF[78], paramArrayOfPointF[80], paramArrayOfPointF[82], AlgoUtils.middlePoint(paramArrayOfPointF[47], paramArrayOfPointF[48]), paramArrayOfPointF[49], AlgoUtils.middlePoint(paramArrayOfPointF[50], paramArrayOfPointF[51]), paramArrayOfPointF[83], paramArrayOfPointF[81], paramArrayOfPointF[79], paramArrayOfPointF[46], paramArrayOfPointF[84], paramArrayOfPointF[90], paramArrayOfPointF[95], paramArrayOfPointF[94], paramArrayOfPointF[93], paramArrayOfPointF[92], paramArrayOfPointF[91], paramArrayOfPointF[101], paramArrayOfPointF[102], paramArrayOfPointF[103], paramArrayOfPointF[85], paramArrayOfPointF[86], paramArrayOfPointF[87], paramArrayOfPointF[88], paramArrayOfPointF[89], paramArrayOfPointF[99], paramArrayOfPointF[98], paramArrayOfPointF[97] };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.FaceDetectUtil
 * JD-Core Version:    0.7.0.1
 */