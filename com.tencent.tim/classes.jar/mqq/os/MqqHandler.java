package mqq.os;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import java.util.concurrent.atomic.AtomicInteger;

public class MqqHandler
  implements IMqqMessageCallback
{
  private static boolean isEnableInited;
  private static boolean isMqqHandlerEnable;
  public static AtomicInteger sInjectCount = new AtomicInteger(0);
  public static MqqRegulatorCallback sRegulatorCallback;
  boolean beInjected = false;
  boolean beRegulatoring = false;
  Handler.Callback mCallback;
  final Looper mLooper;
  private NativeHandler mNativeHandler;
  MessageQueue mQueue;
  MqqMessageQueue mSubQueue;
  
  public MqqHandler()
  {
    this(Looper.myLooper(), null);
  }
  
  public MqqHandler(Handler.Callback paramCallback)
  {
    this(Looper.myLooper(), paramCallback);
  }
  
  public MqqHandler(Looper paramLooper)
  {
    this(paramLooper, null);
  }
  
  public MqqHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    this(paramLooper, paramCallback, false);
  }
  
  public MqqHandler(Looper paramLooper, Handler.Callback paramCallback, boolean paramBoolean)
  {
    this.mLooper = paramLooper;
    if (this.mLooper == null) {
      throw new RuntimeException("Can't create handler inside thread that has not called Looper.prepare()");
    }
    this.mCallback = paramCallback;
    for (;;)
    {
      try
      {
        this.mQueue = paramLooper.getQueue();
        if ((this.mQueue == null) || (this.mLooper != Looper.getMainLooper()) || (!isMqqHandlerEnable()) || (paramBoolean)) {
          continue;
        }
        this.beInjected = true;
        sInjectCount.incrementAndGet();
        this.mSubQueue = MqqMessageQueue.getSubMainThreadQueue();
      }
      catch (Throwable localThrowable)
      {
        this.beInjected = false;
        continue;
      }
      this.mNativeHandler = new NativeHandler(paramLooper, paramCallback);
      this.mNativeHandler.mParentHandler = this;
      return;
      if ((this.mLooper != Looper.getMainLooper()) && (sRegulatorCallback != null)) {
        this.beRegulatoring = sRegulatorCallback.regulatorThread(paramLooper.getThread());
      }
    }
  }
  
  private final Message getPostMessage(Runnable paramRunnable)
  {
    return Message.obtain(this.mNativeHandler, paramRunnable);
  }
  
  private final Message getPostMessage(Runnable paramRunnable, Object paramObject)
  {
    paramRunnable = Message.obtain(this.mNativeHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    return paramRunnable;
  }
  
  private final void handleCallback(Message paramMessage)
  {
    paramMessage.getCallback().run();
  }
  
  public static boolean isMqqHandlerEnable()
  {
    return true;
  }
  
  public static void setMqqHandlerEnable(boolean paramBoolean) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    if (this.beRegulatoring) {
      sRegulatorCallback.checkInRegulatorMsg();
    }
    if (paramMessage.getCallback() != null) {
      handleCallback(paramMessage);
    }
    while ((this.mCallback != null) && (this.mCallback.handleMessage(paramMessage))) {
      return;
    }
    handleMessage(paramMessage);
  }
  
  public final void dump(Printer paramPrinter, String paramString)
  {
    if (this.beInjected) {
      return;
    }
    this.mNativeHandler.dump(paramPrinter, paramString);
  }
  
  public final Looper getLooper()
  {
    return this.mLooper;
  }
  
  public String getMessageName(Message paramMessage)
  {
    if (paramMessage.getCallback() != null) {
      return paramMessage.getCallback().getClass().getName();
    }
    return "0x" + Integer.toHexString(paramMessage.what);
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public final boolean hasMessages(int paramInt)
  {
    if (this.beInjected) {
      return this.mSubQueue.removeMessages(this, paramInt, null, false);
    }
    return this.mNativeHandler.hasMessages(paramInt);
  }
  
  public final boolean hasMessages(int paramInt, Object paramObject)
  {
    if (this.beInjected) {
      return this.mSubQueue.removeMessages(this, paramInt, paramObject, false);
    }
    return this.mNativeHandler.hasMessages(paramInt, paramObject);
  }
  
  public final Message obtainMessage()
  {
    return Message.obtain(this.mNativeHandler);
  }
  
  public final Message obtainMessage(int paramInt)
  {
    return Message.obtain(this.mNativeHandler, paramInt);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    return Message.obtain(this.mNativeHandler, paramInt1, paramInt2, paramInt3);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return Message.obtain(this.mNativeHandler, paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    return Message.obtain(this.mNativeHandler, paramInt, paramObject);
  }
  
  public Message obtainMessage(int paramInt, Runnable paramRunnable)
  {
    paramRunnable = Message.obtain(this.mNativeHandler, paramRunnable);
    paramRunnable.what = paramInt;
    return paramRunnable;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    return sendMessageDelayed(getPostMessage(paramRunnable), 0L);
  }
  
  public final boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    return sendMessageAtFrontOfQueue(getPostMessage(paramRunnable));
  }
  
  public final boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    return sendMessageAtTime(getPostMessage(paramRunnable), paramLong);
  }
  
  public final boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    return sendMessageAtTime(getPostMessage(paramRunnable, paramObject), paramLong);
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    return sendMessageDelayed(getPostMessage(paramRunnable), paramLong);
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    if (this.beInjected)
    {
      this.mSubQueue.removeMessages(this, paramRunnable, null);
      return;
    }
    this.mNativeHandler.removeCallbacks(paramRunnable);
  }
  
  public final void removeCallbacks(Runnable paramRunnable, Object paramObject)
  {
    if (this.beInjected)
    {
      this.mSubQueue.removeMessages(this, paramRunnable, paramObject);
      return;
    }
    this.mNativeHandler.removeCallbacks(paramRunnable, paramObject);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    if (this.beInjected)
    {
      this.mSubQueue.removeCallbacksAndMessages(this, paramObject);
      return;
    }
    this.mNativeHandler.removeCallbacksAndMessages(paramObject);
  }
  
  public final void removeMessages(int paramInt)
  {
    if (this.beInjected)
    {
      this.mSubQueue.removeMessages(this, paramInt, null, true);
      return;
    }
    this.mNativeHandler.removeMessages(paramInt);
  }
  
  public final void removeMessages(int paramInt, Object paramObject)
  {
    if (this.beInjected)
    {
      this.mSubQueue.removeMessages(this, paramInt, paramObject, true);
      return;
    }
    this.mNativeHandler.removeMessages(paramInt, paramObject);
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    return sendEmptyMessageDelayed(paramInt, 0L);
  }
  
  public final boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    return sendMessageAtTime(localMessage, paramLong);
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    return sendMessageDelayed(localMessage, paramLong);
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    return sendMessageDelayed(paramMessage, 0L);
  }
  
  public final boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    if (this.beInjected)
    {
      MqqMessageQueue localMqqMessageQueue = this.mSubQueue;
      if (localMqqMessageQueue != null)
      {
        paramMessage = MqqMessage.obtain(paramMessage);
        paramMessage.target = this;
        return localMqqMessageQueue.enqueueMessage(paramMessage, 0L);
      }
      throw new RuntimeException(this + " sendMessageAtTime() called with no mSubQueue");
    }
    return this.mNativeHandler.sendMessageAtFrontOfQueue(paramMessage);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (this.beInjected)
    {
      MqqMessageQueue localMqqMessageQueue = this.mSubQueue;
      if (localMqqMessageQueue != null)
      {
        paramMessage = MqqMessage.obtain(paramMessage);
        paramMessage.target = this;
        return localMqqMessageQueue.enqueueMessage(paramMessage, paramLong);
      }
      throw new RuntimeException(this + " sendMessageAtTime() called with no mSubQueue");
    }
    return this.mNativeHandler.sendMessageAtTime(paramMessage, paramLong);
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    return sendMessageAtTime(paramMessage, SystemClock.uptimeMillis() + l);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("Handler (");
    localStringBuffer.append(getClass().getName());
    localStringBuffer.append(") {");
    localStringBuffer.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
  
  static class NativeHandler
    extends Handler
  {
    MqqHandler mParentHandler;
    
    public NativeHandler(Looper paramLooper, Handler.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public void dispatchMessage(Message paramMessage)
    {
      this.mParentHandler.dispatchMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.os.MqqHandler
 * JD-Core Version:    0.7.0.1
 */