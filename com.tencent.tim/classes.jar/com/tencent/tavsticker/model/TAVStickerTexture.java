package com.tencent.tavsticker.model;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavsticker.log.TLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TAVStickerTexture
  implements SurfaceTexture.OnFrameAvailableListener
{
  private static final String TAG = TAVStickerTexture.class.getSimpleName();
  private boolean frameAvailable;
  private final Object frameSyncObject = new Object();
  private int preferRotation = 0;
  private boolean quitFlag = false;
  private SurfaceTexture surfaceTexture;
  private TextureInfo textureInfo;
  private Matrix textureMatrix;
  private int textureType;
  
  public TAVStickerTexture(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 36197, 0);
  }
  
  public TAVStickerTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, createTexture(paramInt3));
  }
  
  public TAVStickerTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.textureType = paramInt3;
    this.surfaceTexture = new SurfaceTexture(paramInt5);
    this.surfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      this.textureInfo = new TextureInfo(paramInt5, paramInt3, paramInt1, paramInt2, null, paramInt4);
      this.preferRotation = paramInt4;
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
  }
  
  public TAVStickerTexture(TextureInfo paramTextureInfo)
  {
    this.textureInfo = paramTextureInfo;
    this.surfaceTexture = new SurfaceTexture(paramTextureInfo.textureID);
    if (Build.VERSION.SDK_INT >= 21) {
      this.surfaceTexture.setOnFrameAvailableListener(this, new Handler(Looper.getMainLooper()));
    }
    for (;;)
    {
      paramTextureInfo = new float[16];
      this.surfaceTexture.getTransformMatrix(paramTextureInfo);
      this.preferRotation = 0;
      return;
      this.surfaceTexture.setOnFrameAvailableListener(this);
      reflectLooper();
    }
  }
  
  public static void checkEglError(String paramString)
    throws RuntimeException
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      TLog.e(TAG, paramString + ": EGL error: 0x" + Integer.toHexString(j));
      localStringBuilder.append(paramString).append(": EGL error: 0x").append(Integer.toHexString(j));
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): " + localStringBuilder).printStackTrace();
    }
  }
  
  public static int createTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    checkEglError("glBindTexture mTextureID");
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameteri(paramInt, 10242, 33071);
    GLES20.glTexParameteri(paramInt, 10243, 33071);
    checkEglError("glTexParameter");
    return i;
  }
  
  private void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    float f1 = -1.0F;
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f2;
    float f3;
    float f4;
    switch (paramInt)
    {
    default: 
      paramFloat2 = 0.0F;
      paramFloat1 = 0.0F;
      f1 = 1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f4, f2, paramFloat1, f3, f1, paramFloat2, 0.0F, 0.0F, 1.0F });
      return;
      paramFloat1 = paramFloat2;
      f2 = -1.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      f1 = 0.0F;
      paramFloat2 = 0.0F;
      continue;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = -1.0F;
      continue;
      paramFloat2 = paramFloat1;
      f2 = 1.0F;
      f3 = -1.0F;
      f4 = 0.0F;
      f1 = 0.0F;
      paramFloat1 = 0.0F;
    }
  }
  
  private Matrix getTextureMatrix(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    Object localObject = new float[16];
    paramSurfaceTexture.getTransformMatrix((float[])localObject);
    float f1 = localObject[0];
    float f2 = localObject[4];
    float f3 = localObject[12];
    float f4 = localObject[1];
    float f5 = localObject[5];
    float f6 = localObject[13];
    paramSurfaceTexture = new Matrix();
    localObject = new Matrix();
    if (paramInt != 0) {
      getRotationMatrix((Matrix)localObject, paramInt, 1.0F, 1.0F);
    }
    if (((int)f1 == f1) && ((int)f4 == f4) && ((int)f2 == f2) && ((int)f5 == f5))
    {
      paramSurfaceTexture.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
      if (paramInt != 0) {
        paramSurfaceTexture.preConcat((Matrix)localObject);
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        Matrix localMatrix = new Matrix();
        ((Matrix)localObject).invert(localMatrix);
        paramSurfaceTexture.postConcat(localMatrix);
      }
      return paramSurfaceTexture;
      paramSurfaceTexture.setValues(new float[] { f1, f2, f3, f4, f5, f6, 0.0F, 0.0F, 1.0F });
    }
  }
  
  private boolean isIdentity()
  {
    return (this.textureMatrix == null) || (this.textureMatrix.isIdentity());
  }
  
  private boolean isOES()
  {
    return this.textureType == 36197;
  }
  
  private void reflectLooper()
  {
    Object localObject3 = SurfaceTexture.class.getDeclaredClasses();
    int j = localObject3.length;
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = localObject3[i];
      if (!localObject1.getName().toLowerCase().contains("handler")) {}
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        return;
        i += 1;
        break;
      }
      try
      {
        localObject1 = localObject1.getConstructor(new Class[] { SurfaceTexture.class, Looper.class }).newInstance(new Object[] { this.surfaceTexture, Looper.getMainLooper() });
        localObject3 = this.surfaceTexture.getClass().getDeclaredField("mEventHandler");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(this.surfaceTexture, localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject2 = null;
    }
  }
  
  private void releaseTextureInfo()
  {
    if (this.textureInfo != null)
    {
      this.textureInfo.release();
      this.textureInfo = null;
    }
  }
  
  public boolean awaitNewImage()
  {
    return awaitNewImage(500L);
  }
  
  public boolean awaitNewImage(long paramLong)
  {
    int i = (int)Math.ceil((float)paramLong * 1.0F / 50.0F);
    synchronized (this.frameSyncObject)
    {
      while (!this.frameAvailable)
      {
        boolean bool = this.quitFlag;
        if ((bool) || (i <= 0)) {
          break;
        }
        i -= 1;
        try
        {
          this.frameSyncObject.wait(50L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.frameAvailable = false;
      if (i == 0) {
        return false;
      }
      if (this.quitFlag)
      {
        this.quitFlag = false;
        return false;
      }
    }
    checkEglError("before updateTexImage");
    this.surfaceTexture.updateTexImage();
    this.textureInfo.setTextureMatrix(getTextureMatrix(this.surfaceTexture, this.preferRotation));
    return true;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public TextureInfo getTextureInfo()
  {
    return this.textureInfo;
  }
  
  public void onFrameAvailable(SurfaceTexture arg1)
  {
    synchronized (this.frameSyncObject)
    {
      if (this.frameAvailable)
      {
        new RuntimeException("frameAvailable already set, frame could be dropped").printStackTrace();
        return;
      }
      this.frameAvailable = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
  
  public void quitIfWaiting()
  {
    synchronized (this.frameSyncObject)
    {
      this.quitFlag = true;
      this.frameSyncObject.notifyAll();
      return;
    }
  }
  
  public void release()
  {
    releaseTextureInfo();
    releaseSurfaceTexture();
  }
  
  public void releaseSurfaceTexture()
  {
    if (this.surfaceTexture != null)
    {
      this.surfaceTexture.release();
      this.surfaceTexture = null;
    }
  }
  
  public SurfaceTexture surfaceTexture()
  {
    return this.surfaceTexture;
  }
  
  public Matrix surfaceTextureMatrix()
  {
    if ((isIdentity()) && (isOES())) {
      this.textureMatrix = getTextureMatrix(this.surfaceTexture, this.preferRotation);
    }
    return this.textureMatrix;
  }
  
  public void updateStickerTextureSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.textureInfo != null)) {
      this.textureInfo = new TextureInfo(this.textureInfo.textureID, this.textureInfo.textureType, paramInt1, paramInt2, this.textureInfo.getTextureMatrix(), this.textureInfo.preferRotation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerTexture
 * JD-Core Version:    0.7.0.1
 */