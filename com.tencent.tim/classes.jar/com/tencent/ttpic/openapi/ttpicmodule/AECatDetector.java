package com.tencent.ttpic.openapi.ttpicmodule;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.aekit.plugin.core.AECatAttr;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.initializer.RapidNetCatInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class AECatDetector
  extends IDetect
{
  public static final AECatDetectorInitializer CAT_DETECTOR = new AECatDetectorInitializer();
  public static final String TAG = "AECatDetector";
  
  public void clear()
  {
    CAT_DETECTOR.destroy();
  }
  
  public AECatAttr detect(Bitmap paramBitmap, float paramFloat, int paramInt)
  {
    AECatAttr localAECatAttr = new AECatAttr();
    if (CAT_DETECTOR.getCatDetectImpl() == null)
    {
      localAECatAttr.setCatPointList(new ArrayList());
      return localAECatAttr;
    }
    localAECatAttr = CAT_DETECTOR.getCatDetectImpl().detectFrame(paramBitmap, paramFloat, paramInt);
    localAECatAttr.setDetectWidth(paramBitmap.getWidth());
    localAECatAttr.setDetectHeight(paramBitmap.getHeight());
    return localAECatAttr;
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    Object localObject2 = null;
    if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
      return null;
    }
    int i = (int)(paramAIParam.getWidth() * paramAIParam.getScale(getModuleType()).floatValue());
    int j = (int)(paramAIParam.getHeight() * paramAIParam.getScale(getModuleType()).floatValue());
    float f = paramAIParam.getScale(getModuleType()).floatValue();
    int k = paramAIParam.getRotation();
    AEProfiler.getInstance().start("RGBA-TO-BITMAP");
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (j > 0)
      {
        paramAIInput = paramAIInput.getBytes(paramAIParam.getScale(getModuleType()).floatValue());
        if (paramAIInput == null)
        {
          paramAIInput = new AECatAttr();
          paramAIInput.setCatPointList(new ArrayList());
          return paramAIInput;
        }
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject1).copyPixelsFromBuffer(ByteBuffer.wrap(paramAIInput));
      }
    }
    long l = AEProfiler.getInstance().end("RGBA-TO-BITMAP");
    AEProfiler.getInstance().add(1, "RGBA-TO-BITMAP", l);
    paramAIInput = detect((Bitmap)localObject1, f, k);
    paramAIInput.setDetectWidth(paramAIParam.getWidth());
    paramAIInput.setDetectHeight(paramAIParam.getHeight());
    return paramAIInput;
  }
  
  public String getModuleName()
  {
    return "AECatDetector";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.CAT.value;
  }
  
  public boolean init()
  {
    return CAT_DETECTOR.initGL();
  }
  
  public boolean init(String paramString1, String paramString2)
  {
    FeatureManager.Features.RAPID_NET_CAT.setSoDirOverrideFeatureManager(paramString1);
    FeatureManager.Features.RAPID_NET_CAT.setResourceDirOverrideFeatureManager(paramString2);
    return onModuleInstall(paramString1, paramString2);
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    CAT_DETECTOR.setSoDirOverrideFeatureManager(paramString1);
    CAT_DETECTOR.setResourceDirOverrideFeatureManager(paramString2);
    return CAT_DETECTOR.init();
  }
  
  public void onModuleUninstall()
  {
    CAT_DETECTOR.destroy();
  }
  
  public boolean reInit()
  {
    return CAT_DETECTOR.init();
  }
  
  public boolean reloadModel()
  {
    return CAT_DETECTOR.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AECatDetector
 * JD-Core Version:    0.7.0.1
 */