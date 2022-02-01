package com.tencent.mobileqq.shortvideo.mediadevice;

import aaqi;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import anhm;
import anii;
import anij;
import anij.b;
import anim;
import anim.c;
import aniq;
import anit;
import awed;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.ControlFlagEnum;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.a;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PreviewContext
{
  public static final boolean SG_SUPPORT_CALLBACK = true;
  private static final String TAG = "PreviewContext";
  public static final boolean USE_USER_BUFFER = true;
  private static final int sCheckSizeLimt = 32;
  int fps = 0;
  int frameCount = 0;
  AVCodec mAVCodec = null;
  public boolean mActivtiyDestory = false;
  int mBlockIndex = 0;
  public anim mCamera;
  private boolean mCheckedDataValid;
  private boolean mDisablePrivilage;
  public AtomicReference<SVHwEncoder> mEncodeRef = new AtomicReference(null);
  ArrayList<Integer> mFrameCountArray = new ArrayList();
  private int mFrameIndex;
  private volatile boolean mFrameProcessEnd;
  List<AVIOStruct> mFrameSrcList = new ArrayList();
  private boolean mInitHwEncode;
  int mLastFrameIndex = 0;
  public Handler mMsghandler;
  public boolean mPTVRealBeauty;
  private AVIOStruct mPTVRealBeautyCache = new AVIOStruct();
  private int mRecordToCache;
  private long[] mTimeStamp = new long[1];
  public AtomicInteger mVideoFrameProcess = new AtomicInteger(0);
  public AtomicInteger mVideoFrameWrite = new AtomicInteger(0);
  int mWriteFrameCount = 0;
  private Object mlock = new Object();
  Object mlockFrame = new Object();
  public boolean notifyFirstFrame;
  long updateTime = 0L;
  
  public PreviewContext(anim paramanim, int paramInt1, int paramInt2)
  {
    this.mCamera = paramanim;
    paramanim.mScreenWidth = paramInt1;
    paramanim.mScreenHeight = paramInt2;
    this.mInitHwEncode = initHwCallBackSecurity();
    this.mFrameProcessEnd = false;
    this.mVideoFrameWrite.getAndSet(0);
    this.mVideoFrameProcess.getAndSet(0);
    this.mCheckedDataValid = false;
    this.mDisablePrivilage = false;
  }
  
  public static boolean checkIsDisablePrivilage(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return true;
    }
    if (paramArrayOfByte.length < paramInt) {
      return true;
    }
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      i += (paramArrayOfByte[j] & 0xFF);
      j += 1;
    }
    paramInt = paramArrayOfByte.length - paramInt;
    while (paramInt < paramArrayOfByte.length)
    {
      i += (paramArrayOfByte[paramInt] & 0xFF);
      paramInt += 1;
    }
    return i == 0;
  }
  
  private boolean checkPreviewDataLength(AVIOStruct paramAVIOStruct, byte[] paramArrayOfByte)
  {
    int i = paramAVIOStruct.vHeight;
    int j = paramAVIOStruct.vWidth;
    int k = paramAVIOStruct.vFormat;
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength,height = " + i + ",width = " + j + ",imgFmt = " + k + ",data.length = " + paramArrayOfByte.length + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
    }
    switch (k)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 3,imgFmt  = " + k);
      }
      break;
    }
    do
    {
      do
      {
        return true;
        if (i * j * 2 == paramArrayOfByte.length) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 1 [Build.MODEL=" + Build.MODEL + "]");
      return true;
      if (i * j * 3 / 2 == paramArrayOfByte.length) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreviewContext", 2, "[@] checkPreviewDataLength error 2 [Build.MODEL=" + Build.MODEL + "]");
    return true;
    return false;
  }
  
  private native int getProcessedFrameData(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt);
  
  private native boolean initHwCallBack();
  
  private boolean initHwCallBackSecurity()
  {
    try
    {
      boolean bool = initHwCallBack();
      return bool;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  public void addUserBufferRecycle(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      anij.a().c(true, paramArrayOfByte);
    }
  }
  
  public void encodeOneFrameNotify()
  {
    SVHwEncoder localSVHwEncoder = (SVHwEncoder)this.mEncodeRef.get();
    if (localSVHwEncoder != null)
    {
      locala = localSVHwEncoder.b();
      if (locala == null) {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] encodeOneFrameNotify frame is null");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i;
      do
      {
        SVHwEncoder.a locala;
        return;
        int j = localSVHwEncoder.dGn;
        try
        {
          i = getProcessedFrameData(locala.data, this.mTimeStamp, j);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " colorspace=" + j);
          }
          if (i == 0)
          {
            locala.offset = 0;
            locala.size = locala.data.length;
            locala.time = this.mTimeStamp[0];
            locala.finish = false;
            locala.isVideo = true;
            localSVHwEncoder.a(locala, true);
            return;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            i = -1001;
          }
          this.mEncodeRef.getAndSet(null);
        }
      } while (!QLog.isColorLevel());
      QLog.d("PreviewContext", 2, "[@] HandleVideo: error=" + i + " set encode to null...");
      return;
    }
    QLog.d("PreviewContext", 2, "[@] HandleVideo: [encodeOneFrameNotify] encode=null");
  }
  
  public int getFrameIndex()
  {
    return this.mFrameIndex;
  }
  
  public void getPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PreviewContext", 2, "[@] onPreviewFrame start Build.MODEL=" + Build.MODEL + ", Build.CPU_ABI=" + Build.CPU_ABI + ", notifyFirstFrame=" + this.notifyFirstFrame);
    }
    int i;
    if (this.updateTime == 0L)
    {
      this.updateTime = SystemClock.uptimeMillis();
      this.frameCount = 0;
      if (NewFlowCameraActivity.Mr == 0L) {
        NewFlowCameraActivity.Mr = SystemClock.elapsedRealtime();
      }
      if (this.frameCount == 100)
      {
        paramCamera = new StringBuilder().append("fps = ");
        i = (int)(this.frameCount * 1000 / (SystemClock.uptimeMillis() - this.updateTime));
        this.fps = i;
        QLog.d("PreviewContext", 2, i);
        this.updateTime = 0L;
        this.frameCount = 0;
      }
      if (this.mCheckedDataValid) {
        break label248;
      }
      if (!anii.isFoundProductFeature(anii.KEY_HARDWARE_PRIVILEGE_ERROR_MODEL)) {
        break label240;
      }
      this.mDisablePrivilage = checkIsDisablePrivilage(paramArrayOfByte, 32);
      this.mCheckedDataValid = true;
      if (!this.mDisablePrivilage) {
        break label255;
      }
      this.mCamera.a.notify(12, new Object[] { "camera disabled zero data." });
    }
    label240:
    label248:
    while (this.mDisablePrivilage) {
      for (;;)
      {
        return;
        this.frameCount += 1;
        break;
        this.mDisablePrivilage = false;
      }
    }
    label255:
    if (paramArrayOfByte == null)
    {
      anij.a().PP(true);
      return;
    }
    this.mRecordToCache = 0;
    if (!this.mPTVRealBeauty) {
      sendFirstFrameMsg();
    }
    if (!this.mFrameSrcList.isEmpty()) {}
    for (;;)
    {
      Object localObject;
      try
      {
        paramCamera = (AVIOStruct)this.mFrameSrcList.get(this.mFrameSrcList.size() - 1);
        if (paramCamera != null)
        {
          if (!anit.cHa) {
            continue;
          }
          if (paramCamera.pControlFlag == ControlFlagEnum.NONE.getValue())
          {
            localObject = anij.a().c();
            i = anij.a().getPreviewFormat();
            paramCamera.vWidth = ((anij.b)localObject).width;
            paramCamera.vHeight = ((anij.b)localObject).height;
            paramCamera.vFormat = i;
            paramCamera.vOrientation = anij.a().JE();
            paramCamera.vFPS = aniq.dHc;
            paramCamera.pControlFlag = ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue();
            paramCamera.vBitrate = aniq.dHb;
            paramCamera.pCodec = aniq.mCodecId;
          }
        }
        else
        {
          if ((paramCamera == null) || (!paramCamera.isWriteFrame())) {
            break label728;
          }
          boolean bool = checkPreviewDataLength(paramCamera, paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] onPreviewFrame PreviewDataLength error : " + bool + " Build.MODEL=" + Build.MODEL + " Build.CPU_ABI=" + Build.CPU_ABI);
          }
          if (!bool) {
            continue;
          }
          this.mCamera.a.notify(8, new Object[] { "unacceptable camera preview data" });
          if (1 != aaqi.ciB) {
            break;
          }
          awed.ad(anhm.sUin + "", "qzone_video_record", "8", null);
          return;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramCamera)
      {
        paramCamera = null;
        continue;
        if (paramCamera.pControlFlag != ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) {
          continue;
        }
        paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA.getValue();
        continue;
        if (paramCamera.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue())
        {
          paramCamera.pControlFlag = ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue();
          continue;
        }
        if (paramCamera.pControlFlag != ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue()) {
          continue;
        }
        paramCamera.pControlFlag = ControlFlagEnum.NONE.getValue();
        continue;
        i = this.mFrameIndex;
        this.mFrameIndex = (i + 1);
        paramCamera.pFrameIndex = i;
        paramCamera.vFrameTime = SystemClock.elapsedRealtime();
        this.mWriteFrameCount += 1;
        this.mRecordToCache = 1;
        if (!this.mPTVRealBeauty)
        {
          this.mVideoFrameWrite.incrementAndGet();
          this.mAVCodec.copyQQBuf(paramArrayOfByte, paramCamera);
          QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new HandleVideo());
        }
      }
      label728:
      if (this.mPTVRealBeauty)
      {
        localObject = Message.obtain(this.mMsghandler);
        ((Message)localObject).what = -16716526;
        ((Message)localObject).arg1 = this.mRecordToCache;
        ((Message)localObject).arg2 = 1;
        ((Message)localObject).obj = paramArrayOfByte;
        if (this.mRecordToCache == 1)
        {
          a locala = new a();
          locala.data = paramArrayOfByte;
          locala.b = ((AVIOStruct)paramCamera.clone());
          ((Message)localObject).obj = locala;
          if (this.mMsghandler != null) {
            this.mMsghandler.sendMessage((Message)localObject);
          }
        }
      }
      for (;;)
      {
        label815:
        if (!QLog.isColorLevel()) {
          break label1007;
        }
        QLog.d("PreviewContext", 2, "[@] onPreviewFrame end,mFrameIndex  = " + this.mFrameIndex);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] mPTVRealBeauty: [Build.MODEL=" + Build.MODEL + "]  mMsghandler=" + this.mMsghandler);
        }
        paramCamera = anij.a().c();
        if (paramCamera == null) {
          break;
        }
        i = anij.a().getPreviewFormat();
        this.mPTVRealBeautyCache.vWidth = paramCamera.width;
        this.mPTVRealBeautyCache.vHeight = paramCamera.height;
        this.mPTVRealBeautyCache.vFormat = i;
        if (!checkPreviewDataLength(this.mPTVRealBeautyCache, paramArrayOfByte)) {
          break label815;
        }
        this.mCamera.a.notify(8, new Object[] { "unacceptable camera preview data" });
        return;
        anij.a().c(true, paramArrayOfByte);
      }
      label1007:
      break;
      paramCamera = null;
    }
  }
  
  public int getRemainedRecordFrames(int paramInt)
  {
    if (paramInt >= this.mFrameCountArray.size()) {
      return 0;
    }
    int j = this.mFrameIndex;
    int i = 0;
    while (i < paramInt)
    {
      j -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - (i + 1))).intValue();
      i += 1;
    }
    return j;
  }
  
  public int getSegmentCount()
  {
    if (this.mFrameSrcList != null) {
      return this.mFrameSrcList.size();
    }
    return 0;
  }
  
  public void lockFrameSync()
  {
    if (!this.mFrameProcessEnd)
    {
      synchronized (this.mlock)
      {
        boolean bool = this.mFrameProcessEnd;
        if (bool) {}
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync start wait");
        }
        this.mlock.wait(2000L);
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "lockFrameSync wait finish");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label63:
        break label63;
      }
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void removeLatestVideo()
  {
    if ((this.mFrameSrcList != null) && (this.mFrameSrcList.size() > 0)) {
      this.mFrameSrcList.remove(this.mFrameSrcList.size() - 1);
    }
    if (this.mFrameCountArray.size() > 0)
    {
      this.mFrameIndex -= ((Integer)this.mFrameCountArray.get(this.mFrameCountArray.size() - 1)).intValue();
      if (this.mFrameIndex <= 0) {
        this.mFrameIndex = 0;
      }
      this.mFrameCountArray.remove(this.mFrameCountArray.size() - 1);
      if (this.mFrameCountArray.size() == 0)
      {
        this.mFrameIndex = 0;
        this.mFrameSrcList.clear();
      }
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewContext", 2, "[@] reset");
    }
    if (this.mFrameSrcList != null) {
      this.mFrameSrcList.clear();
    }
    this.mFrameCountArray.clear();
    this.mBlockIndex = 0;
    this.mLastFrameIndex = 0;
    this.mWriteFrameCount = 0;
    this.mFrameIndex = 0;
  }
  
  public void sendFirstFrameMsg()
  {
    if ((this.notifyFirstFrame) && (this.mCamera != null))
    {
      this.mCamera.a.notify(10, new Object[] { "getted" });
      this.notifyFirstFrame = false;
    }
  }
  
  public void setFrameIndex(int paramInt)
  {
    this.mFrameIndex = paramInt;
  }
  
  public void startCapture()
  {
    if (!anit.cHa) {
      return;
    }
    if (this.mFrameSrcList == null) {
      this.mFrameSrcList = new ArrayList();
    }
    AVIOStruct localAVIOStruct = new AVIOStruct();
    int i = this.mBlockIndex;
    this.mBlockIndex = (i + 1);
    localAVIOStruct.pBlockIndex = i;
    this.mFrameSrcList.add(localAVIOStruct);
    this.mLastFrameIndex = this.mFrameIndex;
  }
  
  public void stopCapture()
  {
    this.mFrameCountArray.add(Integer.valueOf(this.mFrameIndex - this.mLastFrameIndex));
  }
  
  public void unlockFrameSync()
  {
    synchronized (this.mlock)
    {
      this.mFrameProcessEnd = true;
      this.mlock.notifyAll();
      if (QLog.isColorLevel()) {
        QLog.d("PreviewContext", 2, "unlockFrameSync notifyAll");
      }
      return;
    }
  }
  
  public class HandleVideo
    implements Runnable
  {
    public HandleVideo() {}
    
    public void run()
    {
      if ((SVHwEncoder)PreviewContext.this.mEncodeRef.get() != null) {
        if (PreviewContext.this.mInitHwEncode)
        {
          PreviewContext.this.mAVCodec.handleQQVideoFrameWithCallback();
          if (QLog.isColorLevel()) {
            QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoFrameWithCallback");
          }
        }
      }
      for (;;)
      {
        PreviewContext.this.mCamera.a.notify(7, new Object[] { Integer.valueOf(0) });
        PreviewContext.this.mVideoFrameProcess.incrementAndGet();
        return;
        PreviewContext.this.mAVCodec.handleQQVideoOneFrame();
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] HandleVideo: handleQQVideoOneFrame");
        }
        PreviewContext.this.encodeOneFrameNotify();
        continue;
        PreviewContext.this.mAVCodec.handleQQVideo();
        if (QLog.isColorLevel()) {
          QLog.d("PreviewContext", 2, "[@] HandleVideo: encode=null");
        }
      }
    }
  }
  
  public static class a
  {
    public AVIOStruct b;
    public byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext
 * JD-Core Version:    0.7.0.1
 */