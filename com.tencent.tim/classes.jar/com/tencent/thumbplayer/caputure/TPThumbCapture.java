package com.tencent.thumbplayer.caputure;

import android.util.Log;
import com.tencent.thumbplayer.adapter.player.ITPCapture;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.HashMap;
import java.util.Map;

public class TPThumbCapture
  implements ITPCapture, ITPImageGeneratorCallback
{
  private static final String TAG = "TPThumbPlayer[TPThumbCapture.java]";
  private Map<Long, TPCaptureCallBack> mCallBackMap;
  private TPImageGenerator mImageGenerator;
  private long mOpaque = 0L;
  
  public TPThumbCapture(int paramInt)
  {
    this.mImageGenerator = new TPImageGenerator(paramInt, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.mImageGenerator.init();
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(localException));
    }
  }
  
  public TPThumbCapture(String paramString)
  {
    this.mImageGenerator = new TPImageGenerator(paramString, this);
    this.mCallBackMap = new HashMap();
    try
    {
      this.mImageGenerator.init();
      return;
    }
    catch (Exception paramString)
    {
      TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(paramString));
    }
  }
  
  public void generateImageAsyncAtTime(long paramLong, TPImageGeneratorParams paramTPImageGeneratorParams, TPCaptureCallBack paramTPCaptureCallBack)
  {
    if (paramTPImageGeneratorParams == null) {
      try
      {
        paramTPImageGeneratorParams = new TPImageGeneratorParams();
        paramTPImageGeneratorParams.format = 37;
        for (;;)
        {
          this.mOpaque += 1L;
          this.mCallBackMap.put(Long.valueOf(this.mOpaque), paramTPCaptureCallBack);
          try
          {
            this.mImageGenerator.generateImageAsyncAtTime(paramLong, this.mOpaque, paramTPImageGeneratorParams);
            return;
          }
          catch (Exception paramTPImageGeneratorParams)
          {
            for (;;)
            {
              TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(paramTPImageGeneratorParams));
            }
          }
        }
      }
      finally {}
    }
  }
  
  public void onImageGenerationCompleted(int paramInt, long paramLong1, long paramLong2, long paramLong3, TPVideoFrame paramTPVideoFrame)
  {
    TPCaptureCallBack localTPCaptureCallBack = (TPCaptureCallBack)this.mCallBackMap.get(Long.valueOf(paramLong3));
    if (localTPCaptureCallBack != null)
    {
      if ((paramInt != 0) || (paramTPVideoFrame == null)) {
        break label82;
      }
      paramTPVideoFrame = TPCaptureUtils.frame2Bitmap(paramTPVideoFrame);
      if (paramTPVideoFrame == null) {
        break label70;
      }
      localTPCaptureCallBack.onCaptureVideoSuccess(paramTPVideoFrame);
    }
    for (;;)
    {
      this.mCallBackMap.remove(Long.valueOf(paramLong3));
      return;
      label70:
      localTPCaptureCallBack.onCaptureVideoFailed(1000001);
      continue;
      label82:
      localTPCaptureCallBack.onCaptureVideoFailed(paramInt);
    }
  }
  
  public void release()
  {
    try
    {
      this.mImageGenerator.cancelAllImageGenerations();
      this.mImageGenerator.unInit();
      this.mCallBackMap.clear();
      this.mImageGenerator = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TPLogUtil.e("TPThumbPlayer[TPThumbCapture.java]", "release: " + Log.getStackTraceString(localException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPThumbCapture
 * JD-Core Version:    0.7.0.1
 */