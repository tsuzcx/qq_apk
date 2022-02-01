package com.tencent.ttpic.openapi.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceDetector;
import com.tencent.ttpic.openapi.initializer.AgeDetectorInitailizer;
import com.tencent.ttpic.openapi.initializer.Face3DLibInitializer;
import com.tencent.ttpic.openapi.initializer.FaceDetectInitializer;
import com.tencent.ttpic.openapi.initializer.FilamentInitializer;
import com.tencent.ttpic.openapi.initializer.GpuParticleInitializer;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.initializer.MediaInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.ParticleSystemInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetCatInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetGenderDetectInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetGenderSwitchInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetGestureInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetHumanSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetHumanSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.TNNStyleChildInitializer;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.initializer.VoiceChangerInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.model.FaceStyleItem.STYLE_CHANGE_TYPE;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import java.io.File;

public class FeatureManager
{
  private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
  private static final String TAG = FeatureManager.class.getSimpleName();
  private static boolean enableResourceCheck;
  private static String resourceDir;
  private static String soDir;
  
  public static void createNoMedia()
  {
    try
    {
      Object localObject = AEModule.getContext();
      localObject = FileUtils.genSeperateFileDir(((Context)localObject).getExternalFilesDir(null).getPath()) + "Tencent" + File.separator + "aekit";
      File localFile = new File((String)localObject);
      if ((!localFile.exists()) && (!localFile.mkdirs())) {
        LogUtils.e(TAG, "FeatureManager create dir fail : " + (String)localObject);
      }
      localObject = new File((String)localObject + File.separator + ".nomedia");
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void enableResourceCheck(boolean paramBoolean)
  {
    enableResourceCheck = paramBoolean;
  }
  
  public static boolean ensureMaterialSoLoaded(VideoMaterial paramVideoMaterial)
  {
    boolean bool1 = true;
    if (paramVideoMaterial == null) {
      return true;
    }
    if ((VideoMaterialUtil.isFilamentMaterial(paramVideoMaterial)) && (!Features.FILAMENT.isFunctionReady())) {}
    for (boolean bool3 = Features.FILAMENT.init() & true;; bool3 = true)
    {
      boolean bool2 = bool3;
      if (VideoMaterialUtil.needVoiceChange(paramVideoMaterial))
      {
        bool2 = bool3;
        if (!Features.VOICE_CHANGDER.isFunctionReady()) {
          bool2 = bool3 & Features.VOICE_CHANGDER.init();
        }
      }
      bool3 = bool2;
      if (VideoMaterialUtil.isAudio2textMaterial(paramVideoMaterial))
      {
        bool3 = bool2;
        if (!Features.VOICE_TO_TEXT.isFunctionReady()) {
          bool3 = bool2 & Features.VOICE_TO_TEXT.init();
        }
      }
      bool2 = bool3;
      if (VideoMaterialUtil.isParticleMaterial(paramVideoMaterial))
      {
        bool2 = bool3;
        if (!Features.PARTICLE_SYSTEM.isFunctionReady()) {
          bool2 = bool3 & Features.PARTICLE_SYSTEM.init();
        }
      }
      bool3 = bool2;
      if (VideoMaterialUtil.is3DCosMaterial(paramVideoMaterial))
      {
        bool3 = bool2;
        if (!Features.FACE_3D_LIB.isFunctionReady()) {
          bool3 = bool2 & Features.FACE_3D_LIB.init();
        }
      }
      if (!VideoMaterialUtil.isHairSegMaterial(paramVideoMaterial))
      {
        bool2 = bool3;
        if (!VideoMaterialUtil.isSkySegMaterial(paramVideoMaterial)) {}
      }
      else
      {
        if ((!Features.RAPID_NET_SEG_GPU.init()) || (!Features.RAPID_NET_SEG_CPU.init())) {
          break label306;
        }
      }
      for (;;)
      {
        bool2 = bool3 & bool1;
        bool3 = bool2;
        if (VideoMaterialUtil.isGestureDetectMaterial(paramVideoMaterial)) {
          bool3 = bool2 & Features.RAPID_NET_GESTURE.init();
        }
        bool2 = bool3;
        if (VideoMaterialUtil.isGpuParticleMaterial(paramVideoMaterial)) {
          bool2 = bool3 & Features.GPU_PARTICLE.init();
        }
        bool3 = bool2;
        if (VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.GENDER_SWITCH)) {
          bool3 = bool2 & Features.RAPID_NET_GENDER_SWITCH.init();
        }
        if (!VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.CHILD_STYLE))
        {
          bool2 = bool3;
          if (!VideoMaterialUtil.isTNNMaterial(paramVideoMaterial, FaceStyleItem.STYLE_CHANGE_TYPE.CARTOON_STYLE)) {}
        }
        else
        {
          bool2 = bool3 & Features.TNN_STYLE_CHILD_INITIALIZER.init();
        }
        bool3 = bool2;
        if (VideoMaterialUtil.isPagMaterial(paramVideoMaterial))
        {
          bool3 = bool2;
          if (!Features.PAG.isFunctionReady()) {
            bool3 = bool2 & Features.PAG.init();
          }
        }
        return bool3;
        label306:
        bool1 = false;
      }
    }
  }
  
  public static String getResourceDir()
  {
    return resourceDir;
  }
  
  public static String getSoDir()
  {
    return soDir;
  }
  
  public static boolean isBasicFeaturesFunctionReady()
  {
    return (Features.YT_COMMON.isFunctionReady()) && (Features.FACE_DETECT.isFunctionReady()) && (Features.PTU_TOOLS.isFunctionReady()) && (Features.PTU_ALGO.isFunctionReady()) && (Features.MASK_IMAGES.isFunctionReady());
  }
  
  public static boolean isBasicFeaturesReadyInDir(String paramString)
  {
    return Features.YT_COMMON.isSoReadyInDirectory(paramString) & Features.PTU_ALGO.isSoReadyInDirectory(paramString) & Features.PTU_TOOLS.isSoReadyInDirectory(paramString) & Features.FACE_DETECT.isSoReadyInDirectory(paramString) & Features.MASK_IMAGES.isSoReadyInDirectory(paramString);
  }
  
  public static boolean isEnableResourceCheck()
  {
    return enableResourceCheck;
  }
  
  public static boolean loadBasicFeatures()
  {
    return loadBasicFeatures(true);
  }
  
  public static boolean loadBasicFeatures(boolean paramBoolean)
  {
    if (!AEModule.isAeKitSupportVersion()) {
      return false;
    }
    boolean bool1 = true;
    if (paramBoolean) {
      bool1 = true & Features.YT_COMMON.init();
    }
    boolean bool2 = bool1 & Features.PTU_TOOLS.init() & Features.PTU_ALGO.init();
    bool1 = bool2;
    if (bool2) {
      bool1 = bool2 & Features.MASK_IMAGES.init();
    }
    return bool1 & AIManager.installDetector(PTFaceDetector.class, Features.FACE_DETECT.getSoDirOverrideFeatureManager(), Features.FACE_DETECT.getResourceDirOverrideFeatureManager()) & Features.MASK_IMAGES.init();
  }
  
  public static void setModelDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      resourceDir = null;
      return;
    }
    resourceDir = FileUtils.genSeperateFileDir(paramString);
  }
  
  public static void setSoDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      soDir = null;
      return;
    }
    soDir = FileUtils.genSeperateFileDir(paramString);
  }
  
  public static class Features
  {
    public static final AgeDetectorInitailizer AGE_DETECT;
    public static final Face3DLibInitializer FACE_3D_LIB;
    public static final FaceDetectInitializer FACE_DETECT;
    public static final FilamentInitializer FILAMENT;
    public static final GpuParticleInitializer GPU_PARTICLE;
    public static final ImageAlgoInitializer IMAGE_ALGO = new ImageAlgoInitializer();
    public static final MaskImagesInitializer MASK_IMAGES;
    public static final MediaInitializer MEDIA;
    public static final PagInitializer PAG;
    public static final ParticleSystemInitializer PARTICLE_SYSTEM;
    public static final PtuAlgoInitializer PTU_ALGO;
    public static final PtuToolsInitializer PTU_TOOLS;
    public static final RapidNetCatInitializer RAPID_NET_CAT;
    public static final RapidNetGenderDetectInitializer RAPID_NET_GENDER_DETECT;
    public static final RapidNetGenderSwitchInitializer RAPID_NET_GENDER_SWITCH;
    public static final RapidNetGestureInitializer RAPID_NET_GESTURE;
    public static final RapidNetHumanSegCpuInitializer RAPID_NET_HUMAN_SEG_CPU;
    public static final RapidNetHumanSegGpuInitializer RAPID_NET_HUMAN_SEG_GPU;
    public static final RapidNetSegCpuInitializer RAPID_NET_SEG_CPU;
    public static final RapidNetSegGpuInitializer RAPID_NET_SEG_GPU;
    public static final TNNStyleChildInitializer TNN_STYLE_CHILD_INITIALIZER;
    public static final VoiceChangerInitializer VOICE_CHANGDER;
    public static final Voice2TextInitializer VOICE_TO_TEXT;
    public static final YTCommonInitializer YT_COMMON = new YTCommonInitializer();
    
    static
    {
      FACE_DETECT = new FaceDetectInitializer();
      PTU_TOOLS = new PtuToolsInitializer();
      PTU_ALGO = new PtuAlgoInitializer();
      MASK_IMAGES = new MaskImagesInitializer();
      FILAMENT = new FilamentInitializer();
      GPU_PARTICLE = new GpuParticleInitializer();
      VOICE_CHANGDER = new VoiceChangerInitializer();
      VOICE_TO_TEXT = new Voice2TextInitializer();
      PARTICLE_SYSTEM = new ParticleSystemInitializer();
      AGE_DETECT = new AgeDetectorInitailizer();
      FACE_3D_LIB = new Face3DLibInitializer();
      PAG = new PagInitializer();
      RAPID_NET_SEG_CPU = new RapidNetSegCpuInitializer();
      RAPID_NET_SEG_GPU = new RapidNetSegGpuInitializer();
      RAPID_NET_GENDER_SWITCH = new RapidNetGenderSwitchInitializer();
      RAPID_NET_GESTURE = new RapidNetGestureInitializer();
      RAPID_NET_HUMAN_SEG_CPU = new RapidNetHumanSegCpuInitializer();
      RAPID_NET_HUMAN_SEG_GPU = new RapidNetHumanSegGpuInitializer();
      RAPID_NET_GENDER_DETECT = new RapidNetGenderDetectInitializer();
      TNN_STYLE_CHILD_INITIALIZER = new TNNStyleChildInitializer();
      RAPID_NET_CAT = new RapidNetCatInitializer();
      MEDIA = new MediaInitializer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.manager.FeatureManager
 * JD-Core Version:    0.7.0.1
 */