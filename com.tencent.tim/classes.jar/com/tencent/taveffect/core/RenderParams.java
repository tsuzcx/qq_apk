package com.tencent.taveffect.core;

import android.graphics.Matrix;

public class RenderParams
{
  private float opacity = 1.0F;
  private TAVRectangle rectangle;
  private int renderHeight;
  private int renderWidth;
  private Matrix textureMatrix;
  private Matrix vertexMatrix;
  
  public float getOpacity()
  {
    return this.opacity;
  }
  
  public TAVRectangle getRectangle()
  {
    return this.rectangle;
  }
  
  public int getRenderHeight()
  {
    return this.renderHeight;
  }
  
  public int getRenderWidth()
  {
    return this.renderWidth;
  }
  
  public Matrix getTextureMatrix()
  {
    return this.textureMatrix;
  }
  
  public Matrix getVertexMatrix()
  {
    return this.vertexMatrix;
  }
  
  public void setOpacity(float paramFloat)
  {
    this.opacity = paramFloat;
  }
  
  public void setRectangle(TAVRectangle paramTAVRectangle)
  {
    this.rectangle = paramTAVRectangle;
  }
  
  public void setRenderHeight(int paramInt)
  {
    this.renderHeight = paramInt;
  }
  
  public void setRenderWidth(int paramInt)
  {
    this.renderWidth = paramInt;
  }
  
  public void setTextureMatrix(Matrix paramMatrix)
  {
    this.textureMatrix = paramMatrix;
  }
  
  public void setVertexMatrix(Matrix paramMatrix)
  {
    this.vertexMatrix = paramMatrix;
  }
  
  public String toString()
  {
    return "RenderParams{renderWidth=" + this.renderWidth + ", renderHeight=" + this.renderHeight + ", vertexMatrix=" + this.vertexMatrix + ", textureMatrix=" + this.textureMatrix + ", rectangle=" + this.rectangle + ", opacity=" + this.opacity + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.core.RenderParams
 * JD-Core Version:    0.7.0.1
 */