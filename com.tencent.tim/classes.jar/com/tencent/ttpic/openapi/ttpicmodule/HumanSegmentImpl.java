package com.tencent.ttpic.openapi.ttpicmodule;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.baseutils.api.ApiHelper;
import com.tencent.ttpic.openapi.PTSegAttr;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import com.tencent.ttpic.openapi.ttpicmodule.thread.HumanSegmentGLThread;
import com.tencent.ttpic.util.MustRunOnGLThread;

public class HumanSegmentImpl
{
  private static String[] NOT_SUPPORT_DEVICE = { "QIHOO_1503-A01", "XIAOMI_MI_3" };
  private boolean isSegLibInitSuccess = true;
  private volatile SegmentDataPipe mDetDataPipe;
  private Frame mRotateFrame = new Frame();
  private HumanSegmentGLThread mSegGLThread;
  private final Object mSegmentLock = new Object();
  private int segLibInitErrorCode;
  private int segLibInitErrorType;
  private HumanSegmentInitializer theHumanSegInitialzer;
  
  private PTSegAttr genSegAttr(Frame paramFrame)
  {
    PTSegAttr localPTSegAttr = new PTSegAttr();
    localPTSegAttr.setMaskFrame(paramFrame);
    return localPTSegAttr;
  }
  
  private boolean inBlackList(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = NOT_SUPPORT_DEVICE;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void setDataPipe(SegmentDataPipe paramSegmentDataPipe)
  {
    synchronized (this.mSegmentLock)
    {
      this.mDetDataPipe = paramSegmentDataPipe;
      this.mSegmentLock.notifyAll();
      return;
    }
  }
  
  public void destroy()
  {
    this.mRotateFrame.clear();
    if (this.mSegGLThread != null)
    {
      this.mSegGLThread.destroy();
      this.mSegGLThread = null;
    }
  }
  
  public PTSegAttr detectFrame(Frame arg1, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Frame localFrame = null;
    if ((this.mSegGLThread != null) && (paramBoolean)) {
      this.mSegGLThread.postSegJob(???, paramInt1, paramInt2);
    }
    for (;;)
    {
      synchronized (this.mSegmentLock)
      {
        try
        {
          if (this.mDetDataPipe == null)
          {
            this.mSegmentLock.wait();
            continue;
          }
          localFrame = localSegmentDataPipe.mMaskFrame;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localSegmentDataPipe = this.mDetDataPipe;
          this.mDetDataPipe = null;
          if (localSegmentDataPipe == null) {
            break label105;
          }
        }
        ??? = localSegmentDataPipe.detectTimes;
        return genSegAttr(localFrame).setDetectTimes(???);
      }
      label105:
      SegmentDataPipe localSegmentDataPipe = null;
      ??? = localObject1;
      Object localObject2 = localSegmentDataPipe;
    }
  }
  
  public HumanSegmentInitializer getHumanSegmentInitializer()
  {
    return this.theHumanSegInitialzer;
  }
  
  public int getSegLibInitErrorCode()
  {
    return this.segLibInitErrorCode;
  }
  
  public int getSegLibInitErrorType()
  {
    return this.segLibInitErrorType;
  }
  
  @MustRunOnGLThread
  @TargetApi(17)
  public void init()
  {
    if ((ApiHelper.hasJellyBeanMR1()) && (this.mSegGLThread == null))
    {
      this.mSegGLThread = new HumanSegmentGLThread(EGL14.eglGetCurrentContext(), getHumanSegmentInitializer());
      this.mSegGLThread.setOnDataReadyListener(new HumanSegmentImpl.1(this));
    }
  }
  
  public boolean isSegLibInitSuccess()
  {
    return this.isSegLibInitSuccess;
  }
  
  public void postJobInSegmentThread(Runnable paramRunnable)
  {
    if (this.mSegGLThread == null) {
      return;
    }
    this.mSegGLThread.postJob(paramRunnable);
  }
  
  public void resetSegmentor()
  {
    this.mDetDataPipe = null;
  }
  
  public void setHumanSegmentInitializer(HumanSegmentInitializer paramHumanSegmentInitializer)
  {
    this.theHumanSegInitialzer = paramHumanSegmentInitializer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.HumanSegmentImpl
 * JD-Core Version:    0.7.0.1
 */