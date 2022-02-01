package com.tencent.ttpic.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

public class SplitFilter
  extends BaseFilter
{
  private float xPos = 0.0F;
  
  public SplitFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  private void updatePosition()
  {
    float f1 = this.xPos * 2.0F - 1.0F;
    float f2 = this.xPos;
    setPositions(new float[] { f1, -1.0F, f1, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F });
    setTexCords(new float[] { f2, 0.0F, f2, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F });
  }
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, Frame paramFrame)
  {
    updatePosition();
    super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, paramFrame);
  }
  
  public void setxPos(float paramFloat)
  {
    this.xPos = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.SplitFilter
 * JD-Core Version:    0.7.0.1
 */