package com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment;

import android.graphics.Bitmap;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.openapi.initializer.Feature;
import com.tencent.ttpic.openapi.initializer.ModelInfo;
import com.tencent.ttpic.openapi.initializer.RapidNetSegCpuInitializer;
import com.tencent.ttpic.openapi.initializer.RapidNetSegGpuInitializer;
import com.tencent.ttpic.openapi.initializer.SharedLibraryInfo;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.ttpicmodule.HairSegmentImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HairSegmentInitializer
  extends Feature
{
  private static final String NAME_RAPIDMODEL_BIG = "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx";
  private static final String NAME_RAPIDMODEL_SMALL = "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx";
  public static final SizeI NET_SIZE_BIG = new SizeI(320, 320);
  public static final SizeI NET_SIZE_SMALL = new SizeI(192, 256);
  private static final String TAG = HairSegmentInitializer.class.getSimpleName();
  private static final ModelInfo[] rapidBigModels = { new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx.rapidproto") };
  private static final ModelInfo[] rapidSmallModels = { new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx.rapidmodel"), new ModelInfo(true, "hairsegment", "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx.rapidproto") };
  private HairSegmentImpl mHairSegmentImpl;
  private boolean useSmallModel = false;
  
  private boolean initModelSync(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(1)) {}
    }
    boolean bool;
    while (FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(1))
    {
      return true;
      localObject = FeatureManager.Features.RAPID_NET_SEG_CPU;
      str2 = getFinalResourcesDir();
      if (paramBoolean) {}
      for (str1 = "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx";; str1 = "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx")
      {
        bool = ((RapidNetSegCpuInitializer)localObject).loadRapidModelFrom(str2, str1, false, true, 0, 0, 1);
        if ((bool) || (paramBoolean)) {
          break;
        }
        this.useSmallModel = true;
        return initModelSync(true);
      }
    }
    Object localObject = FeatureManager.Features.RAPID_NET_SEG_GPU;
    String str2 = getFinalResourcesDir();
    if (paramBoolean) {}
    for (String str1 = "hair_v2_deconv_k4_depthwise_192x256_799999_softmax_iter.onnx.opt.onnx";; str1 = "hair_v2_deconv_k4_320x320_299_softmax_concat4_iter.onnx.opt.onnx")
    {
      bool = ((RapidNetSegGpuInitializer)localObject).loadRapidModelFrom(str2, str1, false, true, 0, 1, 1);
      break;
    }
    return bool;
  }
  
  public boolean destroyImpl()
  {
    return true;
  }
  
  public Bitmap forward(Bitmap paramBitmap, int paramInt)
  {
    if (!isFunctionReady()) {
      return paramBitmap;
    }
    if (this.useSmallModel) {}
    for (paramBitmap = FeatureManager.Features.RAPID_NET_SEG_CPU.forward(paramBitmap, 1, this.useSmallModel, this.useSmallModel, paramInt);; paramBitmap = FeatureManager.Features.RAPID_NET_SEG_GPU.forward(paramBitmap, 1, this.useSmallModel, this.useSmallModel, paramInt)) {
      return paramBitmap;
    }
  }
  
  public SizeI getCurrentSize()
  {
    if (this.useSmallModel) {
      return NET_SIZE_SMALL;
    }
    return NET_SIZE_BIG;
  }
  
  public List<ModelInfo> getModelInfos()
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, rapidBigModels);
    Collections.addAll(localArrayList, rapidSmallModels);
    return localArrayList;
  }
  
  public String getName()
  {
    return "HairSegment";
  }
  
  public HairSegmentImpl getSegmentImpl()
  {
    return this.mHairSegmentImpl;
  }
  
  public List<SharedLibraryInfo> getSharedLibraries()
  {
    return new ArrayList();
  }
  
  public boolean getUseSmallModel()
  {
    return this.useSmallModel;
  }
  
  public boolean initGL()
  {
    return this.mHairSegmentImpl != null;
  }
  
  public boolean initImpl()
  {
    if ((!FeatureManager.Features.RAPID_NET_SEG_GPU.init()) || (!FeatureManager.Features.RAPID_NET_SEG_CPU.init())) {}
    do
    {
      return false;
      this.isSoFilesLoaded = true;
    } while (!initModelSync(this.useSmallModel));
    this.mHairSegmentImpl = new HairSegmentImpl();
    return true;
  }
  
  public boolean isFunctionReady()
  {
    return (this.isInited) && (((FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(1)) && (this.useSmallModel)) || ((FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(1)) && (!this.useSmallModel)));
  }
  
  public boolean reloadModel()
  {
    if (this.useSmallModel)
    {
      if (!FeatureManager.Features.RAPID_NET_SEG_CPU.isModelLoaded(1)) {}
    }
    else {
      while (FeatureManager.Features.RAPID_NET_SEG_GPU.isModelLoaded(1)) {
        return true;
      }
    }
    return initModelSync(this.useSmallModel);
  }
  
  public void setUseSmallModel(boolean paramBoolean)
  {
    this.useSmallModel = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.HairSegmentInitializer
 * JD-Core Version:    0.7.0.1
 */