package com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.aekit.plugin.core.AIInput.DataSize;
import com.tencent.aekit.plugin.core.AIParam;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.ttpicmodule.HairSegmentImpl;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.nio.ByteBuffer;

public class PTHairSegmenter
  extends IDetect
{
  public static final HairSegmentInitializer HAIR_SEGMENT = new HairSegmentInitializer();
  public static final String TAG = "PTHairSegmenter";
  
  public static void clearCache()
  {
    if (HAIR_SEGMENT.getSegmentImpl() != null) {
      HAIR_SEGMENT.getSegmentImpl().clearCache();
    }
  }
  
  public static void setUseSmallModel(boolean paramBoolean)
  {
    HAIR_SEGMENT.setUseSmallModel(paramBoolean);
  }
  
  public void clear()
  {
    clearCache();
    HAIR_SEGMENT.destroy();
  }
  
  public Object detect(AIInput paramAIInput, AIParam paramAIParam)
  {
    if ((paramAIInput == null) || (paramAIInput.getInput("frame") == null)) {}
    PTFaceAttr localPTFaceAttr;
    int i;
    int j;
    int n;
    do
    {
      Frame localFrame;
      do
      {
        return null;
        localFrame = (Frame)paramAIInput.getInput("frame");
        localPTFaceAttr = (PTFaceAttr)paramAIParam.getAIAttr().getRealtimeData(AEDetectorType.FACE.value);
      } while ((localFrame == null) || (localPTFaceAttr == null));
      i = (int)(localFrame.width * localPTFaceAttr.getFaceDetectScale());
      j = (int)(localFrame.height * localPTFaceAttr.getFaceDetectScale());
      int k = paramAIParam.getBytesDataSizeWidth(getModuleType()).intValue();
      int m = paramAIParam.getBytesDataSizeHeight(getModuleType()).intValue();
      n = paramAIParam.getRotation();
      if ((k <= 0) || (m <= 0)) {
        break;
      }
      paramAIParam = paramAIInput.getSizedBytes(new AIInput.DataSize(k, m));
      paramAIInput = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
    } while (paramAIParam == null);
    paramAIInput.copyPixelsFromBuffer(ByteBuffer.wrap(paramAIParam));
    for (;;)
    {
      return HAIR_SEGMENT.getSegmentImpl().detectFrame(paramAIInput, localPTFaceAttr, i, j, n);
      paramAIInput = null;
    }
  }
  
  public String getModuleName()
  {
    return "PTHairSegmenter";
  }
  
  public String getModuleType()
  {
    return AEDetectorType.HAIR_SEGMENT.value;
  }
  
  @MustRunOnGLThread
  public boolean init()
  {
    return HAIR_SEGMENT.initGL();
  }
  
  public boolean onModuleInstall(String paramString1, String paramString2)
  {
    HAIR_SEGMENT.setSoDirOverrideFeatureManager(paramString1);
    HAIR_SEGMENT.setResourceDirOverrideFeatureManager(paramString2);
    return HAIR_SEGMENT.init();
  }
  
  public void onModuleUninstall()
  {
    HAIR_SEGMENT.setUseSmallModel(false);
    HAIR_SEGMENT.destroy();
  }
  
  public boolean reInit()
  {
    return HAIR_SEGMENT.init();
  }
  
  public boolean reloadModel()
  {
    return HAIR_SEGMENT.reloadModel();
  }
  
  public void updateAIAttr(AIAttr paramAIAttr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter
 * JD-Core Version:    0.7.0.1
 */