package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.filter.TextureResParam;
import com.tencent.view.RendererUtils;
import java.util.Map;

public class FaceBeautyAutoFilter
  extends BaseFilter
{
  public static final int FBPFQ_HIGH = 3;
  public static final int FBPFQ_LOW = 1;
  public static final int FBPFQ_MEDIUM = 2;
  public static final int FBPFQ_NONE = 0;
  public static final int FBPF_BAIXI = 3;
  public static final int FBPF_HONGRUN = 2;
  public static final int FBPF_MENGHUAN = 5;
  public static final int FBPF_NONE = 0;
  public static final int FBPF_ROUNEN = 7;
  public static final int FBPF_TIANMEI = 4;
  public static final int FBPF_YANGGUANG = 6;
  public static final int FBPF_ZIRAN = 1;
  private int filterType = 1;
  private int quality = 2;
  
  public FaceBeautyAutoFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public static native void nativeFastBlur(QImage paramQImage, float paramFloat);
  
  private void updateToneFilter(BaseFilter paramBaseFilter)
  {
    int i = this.filterType;
    int j = this.quality;
    double d5 = 0.0D;
    double d1 = 0.0D;
    double d6 = 0.0D;
    double d3 = 0.0D;
    double d7 = 0.0D;
    if (i == 1)
    {
      d5 = 0.09D;
      d1 = 0.09D;
      d7 = 0.15D;
    }
    if (i == 3)
    {
      d6 = -0.06D;
      d7 = 0.07000000000000001D;
    }
    double d2;
    double d4;
    if (i == 4) {
      if (j == 1)
      {
        d1 = 0.2D;
        d2 = 0.455D;
        d4 = 0.17D;
        d3 = 0.177D;
      }
    }
    for (;;)
    {
      if (i == 2) {
        if (j == 1)
        {
          d5 = 0.121D;
          d8 = 0.354D;
          d2 = d1;
          d1 = d8;
        }
      }
      for (;;)
      {
        if (i == 5) {
          d6 = -0.08D;
        }
        if (i == 7)
        {
          d1 = 0.1D;
          d6 = -0.08D;
          d7 = 0.15D;
        }
        if (i == 6)
        {
          d6 = -0.12D;
          d7 = 0.16D;
        }
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent1", (float)d5));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent2", (float)d1));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent3", (float)d4));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent4", (float)d3));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent5", (float)d6));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent6", (float)d2));
        paramBaseFilter.addParam(new UniformParam.FloatParam("percent7", (float)d7));
        return;
        if (j == 2)
        {
          d1 = 0.125D;
          d7 = 0.26D;
          d2 = 0.62D;
          d4 = 0.375D;
          d3 = 0.07000000000000001D;
          break;
        }
        if (j != 3) {
          break label411;
        }
        d1 = 0.2D;
        d2 = 0.824D;
        d4 = 0.461D;
        d3 = 0.152D;
        break;
        if (j == 2)
        {
          d5 = 0.32D;
          d1 = 0.35D;
          d2 = -0.1D;
        }
        else if (j == 3)
        {
          d5 = 0.366D;
          d8 = 0.5540000000000001D;
          d2 = d1;
          d1 = d8;
        }
        else
        {
          d8 = d1;
          d1 = d2;
          d2 = d8;
        }
      }
      label411:
      d2 = d1;
      d4 = 0.0D;
      double d8 = 0.0D;
      d1 = d3;
      d3 = d8;
    }
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    new StringBuilder().append("value = ").append(this.filterType).toString();
    this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
    BaseFilter localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(99));
    setNextFilter(localBaseFilter, null);
    updateToneFilter(localBaseFilter);
    Object localObject = new MicCureFaceFilter(this.filterType, this.quality);
    localBaseFilter.setNextFilter((BaseFilter)localObject, null);
    float f;
    if (this.filterType == 5)
    {
      f = Math.min(paramFloat2, paramFloat1);
      localBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
      localBaseFilter.scaleFact = Math.min(400.0F / f, 1.0F);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      localObject = new FocusBlurFilter(this.quality, localBaseFilter.scaleFact);
      localBaseFilter.setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(BaseFilter.getFragmentShader(3));
      f = 0.0F;
      switch (this.quality)
      {
      }
    }
    for (;;)
    {
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, new int[] { this.srcTextureIndex + 3 });
      ((BaseFilter)localObject).addParam(new UniformParam.FloatParam("filterAdjustParam", 1.0F - f));
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      f = 0.89F;
      continue;
      f = 0.78F;
      continue;
      f = 0.573F;
    }
  }
  
  public void setEffectIndex(int paramInt)
  {
    this.filterType = paramInt;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("effectIndex")) {
      this.filterType = ((Integer)paramMap.get("effectIndex")).intValue();
    }
    if (paramMap.containsKey("filter_type")) {
      this.filterType = ((Integer)paramMap.get("filter_type")).intValue();
    }
    if (paramMap.containsKey("filter_quality")) {
      this.quality = ((Integer)paramMap.get("filter_quality")).intValue();
    }
  }
  
  public class FocusBlurFilter
    extends BaseFilter
  {
    private float blurSize = 0.0F;
    private float lastScaleFilt = 1.0F;
    private int paramTEXTRUEID = 0;
    
    public FocusBlurFilter(int paramInt, float paramFloat)
    {
      super();
      this.lastScaleFilt = paramFloat;
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.blurSize *= 2.0F;
        return;
        this.blurSize = 0.62F;
        continue;
        this.blurSize = 0.67F;
        continue;
        this.blurSize = 1.0F;
      }
    }
    
    public void ClearGLSL()
    {
      RendererUtils.clearTexture(this.paramTEXTRUEID);
      super.ClearGLSL();
    }
    
    public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      this.paramTEXTRUEID = RendererUtils.createTexture();
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    }
    
    public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      QImage localQImage = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
      FaceBeautyAutoFilter.nativeFastBlur(localQImage, this.blurSize * this.lastScaleFilt);
      GLSLRender.nativeTextImage(localQImage, this.paramTEXTRUEID);
      localQImage.Dispose();
    }
    
    public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
    }
  }
  
  public class MicCureFaceFilter
    extends BaseFilter
  {
    private final String[] fileNames = { "error.file", "yijian_ziran", "yijian_hongrun", "yijian_baixi", "yijian_tianmei", "yijian_menghuan", "yijian_yangguang", "yijian_rounen" };
    private int filterType = 0;
    private final float[] qualities = { 1.0F, 1.0F, 0.95F, 0.9F };
    private int quality = 2;
    
    public MicCureFaceFilter(int paramInt1, int paramInt2)
    {
      super();
      this.filterType = paramInt1;
      this.quality = paramInt2;
      new StringBuilder().append("value = ").append(this.filterType).toString();
    }
    
    public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      new StringBuilder().append("value = ").append(this.filterType).toString();
      String str = "yijian/" + this.fileNames[this.filterType] + "_" + this.quality + ".jpg";
      float f2 = this.qualities[this.quality];
      float f1 = f2;
      if (this.filterType == 5)
      {
        if (this.quality == 1) {
          f1 = 0.912F;
        }
      }
      else
      {
        f2 = f1;
        if (this.filterType == 4)
        {
          if (this.quality != 3) {
            break label273;
          }
          f2 = 1.1F;
        }
      }
      for (;;)
      {
        this.glslProgramShader = BaseFilter.getFragmentShader(97);
        addParam(new TextureResParam("inputImageTexture2", str, 33986));
        addParam(new UniformParam.FloatParam("quality", f2));
        addParam(new UniformParam.FloatParam("add_red", 0.0F));
        addParam(new UniformParam.FloatParam("red_m", 0.0F));
        addParam(new UniformParam.FloatParam("green_m", 0.0F));
        addParam(new UniformParam.FloatParam("blue_m", 0.0F));
        super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
        return;
        if (this.quality == 2)
        {
          f1 = 0.95F;
          break;
        }
        f1 = f2;
        if (this.quality != 3) {
          break;
        }
        f1 = 0.88F;
        break;
        label273:
        f2 = f1;
        if (this.quality == 2) {
          f2 = 1.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.FaceBeautyAutoFilter
 * JD-Core Version:    0.7.0.1
 */