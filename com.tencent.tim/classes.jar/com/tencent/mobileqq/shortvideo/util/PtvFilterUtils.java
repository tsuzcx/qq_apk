package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import aqhq;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import ram;

public class PtvFilterUtils
{
  public static final boolean HAS_RELEASE_SURFACE_TEXTURE;
  private static boolean cHL;
  private static boolean cHM;
  private static int[] nH;
  private static Method r;
  
  static
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 14) {
      bool = hasMethod("android.graphics.SurfaceTexture", "release", new Class[0]);
    }
    HAS_RELEASE_SURFACE_TEXTURE = bool;
    nH = new int[2];
    try
    {
      r = HandlerThread.class.getDeclaredMethod("quitSafely", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
  }
  
  public static void Qf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glFinish();
      return;
    }
    GLES20.glFlush();
  }
  
  public static void Qg(boolean paramBoolean)
  {
    try
    {
      setSupportBeauty(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void Qh(boolean paramBoolean)
  {
    try
    {
      setEnableAsyncClipVideo(paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void Vb(int paramInt)
  {
    try
    {
      setBeautyKind(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static void Vc(int paramInt)
  {
    try
    {
      setVideoClipThreadNum(paramInt);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  @TargetApi(18)
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ByteBuffer paramByteBuffer, AVIOStruct paramAVIOStruct)
  {
    int i = 6408;
    if (paramInt4 == 3) {
      i = 6407;
    }
    ram.a("PtvFilterUtils", "sharedMemoryGLReadPixels %d, width=%d, height=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
    if (paramInt1 != 0)
    {
      paramAVIOStruct = new int[1];
      GLES20.glGenFramebuffers(1, paramAVIOStruct, 0);
      GLES20.glBindFramebuffer(36160, paramAVIOStruct[0]);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      GLES20.glReadPixels(0, 0, paramInt2, paramInt3, i, 5121, paramByteBuffer);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, paramAVIOStruct, 0);
      paramAVIOStruct[0] = 0;
    }
    for (;;)
    {
      return 0;
      if ((cHL) && (paramAVIOStruct != null))
      {
        long l1 = SystemClock.elapsedRealtime();
        paramInt1 = paramAVIOStruct.pFrameIndex;
        boolean bool;
        if (paramInt1 == 0)
        {
          bool = true;
          label134:
          q(paramInt2 * paramInt3 * 4, bool);
          GLES30.glBindBuffer(35051, nH[(paramInt1 % nH.length)]);
          getGLFrameBufferDataPBO(paramInt2, paramInt3, 4);
          paramInt4 = GLES20.glGetError();
          if (paramInt4 != 0) {
            ram.e("PtvFilterUtils", "getGLFrameBufferDataPBO:err=" + Integer.toHexString(paramInt4));
          }
          GLES30.glBindTexture(3553, 0);
          ram.a("PtvFilterUtils", "getGLFrameBufferDataPBO request pack pixel to PBO frame=%d, PBO=%d, cost=%d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 % nH.length), Long.valueOf(SystemClock.elapsedRealtime() - l1));
          if (paramInt1 < 1) {
            break label450;
          }
          l1 = SystemClock.elapsedRealtime();
          paramInt1 -= 1;
          GLES30.glBindBuffer(35051, nH[(paramInt1 % nH.length)]);
          ByteBuffer localByteBuffer = (ByteBuffer)GLES30.glMapBufferRange(35051, 0, paramInt2 * paramInt3 * 4, 1);
          paramInt4 = GLES20.glGetError();
          if (paramInt4 != 0) {
            ram.e("PtvFilterUtils", "glMapBufferRange:err=" + Integer.toHexString(paramInt4));
          }
          long l2 = SystemClock.elapsedRealtime();
          long l3 = SystemClock.elapsedRealtime();
          if (localByteBuffer == null) {
            break label440;
          }
          copyMapData(localByteBuffer, paramByteBuffer, paramInt2 * paramInt3 * 4);
          bool = GLES30.glUnmapBuffer(35051);
          ram.d("PtvFilterUtils", "getGLFrameBufferDataPBO copyMapData from PBO frame=%d, PBO=%d, result=%s, glMapBufferRange cost=%d, copyMapData cost=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt1 % nH.length), Boolean.valueOf(bool), Long.valueOf(l2 - l1), Long.valueOf(SystemClock.elapsedRealtime() - l3) });
        }
        for (;;)
        {
          GLES30.glBindBuffer(35051, 0);
          paramAVIOStruct.pFrameIndex -= 1;
          break;
          bool = false;
          break label134;
          label440:
          ram.w("PtvFilterUtils", "getGLFrameBufferDataPBO glMapBufferRange failed");
        }
        label450:
        GLES30.glBindBuffer(35051, 0);
        GLES20.glReadPixels(0, 0, paramInt2, paramInt3, i, 5121, paramByteBuffer);
      }
      else
      {
        GLES20.glReadPixels(0, 0, paramInt2, paramInt3, i, 5121, paramByteBuffer);
      }
    }
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, AVIOStruct paramAVIOStruct, int paramInt5, boolean paramBoolean3, int paramInt6)
  {
    try
    {
      paramInt1 = writeSharedMemtoFile(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramInt4, paramAVIOStruct, paramInt5, paramBoolean3, paramInt6);
      return paramInt1;
    }
    catch (UnsatisfiedLinkError paramAVIOStruct)
    {
      paramAVIOStruct.printStackTrace();
    }
    return -2;
  }
  
  public static int a(AVIOStruct paramAVIOStruct)
  {
    try
    {
      int i = realWriteData(paramAVIOStruct);
      return i;
    }
    catch (UnsatisfiedLinkError paramAVIOStruct)
    {
      paramAVIOStruct.printStackTrace();
    }
    return -2;
  }
  
  public static boolean a(HandlerThread paramHandlerThread)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (r != null) {}
    try
    {
      r.invoke(paramHandlerThread, new Object[0]);
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    if (!bool1)
    {
      paramHandlerThread.quit();
      return true;
    }
    return bool1;
  }
  
  private static native ByteBuffer allocate();
  
  public static native ByteBuffer allocateSharedMem(long paramLong);
  
  public static native void copyMapData(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt);
  
  @TargetApi(18)
  public static void dRi()
  {
    if (cHL)
    {
      GLES30.glDeleteBuffers(nH.length, nH, 0);
      cHM = false;
    }
  }
  
  public static native Object getBitmapFromSharedMem(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int getGLFrameBufferData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native void getGLFrameBufferDataPBO(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void getGLFrameBufferDataPBOMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native long getNativePtrIndex(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int getVideoFrameData(byte[] paramArrayOfByte);
  
  public static long ha()
  {
    return System.nanoTime();
  }
  
  private static boolean hasMethod(String paramString1, String paramString2, Class<?>... paramVarArgs)
  {
    try
    {
      Class.forName(paramString1).getDeclaredMethod(paramString2, paramVarArgs);
      return true;
    }
    catch (Throwable paramString1) {}
    return false;
  }
  
  public static void hs(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + File.separator + "configure.txt";
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "configure file content:" + localStringBuilder.toString());
    }
    aqhq.writeFile(paramString1, localStringBuilder.toString());
  }
  
  public static native int processVideoFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, ByteBuffer paramByteBuffer);
  
  @TargetApi(18)
  public static boolean q(int paramInt, boolean paramBoolean)
  {
    if (cHL)
    {
      if ((cHM) && (paramBoolean))
      {
        GLES30.glDeleteBuffers(nH.length, nH, 0);
        cHM = false;
      }
      if (!cHM)
      {
        GLES30.glGenBuffers(nH.length, nH, 0);
        GLES30.glBindBuffer(35051, nH[0]);
        GLES30.glBufferData(35051, paramInt, null, 35041);
        GLES30.glBindBuffer(35051, nH[1]);
        GLES30.glBufferData(35051, paramInt, null, 35041);
        GLES30.glBindBuffer(35051, 0);
        cHM = true;
      }
      return true;
    }
    return false;
  }
  
  private static native int realWriteData(AVIOStruct paramAVIOStruct);
  
  private static native void setBeautyKind(int paramInt);
  
  private static native void setEnableAsyncClipVideo(boolean paramBoolean);
  
  private static native void setSupportBeauty(boolean paramBoolean);
  
  private static native void setVideoClipThreadNum(int paramInt);
  
  public static int v(byte[] paramArrayOfByte)
  {
    try
    {
      int i = getVideoFrameData(paramArrayOfByte);
      return i;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return -2;
  }
  
  private static native int writeSharedMemtoFile(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, AVIOStruct paramAVIOStruct, int paramInt5, boolean paramBoolean3, int paramInt6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterUtils
 * JD-Core Version:    0.7.0.1
 */