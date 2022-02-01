package com.tencent.ttpic.openapi.util;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.FrameRateUtil.Operation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
@TargetApi(16)
public class GeneralFpsService
{
  private static FPSFrameCallback fpsFrameCallback = null;
  private static volatile boolean isStart = false;
  
  public static void addTag(FrameRateUtil.Operation paramOperation)
  {
    try
    {
      if (fpsFrameCallback != null) {
        fpsFrameCallback.addFpsTag(paramOperation);
      }
      return;
    }
    finally
    {
      paramOperation = finally;
      throw paramOperation;
    }
  }
  
  public static void removeTag(FrameRateUtil.Operation paramOperation)
  {
    try
    {
      if (fpsFrameCallback != null) {
        fpsFrameCallback.removeFpsTag(paramOperation);
      }
      return;
    }
    finally
    {
      paramOperation = finally;
      throw paramOperation;
    }
  }
  
  /* Error */
  public static void start()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 19	com/tencent/ttpic/openapi/util/GeneralFpsService:isStart	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 19	com/tencent/ttpic/openapi/util/GeneralFpsService:isStart	Z
    //   19: new 6	com/tencent/ttpic/openapi/util/GeneralFpsService$FPSFrameCallback
    //   22: dup
    //   23: aconst_null
    //   24: invokespecial 38	com/tencent/ttpic/openapi/util/GeneralFpsService$FPSFrameCallback:<init>	(Lcom/tencent/ttpic/openapi/util/GeneralFpsService$1;)V
    //   27: putstatic 21	com/tencent/ttpic/openapi/util/GeneralFpsService:fpsFrameCallback	Lcom/tencent/ttpic/openapi/util/GeneralFpsService$FPSFrameCallback;
    //   30: invokestatic 44	android/view/Choreographer:getInstance	()Landroid/view/Choreographer;
    //   33: getstatic 21	com/tencent/ttpic/openapi/util/GeneralFpsService:fpsFrameCallback	Lcom/tencent/ttpic/openapi/util/GeneralFpsService$FPSFrameCallback;
    //   36: invokevirtual 48	android/view/Choreographer:postFrameCallback	(Landroid/view/Choreographer$FrameCallback;)V
    //   39: goto -28 -> 11
    //   42: astore_1
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   42	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	42	finally
    //   15	39	42	finally
  }
  
  public static void stop()
  {
    try
    {
      if (fpsFrameCallback != null)
      {
        fpsFrameCallback.setEnabled(false);
        fpsFrameCallback.clearTags();
      }
      isStart = false;
      return;
    }
    finally {}
  }
  
  static class FPSFrameCallback
    implements Choreographer.FrameCallback
  {
    private boolean enabled = true;
    private List<FrameRateUtil.Operation> tagsList = new ArrayList();
    
    public void addFpsTag(FrameRateUtil.Operation paramOperation)
    {
      if (!this.tagsList.contains(paramOperation)) {
        this.tagsList.add(paramOperation);
      }
    }
    
    public void clearTags()
    {
      this.tagsList.clear();
    }
    
    public void doFrame(long paramLong)
    {
      if (!this.enabled) {
        return;
      }
      Iterator localIterator = this.tagsList.iterator();
      while (localIterator.hasNext())
      {
        FrameRateUtil.Operation localOperation = (FrameRateUtil.Operation)localIterator.next();
        if (localOperation == FrameRateUtil.Operation.CAMERA)
        {
          if (TextUtils.isEmpty(DeviceAttrs.getInstance().str_videoPreview720Fps)) {
            FrameRateUtil.getInstance(localOperation).recordFps(true);
          } else {
            FrameRateUtil.getInstance(localOperation).recordFps(false);
          }
        }
        else {
          FrameRateUtil.getInstance(localOperation).recordFps(false);
        }
      }
      Choreographer.getInstance().postFrameCallback(this);
    }
    
    public void removeFpsTag(FrameRateUtil.Operation paramOperation)
    {
      this.tagsList.remove(paramOperation);
    }
    
    public void setEnabled(boolean paramBoolean)
    {
      this.enabled = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.GeneralFpsService
 * JD-Core Version:    0.7.0.1
 */