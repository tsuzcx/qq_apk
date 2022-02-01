package com.tencent.ttpic.openapi.ttpicmodule.module_human_segment;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.ttpicmodule.HumanSegmentImpl;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.util.Map;

public class PTHumanSegmenter
  extends IDetect
{
  public static final HumanSegmentInitializer HUMAN_SEGMENT = new HumanSegmentInitializer();
  public static final String TAG = "PTHumanSegmenter";
  private static boolean isInstalled = false;
  private boolean isInited = false;
  
  public static void setUseSmallModel(boolean paramBoolean)
  {
    HUMAN_SEGMENT.setUseSmallModel(paramBoolean);
  }
  
  public void clear()
  {
    if (this.isInited) {
      HUMAN_SEGMENT.getSegmentImpl().destroy();
    }
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if (!this.isInited) {
      return null;
    }
    Map localMap = paramAIParam.getModuleParam(AEDetectorType.SEGMENT.value);
    if ((localMap != null) && (localMap.containsKey("cameraIndex")) && (localMap.get("cameraIndex") != null)) {}
    for (int i = ((Integer)localMap.get("cameraIndex")).intValue();; i = 0)
    {
      if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {
        return null;
      }
      return HUMAN_SEGMENT.getSegmentImpl().detectFrame((Frame)paramAIInput.getInput("frame"), paramAIParam.getRotation(), true, i);
    }
  }
  
  public String getModuleName()
  {
    return "PTHumanSegmenter";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.SEGMENT.value;
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    if (!isInstalled) {
      return false;
    }
    this.isInited = HUMAN_SEGMENT.initGL();
    return this.isInited;
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    HUMAN_SEGMENT.setSoDirOverrideFeatureManager(paramString1);
    HUMAN_SEGMENT.setResourceDirOverrideFeatureManager(paramString2);
    isInstalled = HUMAN_SEGMENT.init();
    return isInstalled;
  }
  
  public void onModuleUninstall()
  {
    if (isInstalled) {
      HUMAN_SEGMENT.destroy();
    }
  }
  
  public boolean reInit()
  {
    isInstalled = HUMAN_SEGMENT.init();
    return isInstalled;
  }
  
  public boolean reloadModel()
  {
    return HUMAN_SEGMENT.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter
 * JD-Core Version:    0.7.0.1
 */