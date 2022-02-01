package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MessageQueueDownloadMultiplexTask
  extends ImageTask
{
  private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
  private static Handler mDispatcher;
  private static HashMap<String, LinkedList<MessageQueueDownloadMultiplexTask>> mDownloadImageTaskQueue = new HashMap();
  private static int mObjectPoolSize;
  private static boolean needRetry = false;
  private static MessageQueueDownloadMultiplexTask sPool;
  private static final Object sPoolSync;
  private MessageQueueDownloadMultiplexTask next = null;
  
  static
  {
    mDispatcher = null;
    HandlerThread localHandlerThread;
    if (ImageManagerEnv.g().getDispatcher() == null)
    {
      localHandlerThread = new HandlerThread("ImageDownloadMultiplexThread");
      localHandlerThread.start();
    }
    for (mDispatcher = new ImageDownloadMultiplexHandler(localHandlerThread.getLooper());; mDispatcher = new ImageDownloadMultiplexHandler(ImageManagerEnv.g().getDispatcher()))
    {
      sPool = null;
      sPoolSync = new Object();
      mObjectPoolSize = 0;
      clearAndInitSize();
      return;
    }
  }
  
  private MessageQueueDownloadMultiplexTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearAndInitSize()
  {
    synchronized (sPoolSync)
    {
      sPool = null;
      int i = 0;
      while (i < mInitAllocatedSize)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = new MessageQueueDownloadMultiplexTask(null);
        localMessageQueueDownloadMultiplexTask.next = sPool;
        sPool = localMessageQueueDownloadMultiplexTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  private static MessageQueueDownloadMultiplexTask getNextSameDownloadImageTask(String paramString)
  {
    Object localObject = null;
    MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = null;
    LinkedList localLinkedList = (LinkedList)mDownloadImageTaskQueue.get(paramString);
    if (localLinkedList != null)
    {
      localObject = localMessageQueueDownloadMultiplexTask;
      while (localLinkedList.size() > 0)
      {
        localMessageQueueDownloadMultiplexTask = (MessageQueueDownloadMultiplexTask)localLinkedList.removeFirst();
        localObject = localMessageQueueDownloadMultiplexTask;
        if (localMessageQueueDownloadMultiplexTask != null) {
          localObject = localMessageQueueDownloadMultiplexTask;
        }
      }
    }
    if (localObject == null) {
      mDownloadImageTaskQueue.remove(paramString);
    }
    return localObject;
  }
  
  private static boolean hasSameDownloadImageTask(MessageQueueDownloadMultiplexTask paramMessageQueueDownloadMultiplexTask)
  {
    String str = paramMessageQueueDownloadMultiplexTask.getImageKey().urlKey;
    LinkedList localLinkedList = (LinkedList)mDownloadImageTaskQueue.get(str);
    if (localLinkedList == null)
    {
      paramMessageQueueDownloadMultiplexTask = new LinkedList();
      mDownloadImageTaskQueue.put(str, paramMessageQueueDownloadMultiplexTask);
      return false;
    }
    localLinkedList.addLast(paramMessageQueueDownloadMultiplexTask);
    return true;
  }
  
  public static MessageQueueDownloadMultiplexTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        MessageQueueDownloadMultiplexTask localMessageQueueDownloadMultiplexTask = sPool;
        sPool = sPool.next;
        localMessageQueueDownloadMultiplexTask.next = null;
        mObjectPoolSize -= 1;
        localMessageQueueDownloadMultiplexTask.setImageTask(paramImageTask);
        return localMessageQueueDownloadMultiplexTask;
      }
      return new MessageQueueDownloadMultiplexTask(paramImageTask);
    }
  }
  
  private static List<MessageQueueDownloadMultiplexTask> removeSameDownloadImageTask(String paramString)
  {
    return (List)mDownloadImageTaskQueue.remove(paramString);
  }
  
  public void excuteTask()
  {
    Message localMessage = mDispatcher.obtainMessage();
    localMessage.what = 1000;
    localMessage.obj = this;
    localMessage.sendToTarget();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    if (!getImageKey().needDecode()) {
      ImageTracer.end(getImageKey().url);
    }
    Message localMessage;
    switch (paramInt)
    {
    default: 
      setResult(paramInt, paramVarArgs);
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
        } while (needRetry);
        localMessage = mDispatcher.obtainMessage();
        localMessage.what = 0;
        localMessage.obj = new Object[] { this, paramVarArgs[0] };
        localMessage.sendToTarget();
        return;
      } while (needRetry);
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    case 2: 
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 2;
      localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2] };
      localMessage.sendToTarget();
      return;
    case 11: 
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 11;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
    }
    paramVarArgs = mDispatcher.obtainMessage();
    paramVarArgs.what = 12;
    paramVarArgs.obj = new Object[] { this };
    paramVarArgs.sendToTarget();
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
  
  static class ImageDownloadMultiplexHandler
    extends Handler
  {
    public ImageDownloadMultiplexHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject2;
      ImageTask localImageTask;
      switch (paramMessage.what)
      {
      default: 
      case 1000: 
      case 0: 
      case 1: 
      case 2: 
        do
        {
          do
          {
            return;
            paramMessage = (MessageQueueDownloadMultiplexTask)paramMessage.obj;
          } while (MessageQueueDownloadMultiplexTask.hasSameDownloadImageTask(paramMessage));
          if (paramMessage.getNextTask() != null)
          {
            if (!paramMessage.getImageKey().needDecode()) {
              ImageTracer.start(paramMessage.getImageKey().url);
            }
            paramMessage.getNextTask().excuteTask();
            return;
          }
          paramMessage.setResult(1, new Object[] { paramMessage.getImageKey().url });
          return;
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
          localObject2 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localImageTask = (ImageTask)((Iterator)localObject2).next();
              if (localImageTask != null) {
                localImageTask.setResult(0, new Object[] { paramMessage[1] });
              }
            }
          }
          ((MessageQueueDownloadMultiplexTask)localObject1).setResult(0, new Object[] { paramMessage[1] });
          return;
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
          localObject2 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localImageTask = (ImageTask)((Iterator)localObject2).next();
              if (localImageTask != null) {
                localImageTask.setResult(1, new Object[] { paramMessage[1] });
              }
            }
          }
          ((MessageQueueDownloadMultiplexTask)localObject1).setResult(1, new Object[] { paramMessage[1] });
          return;
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
        } while ((localObject1 == null) || (((MessageQueueDownloadMultiplexTask)localObject1).getImageKey() == null));
        localObject2 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localImageTask = (ImageTask)((Iterator)localObject2).next();
            if (localImageTask != null) {
              localImageTask.setResult(2, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3] });
            }
          }
        }
        ((MessageQueueDownloadMultiplexTask)localObject1).setResult(2, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3] });
        return;
      case 11: 
        paramMessage = (Object[])paramMessage.obj;
        localObject1 = (MessageQueueDownloadMultiplexTask)paramMessage[0];
        localObject2 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(((MessageQueueDownloadMultiplexTask)localObject1).getImageKey().urlKey);
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localImageTask = (ImageTask)((Iterator)localObject2).next();
            if (localImageTask != null) {
              localImageTask.setResult(11, new Object[] { paramMessage[1] });
            }
          }
        }
        ((MessageQueueDownloadMultiplexTask)localObject1).setResult(11, new Object[] { paramMessage[1] });
        return;
      }
      paramMessage = (MessageQueueDownloadMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
      Object localObject1 = MessageQueueDownloadMultiplexTask.removeSameDownloadImageTask(paramMessage.getImageKey().urlKey);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ImageTask)((Iterator)localObject1).next();
          if (localObject2 != null) {
            ((ImageTask)localObject2).setResult(12, new Object[0]);
          }
        }
      }
      paramMessage.setResult(12, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDownloadMultiplexTask
 * JD-Core Version:    0.7.0.1
 */