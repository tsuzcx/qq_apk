package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public abstract class BaseRender
{
  private static final String TAG = "VideoPlayer|BaseRender";
  protected static float squareSize = 1.0F;
  protected ShortBuffer drawListBuffer;
  protected short[] drawOrder = { 0, 1, 2, 0, 2, 3 };
  protected float mLastCropValue = 0.0F;
  protected int mRenderType = -1;
  protected boolean mReverseHorizonal = false;
  protected float[] squareCoords = { -squareSize, squareSize, -squareSize, -squareSize, squareSize, -squareSize, squareSize, squareSize };
  protected float[] squareCoords_horizonal_reverse = { squareSize, squareSize, squareSize, -squareSize, -squareSize, -squareSize, -squareSize, squareSize };
  protected float[] squareCoords_vertical_horizonal_reverse = { squareSize, -squareSize, squareSize, squareSize, -squareSize, squareSize, -squareSize, -squareSize };
  protected float[] squareCoords_vertical_reverse = { -squareSize, -squareSize, -squareSize, squareSize, squareSize, squareSize, squareSize, -squareSize };
  protected float[] textureCoords = { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F, 0.0F, 1.0F };
  protected FloatBuffer textureCoordsBuffer;
  protected float[] textureTransform = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  protected FloatBuffer vertexBuffer;
  protected FloatBuffer vertexBuffer_horizonal_reverse;
  protected FloatBuffer vertexBuffer_horizonal_vertical_reverse;
  protected FloatBuffer vertexBuffer_vertical_reverse;
  
  public BaseRender() {}
  
  public BaseRender(int paramInt)
  {
    this.mRenderType = paramInt;
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      LogUtil.e("VideoPlayer|BaseRender", paramString + ": glError " + GLUtils.getEGLErrorString(i));
    }
  }
  
  public abstract void destroy();
  
  public abstract void draw(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void drawFBO(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public int getRenderType()
  {
    if (this.mRenderType == -1) {
      LogUtil.v("VideoPlayer|BaseRender", "mRenderType  Error, need initDecodeType ");
    }
    return this.mRenderType;
  }
  
  public void setCropValue(float paramFloat)
  {
    LogUtil.v("VideoPlayer|BaseRender", "setCropValue aCropValue=" + paramFloat);
    if (this.mLastCropValue != paramFloat)
    {
      this.mLastCropValue = paramFloat;
      if (paramFloat <= 0.0F) {
        break label181;
      }
    }
    label181:
    for (this.textureCoords = new float[] { 0.0F, 1.0F - paramFloat, 0.0F, 1.0F, 0.0F, paramFloat, 0.0F, 1.0F, 0.5F, paramFloat, 0.0F, 1.0F, 0.5F, 1.0F - paramFloat, 0.0F, 1.0F };; this.textureCoords = new float[] { 0.0F - paramFloat / 2.0F, 1.0F, 0.0F, 1.0F, 0.0F - paramFloat / 2.0F, 0.0F, 0.0F, 1.0F, paramFloat / 2.0F + 0.5F, 0.0F, 0.0F, 1.0F, paramFloat / 2.0F + 0.5F, 1.0F, 0.0F, 1.0F })
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      this.textureCoordsBuffer = localByteBuffer.asFloatBuffer();
      this.textureCoordsBuffer.put(this.textureCoords);
      this.textureCoordsBuffer.position(0);
      return;
    }
  }
  
  public void setRoteTexture()
  {
    this.squareCoords = new float[] { squareSize, -squareSize, -squareSize, -squareSize, -squareSize, squareSize, squareSize, squareSize };
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.squareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer = localByteBuffer.asFloatBuffer();
    this.vertexBuffer.put(this.squareCoords);
    this.vertexBuffer.position(0);
  }
  
  public abstract void setup();
  
  public void setupTextureCoordsBuffer()
  {
    LogUtil.v("VideoPlayer|BaseRender", "setupTexture");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.textureCoordsBuffer = localByteBuffer.asFloatBuffer();
    this.textureCoordsBuffer.put(this.textureCoords);
    this.textureCoordsBuffer.position(0);
  }
  
  public void setupVertexBuffer()
  {
    LogUtil.v("VideoPlayer|BaseRender", "setupVertexBuffer");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(this.drawOrder.length * 2);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.drawListBuffer = localByteBuffer.asShortBuffer();
    this.drawListBuffer.put(this.drawOrder);
    this.drawListBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.squareCoords.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer = localByteBuffer.asFloatBuffer();
    this.vertexBuffer.put(this.squareCoords);
    this.vertexBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.squareCoords_horizonal_reverse.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer_horizonal_reverse = localByteBuffer.asFloatBuffer();
    this.vertexBuffer_horizonal_reverse.put(this.squareCoords_horizonal_reverse);
    this.vertexBuffer_horizonal_reverse.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.squareCoords_vertical_reverse.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer_vertical_reverse = localByteBuffer.asFloatBuffer();
    this.vertexBuffer_vertical_reverse.put(this.squareCoords_vertical_reverse);
    this.vertexBuffer_vertical_reverse.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(this.squareCoords_vertical_horizonal_reverse.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.vertexBuffer_horizonal_vertical_reverse = localByteBuffer.asFloatBuffer();
    this.vertexBuffer_horizonal_vertical_reverse.put(this.squareCoords_vertical_horizonal_reverse);
    this.vertexBuffer_horizonal_vertical_reverse.position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender
 * JD-Core Version:    0.7.0.1
 */