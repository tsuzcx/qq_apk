package com.tencent.mobileqq.apollo;

import abhh;
import abvg;
import abxi;
import abyv;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloEngine
{
  private static CopyOnWriteArrayList<Object> F = new CopyOnWriteArrayList();
  private static BufferedReader a;
  private static boolean bCp;
  private static int coz;
  public long Nn = -1L;
  AtomicBoolean ax = new AtomicBoolean(false);
  private volatile boolean bCq;
  private volatile boolean bCr;
  private ConcurrentHashMap<Integer, Boolean> dp = new ConcurrentHashMap();
  private ApolloTicker mApolloTicker;
  
  static
  {
    abyv.loadSo("classLoad");
  }
  
  public static boolean BJ()
  {
    if (!abyv.Zr())
    {
      abyv.loadSo("other");
      ApolloGameStateMachine.a().n(5, "not load lib");
      return false;
    }
    return true;
  }
  
  public static void Dz(boolean paramBoolean)
  {
    bCp = paramBoolean;
    if (bCp)
    {
      if (coz > 0) {
        nativeSetPipeLog(0);
      }
      coz = 0;
    }
    QLog.i("ApolloManager.Engine", 1, "setPipeLog pipeLogDisable:" + paramBoolean);
  }
  
  private void cBx()
  {
    new File(abxi.bim, "slave");
    String str1 = abxi.bio + "/def/role/0/script/slave/";
    String str2 = abxi.bio + "/";
    nativeSetFileHomeDir(abxi.bjI, abxi.bis, abxi.bim, abxi.bim, abxi.bim + "/extension/", str1, str2);
  }
  
  private void cBy()
  {
    if ((coz > 0) && (a == null)) {
      ThreadManagerV2.newFreeThread(new ApolloEngine.1(this), "Apollo_GL_Log", 1).start();
    }
  }
  
  private native void nativeAudioCallBack(long paramLong);
  
  private native long nativeCreateDirector(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  private native void nativeCreateGLContext(long paramLong1, int paramInt1, int paramInt2, float paramFloat, long paramLong2);
  
  private native void nativeDiposeDirector(long paramLong);
  
  private native void nativeDrawFrame(long paramLong, double paramDouble, int paramInt);
  
  private native void nativeEditorOnClickCallBack(long paramLong, String paramString);
  
  private native void nativeEditorTextChangeCallBack(long paramLong, String paramString);
  
  private native RectF nativeGetDressRect(long paramLong, String paramString);
  
  private native long nativeGetLuaState(long paramLong);
  
  private native RectF nativeGetManRect(long paramLong);
  
  private native int nativeGetRoleNum(long paramLong);
  
  private native String nativeHitestForName(long paramLong, float paramFloat1, float paramFloat2);
  
  private native int nativeHittest(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeHttpCallBack(long paramLong, int paramInt, byte[] paramArrayOfByte);
  
  private native void nativeHttpDownloadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeHttpResponseCallback(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte);
  
  private native void nativeHttpUploadProgressChange(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeLoadScriptFile(long paramLong, String paramString);
  
  private native void nativeLoadScriptString(long paramLong, String paramString, int paramInt);
  
  private native void nativeLocationCallBack(long paramLong, int paramInt, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7);
  
  private native int nativeOrganHittest(long paramLong, float paramFloat1, float paramFloat2, String paramString);
  
  private native String nativeRenderNodeGetExtendString(long paramLong);
  
  private native void nativeScriptCreate(long paramLong, String paramString, int paramInt);
  
  private native void nativeSelectPhotoCallBack(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private native void nativeSetDirectorHidden(long paramLong, int paramInt);
  
  private native void nativeSetDirectorRenderSize(long paramLong, float paramFloat1, float paramFloat2);
  
  private native void nativeSetDirectorScreenScale(long paramLong, float paramFloat);
  
  private native void nativeSetFileHomeDir(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  private native void nativeSetNeedRender(long paramLong, int paramInt);
  
  private native void nativeSetNodeHidden(long paramLong, String paramString, int paramInt);
  
  private static native int nativeSetPipeLog(int paramInt);
  
  private static native void nativeSetQLogLevel(int paramInt);
  
  private native void nativeSetSkey(byte[] paramArrayOfByte);
  
  private native void nativeSetSt(byte[] paramArrayOfByte);
  
  private native void nativeUpdateMouseButton(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private native void nativeWebSocketSetSocket(long paramLong, int paramInt);
  
  private native void nativeWebSocketSetState(long paramLong, int paramInt);
  
  public void A(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[nativeDownloadProgressChange], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeHttpDownloadProgressChange(paramLong, paramInt1, paramInt2);
  }
  
  public void BA(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!jk("[execScriptString]")) {
      return;
    }
    int i;
    for (;;)
    {
      try
      {
        new StringBuilder(paramString.length() + 100).append("try{").append(paramString).append("}catch(err){BK.Script.log(0, 0, err.message);}");
        if (!abhh.bCS) {
          continue;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("ApolloManager.Engine", 1, paramString, new Object[0]);
        return;
        i = 0;
        continue;
        long l = this.Nn;
        if (!QLog.isColorLevel()) {
          break label137;
        }
        i = 1;
        nativeLoadScriptString(l, paramString, i);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("ApolloManager.Engine", 1, paramString, new Object[0]);
        return;
      }
      try
      {
        l = this.Nn;
        if (QLog.isColorLevel())
        {
          i = 1;
          nativeLoadScriptString(l, paramString, i);
          return;
        }
      }
      finally {}
    }
    for (;;)
    {
      label137:
      i = 0;
    }
  }
  
  public void Hc(int paramInt)
  {
    this.dp.put(Integer.valueOf(paramInt), Boolean.TRUE);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, new Object[] { "setScriptLoaded scriptId:", Integer.valueOf(paramInt) });
    }
  }
  
  public void K(long paramLong, String paramString)
  {
    nativeEditorTextChangeCallBack(paramLong, paramString);
  }
  
  public void L(long paramLong, String paramString)
  {
    nativeEditorOnClickCallBack(paramLong, paramString);
  }
  
  public void M(float paramFloat1, float paramFloat2)
  {
    if (jk("[setDirectorRenderSize]")) {
      nativeSetDirectorRenderSize(this.Nn, paramFloat1, paramFloat2);
    }
  }
  
  public boolean XX()
  {
    return this.bCq;
  }
  
  public long a(long paramLong, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    QLog.d("ApolloManager.Engine", 1, "[createDirector] tid: " + Thread.currentThread().getId() + ", mIsInit:" + this.ax.get() + ", isEngineReady:" + BJ() + ",glVersion:" + paramInt4);
    if (BJ())
    {
      new File(abxi.biu).mkdirs();
      if (paramInt4 != 3) {
        break label224;
      }
      paramInt4 = 1;
      this.Nn = nativeCreateDirector(paramLong, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4);
      if (this.Nn > 0L)
      {
        this.ax.set(true);
        this.bCq = true;
      }
      if (BaseApplicationImpl.sProcessId == 1)
      {
        if (bCp) {
          break label230;
        }
        coz = nativeSetPipeLog(1);
        cBy();
        cBx();
        label167:
        QLog.i("ApolloManager.Engine", 1, "sPipeLogFd:" + coz + " sPipeLogDisable:" + bCp);
      }
      if (!QLog.isColorLevel()) {
        break label248;
      }
    }
    label224:
    label230:
    label248:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      nativeSetQLogLevel(paramInt1);
      return this.Nn;
      paramInt4 = 0;
      break;
      if (coz > 0) {
        nativeSetPipeLog(0);
      }
      coz = 0;
      break label167;
    }
  }
  
  public RectF a(String paramString)
  {
    if (jk("[getDressRect]")) {
      return nativeGetDressRect(this.Nn, paramString);
    }
    return null;
  }
  
  public ApolloTicker a()
  {
    if (this.mApolloTicker == null) {
      this.mApolloTicker = new ApolloTicker();
    }
    return this.mApolloTicker;
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (jk("[updateMouseButton]")) {
      nativeUpdateMouseButton(this.Nn, paramInt1, paramInt2, paramFloat1, paramFloat2);
    }
  }
  
  public void a(long paramLong, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, String paramString1, int paramInt, String paramString2)
  {
    nativeLocationCallBack(paramLong, paramInt, paramString2, paramString1, paramDouble2, paramDouble3, paramDouble1, paramDouble5, 0.0D, paramDouble4, paramDouble6);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, "createGLContext");
    }
    if (jk("createGLContext")) {
      nativeCreateGLContext(paramLong, paramInt1, paramInt2, paramFloat, this.Nn);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager.Engine", 2, "[imageselector selectPhoto], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
    }
    nativeSelectPhotoCallBack(paramLong, paramInt1, paramInt2, paramInt3, paramArrayOfByte);
  }
  
  @Deprecated
  public void a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[httpCallBack], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeHttpCallBack(paramLong, paramInt, paramArrayOfByte);
  }
  
  public void a(long paramLong, int paramInt, String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[httpResponseCallback], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeHttpResponseCallback(paramLong, paramInt, paramArrayOfString, paramArrayOfByte);
  }
  
  public void aA(float paramFloat)
  {
    if (jk("[setDirectorScreenScale]")) {
      nativeSetDirectorScreenScale(this.Nn, paramFloat);
    }
  }
  
  public void as(long paramLong, int paramInt)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[webSocketSetState], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeWebSocketSetState(paramLong, paramInt);
  }
  
  public void as(byte[] paramArrayOfByte)
  {
    nativeSetSt(paramArrayOfByte);
  }
  
  public void at(long paramLong, int paramInt)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[webSocketSetSSLState], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeWebSocketSetSocket(paramLong, paramInt);
  }
  
  public void b(double paramDouble, int paramInt)
  {
    if (jk("[drawFrame]")) {
      nativeDrawFrame(this.Nn, paramDouble, paramInt);
    }
  }
  
  public native void bkDirectorChangeScreenMode(int paramInt);
  
  public void cBz()
  {
    if (jk("[disposeDirector]"))
    {
      QLog.d("ApolloManager.Engine", 1, "[disposeDirector] tid: " + Thread.currentThread().getId() + ", mDirector: " + this.Nn + " ApolloManager.sApolloEngineLockEnable:" + abhh.bCS);
      this.ax.set(false);
      if (!abhh.bCS) {
        break label105;
      }
    }
    for (;;)
    {
      try
      {
        nativeDiposeDirector(this.Nn);
        this.Nn = -1L;
        return;
      }
      finally {}
      label105:
      nativeDiposeDirector(this.Nn);
    }
  }
  
  public void cY(String paramString, int paramInt)
  {
    if (jk("[setNodeHidden]")) {
      nativeSetNodeHidden(this.Nn, paramString, paramInt);
    }
  }
  
  public RectF g()
  {
    if (jk("[getManRect]")) {
      return nativeGetManRect(this.Nn);
    }
    return null;
  }
  
  public void gP(long paramLong)
  {
    nativeAudioCallBack(paramLong);
  }
  
  public long getLuaState()
  {
    if (jk("[getLuaState]")) {
      return nativeGetLuaState(this.Nn);
    }
    return -1L;
  }
  
  public boolean hL(int paramInt)
  {
    Boolean localBoolean = (Boolean)this.dp.get(Integer.valueOf(paramInt));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return false;
  }
  
  public boolean jk(String paramString)
  {
    if ((!this.ax.get()) || (this.Nn < 0L))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder(paramString);
        paramString.append(" error mIsInit: ").append(this.ax.get()).append(", mDirector: ").append(this.Nn);
        QLog.d("ApolloManager.Engine", 2, paramString.toString());
      }
      return false;
    }
    return true;
  }
  
  public native void nativeNotifyScreenModeChange(long paramLong, int paramInt);
  
  public void setSkey(byte[] paramArrayOfByte)
  {
    nativeSetSkey(paramArrayOfByte);
  }
  
  public String toString()
  {
    return "ApolloEngine{mIsInit=" + this.ax + ", mDirector=" + this.Nn + ", mHadInitDirector=" + this.bCq + ", mViewInited=" + this.bCr + ", hashCode=" + hashCode() + '}';
  }
  
  public void x(double paramDouble)
  {
    BA(String.format(abvg.ro(), new Object[] { Double.valueOf(paramDouble) }));
  }
  
  public void z(long paramLong, int paramInt1, int paramInt2)
  {
    if (!this.ax.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager.Engine", 2, "[nativeUploadProgressChange], errInfo->initErr, mIsLoadSuccess:" + BJ() + ",mIsInit:" + this.ax.get());
      }
      return;
    }
    nativeHttpUploadProgressChange(paramLong, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloEngine
 * JD-Core Version:    0.7.0.1
 */