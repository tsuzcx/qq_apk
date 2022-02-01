package com.tencent.component.media.image;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MessageQueueDecodeMultiplexTask
  extends ImageTask
{
  private static final int MSG_CHECK_SAME_IMAGE_TASK = 1000;
  private static final int MSG_RETRY = 2;
  private static final int MSG_SET_RESULT = 1;
  private static HashMap<Integer, LinkedList<MessageQueueDecodeMultiplexTask>> mDecodeImageTaskQueue = new HashMap();
  private static Handler mDispatcher;
  private static int mObjectPoolSize;
  private static boolean needRetry = false;
  private static MessageQueueDecodeMultiplexTask sPool;
  private static final Object sPoolSync;
  private MessageQueueDecodeMultiplexTask next = null;
  
  static
  {
    mDispatcher = null;
    if (ImageManagerEnv.g().getDispatcher() != null) {}
    HandlerThread localHandlerThread;
    for (mDispatcher = new ImageDecodeMultiplexHandler(ImageManagerEnv.g().getDispatcher());; mDispatcher = new ImageDecodeMultiplexHandler(localHandlerThread.getLooper()))
    {
      sPool = null;
      sPoolSync = new Object();
      mObjectPoolSize = 0;
      clearAndInitSize();
      return;
      localHandlerThread = new HandlerThread("ImageDecodeMultiplexThread");
      localHandlerThread.start();
    }
  }
  
  private MessageQueueDecodeMultiplexTask(ImageTask paramImageTask)
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
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = new MessageQueueDecodeMultiplexTask(null);
        localMessageQueueDecodeMultiplexTask.next = sPool;
        sPool = localMessageQueueDecodeMultiplexTask;
        mObjectPoolSize += 1;
        i += 1;
      }
      return;
    }
  }
  
  private static MessageQueueDecodeMultiplexTask getNextSameDecodeImageTask(int paramInt)
  {
    Object localObject = null;
    MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = null;
    LinkedList localLinkedList = (LinkedList)mDecodeImageTaskQueue.get(Integer.valueOf(paramInt));
    if (localLinkedList != null)
    {
      localObject = localMessageQueueDecodeMultiplexTask;
      while (localLinkedList.size() > 0)
      {
        localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)localLinkedList.removeFirst();
        localObject = localMessageQueueDecodeMultiplexTask;
        if (localMessageQueueDecodeMultiplexTask != null) {
          localObject = localMessageQueueDecodeMultiplexTask;
        }
      }
    }
    if (localObject == null) {
      mDecodeImageTaskQueue.remove(Integer.valueOf(paramInt));
    }
    return localObject;
  }
  
  private static boolean hasSameDecodeImageTask(MessageQueueDecodeMultiplexTask paramMessageQueueDecodeMultiplexTask)
  {
    if (paramMessageQueueDecodeMultiplexTask.getImageKey() == null) {
      return true;
    }
    int i = paramMessageQueueDecodeMultiplexTask.getImageKey().hashCodeEx();
    LinkedList localLinkedList = (LinkedList)mDecodeImageTaskQueue.get(Integer.valueOf(i));
    if (localLinkedList == null)
    {
      paramMessageQueueDecodeMultiplexTask = new LinkedList();
      mDecodeImageTaskQueue.put(Integer.valueOf(i), paramMessageQueueDecodeMultiplexTask);
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      localLinkedList.addLast(paramMessageQueueDecodeMultiplexTask);
    }
  }
  
  public static MessageQueueDecodeMultiplexTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask = sPool;
        sPool = sPool.next;
        localMessageQueueDecodeMultiplexTask.next = null;
        mObjectPoolSize -= 1;
        localMessageQueueDecodeMultiplexTask.setImageTask(paramImageTask);
        return localMessageQueueDecodeMultiplexTask;
      }
      return new MessageQueueDecodeMultiplexTask(paramImageTask);
    }
  }
  
  private static List<MessageQueueDecodeMultiplexTask> removeSameDecodeImageTask(int paramInt)
  {
    return (List)mDecodeImageTaskQueue.remove(Integer.valueOf(paramInt));
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
    ImageTracer.end(getImageKey().url);
    switch (paramInt)
    {
    case 10: 
    case 12: 
    default: 
      setResult(paramInt, paramVarArgs);
    }
    do
    {
      return;
      paramVarArgs = mDispatcher.obtainMessage();
      paramVarArgs.what = 13;
      paramVarArgs.obj = new Object[] { this };
      paramVarArgs.sendToTarget();
      return;
      Message localMessage = mDispatcher.obtainMessage();
      localMessage.what = 11;
      localMessage.obj = new Object[] { this, paramVarArgs[0] };
      localMessage.sendToTarget();
      return;
      localMessage = mDispatcher.obtainMessage();
      localMessage.what = 8;
      localMessage.obj = new Object[] { this, paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5] };
      localMessage.sendToTarget();
      return;
    } while (needRetry);
    paramVarArgs = mDispatcher.obtainMessage();
    paramVarArgs.what = 9;
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
  
  static class ImageDecodeMultiplexHandler
    extends Handler
  {
    public ImageDecodeMultiplexHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject1;
      Object localObject2;
      switch (paramMessage.what)
      {
      default: 
      case 1000: 
      case 13: 
      case 11: 
      case 8: 
        MessageQueueDecodeMultiplexTask localMessageQueueDecodeMultiplexTask;
        do
        {
          do
          {
            do
            {
              return;
              paramMessage = (MessageQueueDecodeMultiplexTask)paramMessage.obj;
            } while (MessageQueueDecodeMultiplexTask.hasSameDecodeImageTask(paramMessage));
            ImageManager.getInstance().imageKeyFilePathCheck(paramMessage.getImageKey());
            if (paramMessage.getNextTask() != null)
            {
              ImageTracer.start(paramMessage.getImageKey().url);
              paramMessage.getNextTask().excuteTask();
              return;
            }
            localObject1 = paramMessage.getImageKey();
            if ((localObject1 != null) && (((ImageKey)localObject1).options != null)) {
              ((ImageKey)localObject1).options.errCode = ImageManager.getErrorString((ImageKey)localObject1, 700);
            }
            paramMessage.setResult(9, new Object[0]);
            return;
            paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
          } while ((paramMessage == null) || (paramMessage.getImageKey() == null));
          localObject1 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(paramMessage.getImageKey().hashCodeEx());
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageQueueDecodeMultiplexTask)((Iterator)localObject1).next();
              if ((localObject2 != null) && (((MessageQueueDecodeMultiplexTask)localObject2).isCanceled()))
              {
                ((MessageQueueDecodeMultiplexTask)localObject2).setResult(13, new Object[0]);
              }
              else if ((localObject2 != null) && (!((MessageQueueDecodeMultiplexTask)localObject2).isCanceled()) && (!MessageQueueDecodeMultiplexTask.hasSameDecodeImageTask((MessageQueueDecodeMultiplexTask)localObject2)))
              {
                ImageManager.getInstance().imageKeyFilePathCheck(((MessageQueueDecodeMultiplexTask)localObject2).getImageKey());
                if (((MessageQueueDecodeMultiplexTask)localObject2).getNextTask() != null)
                {
                  ImageTracer.start(((MessageQueueDecodeMultiplexTask)localObject2).getImageKey().url);
                  ((MessageQueueDecodeMultiplexTask)localObject2).getNextTask().excuteTask();
                }
                else
                {
                  ((MessageQueueDecodeMultiplexTask)localObject2).setResult(9, new Object[0]);
                }
              }
            }
          }
          ImageManagerLog.d("MessageQueueDecodeMultiplexTask", "decode cancel, url = " + paramMessage.getImageKey().url);
          return;
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
          localObject2 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
              if (localMessageQueueDecodeMultiplexTask != null) {
                localMessageQueueDecodeMultiplexTask.setResult(11, new Object[] { paramMessage[1] });
              }
            }
          }
          ((MessageQueueDecodeMultiplexTask)localObject1).setResult(11, new Object[] { paramMessage[1] });
          return;
          paramMessage = (Object[])paramMessage.obj;
          localObject1 = (MessageQueueDecodeMultiplexTask)paramMessage[0];
        } while ((localObject1 == null) || (((MessageQueueDecodeMultiplexTask)localObject1).getImageKey() == null));
        ProgressTracer.print(4, ((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().urlKey);
        localObject2 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(((MessageQueueDecodeMultiplexTask)localObject1).getImageKey().hashCodeEx());
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localMessageQueueDecodeMultiplexTask = (MessageQueueDecodeMultiplexTask)((Iterator)localObject2).next();
            if (localMessageQueueDecodeMultiplexTask != null) {
              localMessageQueueDecodeMultiplexTask.setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
            }
          }
        }
        ((MessageQueueDecodeMultiplexTask)localObject1).setResult(8, new Object[] { paramMessage[1], paramMessage[2], paramMessage[3], paramMessage[4], paramMessage[5], paramMessage[6] });
        return;
      }
      paramMessage = (MessageQueueDecodeMultiplexTask)((Object[])(Object[])paramMessage.obj)[0];
      if ((paramMessage != null) && (paramMessage.getImageKey() != null))
      {
        ProgressTracer.print(1002, paramMessage.getImageKey().url);
        localObject1 = MessageQueueDecodeMultiplexTask.removeSameDecodeImageTask(paramMessage.getImageKey().hashCodeEx());
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageQueueDecodeMultiplexTask)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((MessageQueueDecodeMultiplexTask)localObject2).setResult(9, new Object[0]);
            }
          }
        }
      }
      paramMessage.setResult(9, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.MessageQueueDecodeMultiplexTask
 * JD-Core Version:    0.7.0.1
 */