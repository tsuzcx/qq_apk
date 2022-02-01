package com.tencent.qapmsdk.dropframe;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.qapmsdk.base.listener.IMonitorListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import java.util.Arrays;

@TargetApi(16)
public class DropFrameMonitor
  extends QAPMMonitorPlugin
{
  private static final int DROP_0 = 0;
  private static final int DROP_1 = 1;
  private static final int DROP_LESS_15 = 15;
  private static final int DROP_LESS_4 = 4;
  private static final int DROP_LESS_8 = 8;
  private static final int DROP_RANGE_0 = 0;
  private static final int DROP_RANGE_1 = 1;
  private static final int DROP_RANGE_2_4 = 2;
  private static final int DROP_RANGE_4_8 = 3;
  private static final int DROP_RANGE_8_15 = 4;
  private static final int DROP_RANGE_OVER_15 = 5;
  private static final long FRAME_INTERVAL_NANOS = 16666667L;
  private static final double MAX_DURATION = 1.E-009D;
  private static final int MSG_ON_FRAME_RENDERED = 1;
  private static final String TAG = "QAPM_dropframe_DropFrameMonitor";
  private static String currentScene = "";
  static DropFrameMonitor dropFrameMonitor;
  private static volatile DropFrameMonitor instance;
  private static boolean isStarted = false;
  @Nullable
  private Handler calHandler;
  private Choreographer choreographer;
  @NonNull
  private DropFrameResultMeta dropItem = new DropFrameResultMeta();
  @Nullable
  private Choreographer.FrameCallback fpsMeasuringCallback;
  private long lastFrameTimeNs = 0L;
  
  private DropFrameMonitor()
  {
    if (!AndroidVersion.isJellyBean()) {
      return;
    }
    this.choreographer = Choreographer.getInstance();
    this.calHandler = new Handler(ThreadManager.getMonitorThreadLooper(), new DropFrameMonitor.1(this));
    this.fpsMeasuringCallback = new DropFrameMonitor.2(this);
  }
  
  private DropFrameMonitor(boolean paramBoolean) {}
  
  private boolean checkValidData(DropFrameResultMeta paramDropFrameResultMeta)
  {
    if ((paramDropFrameResultMeta.dropCount < 0) || (paramDropFrameResultMeta.duration <= 1.E-009D)) {}
    long l1;
    label65:
    do
    {
      return false;
      paramDropFrameResultMeta = paramDropFrameResultMeta.dropIntervals;
      int j = paramDropFrameResultMeta.length;
      int i = 0;
      l1 = 0L;
      for (;;)
      {
        if (i >= j) {
          break label65;
        }
        long l2 = paramDropFrameResultMeta[i];
        if (l2 < 0L) {
          break;
        }
        l1 += l2;
        i += 1;
      }
    } while (l1 <= 0L);
    return true;
  }
  
  /* Error */
  public static DropFrameMonitor getInstance()
  {
    // Byte code:
    //   0: getstatic 150	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 150	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/qapmsdk/dropframe/DropFrameMonitor
    //   20: dup
    //   21: invokespecial 151	com/tencent/qapmsdk/dropframe/DropFrameMonitor:<init>	()V
    //   24: putstatic 150	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 150	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   33: areturn
    //   34: astore_0
    //   35: new 2	com/tencent/qapmsdk/dropframe/DropFrameMonitor
    //   38: dup
    //   39: iconst_1
    //   40: invokespecial 153	com/tencent/qapmsdk/dropframe/DropFrameMonitor:<init>	(Z)V
    //   43: putstatic 150	com/tencent/qapmsdk/dropframe/DropFrameMonitor:instance	Lcom/tencent/qapmsdk/dropframe/DropFrameMonitor;
    //   46: goto -19 -> 27
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localDropFrameMonitor	DropFrameMonitor
    //   34	1	0	localThrowable	Throwable
    //   49	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	27	34	java/lang/Throwable
    //   9	13	49	finally
    //   17	27	49	finally
    //   27	30	49	finally
    //   35	46	49	finally
    //   50	53	49	finally
  }
  
  private int getRangeIndex(int paramInt)
  {
    int i = 1;
    if (paramInt <= 0) {
      i = 0;
    }
    while (paramInt == 1) {
      return i;
    }
    if (paramInt < 4) {
      return 2;
    }
    if (paramInt < 8) {
      return 3;
    }
    if (paramInt < 15) {
      return 4;
    }
    return 5;
  }
  
  private boolean preMonitorScene()
  {
    if ((this.choreographer == null) || (isStarted)) {
      return false;
    }
    this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
    this.choreographer.postFrameCallback(this.fpsMeasuringCallback);
    isStarted = true;
    return true;
  }
  
  public void beginDropFrameScene(String paramString)
  {
    if (preMonitorScene())
    {
      if (!TextUtils.isEmpty(paramString)) {
        currentScene = paramString;
      }
    }
    else {
      return;
    }
    currentScene = ActivityInfo.getCurrentActivityName();
  }
  
  public void start()
  {
    new Handler(Looper.getMainLooper()).post(new DropFrameRunnable());
  }
  
  public void stop()
  {
    if ((this.choreographer == null) || (!isStarted)) {
      return;
    }
    this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
    this.choreographer = null;
  }
  
  public void stopDropFrameScene()
  {
    if (this.choreographer == null) {
      return;
    }
    try
    {
      this.choreographer.removeFrameCallback(this.fpsMeasuringCallback);
      this.lastFrameTimeNs = 0L;
      if ("".equals(currentScene))
      {
        Object localObject = ActivityInfo.getCurrentActivityName();
        if (!checkValidData(this.dropItem)) {
          break label220;
        }
        Logger.INSTANCE.i(new String[] { "QAPM_dropframe_DropFrameMonitor", "DropFrame, scene: ", localObject, ", state: ", String.valueOf(this.dropItem.state), " , duration: ", Float.toString(this.dropItem.duration), " , dropCount: ", Arrays.toString(this.dropItem.dropIntervals) });
        this.dropItem.scene = currentScene;
        localObject = ListenerManager.monitorListener;
        if (localObject != null) {
          ((IMonitorListener)localObject).onMetaGet(this.dropItem);
        }
        localObject = new InsertRunnable(BaseInfo.userMeta.uin, currentScene, this.dropItem);
        this.calHandler.post((Runnable)localObject);
        currentScene = "";
        isStarted = false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_dropframe_DropFrameMonitor", localThrowable);
        continue;
        String str = currentScene;
        continue;
        label220:
        this.dropItem.reset();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.dropframe.DropFrameMonitor
 * JD-Core Version:    0.7.0.1
 */