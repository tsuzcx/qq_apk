package com.tencent.mobileqq.shortvideo.panoramicvideo;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Sphere
{
  private static final int sPositionDataSize = 3;
  private static final int sTextureCoordinateDataSize = 2;
  private ShortBuffer indexBuffer;
  private int mNumIndices;
  private FloatBuffer mTexCoordinateBuffer;
  private FloatBuffer mVerticesBuffer;
  
  public Sphere(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = 1.0F / paramInt1;
    float f2 = 1.0F / paramInt2;
    int i = (paramInt1 + 1) * (paramInt2 + 1);
    Object localObject3 = new float[i * 3];
    Object localObject1 = new float[i * 2];
    short[] arrayOfShort = new short[i * 6];
    int m = 0;
    int k = 0;
    int j;
    int n;
    for (i = 0; i < paramInt1 + 1; i = (short)(i + 1)) {
      for (j = 0; j < paramInt2 + 1; j = (short)(j + 1))
      {
        float f3 = (float)(Math.cos(6.283186F * j * f2) * Math.sin(3.141593F * i * f1));
        float f4 = (float)Math.sin(-1.570796F + 3.141593F * i * f1);
        float f5 = (float)(Math.sin(6.283186F * j * f2) * Math.sin(3.141593F * i * f1));
        n = m + 1;
        localObject1[m] = (j * f2);
        m = n + 1;
        localObject1[n] = (i * f1);
        n = k + 1;
        localObject3[k] = (f3 * paramFloat);
        int i1 = n + 1;
        localObject3[n] = (f4 * paramFloat);
        k = i1 + 1;
        localObject3[i1] = (f5 * paramFloat);
      }
    }
    k = 0;
    m = paramInt2 + 1;
    for (i = 0; i < paramInt1; i = (short)(i + 1)) {
      for (j = 0; j < paramInt2; j = (short)(j + 1))
      {
        n = k + 1;
        arrayOfShort[k] = ((short)(i * m + j));
        k = n + 1;
        arrayOfShort[n] = ((short)((i + 1) * m + j));
        n = k + 1;
        arrayOfShort[k] = ((short)(i * m + (j + 1)));
        k = n + 1;
        arrayOfShort[n] = ((short)(i * m + (j + 1)));
        n = k + 1;
        arrayOfShort[k] = ((short)((i + 1) * m + j));
        k = n + 1;
        arrayOfShort[n] = ((short)((i + 1) * m + (j + 1)));
      }
    }
    Object localObject2 = ByteBuffer.allocateDirect(localObject3.length * 4);
    ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
    localObject2 = ((ByteBuffer)localObject2).asFloatBuffer();
    ((FloatBuffer)localObject2).put((float[])localObject3);
    ((FloatBuffer)localObject2).position(0);
    localObject3 = ByteBuffer.allocateDirect(localObject1.length * 4);
    ((ByteBuffer)localObject3).order(ByteOrder.nativeOrder());
    localObject3 = ((ByteBuffer)localObject3).asFloatBuffer();
    ((FloatBuffer)localObject3).put((float[])localObject1);
    ((FloatBuffer)localObject3).position(0);
    localObject1 = ByteBuffer.allocateDirect(arrayOfShort.length * 2);
    ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
    this.indexBuffer = ((ByteBuffer)localObject1).asShortBuffer();
    this.indexBuffer.put(arrayOfShort);
    this.indexBuffer.position(0);
    this.mTexCoordinateBuffer = ((FloatBuffer)localObject3);
    this.mVerticesBuffer = ((FloatBuffer)localObject2);
    this.mNumIndices = arrayOfShort.length;
  }
  
  public void draw()
  {
    if (this.indexBuffer != null)
    {
      this.indexBuffer.position(0);
      GLES20.glDrawElements(4, this.mNumIndices, 5123, this.indexBuffer);
      return;
    }
    GLES20.glDrawArrays(4, 0, this.mNumIndices);
  }
  
  public FloatBuffer getTexCoordinateBuffer()
  {
    return this.mTexCoordinateBuffer;
  }
  
  public FloatBuffer getVerticesBuffer()
  {
    return this.mVerticesBuffer;
  }
  
  public void uploadTexCoordinateBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getTexCoordinateBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 2, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maTextureHandle");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maTextureHandle");
  }
  
  public void uploadVerticesBuffer(int paramInt)
  {
    FloatBuffer localFloatBuffer = getVerticesBuffer();
    if (localFloatBuffer == null) {
      return;
    }
    localFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(paramInt, 3, 5126, false, 0, localFloatBuffer);
    GlUtil.checkGlError("glVertexAttribPointer maPosition");
    GLES20.glEnableVertexAttribArray(paramInt);
    GlUtil.checkGlError("glEnableVertexAttribArray maPositionHandle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.Sphere
 * JD-Core Version:    0.7.0.1
 */