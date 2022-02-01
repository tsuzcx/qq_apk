package com.tencent.ttpic.openai.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.aekit.plugin.core.PTHandAttr;
import com.tencent.ttpic.openapi.initializer.RapidNetGestureInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;

public class AEHandDetector
  extends IDetect
{
  public static final AEHandDetectorInitializer HAND_DETECTOR = new AEHandDetectorInitializer();
  public static final String TAG = "AEHandDetector";
  
  public void clear()
  {
    HAND_DETECTOR.destroy();
  }
  
  public PTHandAttr detect(Bitmap paramBitmap)
  {
    if (HAND_DETECTOR.getHandDetectImpl() == null)
    {
      paramBitmap = new PTHandAttr();
      paramBitmap.setHandType(-1);
      paramBitmap.setConfidence(0.0F);
      paramBitmap.setHandPointList(new ArrayList());
      return paramBitmap;
    }
    return HAND_DETECTOR.getHandDetectImpl().detectFrame(paramBitmap, 1.0F, 0);
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
      return null;
    }
    Object localObject = paramAIParam.getModuleParam(AEDetectorType.HAND.value);
    boolean bool1 = false;
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        if ((!((Map)localObject).containsKey("needDetectHandBone")) || (((Map)localObject).get("needDetectHandBone") == null)) {
          break label303;
        }
        boolean bool2 = ((Boolean)((Map)localObject).get("needDetectHandBone")).booleanValue();
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        int i;
        int j;
        float f;
        int k;
        long l;
        continue;
        paramAIInput = null;
        continue;
      }
      HAND_DETECTOR.getHandDetectImpl().setNeedDetectBonePoint(bool1);
      i = (int)(paramAIParam.getWidth() * paramAIParam.getScale(getModuleType()).floatValue());
      j = (int)(paramAIParam.getHeight() * paramAIParam.getScale(getModuleType()).floatValue());
      f = paramAIParam.getScale(getModuleType()).floatValue();
      k = paramAIParam.getRotation();
      AEProfiler.getInstance().start("RGBA-TO-BITMAP");
      if ((i > 0) && (j > 0))
      {
        localObject = paramAIInput.getBytes(paramAIParam.getScale(getModuleType()).floatValue());
        if (localObject == null)
        {
          paramAIInput = new PTHandAttr();
          paramAIInput.setHandType(-1);
          paramAIInput.setConfidence(0.0F);
          paramAIInput.setHandPointList(new ArrayList());
          return paramAIInput;
        }
        paramAIInput = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        paramAIInput.copyPixelsFromBuffer(ByteBuffer.wrap((byte[])localObject));
        l = AEProfiler.getInstance().end("RGBA-TO-BITMAP");
        AEProfiler.getInstance().add(1, "RGBA-TO-BITMAP", l);
        paramAIInput = HAND_DETECTOR.getHandDetectImpl().detectFrame(paramAIInput, f, k);
        paramAIInput.setDetectWidth(paramAIParam.getWidth());
        paramAIInput.setDetectHeight(paramAIParam.getHeight());
        return paramAIInput;
      }
      label303:
      bool1 = false;
    }
  }
  
  public String getModuleName()
  {
    return "AEHandDetector";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.HAND.value;
  }
  
  public boolean init()
  {
    return HAND_DETECTOR.initGL();
  }
  
  public boolean init(String paramString1, String paramString2)
  {
    FeatureManager.Features.RAPID_NET_GESTURE.setSoDirOverrideFeatureManager(paramString1);
    FeatureManager.Features.RAPID_NET_GESTURE.setResourceDirOverrideFeatureManager(paramString2);
    return onModuleInstall(paramString1, paramString2);
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    HAND_DETECTOR.setSoDirOverrideFeatureManager(paramString1);
    HAND_DETECTOR.setResourceDirOverrideFeatureManager(paramString2);
    return HAND_DETECTOR.init();
  }
  
  public void onModuleUninstall()
  {
    HAND_DETECTOR.destroy();
  }
  
  public boolean reInit()
  {
    return HAND_DETECTOR.init();
  }
  
  public boolean reloadModel()
  {
    return HAND_DETECTOR.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openai.ttpicmodule.AEHandDetector
 * JD-Core Version:    0.7.0.1
 */