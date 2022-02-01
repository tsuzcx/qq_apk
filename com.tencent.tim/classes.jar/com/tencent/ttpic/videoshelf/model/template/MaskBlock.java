package com.tencent.ttpic.videoshelf.model.template;

import com.google.gson.annotations.Expose;

public class MaskBlock
{
  @Expose
  private int blendMode;
  @Expose
  private MaskRectPoint[] maskRect;
  @Expose
  private NodeRectPoint[] nodeRect;
  @Expose
  private int zIndex;
  
  public int getBlendMode()
  {
    return this.blendMode;
  }
  
  public MaskRectPoint[] getMaskRect()
  {
    return this.maskRect;
  }
  
  public NodeRectPoint[] getNodeRect()
  {
    return this.nodeRect;
  }
  
  public int getZIndex()
  {
    return this.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.template.MaskBlock
 * JD-Core Version:    0.7.0.1
 */