package com.tencent.ttpic.filter.aifilter;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.microrapid.opencv.ImageAutoProcessor;
import com.microrapid.opencv.ImageStatisticsData;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.faceBeauty.FaceParam;
import com.tencent.faceBeauty.NormalizedFaceParam;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.baseutils.encrypt.MD5Util;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.AdjustRealConfig.TYPE;
import com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.view.Photo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PhotoAIFilter
  extends AEChainI
  implements AICache
{
  public static AIImageFilterResult mAIImageFilterResult;
  public static String mAIImageJsonPath = null;
  public static String mLutImagePath;
  private static String mTemperatureStatisticsPath = "";
  private float alpha = 1.0F;
  ExecutorService asyncThreadPool = Executors.newFixedThreadPool(4);
  private Frame cacheFrame;
  private NewEnhanceCategories curCategory = NewEnhanceCategories.COMMON;
  private int[] curve;
  private List<List<PointF>> facePoints;
  private AtomicBoolean isCancel = new AtomicBoolean(false);
  private boolean isFirstTime = true;
  private boolean lightnessProcessComplete = false;
  private String lutMessage;
  private AdjustLutListener mAdjustLutListener;
  private PTFaceAttr mFaceAttr;
  private FilterChain mFilterChain = new FilterChain(new ArrayList());
  private NetworkRequest mNetworkRequestListener;
  private Photo photo;
  @Nullable
  private PhotoAIFilterListener photoAiFilterListener;
  private Bitmap preProcessedBmp;
  private long startTime;
  private Semaphore stepProcessLock = new Semaphore(0);
  
  static
  {
    mAIImageFilterResult = new AIImageFilterResult();
    mLutImagePath = null;
  }
  
  public PhotoAIFilter()
  {
    if (AEModule.getNetworkRequest() != null) {
      this.mNetworkRequestListener = AEModule.getNetworkRequest();
    }
  }
  
  private Bitmap flipVertical(Bitmap paramBitmap)
  {
    if (!BitmapUtils.isLegal(paramBitmap)) {
      return paramBitmap;
    }
    float f1 = paramBitmap.getWidth() / 2.0F;
    float f2 = paramBitmap.getHeight() / 2.0F;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, -1.0F, f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static List<AIImageFilterResult> getAIFilterConfigList(AIFilterConfigBean paramAIFilterConfigBean, String paramString)
  {
    AIImageFilterResult localAIImageFilterResult = null;
    Object localObject = localAIImageFilterResult;
    if (paramAIFilterConfigBean != null)
    {
      localObject = localAIImageFilterResult;
      if (paramAIFilterConfigBean.filters != null)
      {
        localObject = localAIImageFilterResult;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new ArrayList();
          paramAIFilterConfigBean = paramAIFilterConfigBean.filters.iterator();
          while (paramAIFilterConfigBean.hasNext())
          {
            localAIImageFilterResult = (AIImageFilterResult)paramAIFilterConfigBean.next();
            if (paramString.equals(localAIImageFilterResult.sceneLabel))
            {
              if ("lookup".equals(localAIImageFilterResult.fid)) {
                localAIImageFilterResult.lutPath = ("assets://" + localAIImageFilterResult.lutPath);
              }
              ((List)localObject).add(localAIImageFilterResult);
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static RectF getFaceRectF(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      float f2 = 3.4028235E+38F;
      float f3 = 1.4E-45F;
      float f4 = 3.4028235E+38F;
      PointF localPointF;
      for (float f1 = 1.4E-45F; paramList.hasNext(); f1 = Math.max(f1, localPointF.y))
      {
        localPointF = (PointF)paramList.next();
        f4 = Math.min(f4, localPointF.x);
        f3 = Math.max(f3, localPointF.x);
        f2 = Math.min(f2, localPointF.y);
      }
      return new RectF(f4, f2, f3, f1);
    }
    return null;
  }
  
  public static final String getMultiPhotoClassifyUrl()
  {
    return "https://api.pengyou.com/go-cgi-bin/smart_filter/multi_image_classify";
  }
  
  private final JSONArray getNormalizedFaceRectsJson(PTFaceAttr paramPTFaceAttr)
  {
    JSONArray localJSONArray = new JSONArray();
    if (paramPTFaceAttr != null)
    {
      Iterator localIterator = paramPTFaceAttr.getAllFacePoints().iterator();
      while (localIterator.hasNext())
      {
        RectF localRectF = getFaceRectF((List)localIterator.next());
        if (localRectF != null) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("x", localRectF.left / paramPTFaceAttr.getFaceDetWidth());
            localJSONObject.put("y", localRectF.top / paramPTFaceAttr.getFaceDetHeight());
            localJSONObject.put("w", Math.abs(localRectF.right - localRectF.left) / paramPTFaceAttr.getFaceDetWidth());
            localJSONObject.put("h", Math.abs(localRectF.bottom - localRectF.top) / paramPTFaceAttr.getFaceDetHeight());
            localJSONArray.put(localJSONObject);
          }
          catch (JSONException localJSONException) {}
        }
      }
    }
    return localJSONArray;
  }
  
  private final JSONArray getNormalizedFaceRectsJson(List<FaceParam> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (FaceParam)paramList.next();
        LogUtils.d("NewEnhance_Batch", "Face origin(" + ((FaceParam)localObject).mFace.left + ", " + ((FaceParam)localObject).mFace.top + ", " + ((FaceParam)localObject).mFace.width() + ", " + ((FaceParam)localObject).mFace.height() + ')');
        localObject = ((FaceParam)localObject).normalizeFace();
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("x", ((NormalizedFaceParam)localObject).getX());
          localJSONObject.put("y", ((NormalizedFaceParam)localObject).getY());
          localJSONObject.put("w", ((NormalizedFaceParam)localObject).getW());
          localJSONObject.put("h", ((NormalizedFaceParam)localObject).getH());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException) {}
      }
    }
    return localJSONArray;
  }
  
  public static final String getSinglePhotoClassifyUrl()
  {
    return "https://api.pengyou.com/go-cgi-bin/smart_filter/single_image_classify";
  }
  
  private static String getTemperatureStatisticsFilePath()
  {
    String str = getTemperatureStatisticsPath() + "temperature.csv";
    if (!new File(str).exists()) {
      FileUtils.copyAssets(AEModule.getContext(), "statistics/temperature.csv", str);
    }
    return str;
  }
  
  public static String getTemperatureStatisticsPath()
  {
    return mTemperatureStatisticsPath;
  }
  
  private final boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static AIFilterConfigBean parseAIFilterConfigParam(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramString = FileOfflineUtil.readStringFromAssets(paramString); paramString == null; paramString = FileOfflineUtil.readJsonStringFromFile(paramString)) {
      return null;
    }
    return (AIFilterConfigBean)GsonUtils.json2Obj(paramString, new PhotoAIFilter.1().getType());
  }
  
  public static List<AIImageFilterResult> parseAIFilterConfigParamLabel(String paramString)
  {
    int i = 0;
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    Object localObject2;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (!((NewEnhanceCategories)localObject2).serverLabel.equals(paramString)) {
        break label465;
      }
      mAIImageFilterResult.setSceneLabel(((NewEnhanceCategories)localObject2).filterType);
      localObject1 = localObject2;
    }
    localObject1 = VideoTemplateParser.readMaterialFile(mAIImageJsonPath, ((NewEnhanceCategories)localObject1).filterType, false, VideoTemplateParser.decryptListener);
    paramString = new ArrayList();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (i < ((JSONObject)localObject1).getJSONArray("filters").length())
        {
          localObject3 = (String)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("fid");
          localObject2 = new AIImageFilterResult();
          ((AIImageFilterResult)localObject2).fid = ((String)localObject3);
          if (!((String)localObject3).equals("adjust")) {
            break label258;
          }
          localObject3 = new HashMap();
          JSONObject localJSONObject = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
          Iterator localIterator = localJSONObject.keys();
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((HashMap)localObject3).put(str, localJSONObject.getString(str));
            continue;
          }
        }
        else
        {
          return paramString;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ((AIImageFilterResult)localObject2).setAdjustParam((HashMap)localObject3);
      paramString.add(localObject2);
      break label468;
      label258:
      if (((String)localObject3).equals("lookup"))
      {
        localObject3 = (JSONObject)localException.getJSONArray("filters").getJSONObject(i).get("params");
        ((AIImageFilterResult)localObject2).setLutPath(mLutImagePath + ((JSONObject)localObject3).get("lut"));
        ((AIImageFilterResult)localObject2).setLutStrengt(Float.parseFloat(((JSONObject)localObject3).getString("strength")) / 100.0F);
        paramString.add(localObject2);
      }
      else if (((String)localObject3).equals("faceBeauty"))
      {
        ((AIImageFilterResult)localObject2).setSmoothLevel(Float.parseFloat(((JSONObject)localException.getJSONArray("filters").getJSONObject(i).get("params")).getString("smooth")));
        paramString.add(localObject2);
      }
      else if (((String)localObject3).equals("xuanlan"))
      {
        ((AIImageFilterResult)localObject2).setLutStrengt(Float.parseFloat(((JSONObject)localException.getJSONArray("filters").getJSONObject(i).get("params")).getString("strength")) / 100.0F);
        paramString.add(localObject2);
        break label468;
        label465:
        break;
      }
      label468:
      i += 1;
    }
  }
  
  public static AIImageFilterResult parseAIImageParamsBySceneLabel(String paramString)
  {
    AIImageFilterResult localAIImageFilterResult = new AIImageFilterResult();
    Object localObject1 = NewEnhanceCategories.COMMON;
    Object localObject3 = NewEnhanceCategories.newEnhanceTypes.iterator();
    Object localObject2;
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (NewEnhanceCategories)((Iterator)localObject3).next();
      if (!((NewEnhanceCategories)localObject2).serverLabel.equals(paramString)) {
        break label412;
      }
      localAIImageFilterResult.setSceneLabel(((NewEnhanceCategories)localObject2).filterType);
      localObject1 = localObject2;
    }
    label412:
    for (;;)
    {
      break;
      paramString = new HashMap();
      localObject1 = VideoTemplateParser.readMaterialFile(mAIImageJsonPath, ((NewEnhanceCategories)localObject1).filterType, false, VideoTemplateParser.decryptListener);
      for (;;)
      {
        int i;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          i = 0;
          if (i < ((JSONObject)localObject1).getJSONArray("filters").length())
          {
            localObject2 = (String)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("fid");
            if (!((String)localObject2).equals("adjust")) {
              break label230;
            }
            localObject3 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
            Iterator localIterator = ((JSONObject)localObject3).keys();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              paramString.put(str, ((JSONObject)localObject3).getString(str));
              continue;
            }
          }
          else
          {
            return localAIImageFilterResult;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        localAIImageFilterResult.setAdjustParam(paramString);
        label230:
        if (((String)localObject2).equals("lookup"))
        {
          localObject3 = (JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params");
          localAIImageFilterResult.setLutPath(mLutImagePath + ((JSONObject)localObject3).get("lut"));
          localAIImageFilterResult.setLutStrengt(Float.parseFloat(((JSONObject)localObject3).getString("strength")) / 100.0F);
        }
        if (((String)localObject2).equals("xuanlan")) {
          localAIImageFilterResult.setGlowStrength(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("strength")) / 100.0F);
        }
        if (((String)localObject2).equals("faceBeauty")) {
          localAIImageFilterResult.setSmoothLevel(Float.parseFloat(((JSONObject)((JSONObject)localObject1).getJSONArray("filters").getJSONObject(i).get("params")).getString("smooth")));
        }
        i += 1;
      }
    }
  }
  
  private final boolean parseClassifyResult(PhotoResult paramPhotoResult, ReportInfo paramReportInfo, boolean paramBoolean)
  {
    if (paramPhotoResult != null) {
      if (paramPhotoResult != null)
      {
        paramReportInfo.setExtInt2(Integer.parseInt(paramPhotoResult.getRetcode()));
        if (paramPhotoResult.getRetcode().equals("0"))
        {
          paramReportInfo = null;
          Iterator localIterator = NewEnhanceCategories.newEnhanceTypes.iterator();
          if (localIterator.hasNext())
          {
            NewEnhanceCategories localNewEnhanceCategories = (NewEnhanceCategories)localIterator.next();
            if (!localNewEnhanceCategories.serverLabel.equals(paramPhotoResult.getPituLabel())) {
              break label299;
            }
            paramReportInfo = localNewEnhanceCategories;
          }
        }
      }
    }
    label299:
    for (;;)
    {
      break;
      if (paramReportInfo != null) {
        this.curCategory = paramReportInfo;
      }
      if ((paramPhotoResult.getDisplayLabels() != null) && (paramPhotoResult.getDisplayLabels().length >= 2))
      {
        this.lutMessage = (paramPhotoResult.getPituLabel() + ":" + paramPhotoResult.getDisplayLabels()[0].getLabel() + ":" + paramPhotoResult.getDisplayLabels()[1].getLabel());
        if (this.photoAiFilterListener != null) {
          this.photoAiFilterListener.onReqSuccess(paramPhotoResult.getPituLabel(), paramPhotoResult.getDisplayLabels()[0].getLabel(), paramPhotoResult.getDisplayLabels()[1].getLabel());
        }
      }
      for (;;)
      {
        return true;
        if (this.photoAiFilterListener != null) {
          this.photoAiFilterListener.onReqSuccess(paramPhotoResult.getPituLabel(), paramPhotoResult.getPituLabel(), paramPhotoResult.getPituLabel());
        }
      }
      if (this.photoAiFilterListener != null) {
        this.photoAiFilterListener.onAIFilterEnd(false);
      }
      for (;;)
      {
        return false;
        if (this.photoAiFilterListener != null)
        {
          this.photoAiFilterListener.onAIFilterEnd(false);
          continue;
          if (this.photoAiFilterListener != null) {
            this.photoAiFilterListener.onAIFilterEnd(false);
          }
        }
      }
    }
  }
  
  public static ImageStatisticsData preprocessImages(List<Bitmap> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    String str = getTemperatureStatisticsFilePath();
    ImageStatisticsData localImageStatisticsData1 = new ImageStatisticsData(null);
    ImageStatisticsData localImageStatisticsData2 = new ImageStatisticsData(null);
    Iterator localIterator = paramList.iterator();
    int i = 0;
    double d;
    if (localIterator.hasNext())
    {
      ImageStatisticsData localImageStatisticsData3 = ImageAutoProcessor.getImageStatistics((Bitmap)localIterator.next(), str);
      localImageStatisticsData1.lightness += localImageStatisticsData3.lightness;
      localImageStatisticsData1.contrast += localImageStatisticsData3.contrast;
      localImageStatisticsData1.overexposure += localImageStatisticsData3.overexposure;
      localImageStatisticsData1.underexposure += localImageStatisticsData3.underexposure;
      if (localImageStatisticsData3.temperature <= 0.0D) {
        break label547;
      }
      i += 1;
      d = localImageStatisticsData1.temperature;
      localImageStatisticsData3.temperature += d;
    }
    label547:
    for (;;)
    {
      break;
      int j = paramList.size();
      localImageStatisticsData1.lightness /= j;
      localImageStatisticsData1.contrast /= j;
      localImageStatisticsData1.overexposure /= j;
      localImageStatisticsData1.underexposure /= j;
      if (i > 0) {
        localImageStatisticsData1.temperature /= i;
      }
      localImageStatisticsData2.lightness = (-99.129000000000005D * localImageStatisticsData1.lightness * localImageStatisticsData1.lightness + 44.652999999999999D * localImageStatisticsData1.lightness + 18.248999999999999D);
      localImageStatisticsData2.contrast = (-28.879000000000001D * localImageStatisticsData1.contrast + 29.146000000000001D);
      localImageStatisticsData2.overexposure = (10.445D * localImageStatisticsData1.overexposure * localImageStatisticsData1.overexposure + 0.632D * localImageStatisticsData1.overexposure - 26.337D);
      localImageStatisticsData2.underexposure = (16.786999999999999D * localImageStatisticsData1.underexposure + 21.591999999999999D);
      localImageStatisticsData2.temperature = 0.0D;
      d = Math.min(localImageStatisticsData1.temperature, 10000.0D);
      if ((0.0D < d) && (d < 3500.0D)) {
        localImageStatisticsData2.temperature = ((3500.0D - d) * -0.02D);
      }
      for (;;)
      {
        localImageStatisticsData2.lightness = Math.max(Math.min(localImageStatisticsData2.lightness, 30.0D), -30.0D);
        localImageStatisticsData2.contrast = Math.max(Math.min(localImageStatisticsData2.contrast, 30.0D), 0.0D);
        localImageStatisticsData2.overexposure = Math.max(Math.min(localImageStatisticsData2.overexposure, 0.0D), -50.0D);
        localImageStatisticsData2.underexposure = Math.max(Math.min(localImageStatisticsData2.underexposure, 40.0D), 0.0D);
        localImageStatisticsData2.temperature = Math.max(Math.min(localImageStatisticsData2.temperature, 30.0D), -100.0D);
        localImageStatisticsData2.saturation = 10.0D;
        return localImageStatisticsData2;
        if (d > 7000.0D) {
          localImageStatisticsData2.temperature = (0.01D * (d - 7000.0D));
        }
      }
    }
  }
  
  private final Triple<ReportInfo, Boolean, PhotoResult> requestClassify(Bitmap paramBitmap, PTFaceAttr paramPTFaceAttr)
  {
    paramBitmap = BitmapUtils.resizeBySidesRange(paramBitmap, 256, 640);
    ReportInfo localReportInfo = new ReportInfo("perf_cgi_request", "app_launch", "none");
    return new Triple(localReportInfo, Boolean.valueOf(false), requestPhotoClassifySingle(paramBitmap, getNormalizedFaceRectsJson(paramPTFaceAttr), localReportInfo));
  }
  
  private final Triple<ReportInfo, Boolean, PhotoResult> requestClassifyMulti(List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    ReportInfo localReportInfo = new ReportInfo("perf_cgi_request", "app_launch", "none");
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(BitmapUtils.resizeBySidesRange((Bitmap)paramList.next(), 256, 640));
      }
    }
    paramList = new ArrayList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext()) {
        paramList.add(getNormalizedFaceRectsJson((PTFaceAttr)paramList1.next()));
      }
    }
    return new Triple(localReportInfo, Boolean.valueOf(false), requestPhotoClassifyMulti(localArrayList, paramList, localReportInfo));
  }
  
  private PhotoResult requestPhotoClassifyMulti(List<Bitmap> paramList, List<JSONArray> paramList1, ReportInfo paramReportInfo)
  {
    if (!DeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      return null;
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      int i;
      int j;
      Object localObject5;
      try
      {
        localObject2 = new JSONObject();
        localObject3 = new JSONArray();
        i = 0;
        if (i < paramList.size())
        {
          localObject1 = BitmapUtils.getBase64FromBitmap((Bitmap)paramList.get(i), 2, 90);
          localObject4 = new JSONObject();
          j = (int)(((String)localObject1).length() * 0.5D);
          int k = (int)(((String)localObject1).length() * 0.1D);
          localObject5 = MD5Util.GetMD5Code(((String)localObject1).substring(j, k + j) + "9996ef4aa4fb4378826bc1f1a8409dd7");
          ((JSONObject)localObject4).put("raw_base64", localObject1);
          ((JSONObject)localObject4).put("token", localObject5);
          if ((paramList1 == null) || (paramList1.size() <= i)) {
            break label599;
          }
          localObject1 = paramList1.get(i);
          ((JSONObject)localObject4).put("face_rects", localObject1);
          ((JSONArray)localObject3).put(localObject4);
          i += 1;
          continue;
        }
        ((JSONObject)localObject2).put("multi_pics", localObject3);
        ((JSONObject)localObject2).put("num", paramList.size());
        paramList = null;
        if (this.mNetworkRequestListener != null) {
          paramList = this.mNetworkRequestListener.post(getMultiPhotoClassifyUrl(), ((JSONObject)localObject2).toString());
        }
        if (paramList == null) {
          break label597;
        }
        paramList1 = new JSONObject(paramList);
        paramList = paramList1.get("retcode").toString();
        paramList1 = ((JSONObject)paramList1.get("result")).optJSONArray("multi_results");
        if (paramList1 == null) {
          break label597;
        }
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        i = 0;
        if (i >= paramList1.length()) {
          break label569;
        }
        Object localObject4 = paramList1.getJSONObject(i);
        if (localObject4 == null) {
          break label606;
        }
        localObject3 = ((JSONObject)localObject4).get("pitu_label").toString();
        localObject4 = ((JSONObject)localObject4).optJSONArray("display_labels");
        localObject5 = new DisplayLabel[2];
        if (localObject4 != null)
        {
          j = 0;
          if (j < ((JSONArray)localObject4).length())
          {
            localJSONObject = ((JSONArray)localObject4).getJSONObject(j);
            if (localJSONObject == null) {
              break label615;
            }
            if (j == 0)
            {
              paramReportInfo.setExtStr1(localJSONObject.optString("label").replace("_", "/"));
              localObject5[0] = new DisplayLabel(localJSONObject.optString("label"), (float)localJSONObject.optDouble("confidence"));
              break label615;
            }
          }
        }
      }
      catch (Exception paramList)
      {
        JSONObject localJSONObject;
        paramList = paramList;
        LogUtils.e(FaceDetectUtil.TAG, "requestPhotoClassify() - Exception: ${e.message}");
        return null;
        if (j != 1) {
          break label615;
        }
        paramReportInfo.setExtStr2(localJSONObject.optString("label").replace("_", "/"));
        localObject5[1] = new DisplayLabel(localJSONObject.optString("label"), (float)localJSONObject.optDouble("confidence"));
        break label615;
      }
      finally {}
      ((List)localObject1).add(localObject5);
      ((List)localObject2).add(localObject3);
      break label606;
      label569:
      paramList = new PhotoResult(paramList, voteLable((List)localObject2), (DisplayLabel[])((List)localObject1).get(0));
      return paramList;
      label597:
      return null;
      label599:
      Object localObject1 = "";
      continue;
      label606:
      i += 1;
      continue;
      label615:
      j += 1;
    }
  }
  
  private PhotoResult requestPhotoClassifySingle(Bitmap paramBitmap, JSONArray paramJSONArray, ReportInfo paramReportInfo)
  {
    if (!DeviceUtils.isNetworkAvailable(AEModule.getContext())) {
      return null;
    }
    paramBitmap = BitmapUtils.getBase64FromBitmap(paramBitmap, 2, 90);
    System.currentTimeMillis();
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject();
        i = (int)(paramBitmap.length() * 0.5D);
        int j = (int)(paramBitmap.length() * 0.1D);
        localObject2 = MD5Util.GetMD5Code(paramBitmap.substring(i, j + i) + "9996ef4aa4fb4378826bc1f1a8409dd7");
        ((JSONObject)localObject1).put("raw_base64", paramBitmap);
        ((JSONObject)localObject1).put("token", localObject2);
        ((JSONObject)localObject1).put("face_rects", paramJSONArray);
        paramBitmap = null;
        if (this.mNetworkRequestListener != null) {
          paramBitmap = this.mNetworkRequestListener.post(getSinglePhotoClassifyUrl(), ((JSONObject)localObject1).toString());
        }
        if (paramBitmap == null) {
          break label399;
        }
        paramJSONArray = new JSONObject(paramBitmap);
        paramBitmap = paramJSONArray.get("retcode").toString();
        localObject1 = new JSONObject(paramJSONArray.get("result").toString());
        paramJSONArray = ((JSONObject)localObject1).get("pitu_label").toString();
        localObject1 = ((JSONObject)localObject1).optJSONArray("display_labels");
        localObject2 = new DisplayLabel[2];
        if (localObject1 == null) {
          break label399;
        }
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          if (localJSONObject == null) {
            break label401;
          }
          if (i == 0)
          {
            paramReportInfo.setExtStr1(localJSONObject.optString("label").replace("_", "/"));
            localObject2[0] = new DisplayLabel(localJSONObject.optString("label"), (float)localJSONObject.optDouble("confidence"));
            break label401;
          }
        }
      }
      catch (Exception paramBitmap)
      {
        JSONObject localJSONObject;
        paramBitmap = paramBitmap;
        LogUtils.e(FaceDetectUtil.TAG, "requestPhotoClassify() - Exception: ${e.message}");
        return null;
        if (i != 1) {
          break label401;
        }
        paramReportInfo.setExtStr2(localJSONObject.optString("label").replace("_", "/"));
        localObject2[1] = new DisplayLabel(localJSONObject.optString("label"), (float)localJSONObject.optDouble("confidence"));
        break label401;
      }
      finally {}
      paramBitmap = new PhotoResult(paramBitmap, paramJSONArray, (DisplayLabel[])localObject2);
      return paramBitmap;
      label399:
      return null;
      label401:
      i += 1;
    }
  }
  
  public static void setAIImageJsonPath(String paramString)
  {
    mAIImageJsonPath = paramString;
  }
  
  public static void setLutImagePath(String paramString)
  {
    mLutImagePath = paramString;
  }
  
  public static void setTemperatureStatisticsPath(String paramString)
  {
    mTemperatureStatisticsPath = paramString;
  }
  
  public void apply()
  {
    if (!this.mIsApplied) {
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    if (this.cacheFrame != null) {
      this.cacheFrame.clear();
    }
    this.cacheFrame = null;
  }
  
  public final PTFaceAttr doFaceDetect(Bitmap paramBitmap)
  {
    paramBitmap = FaceDetectUtil.detectFace(paramBitmap, 0.16666667163372D);
    if (paramBitmap != null)
    {
      this.facePoints = paramBitmap.getAllFacePoints();
      return paramBitmap;
    }
    this.facePoints = new ArrayList();
    return paramBitmap;
  }
  
  public final PTFaceAttr doFaceDetect(Bitmap paramBitmap, float paramFloat)
  {
    paramBitmap = FaceDetectUtil.detectFace(paramBitmap, paramFloat);
    if (paramBitmap != null)
    {
      this.facePoints = paramBitmap.getAllFacePoints();
      return paramBitmap;
    }
    this.facePoints = new ArrayList();
    return paramBitmap;
  }
  
  public NewEnhanceCategories getCurCategory()
  {
    return this.curCategory;
  }
  
  public String getLutMessage()
  {
    return this.lutMessage;
  }
  
  @Nullable
  public final PhotoAIFilterListener getPhotoAiFilterListener()
  {
    return this.photoAiFilterListener;
  }
  
  public boolean hasCache()
  {
    return this.cacheFrame != null;
  }
  
  public void init(@NotNull String paramString) {}
  
  public boolean isAIFilterCancelled()
  {
    return this.isCancel.get();
  }
  
  public boolean isApplied()
  {
    return this.mIsApplied;
  }
  
  public Frame render(Frame paramFrame)
  {
    return paramFrame;
  }
  
  public boolean requestClassifyLut(Bitmap paramBitmap)
  {
    paramBitmap = requestClassify(paramBitmap, this.mFaceAttr);
    ReportInfo localReportInfo = (ReportInfo)paramBitmap.getFirst();
    boolean bool = ((Boolean)paramBitmap.getSecond()).booleanValue();
    return parseClassifyResult((PhotoResult)paramBitmap.getThird(), localReportInfo, bool);
  }
  
  public boolean requestClassifyMultiLut(List<Bitmap> paramList, List<PTFaceAttr> paramList1)
  {
    paramList = requestClassifyMulti(paramList, paramList1);
    paramList1 = (ReportInfo)paramList.getFirst();
    boolean bool = ((Boolean)paramList.getSecond()).booleanValue();
    return parseClassifyResult((PhotoResult)paramList.getThird(), paramList1, bool);
  }
  
  public void resetCacheFrame()
  {
    if (this.cacheFrame != null) {
      this.cacheFrame.clear();
    }
    this.cacheFrame = null;
  }
  
  public void setAdjustLutListener(AdjustLutListener paramAdjustLutListener)
  {
    this.mAdjustLutListener = paramAdjustLutListener;
  }
  
  public void setAlphaParam(float paramFloat)
  {
    this.alpha = paramFloat;
  }
  
  public void setCancel(boolean paramBoolean)
  {
    this.isCancel.set(paramBoolean);
    if (paramBoolean) {
      this.stepProcessLock.release();
    }
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public final void setNetworkRequestListener(NetworkRequest paramNetworkRequest)
  {
    this.mNetworkRequestListener = paramNetworkRequest;
  }
  
  public final void setPhotoAiFilterListener(@Nullable PhotoAIFilterListener paramPhotoAIFilterListener)
  {
    this.photoAiFilterListener = paramPhotoAIFilterListener;
  }
  
  public void updateAdjustValue(ImageStatisticsData paramImageStatisticsData)
  {
    if ((paramImageStatisticsData != null) && (this.mAdjustLutListener != null))
    {
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.COLOR_TEMPERATURE, (int)paramImageStatisticsData.temperature, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.LIGHTNESS, (int)paramImageStatisticsData.lightness, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.HIGHLIGHT, (int)paramImageStatisticsData.overexposure, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SHADOW, (int)paramImageStatisticsData.underexposure, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.COMPARE, (int)paramImageStatisticsData.contrast, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SHARP, (int)paramImageStatisticsData.sharpness, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.SATURATION, (int)paramImageStatisticsData.saturation, false);
      this.mAdjustLutListener.onChangeAdjust(AdjustRealConfig.TYPE.FADE, (int)paramImageStatisticsData.colorfulness, false);
    }
  }
  
  public String voteLable(List<String> paramList)
  {
    Object localObject1 = new HashMap();
    int i = 0;
    if (i < paramList.size())
    {
      if (((Map)localObject1).containsKey(paramList.get(i))) {
        ((Map)localObject1).put(paramList.get(i), Integer.valueOf(((Integer)((Map)localObject1).get(paramList.get(i))).intValue() + 1));
      }
      for (;;)
      {
        i += 1;
        break;
        ((Map)localObject1).put(paramList.get(i), Integer.valueOf(0));
      }
    }
    Iterator localIterator = ((Map)localObject1).entrySet().iterator();
    localObject1 = (Map.Entry)localIterator.next();
    paramList = (String)((Map.Entry)localObject1).getKey();
    localObject1 = (Integer)((Map.Entry)localObject1).getValue();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (Integer)((Map.Entry)localObject2).getValue();
      if (((Integer)localObject1).intValue() >= ((Integer)localObject2).intValue()) {
        break label215;
      }
      paramList = str;
      localObject1 = localObject2;
    }
    label215:
    for (;;)
    {
      break;
      return paramList;
    }
  }
  
  public static abstract interface AdjustLutListener
  {
    public abstract void onChangeAdjust(AdjustRealConfig.TYPE paramTYPE, int paramInt, boolean paramBoolean);
  }
  
  public static abstract interface PhotoAIFilterListener
  {
    public abstract void onAIFilterEnd(boolean paramBoolean);
    
    public abstract void onAIFilterProcessCancel();
    
    public abstract void onAIFilterStart();
    
    public abstract void onReqSuccess(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoAIFilter
 * JD-Core Version:    0.7.0.1
 */