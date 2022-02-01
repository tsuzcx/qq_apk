package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTGenderAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetGenderDetectInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

public class AEGenderDetector
  extends IDetect
{
  public static final AEGenderDetectorInitializer GENDER_DETECTOR = new AEGenderDetectorInitializer();
  public static final String TAG = "AEGenderDetector";
  public static final AEGenderDetectorOld aeGenderDetectorOld = new AEGenderDetectorOld();
  
  public void clear()
  {
    GENDER_DETECTOR.destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (paramAIInput == null) {}
    int i;
    int j;
    int k;
    Object localObject1;
    Object localObject2;
    boolean bool;
    do
    {
      do
      {
        return null;
        i = (int)(paramAIParam.getWidth() * paramAIParam.getScale(getModuleType()).floatValue());
        j = (int)(paramAIParam.getHeight() * paramAIParam.getScale(getModuleType()).floatValue());
        paramAIParam.getScale(getModuleType()).floatValue();
        k = paramAIParam.getRotation();
        localObject1 = paramAIParam.getModuleParam(AEDetectorType.GENDER_DETECT.value);
      } while ((localObject1 == null) || (!((Map)localObject1).containsKey("faceInfoList")) || (((Map)localObject1).get("faceInfoList") == null));
      localObject2 = (PTFaceAttr)((Map)localObject1).get("faceInfoList");
      bool = ((Boolean)((Map)localObject1).get("resetGender")).booleanValue();
      localObject1 = ((PTFaceAttr)localObject2).getFaceInfoList();
      localObject2 = ((PTFaceAttr)localObject2).getFaceStatusList();
      AEProfiler.getInstance().start("RGBA-TO-BITMAP");
      if ((i <= 0) || (j <= 0)) {
        break;
      }
      paramAIParam = paramAIInput.getBytes(paramAIParam.getScale(getModuleType()).floatValue());
    } while (paramAIParam == null);
    paramAIInput = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    paramAIInput.copyPixelsFromBuffer(ByteBuffer.wrap(paramAIParam));
    for (;;)
    {
      long l = AEProfiler.getInstance().end("RGBA-TO-BITMAP");
      AEProfiler.getInstance().add(1, "RGBA-TO-BITMAP", l);
      paramAIParam = new PTGenderAttr();
      if (bool) {
        aeGenderDetectorOld.reset();
      }
      Bitmap localBitmap = BitmapUtils.rotateBitmap(paramAIInput, (-k + 360) % 360);
      aeGenderDetectorOld.detectGenderAndUpdateFaceInfo(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), (List)localObject1);
      i = 0;
      while ((localObject1 != null) && (i < ((List)localObject1).size()))
      {
        FaceInfo localFaceInfo = (FaceInfo)((List)localObject1).get(i);
        ((FaceStatus)((List)localObject2).get(i)).gender = localFaceInfo.gender;
        paramAIParam.addGenderInfo(localFaceInfo.faceId, localFaceInfo.rect, localFaceInfo.gender, localFaceInfo.curGender, 0.0F);
        i += 1;
      }
      BitmapUtils.recycle(localBitmap);
      BitmapUtils.recycle(paramAIInput);
      return paramAIParam;
      paramAIInput = null;
    }
  }
  
  public String getModuleName()
  {
    return "AEGenderDetector";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.GENDER_DETECT.value;
  }
  
  public boolean init()
  {
    return (GENDER_DETECTOR.initGL()) && (aeGenderDetectorOld.init());
  }
  
  public boolean init(String paramString1, String paramString2)
  {
    FeatureManager.Features.RAPID_NET_GENDER_DETECT.setSoDirOverrideFeatureManager(paramString1);
    FeatureManager.Features.RAPID_NET_GENDER_DETECT.setResourceDirOverrideFeatureManager(paramString2);
    return onModuleInstall(paramString1, paramString2);
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    GENDER_DETECTOR.setSoDirOverrideFeatureManager(paramString1);
    GENDER_DETECTOR.setResourceDirOverrideFeatureManager(paramString2);
    return GENDER_DETECTOR.init();
  }
  
  public void onModuleUninstall()
  {
    GENDER_DETECTOR.destroy();
  }
  
  public boolean reInit()
  {
    return GENDER_DETECTOR.init();
  }
  
  public boolean reloadModel()
  {
    return GENDER_DETECTOR.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEGenderDetector
 * JD-Core Version:    0.7.0.1
 */