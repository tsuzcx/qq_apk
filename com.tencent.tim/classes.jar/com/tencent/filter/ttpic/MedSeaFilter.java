package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam.FloatsParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.HSVColorChannelFilter;
import com.tencent.filter.TextureResParam;

public class MedSeaFilter
  extends BaseFilter
{
  public MedSeaFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    Object localObject2 = new BaseFilter(BaseFilter.getFragmentShader(54));
    ((BaseFilter)localObject2).addParam(new TextureResParam("inputImageTexture2", "sh/medsea_curve.png", 33986));
    setNextFilter((BaseFilter)localObject2, null);
    Object localObject1 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject1).setInput(-3.0F, 21.0F, 6.0F, 299.0F, 329.0F, 359.0F, 29.0F);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new HSVColorChannelFilter();
    ((HSVColorChannelFilter)localObject2).setInput(-6.0F, 1.0F, 8.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    localObject1 = new BaseFilter(BaseFilter.getFragmentShader(57));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("shadowsShift", new float[] { 0.09803922F, 0.09019608F, 0.0666667F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("midtonesShift", new float[] { 0.07058824F, 0.0F, 0.0F }));
    ((BaseFilter)localObject1).addParam(new UniformParam.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.filter.ttpic.MedSeaFilter
 * JD-Core Version:    0.7.0.1
 */