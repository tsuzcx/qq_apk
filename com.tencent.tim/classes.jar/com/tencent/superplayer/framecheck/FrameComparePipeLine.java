package com.tencent.superplayer.framecheck;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.superplayer.utils.BitmapHashUtil;
import com.tencent.superplayer.utils.LogUtil;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class FrameComparePipeLine
{
  public static final int BLACK_SCREEN_HASH = -2;
  public static final int HAMMING_DISTANCE_LIMIT = 0;
  private static final String TAG = "SuperPlayer-.FrameComparePipeLine";
  private Handler mHandler;
  private HandlerThread mHandlerThread = new HandlerThread("FrameComparePipeLine");
  private OnVideoFrameCheckListener mOnVideoFrameCheckListener = null;
  private Queue<VideoFrameCaptureTask> mQueue = new ArrayDeque();
  private Random mRandom = new Random();
  private List<TaskResult> mTaskResultList = new ArrayList();
  
  public FrameComparePipeLine()
  {
    this.mHandlerThread.start();
    this.mHandler = new Handler(this.mHandlerThread.getLooper());
  }
  
  private boolean checkBitmapIsColor(Bitmap paramBitmap, int paramInt)
  {
    int j = Math.min(Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()), 32);
    int i = 0;
    while (i < j)
    {
      if (paramBitmap.getPixel(i, this.mRandom.nextInt(j)) != paramInt) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int checkTaskResultList()
  {
    Iterator localIterator = this.mTaskResultList.iterator();
    Object localObject = null;
    int i = 1;
    int k = 1;
    int j = 1;
    TaskResult localTaskResult;
    if (localIterator.hasNext())
    {
      localTaskResult = (TaskResult)localIterator.next();
      if ((j != 0) && (localTaskResult.isBlack))
      {
        j = 1;
        label56:
        if ((k == 0) || (!localTaskResult.isTransparent)) {
          break label109;
        }
        k = 1;
        label70:
        if (localObject == null) {
          break label139;
        }
        if ((i == 0) || (BitmapHashUtil.hammingDistance(localTaskResult.pHash, localObject.pHash) > 0)) {
          break label114;
        }
        i = 1;
      }
    }
    label139:
    for (;;)
    {
      localObject = localTaskResult;
      break;
      j = 0;
      break label56;
      label109:
      k = 0;
      break label70;
      label114:
      i = 0;
      continue;
      if (k != 0) {
        return 1;
      }
      if (j != 0) {
        return 2;
      }
      if (i != 0) {
        return 3;
      }
      return 0;
    }
  }
  
  private void fetchOneTaskAndRun()
  {
    VideoFrameCaptureTask localVideoFrameCaptureTask = (VideoFrameCaptureTask)this.mQueue.poll();
    boolean bool = this.mQueue.isEmpty();
    if (localVideoFrameCaptureTask != null) {
      this.mHandler.postDelayed(new FrameComparePipeLine.2(this, localVideoFrameCaptureTask, bool), localVideoFrameCaptureTask.getTaskDelay());
    }
  }
  
  private String getResultListStr()
  {
    StringBuilder localStringBuilder = new StringBuilder("mTaskResultList:");
    Iterator localIterator = this.mTaskResultList.iterator();
    while (localIterator.hasNext())
    {
      TaskResult localTaskResult = (TaskResult)localIterator.next();
      localStringBuilder.append("\n").append(localTaskResult);
    }
    return localStringBuilder.toString();
  }
  
  private void innerHandleTask(VideoFrameCaptureTask paramVideoFrameCaptureTask, boolean paramBoolean)
  {
    runTask(paramVideoFrameCaptureTask);
    fetchOneTaskAndRun();
    if (paramVideoFrameCaptureTask.isEndTask)
    {
      i = checkTaskResultList();
      LogUtil.d("SuperPlayer-.FrameComparePipeLine", "checkTaskResultList resultCode:" + i + "\n" + getResultListStr());
      if (this.mOnVideoFrameCheckListener != null) {
        this.mOnVideoFrameCheckListener.onVideoFrameCheckResult(i);
      }
    }
    while (!paramBoolean)
    {
      int i;
      return;
    }
    LogUtil.w("SuperPlayer-.FrameComparePipeLine", "No end task, when mQueue is empty.");
  }
  
  private void onTaskException()
  {
    this.mTaskResultList.clear();
  }
  
  private void runTask(VideoFrameCaptureTask paramVideoFrameCaptureTask)
  {
    Bitmap localBitmap = paramVideoFrameCaptureTask.doTask();
    if (localBitmap == null) {
      onTaskException();
    }
    for (;;)
    {
      return;
      TaskResult localTaskResult = new TaskResult();
      if (checkBitmapIsColor(localBitmap, 0))
      {
        LogUtil.d("SuperPlayer-.FrameComparePipeLine", "checkTransparentBitmap unPass, " + paramVideoFrameCaptureTask);
        localTaskResult.isTransparent = true;
      }
      try
      {
        localTaskResult.pHash = BitmapHashUtil.dctImageHash(localBitmap, true);
        if (BitmapHashUtil.hammingDistance(-2L, localTaskResult.pHash) == 0)
        {
          LogUtil.d("SuperPlayer-.FrameComparePipeLine", "checkBlackBitmap unPass, " + paramVideoFrameCaptureTask);
          localTaskResult.isBlack = true;
        }
        this.mTaskResultList.add(localTaskResult);
        if (localBitmap.isRecycled()) {
          continue;
        }
        localBitmap.recycle();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtil.e("SuperPlayer-.FrameComparePipeLine", "dctImageHash exception", localIOException);
        }
      }
    }
  }
  
  public void addTask(VideoFrameCaptureTask paramVideoFrameCaptureTask)
  {
    if ((paramVideoFrameCaptureTask instanceof FirstFrameCaptureTask))
    {
      ArrayList localArrayList = new ArrayList(this.mQueue);
      this.mQueue.clear();
      this.mQueue.add(paramVideoFrameCaptureTask);
      this.mQueue.addAll(localArrayList);
      return;
    }
    this.mQueue.add(paramVideoFrameCaptureTask);
  }
  
  public void release()
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.mHandlerThread.quitSafely();
      return;
    }
    this.mHandlerThread.quit();
  }
  
  public void reset()
  {
    this.mHandler.removeCallbacks(null);
    this.mQueue.clear();
    this.mHandler.post(new FrameComparePipeLine.1(this));
  }
  
  public void setOnVideoFrameCheckListener(OnVideoFrameCheckListener paramOnVideoFrameCheckListener)
  {
    this.mOnVideoFrameCheckListener = paramOnVideoFrameCheckListener;
  }
  
  public void start()
  {
    LogUtil.d("SuperPlayer-.FrameComparePipeLine", "start");
    fetchOneTaskAndRun();
  }
  
  public void stop()
  {
    reset();
  }
  
  public static abstract interface OnVideoFrameCheckListener
  {
    public abstract void onVideoFrameCheckResult(int paramInt);
  }
  
  class TaskResult
  {
    public static final int BLACK_SCREEN = 2;
    public static final int FRAME_SAME = 3;
    public static final int TASK_PASS = 0;
    public static final int TEXTUREVIEW_NOT_AVAILABLE = 5;
    public static final int TEXTUREVIEW_NULL = 4;
    public static final int TRANS_SCREEN = 1;
    public boolean isBlack;
    public boolean isTransparent;
    public long pHash;
    
    TaskResult() {}
    
    public String toString()
    {
      return "TaskResult{isBlack=" + this.isBlack + ", isTransparent=" + this.isTransparent + ", pHash=" + this.pHash + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FrameComparePipeLine
 * JD-Core Version:    0.7.0.1
 */